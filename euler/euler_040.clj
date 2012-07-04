; An irrational decimal fraction is created by concatenating the positive
; integers:
;
; 0.123456789101112131415161718192021...
;
; It can be seen that the 12th digit of the fractional part is 1.
;
; If dn represents the nth digit of the fractional part, find the value of
; the following expression.

(ns euler
    (:use clojure.test))

; Build a list of integers. Since we only want the fraction part, might aswell
; ignore the decimals
(defn upto [limit] (for [b (range 1 (+ limit 5))] b))

; Convert a list of separate ints to a single string
(defn to-string [li] (apply str li))

; Get the n:th character of the string
(defn get-nth [string n] (str (.charAt string n)))

; start building the string
(defn
    ^{:test #(is (= (digit 12) "1"))}
    digit [n] (get-nth (to-string (upto n)) n))

; Parse a string to an int
(defn to-int [c] (Integer/parseInt (to-string (digit (dec c)))))

; Run any tests
(run-tests)

; print the result
(prn
    (*
        (to-int 1)
        (to-int 10)
        (to-int 100)
        (to-int 1000)
        (to-int 10000)
        (to-int 100000)
        (to-int 1000000)
    )
)