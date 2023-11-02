let test = 
    function test2 ->
        if -true = -(function x -> x) then
            1
        else
            letrec test3 = function x -> x in
              2
in 
    -(-18)