(defn lazy-primes3 []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                (dissoc candidate)
                (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate
                (lazy-seq (next-primes (next-sieve sieve candidate)
                            (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))

(defn prime-divisors [n]
	(lazy-seq
		filter
		#(zero? (rem n %))
		(take-while #(< % n) (lazy-primes3))
	)
)

(defn tri-nums []
	(map
		last
	(iterate 
		(fn [[a b]] [(inc a) (+ b (inc a))]) [1 1])))


(defn num-its [n pd]
	(count (take-while #(zero? (rem % pd)) (iterate #(/ % pd) n)))
)

(defn num-divisors [n]
	(reduce 
		*
	(map
		#(+ 1 (num-its n %))
		(prime-divisors n)
	))
)

(defn first-over [n]
	(first (drop-while #(< (num-divisors %) n) (tri-nums)))
)

(println (first-over 500))