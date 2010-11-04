(ns fiftysix.core)

(defn digital-sum [num]
  (apply + (map #(- (int %) 48) (str num))))

(println
  (reduce
    (fn [curr-max curr] 
      (let [a (digital-sum (.pow (curr :a) (curr :b)))]
        (max a curr-max)))
    0
    (for [a (range 100) b (range 100)]
      {:a (new java.math.BigInteger (str a)) :b (new java.math.BigInteger (str b))})))