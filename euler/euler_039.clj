; If p is the perimeter of a right angle triangle with integral length
; sides, {a,b,c}, there are exactly three solutions for p = 120.
;
; {20,48,52}, {24,45,51}, {30,40,50}
;
; For which value of p <= 1000, is the number of solutions maximised?

(ns euler
    (:use clojure.test))

(defn triplet [a p]
    (/ (- (* p p) (* 2 p a)) (- (* 2 p) (* 2 a))))

(defn
    ^{:test #(is (= 3 (count-solutions 120)))}
    count-solutions [p]
        (count
            (for [a (range 1 (int (/ p 3)))
                :when (zero? (rem (* p (- p (* 2 a))) (* 2 (- p a))))]
                (triplet a p))))

(defn create-map [limit]
    (let [s #{}]
    (into s (for [a (range 1 (inc limit))
        :when (not (zero? (count-solutions a)))]
        [a (count-solutions a)]))))

(defn
    problem-039 [limit] (create-map limit))

(defn reverse-map [m]
  (into {} (map (fn [[a b]] [b a]) m)))

(run-tests)
(prn (last (sort (reverse-map (problem-039 1000)))))