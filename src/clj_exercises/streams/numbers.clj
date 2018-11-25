(ns clj-exercises.streams.numbers)

(defn integers-stream
  "Generates a infinite sequence of positive numbers.
  Can be called as:
    - No arguments: results on a stream starting from 1
    - A integer: results on a stream starting from the given number"
  ([] (integers-stream 1))
  ([n] (cons n (lazy-seq (integers-stream (inc n))))))