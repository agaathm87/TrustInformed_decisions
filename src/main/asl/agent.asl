//////////////////////////////////////////////////////////////////////
///////////////////// INTIAL BELIEFS /////////////////////////////////
//////////////////////////////////////////////////////////////////////


/////////////////// AS ///////////////////////////////////////////
agent(damian).
agent(tom).
agent(paula).
trustor(anna).

trust(tom, 0.5).
trust(paula, 0.5).
trust(damian, 0.5).

goal(damian, gardening).
goal(damian, cleaning).
goal(paula, gardening).
goal(paula, cleaning).
goal(tom, gardening).
goal(tom, cleaning).

subplan(gardening, weeding).
subplan(cleaning, dusting).

// Optional input for benevolence, competence
benevolence(damian, fun, 0, 0).
benevolence(damian, health, 0, 0).
benevolence(paula, fun, 0, 0).
benevolence(paula, health, 0, 0).
benevolence(tom, fun, 0, 0).
benevolence(tom, health, 0, 0).

// Value satisfaction for each plan (phi)
phi(damian, fun, gardening, 0.9).
phi(damian, health, gardening, 1.0).
phi(damian, fun, cleaning, 0.1).
phi(damian, health, cleaning, 0.1).
phi(damian, fun, repairing, 0.6).
phi(damian, health, repairing, 0.6).

phi(paula, fun, gardening, 0.8).
phi(paula, health, gardening, 0.9).
phi(paula, fun, cleaning, 0.2).
phi(paula, health, cleaning, 0.3).

phi(tom, fun, gardening, 0.7).
phi(tom, health, gardening, 0.8).
phi(tom, fun, cleaning, 0.3).
phi(tom, health, cleaning, 0.2).

/////////////////// PRINCIPLES ///////////////////////////////////////
// Input for integrity
principle(gardening, honesty, 0.8).
principle(gardening, reliability, 0.7).
principle(cleaning, honesty, 0.3).
principle(cleaning, reliability, 0.9).


/////////////////// INTENTIONS ///////////////////////////////////////
// Input for competence, integrity
// Output of benevolence

intention(damian, gardening).
intention(paula, cleaning).
intention(tom, gardening).
intention(tom, cleaning).

///////////////// ACTIONS ////////////////////////////////////////////
// Input for benevolence
offer(damian, cleaning, gardening, offer2).
offer(damian, repairing, gardening, offer1).
offer(paula, cleaning, gardening, offer3).
offer(tom, cleaning, gardening, offer4).

reject(damian, offer2, fun).
reject(damian, offer2, health).

///////////////// RESULTS ////////////////////////////////////////////
// Input for competence
succes(damian, gardening).
failure(paula, cleaning).

////////////// VALUE OF PLANS ////////////////////////////////////////

value(damian, honesty, 0.7).
value(damian, reliability, 0.8).
value(paula, honesty, 0.5).
value(paula, reliability, 0.9).
value(tom, honesty, 0.9).
value(tom, reliability, 0.6).

/////////////// ACTIONS ////////////////////////////////

// Knowledge, resources, skills for actions and subactions
knowledge(tom, gardening, edible, 0.8).
resource(tom, gardening, tools, 0.2).
resource(tom, gardening, time, 0.5).
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
resource(paula, gardening, time, 0.5).
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
resource(damian, gardening, time, 0.5).
skill(gardening, ability, 0.9).

knowledge(damian, weeding, herbology, 0.7).
resource(damian, weeding, tools, 0.6).
skill(damian, weeding, ability, 0.8).

knowledge(damian, cleaning, surfaces, 0.5).
resource(damian, cleaning, vacuum, 0.6).
skill(damian, cleaning, thoroughness, 0.4).

knowledge(damian, dusting, surfaces, 0.6).
resource(damian, dusting, duster, 0.7).
skill(damian, dusting, attention, 0.5).


//////////////////////////////////////////////////////////////////////
// DERIVED BELIEFS///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////

// --- Helper Predicates for Competence, Integrity, and Benevolence Calculation ---

