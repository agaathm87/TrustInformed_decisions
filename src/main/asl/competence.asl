//////////////////////////////////////////////
// Example of initial beliefs
//////////////////////////////////////////////
// Agents
agent(damian).
agent(tom).
agent(paula).
trustor(anna).

// Goals and outcomes
goal(damian, gardening).
goal(damian, cleaning).
goal(paula, gardening).
goal(paula, cleaning).
goal(tom, gardening).
goal(tom, cleaning).

// Example: damian succeeded at gardening, paula failed at cleaning, tom pending
succes(damian, gardening).
failure(paula, cleaning).
// tom's actions are pending

// Subplans (if any)
subplan(gardening, weeding).
subplan(cleaning, dusting).

// Knowledge, resources, skills for actions and subactions
knowledge(tom, gardening, edible, 0.8).
resource(tom, gardening, tools, 0.2).
skill(tom, gardening, ability, 0.9).

knowledge(tom, weeding, herbology, 0.7).
resource(tom, weeding, tools, 0.6).
skill(tom, weeding, ability, 0.8).

knowledge(tom, cleaning, surfaces, 0.5).
resource(tom, cleaning, vacuum, 0.6).
skill(tom, cleaning, thoroughness, 0.4).

knowledge(tom, dusting, surfaces, 0.6).
resource(tom, dusting, duster, 0.7).
skill(tom, dusting, attention, 0.5).

knowledge(paula, gardening, edible, 0.8).
resource(paula, gardening, tools, 0.2).
skill(paula, gardening, ability, 0.9).

knowledge(paula, weeding, herbology, 0.7).
resource(paula, weeding, tools, 0.6).
skill(paula, weeding, ability, 0.8).

knowledge(paula, cleaning, surfaces, 0.5).
resource(paula, cleaning, vacuum, 0.6).
skill(paula, cleaning, thoroughness, 0.4).

knowledge(paula, dusting, surfaces, 0.6).
resource(paula, dusting, duster, 0.7).
skill(paula, dusting, attention, 0.5).

knowledge(damian, gardening, edible, 0.8).
resource(damian, gardening, tools, 0.2).
skill(gardening, ability, 0.9).

knowledge(damian, weeding, herbology, 0.7).
resource(damian, weeding, tools, 0.6).
skill(damian, weeding, ability, 0.8).

knowledge(damian, cleaning, surfaces, 0.5).
resource(damian, cleaning, vacuum, 0.6).
skill(damian, cleaning, thoroughness, 0.4).

knowledge(damian, dusting, surfaces, 0.6).
resource(damian, dusting, duster, 0.7).
skill(damiann, dusting, attention, 0.5).

//prerequisits for actions and subactions
prerequisits(gardening, knowledge, edible).
prerequisits(gardening, resource, tools).
prerequisits(gardening, skill, ability).

// For plan weeding
prerequisits(weeding, knowledge, herbology).
prerequisits(weeding, resource, tools).
prerequisits(weeding, skill, ability).

// For plan cleaning
prerequisits(cleaning, knowledge, surfaces).
prerequisits(cleaning, resource, vacuum).
prerequisits(cleaning, skill, thoroughness).

// For plan dusting
prerequisits(dusting, knowledge, surfaces).
prerequisits(dusting, resource, duster).
prerequisits(dusting, skill, attention).

// Thresholds for each action/subaction
threshold_knowledge(gardening, 0.7).
threshold_skill(gardening, 0.7).
threshold_resource(gardening, 0.7).
threshold_knowledge(weeding, 0.6).
threshold_skill(weeding, 0.6).
threshold_resource(weeding, 0.6).
threshold_knowledge(cleaning, 0.5).
threshold_skill(cleaning, 0.5).
threshold_resource(cleaning, 0.5).
threshold_knowledge(dusting, 0.5).
threshold_skill(dusting, 0.5).
threshold_resource(dusting, 0.5).

// Relationship weights and strengths (for default assignment)
relationship(anna, tom, friend).
relationship(anna, paula, collegue).
relationship(anna, damian, acquaintance).

