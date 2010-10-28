(defn is_palindrome? [x]
	(def wordlength (count (str x)))
	(def wordstring (str x))
	
	(=
		(take (int (/ wordlength 2)) wordstring)
		(reverse (take-last (int (/ wordlength 2)) wordstring))
	)
)

(defn three_digit_products [x, y]
	(for [a x b y]
		(* a b)
	)
)

(println 
	(last 
		(filter 
			is_palindrome?
			(sort 
				(three_digit_products (range 100 1000) (range 100 1000))
			)
		)
	)
)
; (println (is_palindrome? 9009))
; (println (is_palindrome? 90409))
; (println (is_palindrome? 903409))