// Helper predicates to check for missing or zero values competence calculation
missing_or_zero_resource(A, Action, Condition) :- not resource(A, Action, Condition, _) ||  resource(A, Action, Condition, 0).
missing_or_zero_skill(A, Action, Condition) :- not skill(A, Action, Condition, _) || skill(A, Action, Condition, 0).
missing_or_zero_knowledge(A, Action, Condition) :- not knowledge(A, Action, Condition, _) || knowledge(A, Action, Condition, 0).

// Helper predicate to check for missing or zero values benevolence calculation
missing_or_zero_benevolence(Agent, Value) :- not benevolence(Agent, Value, _, _) || benevolence(Agent, Value, Bmin, 0).

// Helper predicate to check for missing or zero values integrity calculation
missing_or_zero_value(Agent, Principle, Value):- value(Agent, Principle, 0)|| not value(Agent, Principle, _).

// --- Derived Beliefs ---
// Calculate benevolence score as the mean of min and max offer
benevolence(A, Goal, BScore) :- benevolence_offer(A, Goal, Bmin, Bmax) && BScore is ((Bmin + Bmax) / 2).

//////////////////////////////////////////////////////////////////////
// THRESHOLDS, WEIGHTS AND COUNTERS 
///////////////////////////////////////////////////////////////

// Example value weights (add these to your initial beliefs) benevolence
value_weight(fun, 0.6).
value_weight(health, 0.4).

// Initializing variables counters benevolence
totalbenmin(0).
totalbenmax(0).
number_of_values(_, 0).
accepted_values(_, 0).
total_combined_weight(0).

// Weights for resource, skill, and knowledge in competence calculation
weight_resource(0.3).
weight_skill(0.4).
weight_knowledge(0.3).

// Initialisers for counters used in competence calculation
number_of_subs(_, 0).
succeeded_subs(_, 0).
competence_sub(_, _, 0).


// Weights for each principle (importance)
weight(honesty, 0.6).
weight(reliability, 0.4).

// Variables for calculations integrity
threshold(0.7).

// Define weights for each attribute in trustworthiness calculation
weight_competence(0.4).
weight_benevolence(0.6).
weight_integrity(0.3).

// Define threshold for trustworthiness for a specific goal
threshold_trustworthiness(gardening, 0.7).

// --- Goal and Trustor Scores ---
// Example: goal_scores(Goal, BScore, CScore, IScore).
goal_scores(gardening, 0.75, 0.85, 0.9).
goal_scores(cleaning, 0.65, 0.8, 0.85)..

// Example: trustor_scores(Trustor, Goal, BScore, CScore, IScore).
trustor_scores(anna, gardening, 0.7, 0.8, 0.85).
trustor_scores(anna, cleaning, 0.6, 0.75, 0.8).

// preequisits for plans competence
prerequisits(gardening, knowledge, edible).
prerequisits(gardening, resource, time).
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

// --- Relationship Definitions ---
// Define relationships, their types, and strengths
relationship(tom, damian, friend).
weight_relationship(friend, 0.8 ).
relationship_strength(tom, damian, 0.9).
relationship(paula, tom, collegue).
weight_relationship(collegue, 0.5 ).
relationship_strength(paula, tom, 0.6).
relationship(damian, paula, acquaintance).
weight_relationship(acquaintance, 0.3 ).
relationship_strength(damian, paula, 0.2).
relationship(tom, paula, friend).
weight_relationship(friend, 0.8 ).
relationship_strength(tom, paula, 0.4).

/////////////////////////////////////////////////////////////////////
// MAIN PROGRAM
/////////////////////////////////////////////////////////////////////
!update_trustworthiness().

+!update_trustworthiness() =>
    for (A in agent(A)) {
    !update_benevolence(A);
    !update_integrity(A);
    !update_competence(A);
    !process_trustworthiness(A);
    !process_selection(A);
    }.

//////////////////////////////////////////////////////////////////////
// BENEVOLENCE
/////////////////////////////////////////////////////////////////////

// Plans

    // Respond to #coms.ask for offer_acceptable
//+?offer_acceptable(A, Offer) =>
 //   #println("Received ask: is offer " + Offer + " acceptable for " + A + "?");
 //   !evaluate_offer(A, Offer).

// Adapt incoming decision via  #coms.inform(A, offer_decision(A, Offer, Decision))
    /*
 * Plan: +offer_decision(A, Offer, Decision)
 * Purpose: Handle the response from the asked benevolence agent.
 */