relationship_strength(anna, tom, 0.9).
relationship_strength(anna, paula, 0.6).
relationship_strength(anna, damian, 0.2).

weight_relationship(friend, 0.8).
weight_relationship(acquaintance, 0.5).
weight_relationship(neighbour, 0.6).
weight_relationship(collegue, 0.7).

// Weights for resource, skill, and knowledge in competence calculation
weight_resource(0.3).
weight_skill(0.4).
weight_knowledge(0.3).

// Initialisers for counters used in competence calculation
number_of_subs(_, 0).
succeeded_subs(_, 0).
competence_sub(_, _, 0).

// --- Agent Name Definitions ---
// These are crucial for communication
competence_provider_agent("competence"). 
benevolence_provider_agent("benevolence"). 
integrity_provider_agent("integrity").   
decision_maker_agent("decisionCosinesim").  
trutsworthiness_provider_agent("trustworthiness").   

// Helper predicates to check for missing or zero values
missing_or_zero_resource(A, Action, Condition) :- not resource(A, Action, Condition, _) ||  resource(A, Action, Condition, 0).
missing_or_zero_skill(A, Action, Condition) :- not skill(A, Action, Condition, _) || skill(A, Action, Condition, 0).
missing_or_zero_knowledge(A, Action, Condition) :- not knowledge(A, Action, Condition, _) || knowledge(A, Action, Condition, 0).

//////////////////////////////////////////////
// Initial goals
//////////////////////////////////////////////
!getnames().

//////////////////////////////////////////////
// Plans
//////////////////////////////////////////////
// Respond to #coms.ask for competence
//+?competence(A, Goal, CScore) :
    //competence(A, Goal, CScore)&&
    //decision_maker_agent(DMAgent)&&
    //trustworthiness_provider_agent(Tagent) =>

    //#coms.inform(DMAgent, competence(A, Action, CScore));
    //#coms.inform(Tagent,competence(A,Action,CScore)).

// If score is not present, calculate it first, then send
//+?competence(A, Goal, CScore) : not competence(A, Goal, _) =>
    //!update_competence(A).

// Respond to #coms.ask for incompetence (if needed)
//+?incompetence(A, Goal, InCScore) :
    //incompetence(A, Goal, InCScore)&&
    //decision_maker_agent(DMAgent)&&
    //trustworthiness_provider_agent(Tagent) =>
   
    //#coms.inform(DMAgent, incompetence(A, Goal, InCScore));
    //#coms.inform(Tagent,incompetence(A,Goal,InCScore)).

 // If score is not present, calculate it first, then send
//+?incompetence(A, Goal, InCScore) : not incompetence(A, Goal, _) =>
    //!update_competence(A).

// Looping through all the agents
+!getnames() =>
    for (A in agent(A)) {
        !update_competence(A);
    }.

/*
 * Plan: +!update_competence(A)
 * Purpose: Update the competence of agent A for all actions.
 * Handles actions in success, failure, and pending (neither).
 */
+!update_competence(A) =>
    #println("------Updating competence of agent " + A + "------");

    // Handle actions marked as success
    for (Action in succes(A, Action)) {
        #println(Action);
        !check_and_assign_defaults(A, Action);
        !handle_subplans(A, Action);
        #println("Action " + Action + " is in success.");
        !competence_score_only(A, Action);
        !update_competence_succes(A, Action);
    };

    // Handle actions marked as failure
    for (Action in failure(A, Action, _)) {
        #println(Action);
        !check_and_assign_defaults(A, Action);
        !handle_subplans(A, Action);
        #println("Action " + Action + " is in failure.");
        !incompetence_score_only(A, Action);
        !update_competence_failures(A, Action);
    };

    // Handle actions that are neither success nor failure (pending)
    for (Action in goal(A, Action)) {
        !handle_pending_action(A, Action);
    }.

/*
 * Plan: +!handle_pending_action(A, Action)
 * Purpose: Handle actions that are neither in success nor failure.
 */
