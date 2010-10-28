(defn sum_of_squares [rnge]
	(apply + (map (fn [y] (* y y)) rnge))
)

(defn square_of_sum [rnge]
	(*
		(apply + rnge)
		(apply + rnge)
	)
)

(defn difference_between [rnge]
	(-
		(square_of_sum rnge)
		(sum_of_squares rnge)
	)
)

(println (sum_of_squares (range 11)))
(println (square_of_sum (range 11)))
(println "=" (difference_between (range 11)))

(println (sum_of_squares (range 101)))
(println (square_of_sum (range 101)))
(println "=" (difference_between (range 101)))

