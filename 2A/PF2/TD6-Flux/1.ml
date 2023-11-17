module type Iter =
sig
  type 'a flux

  val vide: 'a flux
  val cons: 'a -> 'a flux -> 'a flux
  val uncons: 'a flux -> ('a * 'a flux) option
  val apply: ('a -> 'b) flux -> ('a flux -> 'b flux)
  val unfold: ('b -> ('a * 'b) option) -> ('b -> 'a flux)
  val filter: ('a -> bool) -> 'a flux -> 'a flux
  val append: 'a flux -> 'a flux -> 'a flux
end

module FFlux : Iter =
struct
  type 'a flux = Tick of (unit -> ('a * 'a flux) option)

  let vide = Tick (fun () -> None)
  let cons t q = Tick (fun () -> Some (t, q))
  let uncons (Tick f) = f ()
  let rec apply f x =
    Tick (fun () ->
        match uncons f, uncons x with
        | None, _ -> None
        | _, None -> None
        | Some (tf, qf), Some (tx, qx) ->
          Some (tf tx, apply qf qx)
        )
  let rec unfold f e =
    Tick (fun () ->
        match f e with
        | None -> None
        | Some (t, e') -> Some (t, unfold f e')
        )

    let rec filter p f =
        Tick (fun () ->
            match uncons f with
            | None -> None
            | Some (t, q) ->
                if p t then Some (t, filter p q)
                else uncons (filter p q)
        )

    let rec append f1 f2 =
        Tick (fun () ->
            match uncons f1 with
            | None -> uncons f2
            | Some (t, q) -> Some (t, append q f2)
        )
end
module LFlux : Iter =
struct
    type 'a flux = Tick of ('a * 'a t) option Lazy.t

    let vide = Tick (lazy None)
    let cons t q = Tick (lazy (Some (t, q)))
    let uncons (Tick f) = Lazy.force f
    let rec apply f x =
        Tick (lazy (
            match uncons f, uncons x with
            | None, _ -> None
            | _, None -> None
            | Some (tf, qf), Some (tx, qx) ->
                Some (tf tx, apply qf qx)
        ))
    let rec unfold f e =
        Tick (lazy (
            match f e with
            | None -> None
            | Some (t, e') -> Some (t, unfold f e')
        ))
    let rec filter p flux =
        Tick (lazy (
            match uncons flux with
            | None -> None
            | Some (t, q) ->
                if p t then Some (t, filter p q)
                else uncons (filter p q)
        ))
    let rec append f1 f2 =
        Tick (lazy (
            match uncons f1 with
            | None -> uncons f2
            | Some (t, q) -> Some (t, append q f2)
        ))
end

module TD (Flux: Iter) =
struct
    let constant c = Flux.unfold (fun c -> Some (c, c)) c
    (* or : *)
    (* let constant c = Flux.unfold (fun () -> Some (c, ())) c *)
    let map f x = Flux.apply (constant f) x
    let map2 f flux1 flux2 = 
        Flux.unfold (
            fun (a,b) -> 
                match (Flux.uncons a, Flux.uncons b) with 
                |None, _ -> None 
                | _, None -> None 
                | Some (c,d), Some(e,g) -> 
                    Some(f c e, (d,g))
        ) (flux1, flux2)

    let fib = 
        Flux.unfold (
            fun (fn, fn1)
                -> Some (fn, (fn1, fn + fn1))
        ) (0, 1) 
end