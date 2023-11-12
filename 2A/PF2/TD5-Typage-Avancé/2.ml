type 'a perfect_tree =
    | Empty
    | Node of 'a * ('a * 'a) perfect_tree

let rec split : type a. (a * a) perfect_tree -> (a perfect_tree * a perfect_tree) = 
    function
    | Empty -> (Empty, Empty)
    | Node ((t1, t2), q) ->
        let (q1, q2) = split q in
        (Node (t1, q2), Node (t2, q1))

(***********************************)

type zero = Z
type 'a succ = S of 'a
type ('a, _ ) ptree =
    | Empty : ('a, zero) ptree
    | Node : 'a * (('a * 'a), 'p) ptree -> ('a, 'p succ) ptree

let rec split : type a p. (a*a, p) ptree -> (a, p) ptree * (a, p) ptree =
    function
    | Empty -> (Empty, Empty)
    | Node ((t1, t2), q) ->
        let (q1, q2) = split q in
        (Node (t1, q1), Node (t2, q2))

let rec merge : type a p. (a, p) ptree -> (a, p) ptree -> (a*a, p) ptree =
    fun t1 t2 ->
        match t1, t2 with
        | Empty, Empty -> Empty
        | Node (a1, q1), Node (a2, q2) ->
            Node ((a1, a2), merge q1 q2)

(***********************************)