(defn factor [num cur]
  (if (= num cur)
    num
    (if (zero? (mod num cur))
      (factor (/ num cur) cur)
      (factor num (inc cur)))))

(println (factor 600851475143 2))