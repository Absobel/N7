(* 1. *)
let map f l =
    List.fold_right (fun acc l -> (f acc)::l) l []

(* 2. *)
let flatten l =
    List.fold_right (fun l acc -> l@acc) l []

(* 3. *)

let fsts l =
    List.map fst l

(* 4. *)
let split l =
    List.fold_right (fun (e1,e2) (l1,l2) -> (e1::l1, e2::l2)) l ([],[]) 

let remove_double l =
    List.fold_right (
        fun e acc -> 
            if List.mem e acc then 
                acc 
            else 
                e::acc
        ) l []

let _ = List.iter print_int (remove_double [1;2;1;3;4;3;5;2;2;2;6])