threshold(T).

offer(Agent, NewPlan, OldPlan, Label) :-belief(Y, offer, Agent, NewPlan, OldPlan, Label) && threshold(T) && Y > T.
reject(Agent, Offer, Value) :-belief(Y, reject, Agent, Offer, Value) && threshold(T) && Y > T.
phi(Plan, Value, X) :-belief(Y, phi, Plan, Value, X) && threshold(T) && Y > T.

+!send_beliefs() =>
    TrustorName = "trustor"; !send_belief1(TrustorName).

+!send_belief1(TrustorName) =>
    for (A in message(A, B)) {
        !send_belief2(TrustorName, A);};
    for (A1 in message(A1, B1, C1)) {
        !send_belief2(TrustorName, A1);};
    for (A2 in message(A2, B2, C2, D2)) {
        !send_belief2(TrustorName, A2);};
    for (A3 in message(A3, B3, C3, D3, E3)) {
        !send_belief2(TrustorName, A3);
    }.

+!send_belief2(TrustorName, A) =>
    for (B in message(A, B)) {
        #coms.inform(TrustorName, belief(Self, A, B));};
    for (B1 in message(A, B1, C1)) {
        !send_belief3(TrustorName, A, B1);};
    for (B2 in message(A, B2, C2, D2)) {
        !send_belief3(TrustorName, A, B2);};
    for (B3 in message(A, B3, C3, D3, E3)) {
        !send_belief3(TrustorName, A, B3);
    }.

+!send_belief3(TrustorName, A, B)=>
    for (C in message(A, B, C)) {
        #coms.inform(TrustorName, belief(Self, A, B, C));
    };
    for (C1 in message(A, B, C1, D1)) {
        !send_belief4(TrustorName, A, B, C1);
    };
    for (C2 in message(A, B, C2, D2, E2)) {
        !send_belief4(TrustorName, A, B, C2);
    }.

+!send_belief4(TrustorName, A, B, C)=>
    for (D in message(A, B, C, D)) {
        #coms.inform(TrustorName, belief(Self, A, B, C, D));
    };
    for (D1 in belief(A, B, C, D1, E1)) {
        !send_belief5(TrustorName, A, B, C, D1);
    }.

+!send_belief5(TrustorName, A, B, C, D)=>
    for (E in message(A, B, C, D, E)) {
        #coms.inform(TrustorName, belief(Self, A, B, C, D, E));
    }.
