///////////////////////////////////////////
// Example of initial beliefs
///////////////////////////////////////////

// --- Initial beliefs and weights for benevolence calculation on gardening vs cleaning---
// Agents
agent(damian).
agent(tom).
agent(paula).
trustor(anna).
// Offers (who is being asked, new plan, old plan, offer id)
offer(damian, cleaning, gardening, offer2).
offer(paula, cleaning, gardening, offer3).
offer(tom, cleaning, gardening, offer4).

// Intentions (current plan for each agent)
intention(damian, gardening).
intention(paula, gardening).
intention(tom, gardening).

// Relationships (for benevolence initialization)
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

// Value weights (importance of each value in the offer)
value_weight(fun, 0.6).
value_weight(health, 0.4).

// Value satisfaction for each plan (phi)
phi(damian, fun, gardening, 0.9).
phi(damian, health, gardening, 1.0).
phi(damian, fun, cleaning, 0.1).
phi(damian, health, cleaning, 0.1).

phi(paula, fun, gardening, 0.8).
phi(paula, health, gardening, 0.9).
phi(paula, fun, cleaning, 0.2).
phi(paula, health, cleaning, 0.3).

phi(tom, fun, gardening, 0.7).
phi(tom, health, gardening, 0.8).
phi(tom, fun, cleaning, 0.3).
phi(tom, health, cleaning, 0.2).

// Initial benevolence intervals (can be [0,0] to trigger initialization)
benevolence(damian, fun, 0, 0).
benevolence(damian, health, 0, 0).
benevolence(paula, fun, 0, 0).
benevolence(paula, health, 0, 0).
benevolence(tom, fun, 0, 0).
benevolence(tom, health, 0, 0).

// Example: rejected values for an offer (if any)
reject(damian, offer2, fun).
reject(damian, offer2, health).



// Initializing variables 
totalbenmin(0).
totalbenmax(0).
number_of_values(_, 0).
accepted_values(_, 0).
total_combined_weight(0).

// --- Agent Name Definitions ---
// These are crucial for communication
competence_provider_agent("competence"). 
benevolence_provider_agent("benevolence"). 
integrity_provider_agent("integrity").   
decision_maker_agent("decisionCosinesim").
trutsworthiness_provider_agent("trustworthiness").     

missing_or_zero_benevolence(Agent, Value) :- not benevolence(Agent, Value, _, _) || benevolence(Agent, Value, Bmin, 0).
///////////////////////////////////////////
// Initial goals
///////////////////////////////////////////

!getnames().

//////////////////////////////////////////////
// Plans
//////////////////////////////////////////////

// --- Communication: Respond to #coms.ask for benevolence_offer ---
+?benevolence_offer(A, Offer, Bmin, Bmax) :
    benevolence_offer(A, Offer, Bmin, Bmax) &&
    decision_maker_agent(DMAgent) &&
    trustworthiness_provider_agent(Tagent)  =>

    #coms.inform(DMAgent, benevolence_offer(A, Offer, Bmin, Bmax));
    #coms.inform(DMAgent, benevolence_offer(A, Offer, Bmin, Bmax)).

// Respond to #coms.ask for benevolence_offer
// If score is not present, calculate it first, then send
+?benevolence_offer(A, Goal, Bmin, Bmax) : not benevolence_offer(A, Goal, _, _) =>
    !update_benevolence(A).

    // Respond to #coms.ask for offer_acceptable
//+?offer_acceptable(A, Offer) =>
 //   #println("Received ask: is offer " + Offer + " acceptable for " + A + "?");
 //   !evaluate_offer(A, Offer).

//Adapt incoming decision from #coms.inform(A, offer_decision(A, Offer, Decision, Value))
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

//+offer_decision(A, Offer, reject, Value) =>
    //#println("Offer " + Offer + " was rejected by " + A + ".");
    //-pending_offer_decision(Offer).
    //+reject(A, Offer, Value).

    //+offer_decision(A, Offer, rejected) =>
    //#println("Offer" + Offer + " was rejected by " + A + ".");
    //-pending_offer_decision(Offer)
    //!process_offers(A).

// Looping through all the agents
+!getnames() =>
    for (A in agent(A)) {
        !update_benevolence(A);
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
 * Plan: +!initialize_benevolence(A,Value)
 * Purpose: Initialize benevolence intervals for agent A and value, based on relationship if available.
 * If relationship data is present, use it to set the lower bound.
 * Otherwise, use default [0,1] interval.
 */
+!initialize_benevolence(A,Value): 
    trustor(B) &&
    relationship(B,A, Type) &&
    weight_relationship(Type, W) &&
    relationship_strength(B, A, Strength) =>
    DefaultMin = (Strength * W) ;
    for (Value in benevolence(A, Value, _, _)) {
        #println("Initialized benevolence for " + A + " on " + Value + " from relationship with " + B + ": [" + DefaultMin + ", 1 ]");
        -benevolence(A, Value, _, _);
        +benevolence(A, Value, DefaultMin, 1);
    };
    !process_offers(A).

// Fallback: initialize benevolence to [0,1] if no relationship data
+!initialize_benevolence(A,Value)=>
    for (Value in benevolence(A, Value, _, _)) {
        #println("No relationship data found. Using default benevolence [0, 1] for " + Value);
        -benevolence(A, Value, _, _);
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
    #println("Asking " +  A + " if they accept offer " + Offer + ".");
    //OtherAgent= A;
    //#coms.ask(OtherAgent, offer_acceptable(OtherAgent, Offer));
    +pending_offer_decision(Offer);
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

        // Reset counters for this offer
    -number_of_values(Offer, _);
    +number_of_values(Offer, 0);
    -accepted_values(Offer, _);
    +accepted_values(Offer, 0);
    -totalbenmin(_);
    +totalbenmin(0);
    -totalbenmax(_);
    +totalbenmax(0);
    -total_combined_weight(_);
    +total_combined_weight(0);

    !init_benevolence_counters(Offer);
    !init_combined_weights(A, Offer, NewPlan);
    #println("It is not known yet whether " + A + " accepted or rejected the offer.");
    #println("Evaluating offer: " + Offer);
    #println("Processing values for offer: " + Offer);
    
    // For each value, evaluate and compute benevolence score
    for (Value in phi(A, Value, NewPlan, Y)) {
        !evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan); 
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
+!evaluate_offer_value(A, Offer, Value, NewPlan, OldPlan) :
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
        //#coms.inform(Asker, offer_decision(A, Offer, reject, Value));
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
        //#coms.inform(Asker, offer_decision(A, Offer, rejected));

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
    total_combined_weight(TotalW) &&
    decision_maker_agent(DMAgent) &&
    trutsworthiness_provider_agent(Tagent) =>

    #println("---- Calculating normalized benevolence interval for offer " + Offer + " ----");

    // Calculate normalized interval (average over all values)
    NormalizedMin = SumMin / TotalW;
    NormalizedMax = SumMax / TotalW;

    // Store and print the result
    -benevolence_offer(A, Offer, _, _);
    +benevolence_offer(A, Offer, NormalizedMin, NormalizedMax);
    #coms.inform(DMAgent, benevolence_offer(A, Goal, NormalizedMin, NormalizedMax));
    #coms.inform(Tagent, benevolence_offer(A, Goal, NormalizedMin, NormalizedMax));
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