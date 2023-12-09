let rec insertions e ens =
    match ens with
    | [] -> [[e]]
    | t::q -> (e::ens)::(List.map (fun l -> t::l) (insertions e q)) 

let%test _ = insertions 4 [1;2;3] = [4;1;2;3]::[1;4;2;3]::[1;2;4;3]::[1;2;3;4]::[]

let rec permutations ens =
    match ens with
    | [] -> [[]]
    | t::q -> List.flatten (List.map (insertions t) (permutations q))

let permutations ens = List.fold_right (fun t acc -> List.flatten(List.map (insertions t) acc)) ens

let%test _ = insertions 4 [1;2;3] = [4;1;2;3]::[1;4;2;3]::[1;2;4;3]::[1;2;3;4]::[]