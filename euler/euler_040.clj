; An irrational decimal fraction is created by concatenating the positive
; integers:
;
; 0.123456789101112131415161718192021...
;
; It can be seen that the 12th digit of the fractional part is 1.
;
; If dn represents the nth digit of the fractional part, find the value of
; the following expression.
;
; d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000

(defn to-int [x] (Integer/parseInt (str x)))

(defn euler-40 [limit]
  (let [st (apply str (doall (range 1 (inc limit))))]
    (loop [position limit result 1]
      (if (= position 1)
        result
        (recur (quot position 10) (* result (to-int (nth st (dec position)))))))))

(prn (euler-40 1000000))