+!handle_pending_action(A, Action) :
    not succes(A, Action) &&
    not failure(A, Action, _) =>
    #println("Action " + Action + " is neither in success nor failure.");
    !check_and_assign_defaults(A, Action);
    !handle_subplans(A, Action);
    !competent(A, Action).

/*
 * Plan: +!handle_subplans(A, Action)
 * Purpose: Recursively handle subplans for a given action.
 */
+!handle_subplans(A, Action) :
    subplan(Action, Subaction) =>
    // Handle subplans for the action
    #println("Handling subplans for " + Action);
    for (Subaction in subplan(Action, Subaction)) {
        #println("Subplan: " + Subaction);
        !check_and_assign_defaults(A, Subaction); // Subplan
    }.

//*
 //* Plan: +!check_and_assign_defaults(A, Action)
// * Purpose: Assign default values for missing knowledge, resource, and skill prerequisites.
// *//
+!check_and_assign_defaults(A, Action) =>
    // For all knowledge prerequisites
    for (Condition in prerequisits("knowledge", Action, Condition)) {
        !check_and_assign_defaults_knowledge(A, Action, Condition);
    };
    // For all resource prerequisites
    for (Condition in prerequisits("resource", Action, Condition)) {
        !check_and_assign_defaults_resource(A, Action, Condition);
    };
    // For all skill prerequisites
    for (Condition in prerequisits("skill", Action, Condition)) {
        !check_and_assign_defaults_skill(A, Action, Condition);
    }.

/*
 * Plans: +!check_and_assign_defaults_resource/skill/knowledge
 * Purpose: Assign default values for missing prerequisites, using relationship if available.
 */
+!check_and_assign_defaults_resource(A, Action, Condition) :
    prerequisits("resource", Action, Condition) &&
    missing_or_zero_resource(A,Action, Condition) &&
    relationship(B, A, Reltype) &&
    weight_relationship(Reltype, Weight) &&
    relationship_strength(B, A, Strength) &&
    DefaultScore is (Strength * Weight) =>
    #println("Assigned default score for resource " + Condition + " in " + Action + " based on relationship: " + Reltype + " assigned " + DefaultScore + ".");
    -resource(A,Action, Condition, _); // Remove any old entry
    +resource(A,Action, Condition, DefaultScore).

+!check_and_assign_defaults_resource(A, Action, Condition) :
    prerequisits("resource", Action, Condition) &&
    missing_or_zero_resource(A, Action, Condition) =>
    #println("No relationship found for resource " + Condition + " in " + Action + ". Assigning default value 0.5.");
    -resource(A, Action, Condition, _);
    +resource(A, Action, Condition, 0.5).

+!check_and_assign_defaults_skill(A, Action, Condition) :
    prerequisits("skill", Action, Condition) &&
    missing_or_zero_skill(A, Action, Condition) &&
    relationship(B, A, Reltype) &&
    weight_relationship(Reltype, Weight) &&
    relationship_strength(B, A, Strength) &&
    DefaultScore is (Strength * Weight) =>
    #println("Assigned default score for skill " + Condition + " in " + Action + " based on relationship: " + Reltype + " assigned " + DefaultScore + ".");
    -skill(A, Action, Condition, _);
    +skill(A, Action, Condition, DefaultScore).

+!check_and_assign_defaults_skill(A, Action, Condition) :
    prerequisits("skill", Action, Condition) &&
    missing_or_zero_skill(A, Action, Condition) =>
    #println("No skill found for " + Condition + ". Assigning default skill 0.5.");
    -skill(A, Action, Condition, _);
    +skill(A, Action, Condition, 0.5).

+!check_and_assign_defaults_knowledge(A, Action, Condition) :
    prerequisits("knowledge", Action, Condition) &&
    missing_or_zero_knowledge(A, Action, Condition) =>
    #println("No knowledge found for " + Condition + ". Assigning default knowledge 0.5.");
    -knowledge(A, Action, Condition, _);
    +knowledge(A, Action, Condition, 0.5).

