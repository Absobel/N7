(* Module précisant la base dans laquelle vont être décomposer des entiers *)
module type Base = sig
  (* Entier qui va servir de base de décomposition des entiers*)
  val base : int
end

module Base2 = struct
  let base = 2  
end

module Base5 = struct
  let base = 5  
end
