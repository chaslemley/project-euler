(defn satisfies_reqs? [n]
	(def num_str (str n))
	(and
		(= (nth num_str 0)  \1)
		(= (nth num_str 2)  \2)
    (= (nth num_str 4)  \3)
    (= (nth num_str 6)  \4)
    (= (nth num_str 8)  \5)
    (= (nth num_str 10) \6)
    (= (nth num_str 12) \7)
    (= (nth num_str 14) \8)
    (= (nth num_str 16) \9)
    (= (nth num_str 18) \0)
	)
)

(println (satisfies_reqs? 545454))
(println (satisfies_reqs? 1020304050607080900))
(println (satisfies_reqs? 10616816667291844))

(def start_num 1010101010)
(def end_num 1389026623)

(println (count (str (* start_num start_num))))

(println 
	(filter 
		(fn [x] (satisfies_reqs? x))
		(map 
			(fn [z] (do (println z)) (* z z))
			(range start_num end_num)
		)
	)
)


