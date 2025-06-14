//////////////////////////////////////////////
// Example of initial beliefs
//////////////////////////////////////////////

// Define agents in the system
// Agents
agent(damian).
agent(tom).
agent(paula).
trustor(anna).

// Principles (named)
principle(gardening, honesty, 0.8).
principle(gardening, reliability, 0.7).
principle(cleaning, honesty, 0.3).
principle(cleaning, reliability, 0.9).

// Weights for each principle
weight(honesty, 0.6).
weight(reliability, 0.4).

// Values for each agent (how much they value each principle)
value(damian, honesty, 0.7).
value(damian, reliability, 0.8).
value(paula, honesty, 0.5).
value(paula, reliability, 0.9).
value(tom, honesty, 0.9).
value(tom, reliability, 0.6).

// Intentions (which plan each agent intends to do)
intention(damian, gardening).
intention(damian, cleaning).
intention(paula, gardening).
intention(paula, cleaning).
intention(tom, gardening).
intention(tom, cleaning).

// Relationships (for default assignment if needed)
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


// Variables for calculations
//sum(_, _, 0).
//WeightSum(0).
//dMax(_, Plan, 0.0).
threshold(0.7).

missing_or_zero_value(Agent, Principle, Value):- value(Agent, Principle, 0)|| not value(Agent, Principle, _).

// --- Agent Name Definitions ---
// These are crucial for communication
competence_provider_agent("competence"). 
benevolence_provider_agent("benevolence"). 
integrity_provider_agent("integrity").   
decision_maker_agent("decisionCosinesim").     
trutsworthiness_provider_agent("trustworthiness").

//////////////////////////////////////////////
// Initial goal: Start integrity update for all agents
//////////////////////////////////////////////

!getnames().

//////////////////////////////////////////////
// Plans
//////////////////////////////////////////////
// Respond to #coms.ask for integrity
+?integrity(A, Goal, IScore) :
    integrity(A, Goal, IScore) &&
    decision_maker_agent(DMAgent)&&
    trutsworthiness_provider_agent(Tagent) =>

    #coms.inform(DMAgent, integrity(A, Goal, IScore));
    #coms.inform(Tagent, integrity(A, Goal, Iscore)).

// If score is not present, calculate it first, then send
+?integrity(A, Goal, IScore) : not integrity(A, Goal, _) =>
    !update_integrity(A, Goal).

// Looping through all the agents
+!getnames() =>
  #println("Starting integrity update for all agents.");
    for (A in agent(A)) {
        #println("Processing agent: " + A);
        for (Plan in intention(A, Plan)) {
            #println("  Processing plan: " + Plan);
            !update_integrity(A, Plan);
        };
    }.

/*
 * Plan: +!update_integrity(A, Plan)
 * Purpose: Main plan to update the integrity of agent A.
 * For each principle, process intentions and calculate distances.
 */
+!update_integrity(A, Plan) =>
#println("Calling update_integrity for " + A + " and plan " + Plan);
    -sum(A, Plan, _);      // Remove any old sum for this agent/plan
    +sum(A, Plan, 0.0);    // Initialize to 0.0
    -dMax(A, Plan, _);     // Remove any old dMax for this agent/plan
    +dMax(A, Plan, 0.0);   // Initialize to 0.0

    #println("-------Update the integrity of Agent " + A + " for plan " + Plan+"------");
    // For each principle X in any plan, process intentions and distances
    for (X in principle(Plan, X, P)) {
        !get_principle_intention(A,Plan, X); // Process intentions for each principle
        !distanceMax(A,Plan, 1); // Update max distance for normalization
    };
    !normalizedDistance(A, Plan). // Normalize and print integrity

/*
 * Plan: +!get_principle_intention(A, Plan, X)
 * Purpose: For a given principle X, process all plans A intends to do.
 * Ensures value is set, processes intentions, and sums weighted distances.
 */
+!get_principle_intention(A, Plan, X):
    missing_or_zero_value(A, X, Value) =>
    #println("The agent " + A + " has no value for principle " + X + ". Assigning default value.");
    !assign_value(A, X). // Assign value if not set

