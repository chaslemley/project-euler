; ; Find the number of integers 1  n  107, 
; for which n and n + 1 have the same number of positive divisors. 
; 
; For example, 
; 14 has the positive divisors 1, 2, 7, 14 while 
; 15 has 1, 3, 5, 15.

(defn positive_divisors [n]
	(count
		(filter 
			(fn [x] (first x))
			(map
				(fn [y] [(= (rem n y) 0) y])
				(range 1 (inc n))
			)
		)
	)
)

(def count_where_reqs 
	(fn [low high]
		(loop [curr low accum []]
			(if (> curr high)
				accum
				(recur 
					(inc curr) 
					;; (if (= (positive_divisors curr) (positive_divisors (inc curr)))
					(if (= curr (inc curr))
						(conj accum curr)
						accum
					)
				)
			)
		)
	)
)

(println "starting")
(println (count_where_reqs 1 10000000))
(println "finished")
