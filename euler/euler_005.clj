; 2520 is the smallest number that can be divided by each of the numbers
; from 1 to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all
; of the numbers from 1 to 20?

(defn divisible? [number div] (zero? (rem number div)))

(defn simplify [div number] (if (divisible? number div) (quot number div) number))

; Use partial instead of #(not= 1 %) and #(simplify div %)
(defn simplify-all [nums div] (filter (partial not= 1) (map (partial simplify div) nums)))

(defn solve [n]
   (loop [values (range 2 (inc n)) factors []]
     (if (empty? values)
       (apply * factors)
       (let [a (first values) b (rest values)]
         (recur (simplify-all b a) (conj factors a))))))

(prn (solve 20))