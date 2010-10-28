(defn factorial [n]
	(if (<= n 1)
		1
		(* n (factorial (dec n)))
	)
)

(defn is-curious? [n]
	(=
		n
		(apply
			+
			(map
				#(factorial (- (int %) 48))
				(str n)
			)
		)
	)
)

(defn list-of-curious [upper-limit]
	(filter
		#(is-curious? %)
		(range 3 upper-limit)
	)
)


(println (list-of-curious 99999))