+!get_principle_intention(A, Plan, X):
    value(A, X, V) =>
    #println(A + " intends to do " + Plan + ".");
    !get_weight(A, X, Plan); // Get the weight/distance for this principle in this plan
    !distanceSum(A, Plan, X). // Add up the weighted distances for this principle


/*
 * Plan: +!get_weight(A, X, Plan)
 * Purpose: Get the weight/distance for a principle X in a plan for agent A.
 * Updates intention and insincerity if actual value is further from the principle than the intention.
 */
+!get_weight(A, X, Plan) :
    principle(Plan, X, P) && // Get the principle value for this plan
    value(A, X, Weight) && // Get the agent's value for this principle
    intention(A, X, Weight2) && // Get the agent's intention for this principle (if exists)
    D1 is (Weight - P)**2 && // Squared distance between value and principle
    D2 is (Weight2 - P) **2 && // Squared distance between intention and principle
    D is (Weight - P) => // Raw distance between value and principle
    if (D1 > D2) {
        -intention(A, X, Weight2); // Remove old intention
        +intention(A, X, Weight); // Add new intention
        -insincere(A, X, _); // Remove old insincerity
        +insincere(A, X, D); // Add new insincerity
        #println("The intentions of " + A + " show that they deviate " + D + " from what I believed about how they value " + X + ".");
    }.

//*
 //* Plan: +!get_weight(A, X, Plan) (fallback)
// * Purpose: If only value is present, update intention and insincerity.
// *//
+!get_weight(A, X, Plan) :
    principle(Plan, X, P) &&
    value(A, X, Weight) &&
    D is ( Weight - P) =>
    -intention(A, X, _) ; // Remove any old intention for this principle
    +intention(A, X, Weight); // Add new intention
    -insincere(A, X, _); // Remove old insincerity (note typo: should be insincere)
    +insincere(A, X, D); // Add new insincerity
    #println("The intentions of " + A + " show that they deviate " + D + " from what I believed about how they value " + X + ".").

//*
// * Plan: +!get_weight(A, X, Plan) (no value for principle)
 //* Purpose: If the plan does not have a value for that principle, assign default intention.
 //*//
+!get_weight(A, X, Plan) :
    principle(Plan, X, P) =>
    -insincere(A, X, _); // Remove old insincerity
    +insincere(A, X, 0); // Set insincerity to 0 (no info)
    #println("The intentions of " + A + " do not tell me anything about how they value principle " + X + ". Their behaviour does not influence how I view their integrity.");
    !assign_intention(A,X, Plan). // Assign default intention

//*
 //* Plan: +!assign_intention(A, X)
 //* Purpose: Assign intention based on relationship if available, otherwise use principle value.
 //*//
