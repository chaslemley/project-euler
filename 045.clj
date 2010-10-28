(defn tri-list [upper]
	(set
		(map
			#(/ (* (+ % 1) %) 2)
			(range 1 upper)
		)
	)
)

(defn pent-list [upper]
	(set
		(map
			#(/ (* (- (* % 3) 1) %) 2)
			(range 1 upper)
		)
	)
)

(defn hex-list [upper]
	(set
		(map
			#(* (- (* % 2) 1) %)
			(range 1 upper)
		)
	)
)

(defn combine-sets
	([x y] (set (filter #(contains? x %) y)))
	([x y z] 
		(combine-sets
			(combine-sets x y)
		z)
	)
)

(def uppper-limit 78000)

(println (combine-sets (tri-list uppper-limit) (hex-list uppper-limit) (pent-list uppper-limit)))

; (println (combine-two (set (combine-two (tri-list 1 1000000) (hex-list 1 1000000))) (pent-list 1 1000000)))