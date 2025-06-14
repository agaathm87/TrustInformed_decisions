//////////////////////////////////////////////
// Example of initial beliefs
//////////////////////////////////////////////

agent(tom).
agent(paula).
agent(damian).
trustor(anna).
// --- Initial trust values for each agent ---
trust(tom, 0.5).
trust(paula, 0.5).
trust(damian, 0.5).

// --- Initial goals for each agent ---
goal(tom, gardening).
goal(paula, gardening).
goal(damian, gardening).
goal(tom, cleaning).
goal(paula, cleaning).
goal(damian, cleaning).

// Provide competence, benevolence, integrity, and incompetence scores directly
competence(tom, gardening, 0.8).
competence(paula, gardening, 0.6).
competence(damian, gardening, 0.7).

// incompetence scores for agents
incompetence(paula, gardening, 0.4).


benevolence_offer(tom, gardening, 0.7, 0.9).
benevolence_offer(paula, gardening, 0.5, 0.7).
benevolence_offer(damian, gardening, 0.6, 0.8).

integrity(tom, gardening, 0.85).
integrity(paula, gardening, 0.75).
integrity(damian, gardening, 0.65).

trustworthiness(tom, gardening, 0.85, "above_threshold").
trustworthiness(paula, gardening, 0.7, "above_threshold").
trustworthiness(damian, gardening, 0.6, "below_threshold").

// Untrustworthiness scores for agents
untrustworthiness(damian, gardening, 0.4, "below_threshold").

// For tom
competence(tom, cleaning, 0.7).
benevolence_offer(tom, cleaning, 0.6, 0.8).
integrity(tom, cleaning, 0.8).

// For paula
competence(paula, cleaning, 0.5).
benevolence_offer(paula, cleaning, 0.4, 0.6).
integrity(paula, cleaning, 0.7).

incompetence(paula, cleaning, 0.5).

// For damian
competence(damian, cleaning, 0.6).
benevolence_offer(damian, cleaning, 0.5, 0.7).
integrity(damian, cleaning, 0.75).

// Trustworthiness scores for cleaning
trustworthiness(tom, cleaning, 0.75, "above_threshold").
trustworthiness(paula, cleaning, 0.6, "above_threshold").
trustworthiness(damian, cleaning, 0.55, "below_threshold").

// Untrustworthiness scores for cleaning
untrustworthiness(damian, cleaning, 0.45, "below_threshold").

// --- Agent Name Definitions ---
// These are crucial for communication with other agents
competence_provider_agent("competence"). 
benevolence_provider_agent("benevolence"). 
integrity_provider_agent("integrity").   
decision_maker_agent("decisionCosinesim"). 
trutsworthiness_provider_agent("trustworthiness").   

// --- Relationship Definitions ---
// Define relationships, their types, and strengths

relationship(anna, tom, friend).
relationship(anna, paula, collegue).
relationship(anna, damian, acquaintance).

relationship_strength(anna, tom, 0.9).
relationship_strength(anna, paula, 0.6).
relationship_strength(anna, damian, 0.2).

//////////////////////////////////////////////

// --- Goal and Trustor Scores ---
// Example: goal_scores(Goal, BScore, CScore, IScore).
goal_scores(gardening, 0.75, 0.85, 0.9).
goal_scores(cleaning, 0.65, 0.8, 0.85).
// Example: trustor_scores(Trustor, Goal, BScore, CScore, IScore).
trustor_scores(anna, gardening, 0.7, 0.8, 0.85).
trustor_scores(anna, cleaning, 0.6, 0.75, 0.8).

// --- Derived Beliefs ---
// Calculate benevolence score as the mean of min and max offer
benevolence(A, Goal, BScore) :- benevolence_offer(A, Goal, Bmin, Bmax) && BScore is ((Bmin + Bmax) / 2).

//////////////////////////////////////////////
// Initial goal: Start processing all agents and goals
//////////////////////////////////////////////
!process_all_agents_and_goals().

//////////////////////////////////////////////
// Event Handling Plans
//////////////////////////////////////////////

// Plan to react when trustworthiness information is received
+trustworthiness(Agent, Goal, Score, Reason) =>
    #println( " - Agent: " + Agent + ", Goal: " + Goal + ", Score: " + Score + ", Reason: " + Reason);
    // Store this information or use it for further decision making
    -trustworthiness(Agent, Goal,  _, _); // Clear old one
    +trustworthiness(Agent, Goal, Score, Reason).
    // ... trigger other plans based on this information ...
    // For example: !select_agent_for_goal(Goal);

