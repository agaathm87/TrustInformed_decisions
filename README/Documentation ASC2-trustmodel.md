# Documentation ASC2-trustmodel 

## AgentScript’s DSL grammar defenition
The below documentation can be found in Mostafa Mohajeri Parizi,Chapter 2 Developing a Scalable MAS Framework in An Agent-based Approach
to the Governance of Complex Cyber-Infrastructures, pp 19-29.

agent → initial_beliefs initial_goals plans
initial_beliefs → (term '.')*
initial_goals → ('!' atomic_formula '.')*
plans → (plan '.')*
plan → ( '@' atomic_formula )*
trigger_event ( ':' context )
'=>' body_definition '.'
trigger_event → ( '+'|'-'|'+!'|'-!'|'+?' ) atomic_formula
context → term
body_definition → body_formula ( ';' body_formula )*
body_formula → ( '!'|'+'|'-' ) literal
| loop
| conditional
| primitive_call
| <VARIABLE> '=' term
term → <VARIABLE>
| '(' term ')'
| <INTEGER> | <FLOAT> | <STRING> | 'true' | 'false'
| <ATOM> '(' term_list ')'
| term operator term
| 'not' term
| '[' term_list ( '|' term )? ']'
| <ATOM>
| primitive_call
atomic_formula → <ATOM>
| <ATOM> '(' term_list ')'
literal → <VARIABLE>
| atomic_formula
term_list → term ( ',' term )*
operator → '**'|'*'|'/'|'mod'|'+'|'-'|'='
|'=='|'!=='|'!='|'<'|'<='|'>'|'>='|'is'|'>>'
|'^'|'&&'|'||'|':-'
primitive_call → '#' <ATOM> ( '.' <ATOM> )* '(' term_list? ')'
loop → 'for' '(' <VARIABLE> 'in' term ')'
'{' body_definition '}'
conditional → 'if' '(' term ')' '{' body_definition '}'
('else' 'if' '(' term ')' '{' body_definition '}')*
('else' '{' body_definition '}')?

An example of an ASC2 DSL that shows part of the script for a domestic robot
is presented bewlow, where lines 2-4 are initial beliefs, line 6 is an inferential
rule, line 9 is an initial goal and lines 12-15 define an example plan.

### An example script of ASC2 DSL
'''asl
1 % initial beliefs and inferential rules
2 main(fish). soup(veg). wine(white).
3 restaurant(french).
4 at(home).
5
6 meal(S,M,W) :- soup(S), main(M), wine(W).
7
8 % initial goals
9 !go_order(french,meal(veg,meat,white)).
10
11 % plans
12 % P1
13 +!go_order(Loc,Meal) :
14 restaurant(Loc) && not at(Loc) =>
15 #move_to(Loc);
16 !order(Meal).
17 ...
'''

## Terms
The ASC2 DSL uses Prolog-style terms. In the translation of an script written
in the DSL, each term (including inferential rules) maps to a Term object which
encapsulates the parsed data (potentially containing nested Terms).
Any term in ASC2 can be translated and analysed in two ways: (1) external
to the script by querying the belief base, and, (2) locally as part of the low-level
code. The first approach makes use of any data-storage engine utilized by the
belief base. This process is by default present in checking the context conditions
of plans, but can also be used at any point in the agent’s script; in our example
the term:

'''asl
restaurant(Loc) && not at(Loc)
'''

## Access to the Lower-Level Language

 As consequence of an approach basedon compilation, the DSL provides direct access to any object or function available
in the agent’s name space —in the Scala implementation, any object or function
which is accessible via the Java class path. These lower-level access statements,
indicated by the token #, are translated literally to the same statement in the
underlying language. This capability provides fast and seamless reuse of libraries
already established for the underlying language. Let us take the previous example,
but this time also use a few of JVM’s basic library methods, namely String.join
and String.toUpperCase:

'''asl    
#String.join("_", Loc, "restaurant").toUpperCase == "FRENCH_RESTAURANT"
'''
Primitive Actions A primitive action of the form #h(...) is in practice a
lower-level function call in the underlying language and it is translated into a call
to a function h(...) with its respective parameters. In the case of Java/Scala, this
can be any callable entity on JVM’s classpath. Take for example Scala’s println
method, to call this method as a primitive action a simple #println("hello") can
be a statement used in ASC2, and a translation of this call will be:
    
primitive_handler.execute(() => println(StringTerm("hello")))

