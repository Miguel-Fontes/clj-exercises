(ns clj-exercises.streams.numbers-test
  (:require [clojure.test :refer :all]
            [clj-exercises.streams.numbers :refer :all]))

(deftest integers-stream-test
  (testing "Infinite integers stream"
    (let [take-and-count #((comp count (partial take %1)) %2)]
      (is (= 1 (take-and-count 1 (integers-stream))))
      (is (= 2 (take-and-count 2 (integers-stream))))
      (is (= 3 (take-and-count 3 (integers-stream))))
      (is (= 4 (take-and-count 4 (integers-stream))))
      (is (= 5 (take-and-count 5 (integers-stream))))))
  (testing "First number should be the given one"
    (is (= '(-10) (take 1 (integers-stream -10))))
    (is (= '(-100) (take 1 (integers-stream -100))))
    (is (= '(25) (take 1 (integers-stream 25))))
    (is (= '(72) (take 1 (integers-stream 72))))
    (is (= '(12313) (take 1 (integers-stream 12313)))))
  (testing "Second number should be a increment of the first"
    (let [take-2-then-second (comp second (partial take 2))]
      (is (= -9 (take-2-then-second (integers-stream -10))))
      (is (= -99 (take-2-then-second (integers-stream -100))))
      (is (= 26 (take-2-then-second (integers-stream 25))))
      (is (= 73 (take-2-then-second (integers-stream 72))))
      (is (= 12314 (take-2-then-second (integers-stream 12313))))))
  )