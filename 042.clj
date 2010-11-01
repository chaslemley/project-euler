(ns forty-two.core
  (:use [clojure.contrib.duck-streams :only (read-lines)]))
  
(defn word-value [word]
  (reduce #(+ (- (int %1) 48) (- (int %2) 48)) 0 (.toLowerCase word)))
  
(defn tri-step [ab]
  [(+ (first ab) (last ab)) (inc (last ab))])
  
(defn tri-seq [n]
  (set (take n (map first (iterate tri-step [1 2])))))

(def tri-seq (memoize tri-seq))

(defn is-triangle-word? [word]
  (contains? (tri-seq 30) (word-value word)))

(defn process-word [word]
  (if (is-triangle-word? word)
    1
    0))

(defn process-line [acum line]
  (apply + (map process-word (.split (.replace line "\"" "") ","))))


(defn process-file [file-name line-accum]
  (reduce process-line line-accum (clojure.contrib.duck-streams/read-lines file-name)))

(time (process-file "data/042_words.txt" []))