//+offer_decision(A, Offer, accept) =>
    //#println("Offer " + Offer + " was accepted by " + A + ".");
    //+accept(A, Offer);
    //-pending_offer_decision(Offer).
    //!process_offers(A).
    // Proceed with next steps...

    //+offer_decision(A, Offer, rejected) =>
    //#println("Offer" + Offer + " was rejected by " + A + ".");
    //!process_offers(A).

//+offer_decision(A, Offer, reject, Value) =>
    //#println("Value "+Value+"in offer" + Offer + " was rejected by " + A + ".");
    //+reject(A, Offer, Value).

/*
 * Plan: +!update_benevolence(A)
 * Purpose: Check and initialize benevolence intervals for agent A.
 * If benevolence is not initialized (Bmax==0), initialize it.
 * Otherwise, process all offers for the agent.
 */
// Plan 1: If benevolence is present and max > 0, just update
+!update_benevolence(A) :
    benevolence(A, Value, Bmin, Bmax) && 
    Bmax > 0 =>
    #println("------Updating benevolence of agent " + A + "------");
    !process_offers(A).

// Plan 2: If benevolence is missing or max is 0, initialize
+!update_benevolence(A) :
    missing_or_zero_benevolence(A, Value) =>
    #println("------Missing or zero benevolence found for agent " + A + " and value " + Value + ". Initializing benevolence.------");
    !initialize_benevolence(A, Value).
/*
 * Plan: +!process_offers(A)
 * Purpose: Process all offers made to agent A.
 * For each offer, call !evaluate_offer to update benevolence.
 */
+!process_offers(A) =>
    #println("------Processing offers for agent " + A + "------");
    // Process offers
    for (Offer in offer(A, NewPlan, OldPlan, Offer)) {
        #println("We are now updating according to " + Offer + ".");
        #println("We don't know if " + Offer + " is accepted. We will try to find out now.");
        !evaluate_offer(A, Offer);
    }.

    /*
 * Plan: +!init_benevolence_counters(Offer)
 * Purpose: Initialise counters for the number of values and accepted values for a given offer.
 * This ensures that counting starts from zero before evaluating benevolence for an offer.
 */
+!init_benevolence_counters(Offer) :
    not number_of_values(Offer, _) =>
    +number_of_values(Offer, 0);
    +accepted_values(Offer, 0).
/*
 * Plan: +!initialize_benevolence(A,Value)
 * Purpose: Initialize benevolence intervals for agent A and value, based on relationship if available.
 * If relationship data is present, use it to set the lower bound.
 * Otherwise, use default [0,1] interval.
 */
+!initialize_benevolence(A,Value): 
    relationship(B,A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultMin = (Strength * W) ;
    for (Value in benevolence(A, Value, _, _)) {
        #println("Initialized benevolence for " + A + " on " + Value + " from relationship with " + B + ": [" + DefaultMin + ", 1 ]");
        -benevolence(A, Value, 0, 0);
        +benevolence(A, Value, DefaultMin, 1);
    };
    !process_offers(A).

// Fallback: initialize benevolence to [0,1] if no relationship data
+!initialize_benevolence(A,Value)=>
    for (Value in benevolence(A, Value, _, _)) {
        #println("No relationship data found. Using default benevolence [0, 1] for " + Value);
        -benevolence(A, Value, 0, 0);
        +benevolence(A, Value, 0, 1);
    };
    !process_offers(A).

+!init_combined_weights(A, Offer, NewPlan) =>
    for (Value in phi(A, Value, NewPlan, _)) {
        !get_combined_weight(Value, CombinedWv);

    }.
/*
 * Plan: +!evaluate_offer(A, Offer)
 * Purpose: Evaluate an offer for agent A.
 * If accepted, update intentions and benevolence for accepted values.
 * If rejected, update benevolence for rejected values.
 * If undecided, process each value and compute predicted benevolence scores or ask agent for acceptance/rejection amd then calculate.
 */
+!evaluate_offer(A, Offer) :
    offer(A, NewPlan, OldPlan, Offer) &&
    accept(A, Offer) =>
    !init_benevolence_counters(Offer);
    !init_combined_weights(A, Offer, NewPlan);
    #println("The offer was accepted.");
    -intention(A, OldPlan);
    +intention(A, NewPlan);
    for (Value in phi(A, Value, NewPlan, X1)) {
        -val_comp(Offer, 0);
        +val_comp(Offer, 1);

        // Update benevolence for accepted values
        !compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan);
        !comp_sum_ben(A, Offer, Value);
        !comp_values(A, Offer);
        !update_benevolence_accept(A, Value, NewPlan, OldPlan);
    };
    // After all values, aggregate benevolence for the offer
    !comp_total_ben(A, Offer).

