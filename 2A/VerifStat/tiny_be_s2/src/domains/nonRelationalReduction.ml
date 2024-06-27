module type Reduction = sig
  type t
  val rho : t -> t
end

module Make (D : NonRelational.Domain) (R : Reduction with type t = D.t) = struct
  type t = D.t

  let fprint = D.fprint

  let order = D.order

  let top = D.top
  let bottom = D.bottom

  let lift2 f x y = R.rho (f (R.rho x) (R.rho y))

  let join = lift2 D.join
  let meet = lift2 D.meet

  let widening = D.widening  (* Don't reduce widening,
                              * this could break termination. *)

  let sem_itv n1 n2 = R.rho (D.sem_itv n1 n2)

  let sem_plus = lift2 D.sem_plus
  let sem_minus = lift2 D.sem_minus
  let sem_times = lift2 D.sem_times
  let sem_div = lift2 D.sem_div

  let sem_guard t = R.rho (D.sem_guard (R.rho t))

  let lift3 f x y r =
    let x, y = f (R.rho x) (R.rho y) (R.rho r) in
    R.rho x, R.rho y

  let backsem_plus = lift3 D.backsem_plus
  let backsem_minus = lift3 D.backsem_minus
  let backsem_times = lift3 D.backsem_times
  let backsem_div = lift3 D.backsem_div
end
