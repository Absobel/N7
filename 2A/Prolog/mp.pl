/*/// 1 */
/* poids/2 */
poids(morceaux, 10).
poids(cachous, 1).
poids(ballons, 7).
poids(goodies, 6).
poids(ordinateur, 10).

/*/// 2 */
/* poids_sac/2 */
poids_sac([], 0).
poids_sac([T|Q], P) :- poids(T, P1), poids_sac(Q, P2), P is P1 + P2.

/*/// 3 */
/* sous_liste/2 */
sous_liste(_, []).
sous_liste([T|Q], [T|Q1]) :- sous_liste(Q, Q1).
sous_liste([_|Q], L) :- sous_liste(Q, L).

/*/// 4 */
/* acceptable/2 */
acceptable(L, S) :- sous_liste(L, S), poids_sac(S, P), P =< 20.

/*/// 5 */
/* meilleur_poids/2 */
meilleur_poids(L, S) :- acceptable(L, S), poids_sac(S, P), \+ (acceptable(L, S1), poids_sac(S1, P1), P1 > P).

/*/// 6 */
/* utilite/2 */
utilite(morceaux, 1).
utilite(cachous, 2).
utilite(ballons, 1).
utilite(goodies, 3).
utilite(ordinateur, 2).

/* utilite_sac/2 */
utilite_sac([], 0).
utilite_sac([T|Q], U) :- utilite(T, U1), utilite_sac(Q, U2), U is U1 + U2.

/* meilleure_utilite/2 */
meilleure_utilite(L, S) :- meilleur_poids(L, S), utilite_sac(S, U), \+ (meilleur_poids(L, S1), utilite_sac(S1, U1), U1 > U).

/*/// 7 */
q([],_,_) :- fail.
q([X|_],[],[X]).
q([X|RR],[X|RC],S) :- q(RR,RC,S).
q([X|_],[Y|RC],S) :- X \= Y, S = [X,Y|RC].

p(R,C,[C]) :- \+ (q(R,C,_)).
p(R,C,[C|V]) :- q(R,C,S), p(R,S,V).

/*// a */
% Le problème avec cette définition de meilleur_poids est qu'elle nécessite de parcourir toutes les solutions possibles pour trouver la meilleure. */

/*// b */
% p(L, [], X) fait que X soit la liste des sous-listes de L. */
% p(L, S, X) fait que X soit la liste des sous-listes de L à partir de la sous_liste S. */
% q sert alors à trouver la sous_liste suivant S dans la liste des sous-listes de L. */

/*// c */
/* max_poids/2 */
/* renvoie le sac avec le poids le plus élevé */
max_poids(X, Y, X) :- poids_sac(X, P1), poids_sac(Y, P2), P1 > P2.
max_poids(X, Y, Y) :- poids_sac(X, P1), poids_sac(Y, P2), P1 =< P2.

/* find_max_poids/2 */
/* renvoie le sac avec le poids le plus élevé dans une liste de sacs */
find_max_poids([T], X) :- X = T.
find_max_poids([T|Q], X) :- find_max_poids(Q, Y), max_poids(T, Y, X).

/* filter_acceptable/2 */
/* filtre les sacs acceptables par rapport aux élèments L dans une liste de sacs */
filter_correct_weigth([], []).
filter_correct_weigth([T|Q], [T|Q1]) :- poids_sac(T, P), P =< 20, filter_correct_weigth(Q, Q1).
filter_correct_weigth([T|Q], Q1) :- poids_sac(T, P), P > 20, filter_correct_weigth(Q, Q1).

/* meilleur_poids/2 */
meilleur_poids(L, S) :- p(L, [], X), filter_correct_weigth(X, S1), find_max_poids(S1, S).