//////////////////////////////////////////////////////////////////////
// This file contains all the definitions and plans that are necessary
// to simulate the behaviour of an agent receiving new information and
// deciding what to belief.
//////////////////////////////////////////////////////////////////////

///////////// DEFINITIONS //////////////////////////////////
agent(A) :- belief(Y, agent, A).
trust(A, V) :- belief(Y, trust, A, V).
benevolence(A, V, X1, X2) :- belief(Y, benevolence, A, V, X1, X2).
principle(P, X, V) :- belief(Y, principle,P, X, V).
intention(A, P) :- belief(Y, intention, A, P).
offer(A, P1, P2, O) :- belief(Y, offer, A, P1, P2, O).
reject(A, O, V) :- belief(Y, reject, A, O, V).
accept(A, O) :- belief(Y, accept, A, O).
succes(A, P) :- belief(Y, succes, A, P).
failure(A, P, C) :- belief(Y, failure, A, P, C).
value(A, V, P, X) :- belief(Y, value, A, V, P, X).
value(A, V, X) :- belief(Y, value, A, V, X).
subplan(P1, P2) :- belief(Y, subplan, P1, P2).
knowledge(A,P, C, X) :- belief(Y, knowledge,A, P, C, X).
resource(A,P, C, X) :- belief(Y, resource,A, P, C, X).
skill(A,P, C, X) :- belief(Y, skill,A, P, C, X).


+!is_contradiction() :
    belief(Y1, accept, A, B) &&
    belief(Y2, reject, A, B, C) =>
    if (Y1 > Y2) {
        -belief(Y2, reject, A, B, C);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, accept, A, B);
        #println("Contradiction.");
    };
    !is_contradiction().


+!is_contradiction() :
     belief(Y1, failure, A, Plan, B) &&
     belief(Y2, succes, A, Plan) &&
     Y3a is (1 - (Y2 - Y1)) * ((Y1 + Y2) / 2) &&
      Y3b is (1 - (Y1 - Y2)) * ((Y1 + Y2) /2)=>
      -belief(Y1, failure, A, Plan, B);
      -belief(Y2, succes, A, Plan);
      if (Y1 > Y2) {
        +belief(Y3b, succes, A, Plan);
        } else if (Y2 > Y1) {
             +belief(Y3a, failure, A, Plan, B);};
        !is_contradiction().

+!is_contradiction() :
    belief(Y1, Offer, A, Plan) &&
    belief(Y2, notOffer, A, Plan) &&
    Y3a is (1 - (Y2 - Y1)) * ((Y1 + Y2) / 2) &&
    Y3b is (1 - (Y1 - Y2)) * ((Y1 + Y2) /2) =>
    -belief(Y1, Offer, A, Plan);
    -belief(Y2, notOffer, A, Plan);
    if (Y1 > Y2) {
        +belief(Y3b, Offer, A, Plan);
        } else if (Y2 > Y1) {
            +belief(Y3a, notOffer, A, Plan);};
        !is_contradiction().

+!is_contradiction() :
    belief(Y1, value, A, B, C, D) &&
    belief(Y2, value, A, B, C, E) &&
    D != E &&
    Y3a is (1 - (Y2 - Y1)) * ((Y1 + Y2) / 2) &&
    Y3b is (1 - (Y1 - Y2)) * ((Y1 + Y2) /2) &&
    F is ((Y1 * D + Y2 * E)/ (Y1+Y2)) =>
    -belief(Y1, value, A, B, C, D);
    -belief(Y2, value, A, B, C, E);
    if (Y2 - Y1 > 0) {
        +belief(Y3a, value, A, B, C, F);
        } else {
            +belief(Y3b, value, A, B, C, F);};
        !is_contradiction().

