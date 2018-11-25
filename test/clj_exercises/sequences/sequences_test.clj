(ns clj-exercises.sequences.sequences-test
  (:require [clojure.test :refer :all]
            [clj-exercises.streams.numbers :refer :all]
            [clj-exercises.sequences.sequences :refer :all]))

(deftest size-test
  (testing "count the size of a list"
    (let [sequence-of-integers #(take % (integers-stream))]
      (is (= 0 (size [])))
      (is (= 1 (size (sequence-of-integers 1))))
      (is (= 2 (size (sequence-of-integers 2))))
      (is (= 3 (size (sequence-of-integers 3))))
      (is (= 100 (size (sequence-of-integers 100)))))))
