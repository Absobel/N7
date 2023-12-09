param N;
param SCORE{i in 1..N, j in 1..N}, integer;

var x{i in 1..N, j in 1..N}, binary;

maximize Score:
    sum{i in 1..N, j in 1..N} SCORE[i,j] * x[i,j];

s.t. SommeiUn{i in 1..N}:
    sum{j in 1..N} x[i,j] = 1;

s.t. SommejUn{j in 1..N}:
    sum{i in 1..N} x[i,j] = 1;

end;