// Plan to react when untrustworthiness information is received
+untrustworthiness(Agent, Goal, UntrustworthinessFactor, Reason) =>
    #println( " - Agent: " + Agent + ", Goal: " + Goal +  ", Score: " + UntrustworthinessFactor + ", Reason: " + Reason);
    // Store this information or use it for further decision making
    -untrustworthiness(Agent, Goal, _, _); // Clear old one
    +untrustworthiness(Agent, Goal, UntrustworthinessFactor, Reason).

//////////////////////////////////////////////
// Main Processing Plan
//////////////////////////////////////////////

// Plan to iterate through all defined agents and goals,
// then trigger score acquisition and calculation.
+!process_all_agents_and_goals() =>
    #println(": Starting to process all agents and goals for trustworthiness calculation.");
    for (A in agent(A)) {
        #println(": Processing agent: " + A);
        for (Goal in goal(A, Goal)) {
            #println(": Processing goal: " + Goal + " for agent: " + A);
            //!acquire_scores(A, Goal); can be used when communication issue is fixed
            !update_agent_scores(A, Goal); //uncomment if you want to update scores immediately
            #println(": Updated scores for agent " + A + " on goal " + Goal);

        };
    };
    #println(": Finished processing all agents and goals. Triggering selections.");
    // After all processing is done, trigger the selection phase
    !initiate_selections().

// Plan to initiate selections after data processing
+!initiate_selections() =>
    #println("Initiating agent selection process...");
    for (Trustor in trustor(Trustor)) {
         // For each trustor, retrieve their goals
        #println("Processing trustor: " + Trustor);
        for (Goal in trustor_scores(Trustor, Goal, TB, TC, TI)) {
            #println("Selecting agent for goal: " + Goal + " for trustor: " + Trustor);
             // Select an agent for the specific goal
            !select_agent_for_goal(Goal, Trustor);
        };
    }.

//////////////////////////////////////////////
// Plans to Acquire and Store Scores from Providers
//////////////////////////////////////////////

// Plan to acquire all scores. This plan is only applicable if all #coms.ask succeed.
+!acquire_scores(A, Goal):
    competence_provider_agent(CPAgent) &&  // Retrieve CPAgent name
    benevolence_provider_agent(BPAgent) && // Retrieve BPAgent name
    integrity_provider_agent(IPAgent) =>

        // #coms.ask calls are in the context. They must succeed and bind variables.
        #coms.ask(CPAgent, competence(A, Goal, CScore));
        #coms.ask(CPAgent, incompetence(A, Goal, InCScore));
        #coms.ask(BPAgent, benevolence_offer(A, Goal, BScoremin, BScoremax));
        #coms.ask(IPAgent, integrity(A, Goal, IScore));

    #println( ": Successfully asked for all scores for " + A + ", " + Goal ).
 
// React to competence score received from provider
+competence(A, Goal, CScore) =>
    #println("Received competence for " + A + " on " + Goal + ": " + CScore);
    -competence(A, Goal, _);
    +competence(A, Goal, CScore);
    !maybe_update_agent_scores(A, Goal).

// React to incompetence score received from provider
+incompetence(A, Goal, InCScore) =>
    #println("Received incompetence for " + A + " on " + Goal + ": " + InCScore);
    -incompetence(A, Goal, _);
    +incompetence(A, Goal, InCScore);
    !maybe_update_agent_scores(A, Goal).

// React to benevolence offer received from provider (min and max)
+benevolence_offer(A, Goal, BScoremin, BScoremax) :
    BScore is (BScoremin + BScoremax) / 2 =>
    -benevolence(A, Goal, _); // Remove any old value
    +benevolence(A, Goal, BScore); // Store the mean as a fact
    #println("Received benevolence offer for " + A + " on " + Goal + ": min=" + BScoremin + ", max=" + BScoremax + ", mean=" + BScore);
    !maybe_update_agent_scores(A, Goal).

// React to integrity score received from provider
+integrity(A, Goal, IScore) =>
    #println("Received integrity for " + A + " on " + Goal + ": " + IScore);
    -integrity(A, Goal, _);
    +integrity(A, Goal, IScore);
    !maybe_update_agent_scores(A, Goal).

// Helper plan: only calls !update_agent_scores if all three are present
+!maybe_update_agent_scores(A, Goal) :
    competence(A, Goal, _) &&
    benevolence(A, Goal, _) &&
    integrity(A, Goal, _) =>
    !update_agent_scores(A, Goal).

