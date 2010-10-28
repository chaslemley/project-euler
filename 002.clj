(defn two_to_the_power [a]
	(recur
		(if (= a 0)
			1
			(- a 1)
		)
	)
)

(println (two_to_the_power 5))
