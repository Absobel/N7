param N;
param M;
param DISTANCE{i in 1..N, j in 1..N}, integer;

var Y{i in 1..N, j in 1..N}, binary;
var T{i in 1..N}, integer;

minimize Distance:
    sum{i in 1..N, j in 1..N} DISTANCE[i,j] * Y[i,j];

s.t. RegleUn{i in 1..N}:
    sum{j in 1..N} Y[i,j] = 1;

s.t. RegleDeux{j in 1..N}:
    sum{i in 1..N} Y[i,j] = 1;

s.t. RegleTrois{i in 1..N}:
    Y[i,i] = 0;

s.t. RegleQuatre{i in 1..N, j in 2..N}:
     T[j] +(1-Y[i,j])*M >= T[i] +1;

s.t. Reglex{i in 1..N}:
    T[i] >=0;

end;
