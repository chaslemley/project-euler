; http://projecteuler.net/index.php?section=problems&id=11

(ns eleven.core
  (:use [clojure.contrib.duck-streams :only (read-lines)]))

(defn process-file [filename line-accum]
  (reduce 
    (fn [accum line] 
      (conj accum (map #(Integer/parseInt %) (.split line " ")))) 
    line-accum 
    (read-lines filename)))

(defn element-at [y x grid-data]
  (nth (nth grid-data (dec y)) (dec x)))

(defn all-iterations [grid]
  (reduce #(max %1 %2) 0
    (for [x (range 1 20) y (range 1 20) v '([0 1] [1 0] [1 1] [1 -1])]
      (apply * 
        (map
          #(try (element-at (+ y (* (first v) %)) (+ x (* (last v) %)) grid)
             (catch java.lang.IndexOutOfBoundsException ioe 0))
          (range 0 4))))))

(def grid 
  (process-file "data/011_grid.txt" []))

(time (prn (all-iterations grid)))
