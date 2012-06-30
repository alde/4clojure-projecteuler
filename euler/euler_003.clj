; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?

(defn factor [n-arg d-arg]
    (loop [n n-arg
            d d-arg
            factors []]
        (if (< n (* d d))
            (conj factors n)
            (if (zero? (mod n d))
                (recur (/ n d) d (conj factors d))
                (recur n (+ d 1) factors)))))

(defn solve [number]
    (first (reverse (factor number 2))))

(prn (solve 600851475143))