//////////////////////////////////////////////
// Plan to Update Agent Score Vectors
//////////////////////////////////////////////

// Update agent_scores with the new scores
+!update_agent_scores(A, Goal) :
    competence(A, Goal, CScore) &&
    benevolence(A, Goal, BScore) &&
    integrity(A, Goal, IScore) =>
    #println(": Successfully acquired all scores for " + A + ", " + Goal + ". C=" + CScore + ", B=" + BScore + ", I=" + IScore);
    -agent_scores(A, Goal, _, _, _); // Remove old if exists
    +agent_scores(A, Goal, BScore, CScore, IScore);
    !print_vectors(A, Goal).

//////////////////////////////////////////////
// Utility Plans for Printing and Sending Vectors and Scores
//////////////////////////////////////////////

// Print agent, trustor, and goal vectors for debugging
+!print_vectors(A, Goal) :
    agent_scores(A, Goal, B, C, I) &&
    goal_scores(Goal, GB, GC, GI) &&
    trustor_scores(Trustor, Goal, TB, TC, TI)  =>

    #println("Agent vector: [" + B + ", " + C + ", " + I + "]");
    #println("Goal vector: [" + GB + ", " + GC + ", " + GI + "]");

    #println("Sending agent vector for " + A + " and goal " + Goal);
    !send_agent_vector(A, Goal, B, C, I);
    #println("Sending goal vector for goal " + Goal);
    !send_goal_vector(Goal, GB, GC, GI);

    for (Trustor in trustor_scores(Trustor, Goal, TB, TC, TI)) {
        #println("Trustor vector: [" + TB + ", " + TC + ", " + TI + "]");
        #println("Sending trustor vector for trustor " + Trustor + " and goal " + Goal);
        !send_trustor_vector(Trustor, Goal, TB, TC, TI);
    };
    
    #println("Sending all scores to Java for agent " + A + " and goal " + Goal);
    !send_benevolence(A, Goal, B);
    !send_competence(A, Goal, C);
    !send_integrity(A, Goal, I);
    // Send all incompetence values if they exist
    for (InComp in incompetence(A, Goal, InComp)) {
        #println("Sending incompetence for " + A + " on " + Goal + ": " + InComp);
        !send_incompetence(A, Goal, InComp);
    };
    // Send all trustworthiness values if they exist
    for (TScore in trustworthiness(A, Goal, TScore, _)) {
        #println("Sending trustworthiness for " + A + " on " + Goal + ": " + TScore);
        !send_trustworthiness(A, Goal, TScore);
    };
    // Send all untrustworthiness values if they exist
    for (UT in untrustworthiness(A, Goal, UT, _)) {
        #println("Sending untrustworthiness for " + A + " on " + Goal + ": " + UT);
        !send_untrustworthiness(A, Goal, UT);
    };
    // Call the trustor/relationship sending plan here
    !send_relationships(A, Trustor).

+!send_relationships(A, Trustor)  =>
        // Send all relationships if they exist
    for (Trustor in relationship(Trustor, A, Type)) {
        for (Type in relationship(Trustor, A, Type)) {
            for (Strength in relationship_strength(Trustor, A, Strength)) {
                #println("Sending relationship for " + Trustor + " with agent " + A + ": Type=" + Type + ", Strength=" + Strength);
                // Call the Java method to send the relationship
                !send_relationship(Trustor, A, Type, Strength);
            };
        };
    }.

// Send agent vector (benevolence, competence, integrity) to Java
+!send_agent_vector(A, Goal, B, C, I) =>
    #nl.uva.agentselection.AgentSelectionLogic.addAgentVector(A, Goal, B, C, I).

// Send goal vector to Java
+!send_goal_vector(Goal, GB, GC, GI) =>
    #nl.uva.agentselection.AgentSelectionLogic.addGoalVector(Goal, GB, GC, GI).

// Send trustor vector to Java
+!send_trustor_vector(Trustor, Goal, TB, TC, TI) =>
    #nl.uva.agentselection.AgentSelectionLogic.addTrustorVector(Trustor, Goal, TB, TC, TI).

// Send trustworthiness score to Java
+!send_trustworthiness(A, Goal, TScore) =>
    #nl.uva.agentselection.AgentSelectionLogic.addTrustworthiness(A, Goal, TScore).

