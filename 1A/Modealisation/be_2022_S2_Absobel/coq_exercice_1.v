Require Import Naturelle.
Section Session2_2022_Logique_Exercice_1.

Variable A B C : Prop.

Theorem Exercice_1_Naturelle :  ((~A) \/ (~B)) -> (~(A /\ B)).
Proof.
I_imp'.
I_non H0.
E_ou (~A) (~B).
Hyp H.
I_imp'.
E_non A.
E_et_g B.
Hyp H0.
Hyp H1.
I_imp'.
E_non B.
E_et_d A.
Hyp H0.
Hyp H1.
Qed.

Theorem Exercice_1_Coq : ((~A) \/ (~B)) -> (~(A /\ B)).
Proof.
intros.
unfold not.
intro.
elim H.
intro.
absurd A.
exact H1.
destruct H0.
exact H0.
intro.
destruct H0.
absurd B.
exact H1.
exact H2.
Qed.

End Session2_2022_Logique_Exercice_1.

