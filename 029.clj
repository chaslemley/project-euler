(defn combine [low high]
	(set
		(map
			#(Math/pow (first %) (last %))
			(for [a (range low (inc high)) b (range low (inc high))]
				[a b]
			)
		)
	)
)

(println (count (combine 2 100000)))