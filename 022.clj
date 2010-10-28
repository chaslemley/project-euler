(import (java.io BufferedReader FileReader))

(defn score-letter [l]
	(- (int  l) 64)
)

(defn score-word [w]
	(apply
		+
		(map
			#(score-letter %)
			w
		)
	)
)

(println (score-letter \A))
(println (score-letter \C))
(println (score-word "COLIN"))

(defn process-file [file-name line-func line-acc line-curr]
  (with-open [rdr (BufferedReader. (FileReader. file-name))]
    (reduce line-func [line-acc line-curr] (line-seq rdr))))

(defn process-line [acc line]
  [(+ (first acc) (* (inc (last acc)) (score-word line)))
  (inc (last acc))
  ]
)

(prn (process-file "022_names.txt" process-line 0 0))