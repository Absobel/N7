let rec combinaisons l k =
    match l,k with
    | [],_ -> [[]]
    | _,0 -> [[]]
    | (t::q),k -> (combinaisons q k)@