+!evaluate_offer(A, Offer) :
    offer(A, NewPlan, OldPlan, Offer)&&
    reject(A, Offer, _) =>
    !init_benevolence_counters(Offer);
    !init_combined_weights(A, Offer, NewPlan);
    #println("The offer was rejected.");
    for (Value in reject(A, Offer, Value)) {
        #println("It was rejected on the basis of " + Value + ".");
        -val_comp(Offer,_);
        +val_comp(Offer,0);
        
        // Update benevolence for rejected values
        !compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan);
        !comp_sum_ben(A, Offer, Value);
        !comp_values(A, Offer);
        !update_benevolence_reject(A, Offer, Value);
    };
    // After all values, aggregate benevolence for the offer
    !comp_total_ben(A, Offer).

+!evaluate_offer(A, Offer) =>
    #println("It is not known yet whether " + A + " accepted or rejected the offer.");
    OtherAgent = "A";
    #println("Asking " +  OtherAgent+ " if they accept offer " + Offer + ".");
    //#coms.ask(OtherAgent, offer_acceptable(OtherAgent, Offer));
    +pending_offer_decision(Offer);
// If no response is received, evaluate the offer locally
    !check_offer_response(A, Offer).

+!check_offer_response(A, Offer) : pending_offer_decision(Offer) =>
    #println("No response received for offer " + Offer + ". Running local evaluation.");
    -pending_offer_decision(Offer);
    !evaluate_offer_local(A, Offer).
/*
 * Plan: +!evaluate_offer(A, Offer)
 * Purpose: If acceptance/rejection is not known, process each value in the offer.
 * For each value, evaluate and compute benevolence score.
 */
+!evaluate_offer_local(A, Offer) :
    offer(A, NewPlan, OldPlan, Offer)  =>
    !init_benevolence_counters(Offer);
    !init_combined_weights(A, Offer, NewPlan);
    #println("It is not known yet whether " + A + " accepted or rejected the offer.");
    #println("Evaluating offer: " + Offer);
    #println("Processing values for offer: " + Offer);
    
    // For each value, evaluate and compute benevolence score
    for (Value in phi(A, Value, NewPlan, Y)) {
        !evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan, Y); 
        !compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan);
        !comp_sum_ben(A, Offer, Value);
    };
    // Decide on overall offer acceptance/rejection
    !evaluate_offer_decision(A, Offer, NewPlan, OldPlan).
 // Uncomment and adapt the following line as needed:
    //#coms.ask(OtherAgent, offer_acceptable(OtherAgent, Offer)).
/*
 * Plan: +!evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan, Y)
 * Purpose: Evaluate a single value in an offer.
 * Accept if demotion is within benevolence threshold, otherwise reject.
 */
+!evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan, Y) :
    benevolence(A, Value, Bmin, Bmax) &&
    Z is Bmin + Bmax / 2 &&
    phi(A, Value, OldPlan, T) &&
    phi(A, Value, NewPlan, Y) =>


    Ben = Y + Z;

    #println("Processing value: " + Value + " for offer: " + Offer);
    // Accept if demotion is within benevolence threshold 
    if (T =< Ben) {
        #println(A + " accepts value " + Value);
        -val_comp(Offer, _);
        +val_comp(Offer, 1);
    } else {
        #println(A + " rejects value " + Value);
        +reject(A, Offer, Value);
        -val_comp(Offer, _);
        +val_comp(Offer, 0);
    };
    // Update counters for this value
    !comp_values(A, Offer).

