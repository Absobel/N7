---- MODULE mc2 ----
EXTENDS Naturals, FiniteSets

Missionaries == {"M1", "M2", "M3", "M4"}
Cannibals == {"C1", "C2", "C3", "C4"}
Capacity == 2
Entities == Missionaries \union Cannibals \union {"B"}

VARIABLES 
    left, right

TypeInvariant == 
    [](
        /\ left \subseteq Entities
        /\ right \subseteq Entities
        /\ left \intersect right = {}
        /\ (Missionaries \union {"B"}) \subseteq (left \union right)
    )

pasMiamAux(pos) == 
    \/ Cardinality(pos \intersect Missionaries) \geq Cardinality(pos \intersect Cannibals)
    \/ Cardinality(pos \intersect Missionaries) = 0

PasMiam == pasMiamAux(left) /\ pasMiamAux(right)
ToujoursOk == []PasMiam

Solution ==
    [] \neg (Missionaries \subseteq right /\ left = {})

----------------------------------------------------------------------------

Init ==
    /\ left = Entities
    /\ right = {}

bougeGD(S) ==
    /\ S \subseteq left
    /\ "B" \in S
    /\ Cardinality(S) \leq (Capacity+1) /\ Cardinality(S) \geq 2
    /\ left' = left \ S
    /\ right' = right \union S
    /\ PasMiam'

bougeDG(S) ==
    /\ S \subseteq right
    /\ "B" \in S
    /\ Cardinality(S) \leq (Capacity+1) /\ Cardinality(S) \geq 2
    /\ right' = right \ S
    /\ left' = left \union S
    /\ PasMiam'

jeterCrocodileLeft ==
    /\ Missionaries \subseteq left
    /\ Cardinality(left \intersect Cannibals) = 1
    /\ left' = left \ (left \intersect Cannibals)
    /\ UNCHANGED right
    /\ PasMiam'

jeterCrocodileRight ==
    /\ Missionaries \subseteq right
    /\ Cardinality(right \intersect Cannibals) = 1
    /\ right' = right \ (right \intersect Cannibals)
    /\ UNCHANGED left
    /\ PasMiam'

Next == 
    \/ jeterCrocodileLeft 
    \/ jeterCrocodileRight 
    \/ \E s \in SUBSET Entities : (bougeGD(s) \/ bougeDG(s))

Spec == Init /\ [] [ Next ]_<<left, right>>

====