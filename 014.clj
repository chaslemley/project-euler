(def gen-seq
	(fn [n]
		(loop [curr n size 1 accum []]
			(if (= curr 1)
				(conj accum 1)
				(if (= (rem curr 2) 0)
					(recur (/ curr 2) (inc size) (conj accum curr))
					(recur (+ (* 3 curr) 1) (inc size) (conj accum curr))
				)
			)
		)
	)
)

(println
	(apply 
		max-key
			count
			(map
				(fn [y] (gen-seq y))
				(range 1 999999)
			)
	)
)
