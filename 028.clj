(def gen-seq
	(fn [limit]
		(loop [curr 1 curr-element 1 curr-iterator 2 accum '(1)]
			(if (and (= curr-iterator (+ limit 1)) (= curr-element 1))
				accum				
				(if (= curr-element 4)
					(recur (+ curr curr-iterator) 1 (+ 2 curr-iterator) (conj accum (+ curr curr-iterator)))
					(recur (+ curr curr-iterator) (inc curr-element) curr-iterator (conj accum (+ curr curr-iterator)))
				)
			)
		)
	)
)

(println (apply + (gen-seq 1001)))