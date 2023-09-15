Require Import Naturelle.
Section Session2_2022_Logique_Exercice_2.

Variable A B C : Prop.

Theorem Exercice_2_Naturelle : (~(A /\ B)) -> ((~A) \/ (~B)).
Proof.
I_imp'.

Qed.

Theorem Exercice_2_Coq : (~(A /\ B)) -> ((~A) \/ (~B)).
Proof.
intros.

Qed.

End Session2_2022_Logique_Exercice_2.

