(defn add_powers [a b]
  (reduce #(+ (Math/pow %1 %1) (Math/pow %2 %2)) 0 (range a b)))

(println (add_powers 1 2))