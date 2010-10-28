(defn sat-reqs? [num power]
	(=
	num
		(reduce
			+
			(map
				#(Math/pow (- (int %) 48) power)
				(str num)
			)
		)
	)
)

(defn sum-of-powers [upper-limit power]
	(filter
		#(sat-reqs? % power)
		(range 2 upper-limit)
	)
)

(println (apply + (sum-of-powers 1000000 5)))