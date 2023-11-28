param nbF;
param nbM;
param nbD;

param DEMANDES{d in 1..nbD, f in 1..nbF};
param STOCK{m in 1..nbM, f in 1..nbF};
param COUTS{m in 1..nbM, f in 1..nbF};

var q{m in 1..nbM, f in 1..nbF, d in 1..nbD}, >=0;

minimize coutTotal:
    sum{m in 1..nbM, f in 1..nbF, d in 1..nbD} q[m,f,d] * COUTS[m,f];

s.t. demandeRespectee{d in 1..nbD, f in 1..nbF}:
    DEMANDES[d, f] <= sum{m in 1..nbM} q[m,f,d];

s.t. stockRespecte{m in 1..nbM, f in 1..nbF}:
    sum{d in 1..nbD} q[m,f,d] <= STOCK[m,f];

end;