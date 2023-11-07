module type FichierLecture2Char = sig
    type debut
    type encours
    type fin
    type _ fichier
    val open_ : string -> debut fichier
    val read1 : debut fichier -> char * encours fichier
    val read2 : encours fichier -> char * fin fichier
    val close : fin fichier -> unit
end

module Impl2Char : FichierLecture2Char = struct
    type debut = unit
    type encours = unit
    type fin = unit
    type _ fichier = in_channel
    let open_ nom = open_in nom
    let read1 f = (input_char f, f)
    let read2 f = (input_char f, f)
    let close f = close_in f
end

let _ = 
    let f = Impl2Char.open_ "ex1.ml" in
    let (c1, f) = Impl2Char.read1 f in
    let (c2, f) = Impl2Char.read2 f in
    Impl2Char.close f;

module type FichierLecturePairChar = sig
    type pair_char
    type impair_char
    type _ fichier
    val open_ : string -> pair_char fichier
    val read : pair_char fichier -> impair_char fichier
    val read : impair_char fichier -> pair_char fichier
    val close : pair_char fichier -> unit
end