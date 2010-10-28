(defn range_is_divisible_by [r n]
	(map 
		(fn [x]
			(= (rem n x) 0)
		)
		r
	)
)

(def smallest_divisible_for_numbers_between
	(fn [r]
		(loop [curr (* 3 5 7 11 13 17 19)]
			(println curr)
			(if (apply = (range_is_divisible_by r curr))
				(println "*" curr)
				(recur (+ curr 20))
			)
		)
	)
)

(println 
	(filter 
		(fn [y] (first y))
		(map 
			(fn [x] [(apply = (range_is_divisible_by (range 1 21) x)) x]) 
			(range 0 500000000 20)
		)
	)
)

;; (println (apply = (range_is_divisible_by (range 1 3) 160)))
;; (smallest_divisible_for_numbers_between (range 1 21))  ; => 2520
