(* 1. *)
let deuxieme l = 
    match l with
    | _::x::_ -> x
    | _ -> failwith "pas assez d'élements"
        
(* 2. *)
let rec n_a_zero n = 
    if n < 0 then
        []
    else
        n::n_a_zero (n-1)

let zero_a_n n =
    let rec zero_a_n_aux p l =
        if p < 0 then
            l
        else
            zero_a_n_aux (p-1) (p::l)
        in
        zero_a_n_aux n []


(* 3. *)
let pos l e =
    let rec pos_aux l e res c = 
        match l with
        | t::q -> if t = e then res@[c] else pos_aux q e res (c+1)
        | _ -> []
    in
    pos_aux l e [] 0



let a = pos [1;1;2;4] 1