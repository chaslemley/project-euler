; (defn fibonacci [n]
; 	(case n
; 		1 1
; 		2 1
; 		(+ (fibonacci (- n 1)) (fibonacci(- n 2)))
; 	)
; )
; 
; (def get_length
; 	(fn [x]
; 		(loop [curr 1]
; 			(println curr)
; 			(if (= (.length (str (fibonacci curr))) x)
; 				 (println "The first number with" x "digits is term no:" curr)
; 				 (recur (inc curr))
; 			)
; 		)
; 	)
; )

(defn fib-step [ab]
  [(last ab) (+ (first ab) (last ab))])
 
(defn fib-seq []
  (map first (iterate fib-step [0 1])))

(println (map (fn [x] (.length (str x))) (fib-seq)))

; 
; (get_length 1)
; (get_length 2)
; (get_length 3)
; (get_length 4)
; (get_length 5)
; (get_length 6)
; (get_length 7)
; (get_length 8)
; (get_length 9)
; (get_length 10)
; (get_length 11)
; (get_length 12)
; (get_length 13)
; (get_length 14)
; (get_length 15)
; (get_length 16)