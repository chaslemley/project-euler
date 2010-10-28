; The positive integers, x, y, and z, are consecutive terms of an arithmetic progression. Given that n is a positive integer, the equation, x2  y2  z2 = n, has exactly one solution when n = 20:
; 
; In fact there are twenty-five values of n below one hundred for which the equation has a unique solution.
; 
; How many values of n less than fifty million have exactly one solution?

(defn square [a]
	(* a a)
)

(defn reqs? [x s n]
	(and
		(=
			n
			(- 
				(square x)
			  (square (- x s))
		  	(square (- x (* 2 s)))
		  )
		)
		(> x 0)
		(> (- x (* 2 s)) 0)
		(> n 0)
	)
)

(dotimes [n 1000] 
	(dotimes [s 1000]
		(dotimes [x 1000]
			(if 
				(= (reqs? x s n) true)
				(println x s n)
			)	
		)
	)
)


; 50,000,000

(println (reqs? 4 1 3))
(println (reqs? 3 1 4))
(println (reqs? 9 2 7))
(println (reqs? 14 3 11))
(println (reqs? 8 2 12))
(println (reqs? 6 2 16))
(println (reqs? 24 5 19))
(println (reqs? 13 3 20))
(println (reqs? 29 6 23))
(println (reqs? 18 4 28))
(println (reqs? 39 8 31))
(println (reqs? 54 11 43))
(println (reqs? 28 6 44))
(println (reqs? 59 12 47))
(println (reqs? 16 4 48))
(println (reqs? 33 7 52))
(println (reqs? 74 15 59))
(println (reqs? 84 17 67))
(println (reqs? 43 9 68))
(println (reqs? 89 18 71))
(println (reqs? 48 10 76))
(println (reqs? 99 20 79))
(println (reqs? 26 6 80))
(println (reqs? 37 8 87))
(println (reqs? 58 12 92))
(println (reqs? 25 6 95))