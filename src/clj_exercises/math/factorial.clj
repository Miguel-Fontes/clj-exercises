(ns clj-exercises.math.factorial)

(defn factorial
    [n]
    (if (> n 0)
      (bigint (* n (factorial (dec n))))
      1))

(defn factorial-r
    [n]
    (loop [x 1 acc (bigint 1)]
      (if (>= n x)
        (recur (inc x) (* x acc))
        acc)))