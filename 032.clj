(defn comb [r m p] 
	(if (> m 0) 
		(mapcat 
			#(comb
				r
				(dec m)
				(conj p %)
			)
		r) 
		[p]
	)
)

(defn comb-ex [r m p] 
	(if (> m 0) 
		(mapcat 
			#(comb-ex
				(disj r %) 
				(dec m)
				(conj p %)
			)
		r) 
		[p]
	)
)

(def perms
	(filter (fn [x] (= (apply + x) 9)) (comb #{1 2 3 4 5 6 7 8} 3 []))
)

(def build-number
	(fn [x]
		(loop [s x curr 1 accum 0]
			(if (empty? s)
				accum
				(recur (pop s) (* curr 10) (+ accum (* (last s) curr)))
			)
		)
	)
)

(defn sat-reqs? [s e]
	(=
		(*
			(build-number (subvec s 0 (first e)))
			(build-number (subvec s (first e) (+ (first e) (nth e 1))))
		)
		(build-number (subvec s (+ (first e) (nth e 1)) (+ (+ (first e) (nth e 1)) (nth e 2))))
	)
)

(println
(filter
	(fn [y] (first y)) 
	(for [perm perms s (comb-ex #{1 2 3 4 5 6 7 8 9} 9 [])]
		[(sat-reqs? s perm) s perm]
	)
)
)