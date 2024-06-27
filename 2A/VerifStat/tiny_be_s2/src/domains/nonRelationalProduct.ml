module Make (D1 : NonRelational.Domain) (D2 : NonRelational.Domain) = struct
  type t = D1.t * D2.t

  let fprint ff (t1, t2) =
    Format.fprintf ff "(%a, %a)" D1.fprint t1 D2.fprint t2

  let order (x1, x2) (y1, y2) = D1.order x1 y1 && D2.order x2 y2

  let top = D1.top, D2.top
  let bottom = D1.bottom, D2.bottom

  let lift2 f1 f2 (x1, x2) (y1, y2) = f1 x1 y1, f2 x2 y2

  let join = lift2 D1.join D2.join
  let meet = lift2 D1.meet D2.meet

  let widening = lift2 D1.widening D2.widening

  let sem_itv n1 n2 = D1.sem_itv n1 n2, D2.sem_itv n1 n2

  let sem_plus = lift2 D1.sem_plus D2.sem_plus
  let sem_minus = lift2 D1.sem_minus D2.sem_minus
  let sem_times = lift2 D1.sem_times D2.sem_times
  let sem_div = lift2 D1.sem_div D2.sem_div

  let sem_guard (x1, x2) = D1.sem_guard x1, D2.sem_guard x2

  let lift3 f1 f2 (x1, x2) (y1, y2) (r1, r2) =
    let x1, y1 = f1 x1 y1 r1 in
    let x2, y2 = f2 x2 y2 r2 in
    (x1, x2), (y1, y2)

  let backsem_plus = lift3 D1.backsem_plus D2.backsem_plus
  let backsem_minus = lift3 D1.backsem_minus D2.backsem_minus
  let backsem_times = lift3 D1.backsem_times D2.backsem_times
  let backsem_div = lift3 D1.backsem_div D2.backsem_div
end