/*
 * Plan: +!comp_values(A, Offer)
 * Purpose: Update running totals for number of values and accepted values for an offer.
 */
+!comp_values(A, Offer) :
    val_comp(Offer, ValComp) &&
    number_of_values(Offer, NV) &&
    accepted_values(Offer, AV) =>
    NewNV = (NV + 1);
    NewAV = (AV + ValComp);
    #println("Updating counters for offer: " + Offer + ". Total values: " + NewNV + ", Accepted values: " + NewAV);
    // Update running totals
    -number_of_values(Offer, NV);
    +number_of_values(Offer, NewNV);
    -accepted_values(Offer, AV);
    +accepted_values(Offer, NewAV).

/*
 * Plan: +!evaluate_offer_decision(A, Offer, NewPlan, OldPlan)
 * Purpose: Decide whether to accept or reject the offer based on accepted values.
 * If all values are accepted, accept the offer; otherwise, reject.
 * After decision, aggregate benevolence for the offer.
 */
+!evaluate_offer_decision(A, Offer, NewPlan, OldPlan) :
    number_of_values(Offer, NV) &&
    accepted_values(Offer, AV) &&
    offer(A, NewPlan, OldPlan, Offer) =>
    #println("Evaluating decision for offer: " + Offer);
    #println("Total values: " + NV + ", Accepted values: " + AV);

    // Accept if all values are accepted, otherwise reject
    if (NV == AV) {
        #println(A + " accepts the offer: " + Offer);
        !handle_acceptance(A, NewPlan, OldPlan);
        //#coms.inform(Asker, offer_decision(A, Offer, accept));

    } else {
        #println(A + " rejects the offer: " + Offer);
        !handle_rejection(A, Offer);
        //#coms.inform(Asker, offer_decision(A, Offer, reject));

    };
    // After decision, aggregate benevolence for the offer
    !comp_total_ben(A, Offer).
    
    // are these functions a correct translations of this
    //wrongplan(X,V):- phi(V,X,Y) && benevolence(V,Z) && initial(Plan) && phi(V,Plan,T) && Ben is (Y+Z) && T>Ben.
    //acceptable(X):- not wrongplan(X,_).
    //+?benevolent(Y,X): inplan(Z,X) && acceptable(Z) => #println("acceptable plan " + Z).

/*
 * Plan: +!compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan)
 * Purpose: Calculate benevolence score for a single value using a sigmoid function.
 * Updates min and max benevolence scores for the value.
 */
