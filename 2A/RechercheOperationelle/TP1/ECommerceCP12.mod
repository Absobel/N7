param nbF;
param nbM;
param nbD;
param M;

param DEMANDES{d in 1..nbD, f in 1..nbF};
param STOCK{m in 1..nbM, f in 1..nbF};
param COUTS{m in 1..nbM, f in 1..nbF};
param COUTSFIXES{d in 1..nbD, m in 1..nbM};
param COUTSVAR{d in 1..nbD, m in 1..nbM};

var q{m in 1..nbM, f in 1..nbF, d in 1..nbD}, >=0;
var b{m in 1..nbM, d in 1..nbD}, binary;

minimize coutTotal:
    sum{m in 1..nbM, f in 1..nbF, d in 1..nbD} q[m,f,d] * COUTS[m,f]
  + sum{m in 1..nbM, d in 1..nbD, f in 1..nbF} q[m,f,d] * COUTSFIXES[d,m]
  + sum{m in 1..nbM, d in 1..nbD} b[m,d] * COUTSVAR[d,m];

s.t. demandeRespectee{d in 1..nbD, f in 1..nbF}:
    DEMANDES[d, f] <= sum{m in 1..nbM} q[m,f,d];

s.t. stockRespecte{m in 1..nbM, f in 1..nbF}:
    sum{d in 1..nbD} q[m,f,d] <= STOCK[m,f];

s.t. bDef{m in 1..nbM, d in 1..nbD}:
    sum{f in 1..nbF} q[m,f,d] <= M * b[m,d];

end;