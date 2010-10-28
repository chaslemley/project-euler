(defn is_a_square? [a]
	(= 
		(. java.lang.Math (sqrt a))
		(. java.lang.Math (round (. java.lang.Math (sqrt a))))
	)
)

(defn satisfies_reqs? [x y z]
	(and
		(is_a_square? (+ x y)) 
		(is_a_square? (- x y))
		(is_a_square? (+ x z))
		(is_a_square? (- x z))
		(is_a_square? (+ y z))
		(is_a_square? (- y z))
		(> x y)
		(> y z)
		(> z 0)
	)
)

(dotimes [x 3000] 
	(dotimes [y 3000] 
		(dotimes [z 3000]
			(if 
				(satisfies_reqs? z y x)
				(println z y x "=" (+ x y z))
				(print ".")
			)	
		)
	)
)