+!assign_intention(A, X, Plan) :
    // Check if there is a relationship with another agent B
    trustor(B) &&
    principle(Plan, X, P) &&
    relationship(B, A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultIntention = (Strength * W); // Calculate default intention from relationship
    #println("Assigning intention for " + A + " on " + X + " based on relationship with " + B + ": "+ DefaultIntention);
    -intention(A, X, _); // Remove old intention
    +intention(A, X, DefaultIntention). // Add new intention

// Fallback: Assign intention based on principle value
+!assign_intention(A, X, Plan) :
    principle(Plan, X, P) =>
    #println("Assigning intention for " + A + " on " + X + " based on principle value: " + P);
    -intention(A, X, _); // Remove old intention
    +intention(A, X, P). // Add new intention

/*
 * Plan: +!assign_value(A, X)
 * Purpose: Assign value for a principle based on relationship if available, otherwise use default.
 */
+!assign_value(A, X) :
principle(Plan, X, P) &&
    trustor(B)&&
    relationship(B, A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultValue = (Strength * W); // Calculate default value from relationship
    #println("Assigning value for " + A + " on " + X + " based on relationship with " + B + ": " + DefaultValue);
    -value(A, X, 0); // Remove old value if it is 0
    +value(A, X, DefaultValue). // Add new value

// Fallback: Assign default value (e.g., 0.5) if no relationship data
+!assign_value(A, X):
    principle(Plan, X, P) =>
    #println("Assigning default value 0.5 for " + A + " on " + X);
    -value(A, X, 0); // Remove old value if it is 0
    +value(A, X, 0.5). // Add new value

/*
 * Alternative get_weight plans for different structure (not used above, but kept for completeness)
 */
+!get_weight(A, X, Plan) :
    principle(Plan, P, X1) &&
    value(A, P, X2) &&
    insincere(A, P, X3) &&
    D is (X1 - X2) =>
    if (D > X3) {
        -intention(Agent, P, _) ;
        +intention(Agent, P, Weight);
        -insincere(Agent, P, X3);
        +insincere(Agent, P, D);
        #println("The intentions of " + A + " show that they deviate " + D + " from what I believed about how they value " + P + ".");
    }.

+!get_weight(A, X, Plan) :
    principle(Plan, P, X1) &&
    value(A, P, X2) &&
    D is (X1 - X2) =>
    -insencere(A, P, _); // Remove old insincerity (note typo: should be insincere)
    +insincere(A, P, D); // Add new insincerity
    #println("The intentions of " + A + " show that they deviate " + D + " from what I believed about how they value " + P + ".").

/*
 * Plan: +!distanceSum(A,Plan, X)
 * Purpose: Calculate weighted sum of squared distances for a principle X.
 */
+!distanceSum(A, Plan,  X) :
    principle(Plan, X, P) && // Get the principle value
    intention(A, X, I) && // Get the intention value
    weight(X, W) && // Get the weight for this principle
    sum(A, Plan, CurrentSum) && // Get the current sum
    D is W*(((P-I))**2) && // Calculate weighted squared distance
    NewSum is CurrentSum + D =>
    #println("the new sum of distances is :"+ NewSum + " in plan " + Plan + " is: " + NewSum + ".");
    -sum(A, Plan, CurrentSum);
    +sum(A, Plan, NewSum).

/*
 * Plan: +!distanceMax(A,Plan, M)
 * Purpose: Calculate max distance (for normalization).
 */
+!distanceMax(A, Plan, M):
    dMax(A, Plan, CurrentDMax) &&
    NewCurrentDMax is CurrentDMax + M =>
    #println("the new max distance is:" + NewCurrentDMax +".");
    // Updating sum in belief-base
    -dMax(A, Plan, CurrentDMax);
    +dMax(A, Plan, NewCurrentDMax).

/*
 * Plan: +!normalizedDistance(A, Plan)
 * Purpose: Normalize the distance and determine integrity.
 * Prints result and updates integrity belief.
 */
+!normalizedDistance(A, Plan) :
    sum(A, Plan, D) && // Get the sum of distances
    threshold(T) && // Get the integrity threshold
    dMax(A, Plan, M) => // Get the max distance for normalization
    Alpha = (1 -(#nl.uva.sqrt.RootCalculator.calculateRoot(D,2) / M)); // Calculate normalized integrity

    if (Alpha > T) {
        #println("I think the integrity of " + A + " is: " + Alpha + ". That is at least " + T + " so I consider them integer.");
    } else {
        #println("I think the integrity of " + A + " is: " + Alpha + ". That is lower than " + T + " so I consider them not integer.");
    };
    // Reset for next calculation
    -sum(A, Plan, D);
    +sum(A, Plan, 0.0);
    -dMax(A, Plan, M);
    +dMax(A, Plan, 0.0);
    !renew_info(A,Plan,Alpha). // Update integrity belief

/*
 * Plan: +!renew_info(A, Integrity)
 * Purpose: Update or add integrity belief for agent A.
 */
+!renew_info(A, Plan,Integrity) :
    integrity(A, Plan, OldIntegrity)&&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent)=>
    #println("I have updated the integrity of " + A + " to " + Integrity + ". Old integrity was: " + OldIntegrity + ".");
    -integrity(A,Plan, OldIntegrity); // Remove old integrity
    +integrity(A, Plan, Integrity); // Add new integrity
    #coms.inform(DMAgent, integrity(A, Plan, Integrity));
    #coms.inform(Tagent, integrity(A, Plan, Integrity)).

+!renew_info(A, Plan, Integrity):
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent) =>
    #println("I have updated the integrity of " + A + " to " + Integrity + ".");
    +integrity(A, Integrity); // Add new integrity belief
    #coms.inform(DMAgent, integrity(A, Plan, Integrity));
    #coms.inform(Tagent, integrity(A, Plan, Integrity)).