+!check_and_assign_defaults_knowledge(A, Action, Condition) :
    prerequisits("knowledge", Action, Condition) &&
    missing_or_zero_knowledge(A, Action, Condition) &&
    relationship(B, A, Reltype) &&
    weight_relationship(Reltype, Weight) &&
    relationship_strength(B, A, Strength) &&
    DefaultScore is (Strength * Weight) =>
    #println("Assigned default score for knowledge " + Condition + " in " + Action + " based on relationship: " + Reltype + " assigned " + DefaultScore + ".");
    -knowledge(A, Action, Condition, _, _);
    +knowledge(A, Action, Condition, DefaultScore).

/*
 * Plan: +!add_info(A, Action, Condition)
 * Purpose: Update agent's knowledge, resource, or skill intervals after success/failure.
 */
+!add_info(A, Action, Condition) :
    knowledge(A, Action, Condition, X) &&
    knowledge(A, Condition, Low, High) =>
        +knowledge(A, Condition, X, High);
        #println(A, Condition, X, High);
    if ((X > Low) && (X =< High)) {
        +knowledge(A, Condition, X, High);
    }.

+!add_info(A, Action, Condition) :
    knowledge(A, Action, Condition, X) =>
    #println(A, Condition, X, 1);
    +knowledge(A, Condition, X, 1).

+!add_info(A, Action, Condition) :
    resource(A, Action, Condition, X) &&
    resource(A, Condition, Low, High) =>
    #println(A, Condition, X, High);
    if ((X > Low) && (X =< High)) {
        +resource(A, Condition, X, High);
    }.

+!add_info(A, Action, Condition) :
    resource(A, Action, Condition, X) =>
    #println(A, Condition, X, 1);
    +resource(A, Condition, X, 1).

+!add_info(A, Action, Condition) :
    skill(A, Action, Condition, X) &&
    skill(A, Condition, Low, High) =>
    #println(A, Condition, X, High);
    if ((X > Low) && (X =< High)) {
        +skill(A, Condition, X, High);
    }.

+!add_info(A, Action, Condition) :
    skill(A, Action, Condition, X) =>
    #println(A, Condition, X, 1);
    +skill(A, Condition, X, 0.1).

/*
 * Plan: +!init_counters(Action)
 * Purpose: Initialise counters for subplans and succeeded subplans.
 */
+!init_counters(Action) :
    not number_of_subs(Action, _) =>
    +number_of_subs(Action, 0);
    +succeeded_subs(Action, 0).

/*
 * Plan: +!competent(A, Action)
 * Purpose: Main function to determine if agent is competent for a goal.
 * Handles both actions with and without subplans.
 */
+!competent(A, Action): 
    subplan(Action, Subaction) =>
    !init_counters(Action);
    #println("Evaluating the competence of " + A + " for the goal: " + Action);
    #println("The goal " + Action  + " consists of the subplans: ");
    for (Subaction in subplan(Action, Subaction)) {
        #println("- " + Subaction);
    };
    for (Subaction in subplan(Action, Subaction)) {
        #println(" ");
        #println("Evaluating the subplan: " + Subaction);
        !comp_conditions(A, Action, Subaction);
        !comp_subplans(Action, Subaction);
    };
    // Evaluate the main goal's own requirements as well:
    #println("Evaluating the main goal: " + Action);
    !comp_conditions(A, Action, Action);
    !comp_subplans(Action, Action);
    #println("Before comp_total for " + Action);
    !comp_total(A, Action);
    #println("After comp_total for " + Action).

+!competent(A, Action):
    not subplan(Action, Subaction) =>
    #println("Evaluating the competence of " + A + " for the goal: " + Action);
    #println("The goal " + Action + " has no subplans.");
    !comp_conditions(A, Action, Action);
    !comp_subplans(Action, Action);
    !comp_total(A, Action).

