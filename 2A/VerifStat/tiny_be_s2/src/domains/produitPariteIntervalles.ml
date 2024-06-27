module Produit = NonRelationalProduct.Make (Parity) (Intervals)

module Reduction = struct
  type t = Produit.t

  (* Retourne true seulement si (n : InfInt.t) est pair. *)
  let est_pair n = match InfInt.to_int n with
    | Some n -> n mod 2 = 0
    | None -> false

  (* Retourne true seulement si (n : InfInt.t) est impair. *)
  let est_impair n = match InfInt.to_int n with
    | Some n -> n mod 2 = 1
    | None -> false

  let rho (p, i) =
    assert false  (* À faire. *)
end

module ProduitReduit = NonRelationalReduction.Make (Produit) (Reduction)

include ProduitReduit
