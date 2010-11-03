(ns one-zero-two.core
  (:use [clojure.contrib.duck-streams :only (read-lines)]))

(defstruct point :x :y)

(defn create-point [x y]
  (struct-map point :x x :y y))

(defn process-triangle-string [string]
  (let [s (.split string ",")]
    [(create-point (Integer/parseInt (nth s 0)) (Integer/parseInt (nth s 1))) 
     (create-point (Integer/parseInt (nth s 2)) (Integer/parseInt (nth s 3))) 
     (create-point (Integer/parseInt (nth s 4)) (Integer/parseInt (nth s 5)))]))

(defn det [u v]
  (- (* (u :x) (v :y)) (* (u :y) (v :x))))

(defn point-in-triangle [v triangles]
 (let [v0 (first triangles) 
       v1 (create-point (- ((nth triangles 1) :x) ((first triangles) :x)) (- ((nth triangles 1) :y) ((first triangles) :y))) 
       v2 (create-point (- ((last triangles)  :x) ((first triangles) :x)) (- ((last triangles)  :y) ((first triangles) :y)))]
   (let [a (/ (- (det v v2) (det v0 v2)) (det v1 v2)) b (* -1 (/ (- (det v v1) (det v0 v1)) (det v1 v2)))]
       (and (> a 0) (> b 0) (< (+ a b) 1)))))

(defn process-triangle [string]
  (if (point-in-triangle (create-point 0 0) (process-triangle-string string)) 1 0))

(defn process-line [accum line]
  (+ accum (process-triangle line)))

(defn process-file [file-name line-accum]
  (reduce process-line line-accum (read-lines file-name)))

(time (println (process-file "data/102_triangles.txt" 0)))
