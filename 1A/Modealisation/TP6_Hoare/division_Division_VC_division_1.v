(* This file is generated by Why3's Coq driver *)
(* Beware! Only edit allowed sections below    *)
Require Import BuiltIn.
Require BuiltIn.
Require int.Int.

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
Theorem VC_division :
  forall (a:Z) (b:Z), ((0%Z <= a)%Z /\ (0%Z < b)%Z) ->
  ((a = ((0%Z * b)%Z + a)%Z) /\
   ((0%Z <= 0%Z)%Z /\ ((0%Z < b)%Z /\ (0%Z <= a)%Z))) /\
  forall (r:Z) (q:Z),
  ((a = ((q * b)%Z + r)%Z) /\
   ((0%Z <= q)%Z /\ ((0%Z < b)%Z /\ (0%Z <= r)%Z))) ->
  ((b <= r)%Z -> forall (q1:Z), (q1 = (q + 1%Z)%Z) -> forall (r1:Z),
   (r1 = (r - b)%Z) ->
   ((0%Z <= r)%Z /\ (r1 < r)%Z) /\
   ((a = ((q1 * b)%Z + r1)%Z) /\
    ((0%Z <= q1)%Z /\ ((0%Z < b)%Z /\ (0%Z <= r1)%Z)))) /\
  (~ (b <= r)%Z -> (((q * b)%Z + r)%Z = a) /\ ((0%Z <= r)%Z /\ (r < b)%Z)).
Proof.
intros a b (h1,h2).

Qed.