/*
 * Plan: +!comp_conditions(A, Action, Subaction)
 * Purpose: Calculate weighted values for knowledge, skill, and resource for a subaction.
 * Determines if agent is competent for the subaction.
 */
+!comp_conditions(A, Action, Subaction) :
    // Retrieve weights and thresholds
    weight_knowledge(WK) &&
    weight_skill(WS) &&
    weight_resource(WR) &&
    threshold_knowledge(Subaction, TK) &&
    threshold_skill(Subaction, TS) &&
    threshold_resource(Subaction, TR) &&
    // Retrieve values
    knowledge(A, Subaction, Knowledge, K) &&
    skill(A, Subaction, Skill, S) &&
    resource(A, Subaction, Resource, R) =>

    // Calculate weighted values
    WeightedKnowledge = (K * WK);
    WeightedSkill = (S * WS);
    WeightedResource = (R * WR);
    WTK = (TK * WK);
    WTS = (TS * WS);
    WTR = (TR * WR);

    // Calculate subscore
    SubScore = ((WeightedKnowledge + WeightedSkill + WeightedResource) / (WK + WS + WR));

    // Evaluate competence directly within this plan using if-else
    if (WeightedKnowledge >= WTK && WeightedSkill >= WTS && WeightedResource >= WTR) {
        // Competent case
        #println("- " + A + " is competent for the subplan: " + Subaction);
        #println("Competence score: " + SubScore);
        -sub_comp(Subaction, _);
        +sub_comp(Subaction, 1);
        +competent(A, Subaction);
        +competence_sub(A, Subaction, SubScore);
    } else {
        // Incompetent case
        #println("- " + A + " is incompetent for the subplan: " + Subaction);
        #println("Competence score: " + SubScore);
        -sub_comp(Subaction, _);
        +sub_comp(Subaction, 0);
        +competence_sub(A, Subaction, SubScore);
    };

    // Log specific failures for missing thresholds
    if (WeightedKnowledge < WTK) {
        #println("-> " + A + " misses " + (WTK - WeightedKnowledge) + " knowledge");
        +failure(A, Subaction, Knowledge);
    };
    if (WeightedSkill < WTS) {
        #println("-> " + A + " misses " + (WTS - WeightedSkill) + " skills");
        +failure(A, Subaction, Skill);
    };
    if (WeightedResource < WTR ) {
        #println("-> " + A + " misses resources");
        +failure(A, Subaction, Resource);
    }.

/*
 * Plan: +!comp_subplans(Action, Subaction)
 * Purpose: Count the number of subplans and succeeded subplans for an action.
 */
+!comp_subplans(Action, Subaction) :
    sub_comp(Subaction, SubComp) &&
    number_of_subs(Action, NS) &&
    succeeded_subs(Action, SS) &&
    NewNS is (NS + 1) &&
    NewSS is (SS + SubComp) =>
    #println("Counting subplan: " + Subaction + " for " + Action + " (sub_comp=" + SubComp + ")");
    #println("number_of_subs before: " + NS + ", succeeded_subs before: " + SS);
    -number_of_subs(Action, NS);
    +number_of_subs(Action, NewNS);
    -succeeded_subs(Action, SS);
    +succeeded_subs(Action, NewSS);
    #println("number_of_subs after: " + NewNS + ", succeeded_subs after: " + NewSS).

/*
 * Plan: +!comp_total(A, Action)
 * Purpose: Determine overall competence for an action based on subplan results.
 */
+!comp_total(A, Action) :
    number_of_subs(Action, NS) &&
    succeeded_subs(Action, SS)  =>
    #println(" ");
    if (NS == SS) {
        #println(A + " is competent for the goal: " + Action);
        +succes(A, Action);
        +competent(A, Action);
        !competence_calc(A,Action);
        !update_competence_succes(A, Action);
    } else {
        #println(A + " is incompetent for the goal: " + Action);
        !incompetence_calc(A,Action);
        +competence(A, Action, 0); //Agent is incompetent competencescore==0
        !update_competence_failures(A, Action); 
    }.

