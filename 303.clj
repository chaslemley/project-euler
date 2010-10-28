; [2 2]
; [3 12]
; [7 21]
; [42 210]
; [89 1121222]
(defn only_includes_digits_less_than_two [x]
	(every? (fn [y] (< (- (int y) 48) 3)) (str x))
)

(def smallest_positive_multiple
	(fn [x]
		(loop [accum x]
			(if (only_includes_digits_less_than_two accum)
				accum
				(recur (+ accum x))
			)
		)
	)
)

(defn function_value [x]
	(/
		(smallest_positive_multiple x)
		x
	)
)
; (println (smallest_positive_multiple 99))
(println 
	(apply + 
		(map
			(fn [y] (function_value y))
			(range 1 10001)
		)
	)
)
; (println (only_includes_digits_less_than_two 212120))
; (println (only_includes_digits_less_than_two 31))
; (println (smallest_positive_multiple 1))
; (println (smallest_positive_multiple 2))
; (println (smallest_positive_multiple 3))
; (println (smallest_positive_multiple 7))   ;  21]
; (println (smallest_positive_multiple 42)) ;    210]
; (println (smallest_positive_multiple 89))  ;   1121222]