(ns clj-exercises.problems1to10-test
  (:require [clojure.test :refer :all]
            [clj-exercises.problems1to10 :refer :all]))

(deftest find-last-test
  (testing "find last sequence item"
    (is (nil? (find-last [])))
    (is (= 1 (find-last [1])))
    (is (= 2 (find-last [1 2])))
    (is (= 3 (find-last [1 2 3])))))

(deftest find-last-but-one-test
  (testing "find last but one of a sequence"
    (is (nil? (find-last-but-one [])))
    (is (= 1 (find-last-but-one [1])))
    (is (= 1 (find-last-but-one [1 2])))
    (is (= 2 (find-last-but-one [1 2 3])))))

(deftest find-k-element-test
  (testing "find k element of a sequence"
    (is (nil? (find-k-element 1 [])))
    (is (= 1 (find-k-element 1 [1])))
    (is (= 3 (find-k-element 3 [1 2 3])))
    (is (= 1 (find-k-element 1 [1 2 3])))
    (is (= 3 (find-k-element 3 [1 2 3 4 5])))))

(deftest reverse-seq-test
  (testing "reverse a list"
    (is (= [] (reverse-seq [])))
    (is (= [1] (reverse-seq [1])))))