/*
 * Plan: +!competence_calc(A,Action)
 * Purpose: Calculate and store the overall competence score for an action.
 * Handles both actions with and without subplans.
 */
+!competence_calc(A,Action):
    subplan(Action, Subaction) &&
    number_of_subs(Action, NS) &&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent) =>
    TotalCompetenceScore = 0;
    OverallScore = 0;
    for (Subaction in subplan(Action, Subaction)) {
        for (SubScore in competence_sub(A, Subaction, SubScore)) {
            TotalCompetenceScore = TotalCompetenceScore + SubScore;
        };
    };
    for (Mainscore in competence_sub(A, Action, Mainscore)) {
        TotalCompetenceScore = TotalCompetenceScore + Mainscore;
    };
    // Calculate overall competence score
    OverallScore = (TotalCompetenceScore / NS);  
    // Store the competence score
    #println("Competence score for " + A + " on " + Action + ": " + OverallScore);
    -competence(A, Action, OverallScore);
    +competence(A, Action, OverallScore);
    #coms.inform(DMAgent, competence(A, Action, OverallScore));
    #coms.inform(Tagent, competence(A, Action, OverallScore));
    
    // Reset counters after evaluation
    -competence_sub(A, Action, _);
    -sub_comp(Action, _);
    -number_of_subs(Action, _);
    +number_of_subs(Action, 0);
    -succeeded_subs(Action, _);
    +succeeded_subs(Action, 0).

+!competence_calc(A,Action):
    not subplan(Action, Subaction)  &&
    competence_sub(A,ScoredItemName,SubScore) &&
    number_of_subs(Action, NS) &&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent)  =>
    // Calculate overall competence score
    OverallScore =  SubScore;
    // Store the competence score
    #println("Competence score for " + A + " on " + Action + ": " + OverallScore);
    -competence(A, Action, OverallScore);
    +competence(A, Action, OverallScore);
    #coms.inform(DMAgent, competence(A, Action, OverallScore));
    #coms.inform(Tagent, competence(A, Action, OverallScore));
    // Reset counters after evaluation
    -competence_sub(A, Action, _);
    -competence_sub(A, Subaction, _);
    -sub_comp(Action, _);
    -number_of_subs(Action, _);
    +number_of_subs(Action, 0);
    -succeeded_subs(Action, _);
    +succeeded_subs(Action, 0).

/*
 * Plan: +!incompetence_calc(A,Action)
 * Purpose: Calculate and store the overall incompetence score for an action.
 * Handles both actions with and without subplans.
 */
+!incompetence_calc(A,Action):
    not subplan(Action, Subaction) &&
    competence_sub(A,ScoredItemName,SubScore) &&
    number_of_subs(Action, NS) &&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent)  =>
    OverallincScore = 0;
    // Calculate overall incompetence score
    OverallincScore = 1-SubScore ;  
    // Store the incompetence score
    #println("Incompetence score for " + A + " on " + Action + ": " + OverallincScore);
    -incompetence(A, Action, OverallincScore);
    +incompetence(A, Action, OverallincScore);
    #coms.inform(DMAgent, incompetence(A, Action, OverallincScore));
    // Reset counters after evaluation
    -competence_sub(A, Action, _);
    -sub_comp(Action, _);
    -number_of_subs(Action, _);
    +number_of_subs(Action, 0);
    -succeeded_subs(Action, _);
    +succeeded_subs(Action, 0).

