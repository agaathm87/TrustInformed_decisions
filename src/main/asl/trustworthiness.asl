//////////////////////////////////////////////
// Example of initial beliefs and weights
//////////////////////////////////////////////
// Agents
agent(damian).
agent(tom).
agent(paula).

// Trust dimensions for each agent and goal (gardening, cleaning)
// example beliefs to run the trustworthiness calculation without external input
benevolence_offer(damian, gardening, 0.7, 1).
integrity(damian, gardening, 0.9).
total_competence(damian, gardening, 0.8, 1).

benevolence_offer(damian, cleaning, 0.5, 1).
integrity(damian, cleaning, 0.85).
total_competence(damian, cleaning, 0.6, 1).

//total_competence(paula, cleaning, 0.7, 1).
benevolence_offer(paula, cleaning, 0.8, 1).
integrity(paula, cleaning, 0.85).
total_competence(paula, cleaning, 0.75, 1).

benevolence_offer(paula, gardening, 0.6, 1).
integrity(paula, gardening, 0.9).
total_competence(paula, gardening, 0.7, 1).

// Example beliefs for Tom

total_competence(tom, gardening, 0.9, 1).
benevolence_offer(tom, gardening, 0.6, 1).
integrity(tom, gardening, 0.8).

total_competence(tom, cleaning, 0.6, 1).
benevolence_offer(tom, cleaning, 0.7, 1).
integrity(tom, cleaning, 0.7).

// Weights for trustworthiness calculation
weight_competence(0.4).
weight_benevolence(0.6).
weight_integrity(0.3).

// Thresholds for each goal
threshold_trustworthiness(gardening, 0.7).
threshold_trustworthiness(cleaning, 0.7).

// Rules to calculate average values for competence and benevolence
// These ensure the correct format for use in trustworthiness calculation
benevolence(A, Goal, AvgB) :- benevolence_offer(A, Goal, Bmin, Bmax) && AvgB is ((Bmin + Bmax) / 2).
competence(A, Goal, AvgC) :- total_competence(A, Goal, Cmin, Cmax) && AvgC is ((Cmin + Cmax) / 2).

// --- Agent Name Definitions ---
// These are crucial for communication
competence_provider_agent("competence"). 
benevolence_provider_agent("benevolence"). 
integrity_provider_agent("integrity").   
decision_maker_agent("decisionCosinesim").  
trutsworthiness_provider_agent("trustworthiness").     


//////////////////////////////////////////////
// Initial goal: Calculate trustworthiness for agent1 and gardening
//////////////////////////////////////////////

//!calc_trustworthiness(agent1, gardening). //uncomment this line to trigger the initial trustworthiness calculation for agent1 and gardening.
// This plan will be triggered to process all agents and goals
// and calculate trustworthiness based on the defined weights and thresholds.
!process_all_agents_and_goals().

//////////////////////////////////////////////
// Plans
//////////////////////////////////////////////


// Plan to iterate through all defined agents and goals,
// then trigger score acquisition and calculation.
+!process_all_agents_and_goals() =>
    #println(": Starting to process all agents and goals for trustworthiness calculation.");
    // Iterate through all agents defined in the agent predicate

    for (A in agent(A)) { // Using agent(AgentName) as in your context
        #println( ": Processing agent: " + A);
        for (Goal in threshold_trustworthiness(Goal, _)) { // Iterates over goals defined here
            #println( ": Processing goal: " + Goal + " for agent: " + A);
            //!acquire_scores(A, Goal);
            !calc_trustworthiness(Agent, Goal); // Trigger trustworthiness calculation for each agent and goal
        };
    }.

// Plan to acquire all scores. This plan is only applicable if all #coms.ask succeed.
+!acquire_scores(A, Goal):
   competence_provider_agent(CPAgent) &&  // Retrieve CPAgent name
    benevolence_provider_agent(BPAgent) && // Retrieve BPAgent name
    integrity_provider_agent(IPAgent) =>

        // #coms.ask calls are in the context. They must succeed and bind variables.
        #coms.ask(CPAgent, competence(A, Goal, CScore));
        #coms.ask(BPAgent, benevolence(A, Goal, BScore));
        #coms.ask(IPAgent, integrity(A, Goal, IScore));

    #println( ": Successfully asked for  all scores for " + A + ", " + Goal ).

// React to competence score received from provider
+competence(A, Goal, CScore) =>
    #println("Received competence for " + A + " on " + Goal + ": " + CScore);
    -competence(A, Goal, _);
    +competence(A, Goal, CScore);
    !maybe_calc_trustworthiness(A, Goal).