+!is_contradiction() :
    belief(Y1, failure, A, Plan, B) &&
    belief(Y2, succes, A, Plan) =>
    if (Y1 > Y2) {
        -belief(Y2, succes, A, Plan);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, failure, A, Plan, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, mighthave, A, B) &&
    belief(Y2, hasnot, A, B) || belief(Y2, has, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, hasnot, A, B);
        -belief(Y2, has, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, mighthave, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, competent, A, B) &&
    belief(Y2, incompetent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, competent, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, unknown, A, B) &&
    belief(Y2, incompetent, A, B) || belief(Y2, competent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        -belief(Y2, competent, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1){
        -belief(Y1, unknown, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, value, A, B, C, D) &&
    belief(Y2, value, A, B, C, E) &&
    D != E &&
    F is ((Y1 * D + Y2 * E)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, value, A, B, C, D);
    -belief(Y2, value, A, B, C, E);
    +belief(Y1, value, A, B, C, F);
    !is_contradiction().

+!is_contradiction(A, Rumour1, Rumour2) :
    belief(Y1, principle, A, B, C) &&
    belief(Y2, principle, A, B, D) &&
    C != D &&
    E is ((Y1 * C + Y2 * D)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, principle, A, B, C);
    -belief(Y2, principle, A, B, D);
    +belief(Y1, principle, A, B, E);
    !is_contradiction().

+belief(Y, Z, A) :
    trust(Y, X) =>
    -belief(Y, Z, A);
    +belief(X, Z, A);
    !is_contradiction().

+belief(Y, Z, A, B) :
    trust(Y, X) =>
    -belief(Y, Z, A, B);
    +belief(X, Z, A, B);
    !is_contradiction().

+belief(Y, Z, A, B, C) :
    trust(Y, X) =>
    -belief(Y, Z, A, B, C);
    +belief(X, Z, A, B, C);
    !is_contradiction().

+belief(Y, Z, A, B, C, D):
    trust(Y, X) =>
    -belief(Y, Z, A, B, C, D);
    +belief(X, Z, A, B, C, D);
    !is_contradiction().

+belief(Y, Z, A, B, C, D, E) :
    trust(Y, X) =>
    -belief(Y, Z, A, B, C, D, E);
    +belief(X, Z, A, B, C, D, E);
    !is_contradiction().


// +ready() =>
//     !update_trustworthiness().

//////////////////////////////////////////////////////////////////////
// REASONING
/////////////////////////////////////////////////////////////////////

+!is_contradiction() :
    belief(Y1, accept, A, B) &&
    belief(Y2, reject, A, B, C) =>
    if (Y1 > Y2) {
        -belief(Y2, reject, A, B, C);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, accept, A, B);
        #println("Contradiction.");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, failure, A, Plan, B) &&
    belief(Y2, succes, A, Plan) =>
    if (Y1 > Y2) {
        -belief(Y2, succes, A, Plan);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, failure, A, Plan, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, mighthave, A, B) &&
    belief(Y2, hasnot, A, B) || belief(Y2, has, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, hasnot, A, B);
        -belief(Y2, has, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, mighthave, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, competent, A, B) &&
    belief(Y2, incompetent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, competent, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, unknown, A, B) &&
    belief(Y2, incompetent, A, B) || belief(Y2, competent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        -belief(Y2, competent, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1){
        -belief(Y1, unknown, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, value, A, B, C, D) &&
    belief(Y2, value, A, B, C, E) &&
    D != E &&
    F is ((Y1 * D + Y2 * E)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, value, A, B, C, D);
    -belief(Y2, value, A, B, C, E);
    +belief(Y1, value, A, B, C, F);
    !is_contradiction().

+!is_contradiction(A, Rumour1, Rumour2) :
    belief(Y1, principle, A, B, C) &&
    belief(Y2, principle, A, B, D) &&
    C != D &&
    E is ((Y1 * C + Y2 * D)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, principle, A, B, C);
    -belief(Y2, principle, A, B, D);
    +belief(Y1, principle, A, B, E);
    !is_contradiction().
