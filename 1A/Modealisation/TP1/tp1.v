(* Les règles de la déduction naturelle doivent être ajoutées à Coq. *) 
Require Import naturelle.

(* Ouverture d'une section *) 
Section LogiquePropositions. 

(* Déclaration de variables propositionnelles *) 
Variable A B C E Y R : Prop. 

Theorem Thm_0 : A /\ B -> B /\ A.
I_imp'.
I_et.
E_et_d A.
Hyp H.
E_et_g B.
Hyp H.
Qed.

Theorem Thm_1 : ((A \/ B) -> C) -> (B -> C).
I_imp'.
I_imp'.
E_imp (A \/ B).
Hyp H.
I_ou_d.
Hyp H0.
Qed.

Theorem Thm_2 : A -> ~~A.
I_imp'.
I_non H0.
E_non A.
Hyp H.
Hyp H0.
Qed.

Theorem Thm_3 : (A -> B) -> (~B -> ~A).
I_imp'.
I_imp'.
I_non H1.
E_non B.
E_imp A.
Hyp H.
Hyp H1.
Hyp H0.
Qed.

Theorem Thm_4 : (~~A) -> A.
I_imp'.
absurde H1.
E_non (~A).
Hyp H1.
Hyp H.
Qed.

Theorem Thm_5 : (~B -> ~A) -> (A -> B).
I_imp'.
I_imp'.
absurde H1.
E_non A.
Hyp H0.
E_imp (~B).
Hyp H.
Hyp H1.
Qed.

Theorem Thm_6 : ((E -> (Y \/ R)) /\ (Y -> R)) -> ~R -> ~E.
I_imp'.
I_imp'.
I_non H1.
E_non R.
E_ou Y R.
E_imp E.
E_et_g (Y -> R).
Hyp H.
Hyp H1.
E_et_d (E -> Y \/ R).
Hyp H.
I_imp'.
Hyp H2.
Hyp H0.
Qed.

(* Version en Coq *)

Theorem Coq_Thm_0 : A /\ B -> B /\ A.
intro.
destruct H.
split.
exact H0.
exact H.
Qed.

Theorem Coq_E_imp : ((A -> B) /\ A) -> B.
intro.
destruct H.
cut A.
exact H.
exact H0.
Qed.

Theorem Coq_E_et_g : (A /\ B) -> A.
intro.
destruct H.
exact H.
Qed.

Theorem Coq_E_ou : ((A \/ B) /\ (A -> C) /\ (B -> C)) -> C.
intros.
destruct H.
destruct H0.
elim H.
exact H0.
exact H1.
Qed.

Theorem Coq_Thm_7 : ((E -> (Y \/ R)) /\ (Y -> R)) -> (~R -> ~E).
intros.
destruct H.
unfold not.
intro.
absurd R.
exact H0.
elim H.
exact H1.
intro.
exact H3.
exact H2.
Qed.

End LogiquePropositions.

