(defn implode [glue pieces]
  (loop [src1 pieces dest []]
    (if (and (seq src1) (< 1 (count src1)))
    (recur
        (rest src1)
        (conj dest (first src1) glue)
      )
      (conj dest (first src1))
    )
  )
)

(prn (implode 0 [1 2 3]))

(prn (= (implode 0 [1 2 3]) [1 0 2 0 3]))

(prn (= (apply str (implode ", " ["one" "two" "three"])) "one, two, three"))

(prn (= (implode :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))
