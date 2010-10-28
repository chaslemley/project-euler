(defn sum_of_digits [n]
	(apply + (map (fn [a] (- (int a) 48)) (str n)))
)

(defn satisfies_reqs [n]
	(=
		(sum_of_digits n)
		(sum_of_digits (* 137 n))
	)
)

(println
	(count 
		(filter
			(fn [y] (first y))
			(map
				(fn [x] [(satisfies_reqs x) x])
				(range 0 1000000000000000000)
			)
		)
	)
)

(println (sum_of_digits 543))
(println (satisfies_reqs 5343))