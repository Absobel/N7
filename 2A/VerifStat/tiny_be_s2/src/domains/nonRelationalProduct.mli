(** Cartesian product of non relational domains. *)

module Make (D1 : NonRelational.Domain) (D2 : NonRelational.Domain) :
  NonRelational.Domain with type t = D1.t * D2.t
