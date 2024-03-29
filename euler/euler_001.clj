; If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.

(defn result [li]
    (reduce + (filter
        #(or (zero? (mod % 3))
             (zero? (mod % 5)))
        (range 1 li))))

(prn (result 1000))