Variables and Assignment Statements Variable assignment statements in
form of V = term are used to (re-)assign the result value of an Term term to a
variable V. ASC2 uses an internal map-like approach to store variables that also
manages variable scopes, meaning that each code block (e.g, plan body, condition
block) holds a map of all variables declared in that scope which also inherits the
variables in its parent scope. Every read/write to a variable V then becomes a
read/write operation to a member of the variable’s map with the key "V". A
variable assignment is translated to an (overwriting) append operation for the
variable’s map by using the V as the key and exp as the value. As an example
the statement V = V + 1 is translated to:
vars += ("V" -> (vars("V") + IntTerm(1)))

Control Flow Structures The compilation method of ASC2 supports a straightforward
mapping of simple control flow structures such as loops and conditionals
to their executable counterparts. The translation of these control structures to
the underlying language is performed one-to-one; for example an if/else in the
DSL is simply translated to an if/else in the underlying language. Take the
simple statement:
if( Var =< 10 ) { Var = Var+1; }
based on the translation of terms and variable assignments, translates to the valid
Scala statement:
if( vars("Var") <= IntTerm(10) ) {
vars += ("Var" -> (vars("Var") + IntTerm(1))}
The same applies to the loop statement, which is translated to a for-loop in
Scala. The DSL supports a for-loop with the syntax:
for( V in term ) { ... }
which is translated to a for-loop in Scala.

## Plan Rules
A plan rule < e, c, h >, should be translated into the object {e,c,h} which will
be part of the plan library. The triggering event of the plan rule e consists of a
trigger (one of +!,-!,+?,+,-) and a term t. The triggers convey the relevance of
the plan to different event types while t can be seen as the payload of that event;
+! relates to adoption of a new goal, -! relates to failure of a goal, +? relates
to test goals, + and - respectively relate to assertion and retraction of a belief.
The triggering event e then translates to an Event object which encapsulates the
trigger and the translated Term object of t. The context condition c is a Term
and translates to an Term object which can be sent to the Belief Base actor in a
synchronous manner, and the response to that message determines if the plan is
applicable in the current context and also returns the substitution for the variable.

# Documentation on  File-by-File Purpose and Structure

## decisionCosinesim.asl
### Purpose:
Coordinates agent selection, trust updates, and communication with Java logic.

## Key Sections:

### Agent Name Definitions:
Declares the names of agents responsible for providing competence, benevolence, and integrity scores, as well as the decision maker.
This enables modular communication between specialized agents.

### Relationship Definitions:
Specifies relationships between agents, their types (e.g., friend, colleague), and their strengths.
Relationships influence trust and selection.

### Goal and Trustor Scores:
Stores expected benevolence, competence, and integrity scores for each goal and trustor.
Used for comparison and selection.

### Derived Beliefs:
Defines how to compute certain beliefs, such as calculating benevolence as the mean of min and max offers.

### Event Handling Plans:
Handles incoming trustworthiness and untrustworthiness information, storing it and possibly triggering further plans.
This allows the agent to react to new information.

### Score Acquisition Plans:
Requests and stores scores from provider agents, ensuring old beliefs are cleared before adding new ones.
Ensures up-to-date information for decision making.

### Utility Plans:
For debugging and sending various scores and vectors to the Java backend.

### Agent Selection and Trust Update:
Handles the process of selecting an agent for a goal, updating trust based on outcomes, and controlling the learning rate for trust updates.
Implements the core trust dynamics and learning.

#### start_hierarchical_selection(Goal, Trustor, SelectedAgent)
Selects the most suitable agent for a given goal using a hierarchical, multi-criteria process.

#### Steps:

Partition agents into trustworthy and untrustworthy based on trustworthiness threshold.
For each group, apply decisive relationship and similarity checks.
If multiple candidates remain, select by benevolence (maximize).
If still tied, select by incompetence (minimize).
If no agent is found, return "none_found" or "none_available".
Purpose: Filter candidates by relationship type/strength and similarity thresholds.
Only agents meeting all minimum requirements are added to DecisiveAgents.

### Code Comments (for reference and documentation):
Plan: +!start_hierarchical_selection(Goal, Trustor, SelectedAgent)
Purpose: Select the most suitable agent for a given goal using a hierarchical, multi-criteria process.
Steps:

Partition agents into trustworthy and untrustworthy based on trustworthiness threshold.
For each group, apply decisive relationship and similarity checks.
If multiple candidates remain, select by benevolence (maximize).
If still tied, select by incompetence (minimize).
If no agent is found, return "none_found" or "none_available".
Purpose: Filter candidates by relationship type/strength and similarity thresholds.
Only agents meeting all minimum requirements are added to DecisiveAgents.
'''asl
// --- Agent Name Definitions ---
// These are crucial for communication with other agents

// --- Relationship Definitions ---
// Define relationships, their types, and strengths

// --- Goal and Trustor Scores ---
// Example: goal_scores(Goal, BScore, CScore, IScore).
// Example: trustor_scores(Trustor, Goal, BScore, CScore, IScore).

// --- Derived Beliefs ---
// Calculate benevolence score as the mean of min and max offer

// --- Event Handling Plans ---
// This agent receives trustworthiness information, as well as incompetence and benevolence information

// Plan to react when trustworthiness information is received
// Store this information or use it for further decision making
// ... trigger other plans based on this information ...
// For example: !select_agent_for_goal(Goal);

// Plan to react when untrustworthiness information is received
// Store this information or use it for further decision making

// --- Plans to Acquire and Store Scores from Providers ---
// Plan to acquire all scores. This plan is only applicable if all #coms.ask succeed.
// Retrieve CPAgent name
// Retrieve BPAgent name
// Retrieve IPAgent name
// #coms.ask calls are in the context. They must succeed and bind variables.
#coms.ask(CPAgent, competence(A, Goal, CScore));
#coms.ask(CPAgent, incompetence(A, Goal, InCScore));
#coms.ask(BPAgent, benevolence_offer(A, Goal, BScoremin, BScoremax));
#coms.ask(IPAgent, integrity(A, Goal, IScore));

// Store the acquired scores as new, distinct beliefs
// Clear any old ones first
// Remove old if exists

// --- Utility Plans for Printing and Sending Vectors and Scores ---

// Print agent, trustor, and goal vectors for debugging

// Send agent vector (benevolence, competence, integrity) to Java

// Send goal vector to Java

// Send trustor vector to Java

// Send trustworthiness score to Java

// Send untrustworthiness score to Java

// Send benevolence score to Java

// Send incompetence score to Java

// Send relationship (type and strength) to Java

// --- Agent Selection and Trust Update ---

// Example initial goal for decision_maker (if any)
// Call the Java selection logic and bind the result to SelectedAgent
// Send the selected agent's trustworthiness score

// Plan to update overall trust based on the outcome of a goal
// How fast trust changes (tune as needed)
'''

## trustworthiness.asl
### Purpose:
Calculates and manages trustworthiness and untrustworthiness beliefs for agents.

### Key Plan:
'''asl
+!calc_trustworthiness(A, Goal):
Calculates trustworthiness for agent A and a specific goal by combining competence, benevolence, and integrity using defined weights.
Handles cases where any attribute is zero, and records reasons for untrustworthiness.
Ensures robust and transparent trust assessment.
Plan: +!calc_trustworthiness(A, Goal)
Purpose: Calculate the trustworthiness of agent A for a specific goal.
Combines competence, benevolence, and integrity using defined weights.
Handles cases where any attribute is zero, and records reasons for untrustworthiness.
'''
## benevolence.asl
### Purpose:
Manages benevolence intervals, processes offers, and updates benevolence beliefs for agents.

### Key Plans:
'''asl
+!update_benevolence(A):
Initializes or updates benevolence intervals for agent A.
+!process_offers(A):
Processes all offers made to agent A.
+!evaluate_offer(A, Offer):
Evaluates an offer, updating intentions and benevolence accordingly.
+!compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan):
Calculates benevolence score for a single value using a sigmoid function.
+!handle_acceptance / +!handle_rejection:
Updates benevolence intervals based on offer outcomes.
These plans allow the agent to learn and adapt benevolence beliefs over time.

Plan: +!update_benevolence(A)
Purpose: Check and initialize benevolence intervals for agent A.
If benevolence is not initialized (Bmax==0), initialize it.
Otherwise, process all offers for the agent.

Plan: +!process_offers(A)
Purpose: Process all offers made to agent A.
For each offer, call !evaluate_offer to update benevolence.

Plan: +!initialize_benevolence(A,Value)
Purpose: Initialize benevolence intervals for agent A and value, based on relationship if available.
If relationship data is present, use it to set the lower bound.
Otherwise, use default [0,1] interval.

Plan: +!evaluate_offer(A, Offer)
Purpose: Evaluate an offer for agent A.
If accepted, update intentions and benevolence for accepted values.
If rejected, update benevolence for rejected values.
If undecided, process each value and compute benevolence scores.

Plan: +!evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan, Y)
Purpose: Evaluate a single value in an offer.
Accept if demotion is within benevolence threshold, otherwise reject.

Plan: +!comp_values(A, Offer)
Purpose: Update running totals for number of values and accepted values for an offer.

Plan: +!evaluate_offer_decision(A, Offer, NewPlan, OldPlan)
Purpose: Decide whether to accept or reject the offer based on accepted values.
If all values are accepted, accept the offer; otherwise, reject.
After decision, aggregate benevolence for the offer.

Plan: +!compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan)
Purpose: Calculate benevolence score for a single value using a sigmoid function.
Updates min and max benevolence scores for the value.

Plan: +!comp_sum_ben(A, Offer, Value)
Purpose: aggregate per-value benevolence scores for an offer and store the totals.

Plan: +!comp_total_ben(A, Offer)
Purpose: Normalize the  benevolence scores and reset counters.
Stores the normalized benevolence interval for the offer.

Plan: +!handle_acceptance(A, NewPlan, OldPlan)
Purpose: Handle acceptance of an offer by updating intentions and benevolence for all values.

Plan: +!handle_rejection(A, Offer)
Purpose: Handle rejection of an offer by updating benevolence for all rejected values.

Plan: +!update_benevolence_reject(A, Offer, Value)
Purpose: Update benevolence interval based on rejection (tighten upper bound).

Plan: +!update_benevolence_accept(A, Value, NewPlan, OldPlan)
Purpose: Update benevolence interval based on acceptance (tighten lower bound or expand upper bound).
'''

## competence.asl
### Purpose:
Handles competence calculation, updating, and management for agents and their actions.

### Key Plans:
'''asl
+!update_competence(A):
Updates competence for all actions of agent A.
+!competent(A, Action):
Determines if agent A is competent for a given goal.
+!competence_calc(A,Action) / +!incompetence_calc(A,Action):
Calculates and stores overall (in)competence scores.
+!check_and_assign_defaults:
Assigns default values for missing prerequisites, using relationships if available.
Competence is assessed recursively, considering subplans and prerequisites.

Plan: +!update_competence(A)
Purpose: Update the competence of agent A for all actions.
Handles actions in success, failure, and pending (neither).

Plan: +!handle_pending_action(A, Action)
Purpose: Handle actions that are neither in success nor failure.

Plan: +!handle_subplans(A, Action)
Purpose: Recursively handle subplans for a given action.

Plan: +!check_and_assign_defaults(A, Action)
Purpose: Assign default values for missing knowledge, resource, and skill prerequisites.

Plans: +!check_and_assign_defaults_resource/skill/knowledge
Purpose: Assign default values for missing prerequisites, using relationship if available.

Plan: +!add_info(A, Action, Condition)
Purpose: Update agent's knowledge, resource, or skill intervals after success/failure.

Plan: +!init_counters(Action)
Purpose: Initialise counters for subplans and succeeded subplans.

Plan: +!competent(A, Action)
Purpose: Main function to determine if agent is competent for a goal.
Handles both actions with and without subplans.

Plan: +!comp_conditions(A, Action, Subaction)
Purpose: Calculate weighted values for knowledge, skill, and resource for a subaction.
Determines if agent is competent for the subaction.

Plan: +!comp_subplans(Action, Subaction)
Purpose: Count the number of subplans and succeeded subplans for an action.

Plan: +!comp_total(A, Action)
Purpose: Determine overall competence for an action based on subplan results.

Plan: +!competence_calc(A,Action)
Purpose: Calculate and store the overall competence score for an action.
Handles both actions with and without subplans.

Plan: +!incompetence_calc(A,Action)
Purpose: Calculate and store the overall incompetence score for an action.
Handles both actions with and without subplans.

Plans: +!competence_score_only / +!incompetence_score_only
Purpose: Calculate only the (in)competence score for an action, without changing status.
Handles both actions with and without subplans.

Plans: +!comp_conditions_score_only_succes / +!comp_conditions_score_only_failure
Purpose: Calculate the (in)competence score for a subaction, for score-only plans.

Plans: +!update_competence_succes / +!update_competence_failures
Purpose: Update beliefs after success or failure, including updating knowledge, resource, and skill intervals.

Plan: +!update_competence_failure(A, Action, Condition)
Purpose: Update knowledge, resource, or skill intervals after a failure.
'''

## Integrity.asl

### Purpose:
Calculates and updates the integrity of agents based on their principles, intentions, and actions.

### Key Plans:
'''asl
+!update_integrity(A):
Main plan to update the integrity of agent A.
+!distanceSum(A, X) / +!distanceMax(A, M) / +!normalizedDistance(A):
Calculate and normalize the distance between intended and actual values for principles.
+!renew_info(A, Integrity):
Updates or adds integrity belief for agent A.
Integrity is measured as the alignment between principles, intentions, and actions.

Plan: +!update_integrity(A)
Purpose: Main plan to update the integrity of agent A.
For each principle, process intentions and calculate distances.

Plan: +!get_principle_intention(A, X)
Purpose: For a given principle X, process all plans A intends to do.
Ensures value is set, processes intentions, and sums weighted distances.

Plan: +!get_weight(A, X, Plan)
Purpose: Get the weight/distance for a principle X in a plan for agent A.
Updates intention and insincerity if actual value is further from the principle than the intention.

Plan: +!get_weight(A, X, Plan) (fallback)
Purpose: If only value is present, update intention and insincerity.

Plan: +!get_weight(A, X, Plan) (no value for principle)
Purpose: If the plan does not have a value for that principle, assign default intention.

Plan: +!assign_intention(A, X)
Purpose: Assign intention based on relationship if available, otherwise use principle value.

Plan: +!assign_value(A, X)
Purpose: Assign value for a principle based on relationship if available, otherwise use default.

Plan: +!distanceSum(A, X)
Purpose: Calculate weighted sum of squared distances for a principle X.

Plan: +!distanceMax(A, M)
Purpose: Calculate max distance (for normalization).

Plan: +!normalizedDistance(A)
Purpose: Normalize the distance and determine integrity.
Prints result and updates integrity belief.

Plan: +!renew_info(A, Integrity)
Purpose: Update or add integrity belief for agent A.
'''

## AgentSelectionLogic.java

### Purpose:
Implements the Java backend for agent selection, belief storage, and vector similarity calculations.

### Key Components:
'''java
ScoreAgentPair:
Helper class for pairing scores with agent names, used for sorting/filtering.

RealBeliefSource:
Stores all beliefs as vectors and values for agents, goals, and trustors.
Acts as the main belief base for the Java side.

Setters/Getters for ASL Communication:
Methods for updating and retrieving beliefs from ASL via static calls.

Cosine Similarity Utility:
Used to compare agent, goal, and trustor vectors for similarity.

Main Agent Selection Logic:
Selects the best agent for a given goal and trustor using hierarchical criteria:

Partition agents into trustworthy and untrustworthy.
Prioritize agents with a relationship to the trustor.
Maximize similarity to goal/trustor.
Maximize relationship strength.
Maximize benevolence.
Minimize incompetence.
Use trustworthiness/untrustworthiness as a final tie-breaker.
Relationship Similarity Stub:
Placeholder for more complex relationship logic.

Find Agents with Min/Max Score:
Utility methods for filtering agents by score.

This Java class is the bridge between the agent logic in ASL and the underlying trust model computations.

// --- Helper class for pairing scores with agent names ---
// Used for sorting and filtering agents based on a score (e.g., benevolence, incompetence)

// --- RealBeliefSource: stores all beliefs as vectors and values ---
// This class is the main belief base, storing all agent, goal, and trustor data

// --- Setters for ASL communication ---
// These methods are called from static methods (which are called from ASL)

// --- Getters for selection logic ---

// --- Static reference for ASL-Java communication ---
// This is the single instance used for all belief storage and retrieval

// --- Static methods for ASL communication ---
// These are called from ASL using internal actions to update the Java belief base

// --- Cosine similarity utility for vector comparison ---
// Used to compare agent, goal, and trustor vectors for similarity

// --- Main agent selection logic ---
// This method selects the best agent for a given goal and trustor using hierarchical criteria

// Separate agents into trustworthy and untrustworthy based on available scores

// Try to select from trustworthy agents first, then untrustworthy

// If no scores at all, return special code

// --- Hierarchical selection among a set of candidate agents ---

// 1. Prioritize agents with a relationship to the trustor

// 2. Max similarity (to goal or trustor)

// 3. Max relationship strength

// 4. Benevolence (maximize)

// 5. Incompetence (minimize)

// 6. Final tie-breaker: trustworthiness or untrustworthiness

// --- Relationship similarity stub (can be extended for more complex logic) ---

// --- Find agents with the minimum score in a list ---

// --- Find agents with the maximum score in a list ---