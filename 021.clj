(defn sum-of-divisors [n]
  (apply +
    (filter
      #(= (rem n %) 0)
      (range 1 n)
    )
  )
)

(defn sum-list [n]
  (map
    (fn [x] [x (sum-of-divisors x)])
    (range 1 n)
  )
)

(defn amicable-list [f r]
  (apply +
    (map
      #(if (and 
            (= (last f) (first %)) 
            (= (first f) (last %))) 
        (+ (first f) (first %))
        0)
      r
    )
  )
)

(def get-sum
  (fn [l]
    (loop [f (first l) r (rest l) accum 0]
      (if (empty? r)
        accum
        (recur (first r) (rest r) (+ accum (amicable-list f r)))
      )
    )
  )
)

(time (println (get-sum (sum-list 10000))))