+!compute_benevolence_score_value(A, Offer, Value, NewPlan, OldPlan) :
    benevolence(A, Value, Bmin, Bmax) &&
    phi(A, Value, OldPlan, T) &&
    phi(A, Value, NewPlan, Y) =>
    Demotion = T - Y;
    BenMax = Y + Bmax;
    BenMin = Y + Bmin;
    Alpha=10;

    // Calculate sigmoid scores for min and max benevolence
    ExponentMin = (Alpha * (Demotion - BenMin));
    ExpValMin = (#nl.uva.exp.ExponentCalculator.calculateExponent(ExponentMin));
    ScoreMin = (1 / (1 + ExpValMin));

    ExponentMax = (Alpha * (Demotion - BenMax));

    ExpValMax =  (#nl.uva.exp.ExponentCalculator.calculateExponent(ExponentMax));
    ScoreMax = (1 / (1 + ExpValMax));

    // Update belief base with latest scores for this value
    -benevolence_score_min(A, Offer, Value, _);
    +benevolence_score_min(A, Offer, Value, ScoreMin);
    -benevolence_score_max(A, Offer, Value, _);
    +benevolence_score_max(A, Offer, Value, ScoreMax);

    #println("Value " + Value + ": demotion=" + Demotion + ", Bmin=" + Bmin + ", Bmax=" + Bmax + ", scoreMin=" + ScoreMin + ", scoreMax=" + ScoreMax).

    +!get_combined_weight(Value, CombinedWv) :
    benevolence(A, Value, Bmin, Bmax)  &&
    value_weight(Value, Wcontext)  &&
    Z is Bmin + Bmax / 2  &&
    phi(A, Value, NewPlan, Y) =>
    Ben = Y + Z;
    Epsilon = 0.01;
    Wgamma = 1 / (Ben + Epsilon);
    CombinedWv = Wgamma * Wcontext;
    -combined_weight(Value, _);
    +combined_weight(Value, CombinedWv).
/*
 * Plan: +!comp_sum_ben(A, Offer, Value)
 * Purpose: Sum per-value benevolence scores for an offer and store the totals.
 */
+!comp_sum_ben(A, Offer, Value):
    benevolence_score_min(A, Offer, Value, ScoreMin) &&
    benevolence_score_max(A, Offer, Value, ScoreMax) &&
    combined_weight(Value, CombinedWv) &&
    value_weight(Value, Wv) &&
    totalbenmin(TotalBenMin) &&
    totalbenmax(TotalBenMax)&&
    total_combined_weight(TotalW) =>
    
    
    WeightedScoreMin = CombinedWv * ScoreMin;
    WeightedScoreMax = CombinedWv * ScoreMax;

    SumMin = TotalBenMin + WeightedScoreMin;
    SumMax = TotalBenMax + WeightedScoreMax;
    NewTotalW = TotalW + CombinedWv;

    // Update belief base with new sums
    #println("Processing value: " + Value + " for offer: " + Offer);
    #println("Current total benevolence min: " + TotalBenMin + ", max: " + TotalBenMax);
    #println("Adding score for value " + Value + ": scoreMin=" + ScoreMin + ", scoreMax=" + ScoreMax);
    #println("New total benevolence min: " + SumMin + ", max: " + SumMax);

    // Store the sums as beliefs for later normalization
    -totalbenmin(TotalBenMin);
    +totalbenmin(SumMin);
    -totalbenmax(TotalBenMax);
    +totalbenmax(SumMax);
    -total_combined_weight(TotalW);
    +total_combined_weight(NewTotalW).

/*
 * Plan: +!comp_total_ben(A, Offer)
 * Purpose: Normalize the summed benevolence scores and reset counters.
 * Stores the normalized benevolence interval for the offer.
 */
+!comp_total_ben(A, Offer):
    totalbenmin(SumMin) &&
    totalbenmax(SumMax) &&
    total_combined_weight(TotalW) =>

    #println("---- Calculating normalized benevolence interval for offer " + Offer + " ----");

    // Calculate normalized interval (average over all values)
    NormalizedMin = SumMin / TotalW;
    NormalizedMax = SumMax / TotalW;

    // Store and print the result
    -benevolence_offer(A, Offer, _, _);
    +benevolence_offer(A, Offer, NormalizedMin, NormalizedMax);
    #println("Normalized benevolence interval for offer " + Offer + " by " + A + ": [" + NormalizedMin + ", " + NormalizedMax + "]");

    // Reset counters for this offer for future use
    -totalbenmin(SumMin);
    +totalbenmin(0);
    -totalbenmax(SumMax);
    +totalbenmax(0);
    -total_combined_weight(TotalW);
    +total_combined_weight(0);
    -number_of_values(Offer, NV);
    +number_of_values(Offer, 0);
    -accepted_values(Offer, AV);
    +accepted_values(Offer, 0).

/*
 * Plan: +!handle_acceptance(A, NewPlan, OldPlan)
 * Purpose: Handle acceptance of an offer by updating intentions and benevolence for all values.
 */
+!handle_acceptance(A, NewPlan, OldPlan) =>
    #println("Handling acceptance for " + A);
    -intention(A, OldPlan);
    +intention(A, NewPlan);
    // Update benevolence for each value in the new plan
    for (Value in phi(A, Value, NewPlan, _)) {
        #println("Updating benevolence for accepted value: " + Value);
        !update_benevolence_accept(A, Value, NewPlan, OldPlan);
    }.

/*
 * Plan: +!handle_rejection(A, Offer)
 * Purpose: Handle rejection of an offer by updating benevolence for all rejected values.
 */
+!handle_rejection(A, Offer) =>
    #println("Handling rejection for " + A);
    // Update benevolence for rejected values
    for (Value in reject(A, Offer, Value)) {
        #println("Updating benevolence for rejected value: " + Value);
        !update_benevolence_reject(A, Offer, Value);
    }.

/*
 * Plan: +!update_benevolence_reject(A, Offer, Value)
 * Purpose: Update benevolence interval based on rejection (tighten upper bound).
 */
+!update_benevolence_reject(A, Offer, Value) :
    // Retrieve the relevant plans and benevolence interval
    offer(A, NewPlan, OldPlan, Offer) &&
    phi(A, Value, NewPlan, X1) &&
    phi(A, Value, OldPlan, X2) &&
    benevolence(A, Value, Bmin, Bmax) =>
    B = X2 - X1; // Calculate demotion

    // If demotion is negative, something is inconsistent
    if (B < 0) {
        #println("Either " + A + " did not actually reject the offer on the basis of " + Value + " or your assessment of his enjoyment of the plans is incorrect.");
        #println("His benevolence will therefore not be updated according to this information.");
    } 
    // If demotion is less than Bmin, previous assessment was too high
    else if (B < Bmin ) {
        #println("Your previous assessment of his benevolence seems to have been too high.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, 0, B);
        #println("The offer was rejected on the basis of " + Value + ".");
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is [" + 0 + ", " + B + ">.");
    }
    // Otherwise, update the upper bound of the interval
    else {
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, Bmin, B);
        #println("The offer was rejected on the basis of " + Value + ".");
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is [" + Bmin + ", " + B + ">.");
    }.

/*
 * Plan: +!update_benevolence_accept(A, Value, NewPlan, OldPlan)
 * Purpose: Update benevolence interval based on acceptance (tighten lower bound or expand upper bound).
 */
+!update_benevolence_accept(A, Value, NewPlan, OldPlan) :
    // Retrieve value satisfaction and benevolence interval
    phi(A, Value, NewPlan, X1) &&
    phi(A, Value, OldPlan, X2) &&
    benevolence(A, Value, Bmin, Bmax) =>
    #println("One of the relevant values was " + Value + ".");
    B = X2 - X1; // Calculate demotion

    // If demotion is negative, the agent did not sacrifice this value
    if (B < 0) {
        #println("It seems " + A + " did not need to sacrifice " + Value + " to accept this plan.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, 0, Bmax);
        #println("The previous interval was " + Bmin + ", " + Bmax);
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + 0 + ", " + Bmax + ".");
    } 
    // If demotion is greater than Bmax, agent is more benevolent than thought
    else if (B > Bmax) {
        #println("It seems " + A + " is even more benevolent than you thought was possible.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, B, 1);
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + B + ", " + 1 + ".");
    } 
    // Otherwise, update the lower bound of the interval
    else {
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, B, Bmax);
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is [" + B + ", " + Bmax + ">.");
    }.

//////////////////////////////////////////////////////////////////////
// COMPETENCE
/////////////////////////////////////////////////////////////////////

// Plans
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

//////////////////////////////////////////////////////////////////////
// INTEGRITY
/////////////////////////////////////////////////////////////////////

/*
 * Plan: +!update_integrity(A, Plan)
 * Purpose: Main plan to update the integrity of agent A.
 * For each principle, process intentions and calculate distances.
 */
+!update_integrity(A) =>
   for (Plan in intention(A, Plan)) {
    -sum(A, Plan, _);      // Remove any old sum for this agent/plan
    +sum(A, Plan, 0.0);    // Initialize to 0.0
    -dMax(A, Plan, _);     // Remove any old dMax for this agent/plan
    +dMax(A, Plan, 0.0);   // Initialize to 0.0

    #println("-------Update the integrity of Agent " + A + "for plan" + Plan+"------");
    // For each principle X in any plan, process intentions and distances
    for (X in principle(Plan, X, P)) {
        !get_principle_intention(A,Plan, X); // Process intentions for each principle
        !distanceMax(A,Plan, 1); // Update max distance for normalization
    };
    !normalizedDistance(A, Plan); // Normalize and print integrity
   }.

/*
 * Plan: +!get_principle_intention(A, Plan, X)
 * Purpose: For a given principle X, process all plans A intends to do.
 * Ensures value is set, processes intentions, and sums weighted distances.
 */
+!get_principle_intention(A, Plan, X):
    missing_or_zero_value(Agent, X, Value) =>
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
    -insencere(A, X, _); // Remove old insincerity (note typo: should be insincere)
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
    !assign_intention(A,X). // Assign default intention

//*
 //* Plan: +!assign_intention(A, X)
 //* Purpose: Assign intention based on relationship if available, otherwise use principle value.
 //*//
+!assign_intention(A, X) :
    principle(Plan, X, P) &&
    relationship(B, A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultIntention = (Strength * W); // Calculate default intention from relationship
    #println("Assigning intention for " + A + " on " + X + " based on relationship with " + B + ": "+ DefaultIntention);
    -intention(A, X, _); // Remove old intention
    +intention(A, X, DefaultIntention). // Add new intention

// Fallback: Assign intention based on principle value
+!assign_intention(A, X) :
    principle(Plan, X, P) =>
    #println("Assigning intention for " + A + " on " + X + " based on principle value: " + P);
    -intention(A, X, _); // Remove old intention
    +intention(A, X, P). // Add new intention

/*
 * Plan: +!assign_value(A, X)
 * Purpose: Assign value for a principle based on relationship if available, otherwise use default.
 */
+!assign_value(A, X) :
    relationship(B, A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultValue = (Strength * W); // Calculate default value from relationship
    #println("Assigning value for " + A + " on " + X + " based on relationship with " + B + ": " + DefaultValue);
    -value(A, X, 0); // Remove old value if it is 0
    +value(A, X, DefaultValue). // Add new value

// Fallback: Assign default value (e.g., 0.5) if no relationship data
+!assign_value(A, X) =>
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
    +integrity(A, Plan, Integrity). // Add new integrity


+!renew_info(A, Plan, Integrity):
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent) =>
    #println("I have updated the integrity of " + A + " to " + Integrity + ".");
    +integrity(A, Integrity). // Add new integrity belief



//////////////////////////////////////////////////////////////////////
// TRUSTWORTHINESS
//////////////////////////////////////////////////////////////////////
// Calculate normalized trustworthiness
// Plan to iterate through all defined agents and goals,
// then trigger score acquisition and calculation.
+!process_trustworthiness(A) =>
    #println(": Starting to process all goals for trustworthiness calculation.");

        #println( ": Processing agent: " + A);
        for (Goal in threshold_trustworthiness(Goal, _)) { // Iterates over goals defined here
            #println( ": Processing goal: " + Goal + " for agent: " + A);
            !calc_trustworthiness(A, Goal);
        }.
    
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
    } else if (TrustworthinessScore >= T) {
        +trustworthiness(A, Goal, TrustworthinessScore, Reason);
        #println("- " + A + " is trustworthy for the goal: " + Goal + " (score: " + TrustworthinessScore + ")");
    } else {
        +untrustworthiness(A, Goal, UntrustworthinessFactor, Reason);
        #println("- " + A + " is NOT trustworthy for the goal: " + Goal + " (score: " + TrustworthinessScore + ")");
        #println("- Untrustworthiness factor: " + UntrustworthinessFactor);
    }.
//////////////////////////////////////////////////////////////////////
// DECISION COSINESIM (SELECTION)
//////////////////////////////////////////////////////////////////////
// Plan to iterate through all defined agents and goals,
// then trigger score acquisition and calculation.
+!process_selection(A) =>
    #println(": Starting to process all goals for agent: " + A);
    for (Goal in goal(A, Goal)){
        #println(": Processing goal: " + Goal + " for agent: " + A);
        !update_agent_scores(A, Goal);
        #println(": Updated scores for agent " + A + " on goal " + Goal);
        };
        #println(": Finished processing all goals. Triggering selections.");
        // After all processing is done, trigger the selection phase
        !initiate_selections(A).

// Plan to initiate selections after data processing
+!initiate_selections(A) =>
    #println("Initiating agent selection process...");
    for (Trustor in relationship(Trustor, A, Type)) {
         // For each trustor, retrieve their goals
        #println("Processing trustor: " + Trustor);
        for (Goal in trustor_scores(Trustor, Goal, TB, TC, TI)) {
            #println("Selecting agent for goal: " + Goal + " for trustor: " + Trustor);
             // Select an agent for the specific goal
            !select_agent_for_goal(Goal, Trustor);
        };
    }.

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
