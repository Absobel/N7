% 1
drg(Vars) :-
    Vars = [D, O, N, A, L, G, E, R, B, T],
    fd_domain(Vars, 0, 9),
    D #\= 0, G #\= 0, R #\= 0,
    fd_all_different(Vars),
    2*D + 10*2*L + 100*2*A + 1000*(N+R) + 10000*(O+E) + 100000*(D+G) #= T + 10*R + 100*E + 1000*B + 10000*O + 100000*R,
    fd_labeling(Vars). 

% 2
taxi(Vars) :-
    Vars = [N, A, B, C, D],
    N #< 1000000,
    A #=< B, C #=< D, A #< C,
    A**3 + B**3 #= N,
    C**3 + D**3 #= N,
    fd_minimize(fd_labeling(Vars), N).

% 3
sum([], 0).
sum([H|T], S) :- sum(T, S1), S #= S1 + H.

monnaie(Vars) :-
    Vars = [P1, P2, P5, P10, P20, P50, P100, P200],
    fd_domain(Vars, 0, 3),
    P1*1 + P2*2 + P5*5 + P10*10 + P20*20 + P50*50 + P100*100 + P200*200 #= 271,
    sum([P1, P2, P5, P10, P20, P50, P100, P200], NBP),
    Cost #= NBP,
    fd_minimize(fd_labeling(Vars), Cost).