// React to benevolence offer received from provider (min and max)
+benevolence_offer(A, Goal, BScoremin, BScoremax) :
    BScore is (BScoremin + BScoremax) / 2 =>
    -benevolence(A, Goal, _);
    +benevolence(A, Goal, BScore);
    #println("Received benevolence offer for " + A + " on " + Goal + ": min=" + BScoremin + ", max=" + BScoremax + ", mean=" + BScore);
    !maybe_calc_trustworthiness(A, Goal).

// React to integrity score received from provider
+integrity(A, Goal, IScore) =>
    #println("Received integrity for " + A + " on " + Goal + ": " + IScore);
    -integrity(A, Goal, _);
    +integrity(A, Goal, IScore);
    !maybe_calc_trustworthiness(A, Goal).

// Plan to check if all scores are available and then calculate trustworthiness
+!maybe_calc_trustworthiness(A, Goal) :
    competence(A, Goal, CScore) &&
    benevolence(A, Goal, BScore) &&
    integrity(A, Goal, IScore) =>
    #println( ": Successfully acquired all scores for " + A + ", " + Goal + ". C=" + CScore + ", B=" + BScore + ", I=" + IScore);
    !calc_trustworthiness(A, Goal).

/*

 * Plan: +!calc_trustworthiness(A, Goal)
 * Purpose: Calculate the trustworthiness of agent A for a specific goal.
 * Combines competence, benevolence, and integrity using defined weights.
 * Handles cases where any attribute is zero, and records reasons for untrustworthiness.
 */
+!calc_trustworthiness(A, Goal):
    competence(A, Goal, C) &&
    benevolence(A, Goal, B) &&
    integrity(A, Goal, I) &&
    weight_competence(WC) &&
    weight_benevolence(WB) &&
    weight_integrity(WI) &&
    threshold_trustworthiness(Goal, T)&&
    decision_maker_agent(DMAgent) =>
    #println("Calculating trustworthiness for " + A + " for goal: " + Goal);
    #println("Competence: " + C);
    #println("Benevolence: " + B);
    #println("Integrity: " + I);
    #println("Weights: " + WC + ", " + WB + ", " + WI);
    #println("Threshold: " + T);
    #println("-------------------------------------------------");

    // Clear any previous trustworthiness/untrustworthiness status for this agent-goal pair
    -trustworthiness(A, Goal, _, _);
    -untrustworthiness(A, Goal, _, _);

    // Record specific reason for untrustworthiness if any attribute is zero
    // Calculate trustworthiness and untrustworthiness
    TrustworthinessScore = ((C * WC) + (B * WB) + (I * WI))/ (WC + WB + WI);
    UntrustworthinessFactor = 1.0 - TrustworthinessScore;

    // Determine reason for untrustworthiness if any attribute is zero
    if (C == 0 && B == 0 && I == 0) {
        Reason = "all_zero";
    } else if (C == 0 && B == 0) {
        Reason = "competence_benevolence_zero";
    } else if (C == 0 && I == 0) {
        Reason = "competence_integrity_zero";
    } else if (B == 0 && I == 0) {
        Reason = "benevolence_integrity_zero";
    } else if (C == 0) {
        Reason = "competence_zero";
    } else if (B == 0) {
        Reason = "benevolence_zero";
    } else if (I == 0) {
        Reason = "integrity_zero";
    } else if (TrustworthinessScore < T) {
        Reason = "below_threshold";
    } else {
        Reason = "above_threshold";
    };

    // Add the correct belief and inform the decision maker
    if (C == 0 || B == 0 || I == 0) {
        +untrustworthiness(A, Goal, UntrustworthinessFactor, Reason);
        #println("- " + A + " is NOT trustworthy for the goal: " + Goal + " (reason: " + Reason + ")");
        #coms.inform(DMAgent, untrustworthiness(A, Goal, UntrustworthinessFactor, Reason));
    } else if (TrustworthinessScore >= T) {
        +trustworthiness(A, Goal, TrustworthinessScore, Reason);
        #println("- " + A + " is trustworthy for the goal: " + Goal + " (score: " + TrustworthinessScore + ")");
        #coms.inform(DMAgent, trustworthiness(A, Goal, TrustworthinessScore, Reason));
    } else {
        +untrustworthiness(A, Goal, UntrustworthinessFactor, Reason);
        #println("- " + A + " is NOT trustworthy for the goal: " + Goal + " (score: " + TrustworthinessScore + ")");
        #println("- Untrustworthiness factor: " + UntrustworthinessFactor);
        #coms.inform(DMAgent, untrustworthiness(A, Goal, UntrustworthinessFactor, Reason));
    }.