+!incompetence_calc(A,Action):
    subplan(Action, Subaction) &&    
    number_of_subs(Action, NS) &&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent)  =>
    TotalinCompetenceScore = 0;
    OverallincScore = 0;
    for (Subaction in subplan(Action, Subaction)) {
        for (SubScore in competence_sub(A, Subaction, SubScore)) {
            TotalinCompetenceScore = TotalinCompetenceScore + SubScore;
        };
    };
    for (Mainscore in competence_sub(A, Action, Mainscore)) {
        TotalinCompetenceScore = TotalinCompetenceScore + Mainscore;
    };
    // Calculate overall incompetence score
    OverallincScore = (1-(TotalinCompetenceScore / NS));  
    
    // Store the incompetence score
    #println("Incompetence score for " + A + " on " + Action + ": " + OverallincScore);
    -incompetence(A, Action, OverallincScore);
    +incompetence(A, Action, OverallincScore);
    #coms.inform(DMAgent, incompetence(A, Action, OverallincScore));
    // Reset counters after evaluation
    -competence_sub(A, Subaction, _);
    -competence_sub(A, Action, _);
    -sub_comp(Action, _);
    -number_of_subs(Action, _);
    +number_of_subs(Action, 0);
    -succeeded_subs(Action, _);
    +succeeded_subs(Action, 0).

/*
 * Plans: +!competence_score_only / +!incompetence_score_only
 * Purpose: Calculate only the (in)competence score for an action, without changing status.
 * Handles both actions with and without subplans.
 */
+!incompetence_score_only(A, Action) :
    not subplan(Action, _) =>
    !init_counters(Action);
    !comp_conditions_score_only_failure(A, Action, Action);
    !comp_subplans(Action, Action);
    !incompetence_calc(A,Action).

+!incompetence_score_only(A, Action):
    subplan(Action, _) =>
    !init_counters(Action);
    for (Subaction in subplan(Action, Subaction)) {
        !comp_conditions_score_only_failure(A, Action, Subaction);
        !comp_subplans(Action, Subaction);
    };
    // Also process the main action itself
    !comp_conditions_score_only_failure(A, Action, Action);
    !comp_subplans(Action, Action);
    !incompetence_calc(A,Action).

+!competence_score_only(A, Action) :
    not subplan(Action, _) =>
    !init_counters(Action);
    !comp_conditions_score_only_succes(A, Action, Action);
    !comp_subplans(Action, Action);
    !competence_calc(A,Action).

+!competence_score_only(A, Action) :
    subplan(Action, _) =>
    !init_counters(Action);
    for (Subaction in subplan(Action, Subaction)) {
        !comp_conditions_score_only_succes(A, Action, Subaction);
        !comp_subplans(Action, Subaction);   
    };
    // Also process the main action itself
    !comp_conditions_score_only_succes(A, Action, Action);
    !comp_subplans(Action, Action);
    !competence_calc(A,Action).

/*
 * Plans: +!comp_conditions_score_only_succes / +!comp_conditions_score_only_failure
 * Purpose: Calculate the (in)competence score for a subaction, for score-only plans.
 */
+!comp_conditions_score_only_succes(A, Action, Subaction) :
    weight_knowledge(WK) &&
    weight_skill(WS) &&
    weight_resource(WR) &&
    threshold_knowledge(Subaction, TK) &&
    threshold_skill(Subaction, TS) &&
    threshold_resource(Subaction, TR) &&
    knowledge(A, Subaction, Knowledge, K) &&
    skill(A, Subaction, Skill, S) &&
    resource(A, Subaction, Resource, R ) =>

    WeightedKnowledge = (K * WK);
    WeightedSkill = (S * WS);
    WeightedResource = (R * WR);

    SubScore = ((WeightedKnowledge + WeightedSkill + WeightedResource) / (WK + WS + WR));

    #println("Score-only: " + A + " for " + Subaction + " = " + SubScore);
    -sub_comp(Subaction, _);
    +sub_comp(Subaction, 1);
    +competence_sub(A, Subaction, SubScore).

+!comp_conditions_score_only_failure(A, Action, Subaction) :
    weight_knowledge(WK) &&
    weight_skill(WS) &&
    weight_resource(WR) &&
    threshold_knowledge(Subaction, TK) &&
    threshold_skill(Subaction, TS) &&
    threshold_resource(Subaction, TR) &&
    knowledge(A, Subaction, Knowledge, K) &&
    skill(A, Subaction, Skill, S) &&
    resource(A, Subaction, Resource, R ) =>

    WeightedKnowledge = (K * WK);
    WeightedSkill = (S * WS);
    WeightedResource = (R * WR);

    SubScore = ((WeightedKnowledge + WeightedSkill + WeightedResource) / (WK + WS + WR));

    #println("Score-only: " + A + " for " + Subaction + " = " + SubScore);
    -sub_comp(Subaction, _);
    +sub_comp(Subaction, 0);
    +competence_sub(A, Subaction, SubScore).

