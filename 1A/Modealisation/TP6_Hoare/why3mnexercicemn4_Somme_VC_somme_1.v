(* This file is generated by Why3's Coq driver *)
(* Beware! Only edit allowed sections below    *)
Require Import BuiltIn.
Require BuiltIn.
Require int.Int.
Require int.Abs.
Require int.ComputerDivision.

(* Why3 assumption *)
Inductive ref (a:Type) :=
  | mk_ref : a -> ref a.
Axiom ref_WhyType : forall (a:Type) {a_WT:WhyType a}, WhyType (ref a).
Existing Instance ref_WhyType.
Arguments mk_ref {a}.

(* Why3 assumption *)
Definition contents {a:Type} {a_WT:WhyType a} (v:ref a) : a :=
  match v with
  | mk_ref x => x
  end.

(* Why3 goal *)
Theorem VC_somme :
  forall (n:Z), forall (r:Z) (i:Z), (i < n)%Z -> forall (i1:Z),
  (i1 = (i + 1%Z)%Z) -> forall (r1:Z), ~ (r1 = (r + i1)%Z).
Proof.
intros n r i h1 i1 h2 r1.

Qed.

