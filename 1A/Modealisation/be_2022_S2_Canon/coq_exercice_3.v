Section Session2_2022_Induction_Exercice_3.

(* Déclaration d’un domaine pour les éléments des listes *)
Variable A : Set.

Inductive liste : Set :=
Nil
: liste
| Cons : A -> liste -> liste.

(* Déclaration du nom de la fonction append *)
Variable append_spec : liste -> liste -> liste.

(* Spécification du comportement de append pour Nil en premier paramètre *)
Axiom append_Nil : forall (l : liste), append_spec Nil l = l.

(* Spécification du comportement de append pour Cons en premier paramètre *)
Axiom append_Cons : forall (t : A), forall (q l : liste),
   append_spec (Cons t q) l = Cons t (append_spec q l).

(* append est associative à gauche et à droite *)
Axiom append_associative : forall (l1 l2 l3 : liste),
   (append_spec l1 (append_spec l2 l3)) = (append_spec (append_spec l1 l2) l3).

(* Déclaration du nom de la fonction snoc *)
Variable snoc_spec : liste -> A -> liste.

(* Spécification du comportement de snoc pour Nil en premier paramètre *)
Axiom snoc_Nil : forall (e : A), snoc_spec Nil e = Cons e Nil.

(* Spécification du comportement de snoc pour Cons en premier paramètre *)
Axiom snoc_Cons : forall (e : A), forall (t: A), forall (q : liste),
   snoc_spec (Cons t q) e = Cons t (snoc_spec q e).

Theorem snoc_alternate : forall (l : liste), forall (e : A),
  snoc_spec l e = append_spec l (Cons e Nil).
Proof.
intros.
induction l.
rewrite snoc_Nil.
rewrite append_Nil.
reflexivity.
rewrite snoc_Cons.
rewrite IHl.
rewrite append_Cons.
reflexivity.
Qed.
(*
Theorem snoc_append : forall (l1 l2 : liste), forall (e : A), 
  snoc_spec (append_spec l1 l2) e = append_spec l1 (snoc_spec l2 e).
intros.

Qed.
*)
(* Implantation de la fonction snoc *)
Fixpoint snoc_impl (l : liste) (e : A) {struct l} : liste :=
  match l with
    Nil => (Cons e Nil)
    | (Cons t q) => (Cons t (snoc_impl q e))
end.

Theorem snoc_correctness : forall (l : liste), forall (e : A),
   (snoc_spec l e) = (snoc_impl l e).
Proof.
intros.
induction l.
rewrite snoc_Nil.
symmetry.
reflexivity.
rewrite snoc_Cons.
symmetry.
transitivity (Cons a (snoc_impl l e)).
reflexivity.
rewrite IHl.
reflexivity.
Qed.

End Session2_2022_Induction_Exercice_3.