/*
 * Plans: +!update_competence_succes / +!update_competence_failures
 * Purpose: Update beliefs after success or failure, including updating knowledge, resource, and skill intervals.
 */
+!update_competence_succes(A, Action) :
    goal(A, Action) =>
    #println(A + " intended to go " + Action + " and succeeded.");
    +competent(A, Action);
    for (Knowledge in knowledge(A, Action, Knowledge, X)) {
        !add_info(A, Action, Knowledge);
    };
    for (Resource in resource(A, Action, Resource, X)) {
        !add_info(A, Action, Resource);
    };
    for (Skill in skill(A, Action, Skill, X)) {
        !add_info(A, Action, Skill);
    };
    for (Subaction in subplan(Action, Subaction)) {
        #println(Subaction);
        #println(A + " intended to go " + Subaction + " and succeeded.");
        +competent(A, Subaction);
        for (Knowledge in knowledge(A, Subaction, Knowledge, X)) {
            #println(Knowledge, X);
            +knowledge(A, Knowledge, X);
            !add_info(A, Subaction, Knowledge);
        };
        for (Resource in resource(A, Subaction, Resource, X)) {
            #println(Resource, X);
            +resource(A, Resource, X);
            !add_info(A, Subaction, Resource);
        };
        for (Skill in skill(A, Subaction, Skill, X)) {
            #println(Skill, X);
            +skill(A, Skill, X);
            !add_info(A, Subaction, Skill);
        };
    }.

+!update_competence_failures(A, Action) :
    goal(A, Action) &&
    failure(A, Action, Reason) =>
    #println(A + " intended to go " + Action + " and failed.");
    for (Reason in failure(A, Action, Reason)) {
        #println(A + " failed because of " + Reason + ".");
        !update_competence_failure(A, Action, Reason);
    }.

/*
 * Plan: +!update_competence_failure(A, Action, Condition)
 * Purpose: Update knowledge, resource, or skill intervals after a failure.
 */
+!update_competence_failure(A, Action, Condition) :
    resource(A, Action, Condition, X) &&
    resource(A, Condition, Low, High) =>
    #println(A, Condition, Low, X);
    if ((X < High) && (X < Low)) {
        +resource(A, Condition,0, X);}
    else if (X < High) {
        +resource(A, Condition, Low, X); }.

+!update_competence_failure(A, Action, Condition) :
    resource(A, Action, Condition, X)=>
    #println(A, Condition, 0, X);
    +resource(A, Condition, 0, X).

+!update_competence_failure(A, Action, Condition) :
    knowledge(A, Action, Condition, X) &&
    knowledge(A, Condition, Low, High) =>
    #println(A, Condition, Low, X);
    if ((X < High) && (X < Low)) {
        +knowledge(A, Condition,0, X);}
    else if (X < High) {
        +knowledge(A, Condition, Low, X);
    }.

+!update_competence_failure(A, Action, Condition) :
    knowledge(A, Action, Condition, X)=>
    #println(A, Condition, 0, X);
    +knowledge(A, Condition, 0, X).

+!update_competence_failure(A, Action, Condition) :
    skill(A, Action, Condition, X) &&
    skill(A, Condition, Low, High) =>
    #println(A, Condition, Low, X);
    if ((X < High) && (X < Low)) {
        +resource(0, X);}
    else if (X < High) {
        +skill(A, Condition, Low, X);
    }.

+!update_competence_failure(A, Action, Condition) :
    skill(A, Action, Condition, X) =>
    #println(A, Condition, 0, X);
    +skill(A, Condition, 0, X).