// Send untrustworthiness score to Java
+!send_untrustworthiness(A, Goal, UScore) =>
    #nl.uva.agentselection.AgentSelectionLogic.addUntrustworthiness(A, Goal, UScore).

// Send benevolence score to Java
+!send_benevolence(A, Goal, B) =>
    #nl.uva.agentselection.AgentSelectionLogic.addBenevolence(A, Goal, B).

// Send competence score to Java
+!send_competence(A, Goal, C) =>
    #nl.uva.agentselection.AgentSelectionLogic.addCompetence(A, Goal, C).

// Send integrity score to Java
+!send_integrity(A, Goal, I) =>
    #nl.uva.agentselection.AgentSelectionLogic.addIntegrity(A, Goal, I).

// Send incompetence score to Java
+!send_incompetence(A, Goal, InCScore) =>
    #nl.uva.agentselection.AgentSelectionLogic.addIncompetence(A, Goal, InCScore).

// Send relationship (type and strength) to Java
+!send_relationship(Trustor, A, Type, Strength) =>
    #nl.uva.agentselection.AgentSelectionLogic.addRelationship(Trustor, A, Type, Strength).

//////////////////////////////////////////////
// Agent Selection and Trust Update
//////////////////////////////////////////////

// Example initial goal for decision_maker (if any)
+!select_agent_for_goal(Goal, Trustor) =>
    // Call the Java selection logic and bind the result to SelectedAgent
    SelectedAgent =  #nl.uva.agentselection.AgentSelectionLogic.startHierarchicalSelection(Goal, Trustor);
    #println("Selected agent for " + Goal + " by " + Trustor + ": " + SelectedAgent);
    // Call pllan to update trust for the selected agent based on trustworthiness and scores
    !maybe_update_trust_for_selected(SelectedAgent, Goal).

+!maybe_update_trust_for_selected(SelectedAgent, Goal) :
    trustworthiness(SelectedAgent, Goal, TScore, Reason) &&
    agent_scores(SelectedAgent, Goal, BScore, CScore, IScore) && 
    relationship(Trustor, SelectedAgent, Type) =>

    // Print Information for Agent Selection
    #println("-------------------------------------------------");
    #println("Selected agent: " + SelectedAgent + " with trustworthiness: " + TScore + " Reason: " + Reason); 
    #println("Scores for " + SelectedAgent + " on goal " + Goal + ": B=" + BScore + ", C=" + CScore + ", I=" + IScore);
    #println("Relationship with trustor: " + Trustor + ", Type: " + Type);
    #println("-------------------------------------------------");

        // Print all untrustworthiness scores for this agent and goal
    for (UScore in untrustworthiness(SelectedAgent, Goal, UScore, UReason)) {
        #println("Agent" + SelectedAgent + "for " + Goal + ": " +" has minimum Untrustworthinessfactor: " + UScore + ")" + "(" + UReason + ")");
    };

    // Print all incompetence scores for this agent and goal
    for (InCScore in incompetence(SelectedAgent, Goal, InCScore)) {
        #println("Agent" + SelectedAgent + " for " + Goal +"has minimum incompetence score: " + InCScore);
    };

    // Print cosine similarity for selected agent and goal
    AgentGoalSim = #nl.uva.agentselection.AgentSelectionLogic.getAgentGoalCosineSimilarity(SelectedAgent, Goal);
    #println("Cosine similarity (Agent-Goal) for " + SelectedAgent + " and " + Goal + ": " + AgentGoalSim);

    // Print cosine similarity for trustor and selected agent
    TrustorAgentSim = #nl.uva.agentselection.AgentSelectionLogic.getTrustorAgentCosineSimilarity(Trustor, SelectedAgent, Goal);
    #println("Cosine similarity (Trustor-Agent) for " + Trustor + " and " + SelectedAgent + " on " + Goal + ": " + TrustorAgentSim);
    #println("-------------------------------------------------");

    #println("Updating overall trust for " + SelectedAgent + " based on goal: " + Goal);
    // Update the overall trust for the selected agent based on the trustworthiness score
    !update_overall_trust(SelectedAgent, TScore).

// Plan to update overall trust based on the outcome of a goal
+!update_overall_trust(A, Outcome) :
    trust(A, OldTrust) =>
    LearningRate = 0.1; // How fast trust changes (tune as needed)
    NewTrust = OldTrust + LearningRate * (Outcome - OldTrust);
    -trust(A, OldTrust);
    +trust(A, NewTrust);
    #println("Updated trust for " + A + ": " + NewTrust).