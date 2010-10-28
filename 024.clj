(defn comb [r m p] 
	(if (> m 0) 
		(mapcat 
			#(comb 
				(disj r %) 
				(dec m)
				(conj p %)
			)
		r) 
		[p]
	)
)

(println (last (take 1000000 (comb #{0 1 2 3 4 5 6 7 8 9} 10 []))))