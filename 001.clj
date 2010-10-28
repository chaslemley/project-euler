(use 'clojure.set)

(def add_multiples_of
  (fn [n lim]
    (loop [cnt n acc #{}]
      (if (< cnt lim)
				(recur (+ cnt n) (conj acc cnt))
        acc
      )
	  )
	)
)

(println
	(apply +
		(union
			(add_multiples_of 3 50000000)
			(add_multiples_of 5 50000000)
		)
	)
)