; The sum of the squares of the first ten natural numbers is,
;
; 1^2 + 2^2 + ... + 10^2 = 385
; The square of the sum of the first ten natural numbers is,
;
; (1 + 2 + ... + 10)^2 = 55^2 = 3025
; Hence the difference between the sum of the squares of the first ten
; natural numbers and the square of the sum is 3025 - 385 = 2640.
;
; Find the difference between the sum of the squares of the first one
; hundred natural numbers and the square of the sum.
(ns euler
    (:use clojure.test))

(defn
    ^{:test #(are [x y] (= x y) 9 (square 3) 81 (square 9) 100 (square 10))}
    square [x] (* x x))

(defn
    ^{:test #(are [x y] (= x y) 385 (sum-of-squares 10) 55 (sum-of-squares 5))}
    sum-of-squares [n] (/ (* (* n (inc n)) (+ 1 (* 2 n))) 6))

(defn
    ^{:test #(are [x y] (= x y) 3025 (square-of-sums 10) 225 (square-of-sums 5))}
    square-of-sums [n] (square (/ (* n (inc n)) 2)))

(defn
    ^{:test #(is (= 2640 (problem-6 10)))}
    problem-6 [n] (- (square-of-sums n) (sum-of-squares n)))

(prn (run-tests))
(prn (problem-6 100))