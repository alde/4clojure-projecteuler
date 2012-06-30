; A palindromic number reads the same both ways. The largest palindrome
; made from the product of two 2-digit numbers is 9009 = 91 * 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn isPalindrome? [test]
    (let [s (str test)]
        (= s (apply str (reverse s)))))

(defn solve [start end]
    (for [A (range start end)
        B (range start A)
        :when (isPalindrome? (* A B))]
    (* A B)))

(prn (first (reverse (sort (solve 100 999)))))