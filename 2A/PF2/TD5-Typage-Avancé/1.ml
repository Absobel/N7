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

(*****************************************)

module type FichierLecture2Char2 = sig
    type zero
    type _ succ
    type _ fichier
    val open_ : string -> zero fichier
    val read : 'a fichier -> char * 'a succ fichier
    val close : zero succ succ fichier -> unit
end

module Impl2Char2 : FichierLecture2Char2 = struct
    type zero = unit
    type 'a succ = unit
    type _ fichier = in_channel
    let open_ nom = open_in nom
    let read f = (input_char f, f)
    let close f = close_in f
end

let _ = 
    let f = Impl2Char2.open_ "ex1.ml" in
    let (c1, f) = Impl2Char2.read f in
    let (c2, f) = Impl2Char2.read f in
    Impl2Char2.close f;

(*****************************************)

module type FichierLecturePairChar = sig
    type even
    type odd
    type _ fichier
    val open_ : string -> even fichier
    val read : ('a*'b) fichier -> char * ('b*'a) fichier
    val close : even fichier -> unit
end

