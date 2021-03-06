(ns clj-exercises.problems1to10-test
  (:require [clojure.test :refer :all]
            [clojure.string :refer [join]]
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
    (is (= [1] (reverse-seq [1])))
    (is (= [2 1] (reverse-seq [1 2])))
    (is (= [3 2 1] (reverse-seq [1 2 3])))
    (is (= [4 3 2 1] (reverse-seq [1 2 3 4])))))

(deftest palindrome?-test
  (testing "numbers palindromes"
    (is (true? (palindrome? "a")))
    (is (false? (palindrome? "ab")))
    (is (true? (palindrome? "ana")))
    (is (true? (palindrome? "x a m a x")))
    (is (true? (palindrome? "")))
    (is (true? (palindrome? "AabaA"))))

  (testing "number palindromes"
    (is (true? (palindrome? [])))
    (is (true? (palindrome? [1])))
    (is (true? (palindrome? [1 2 1])))
    (is (true? (palindrome? [1 2 3 2 1])))
    (is (false? (palindrome? [1 2 3])))
    (is (false? (palindrome? [3 2 1])))))

(deftest flatten-seq-test
  (testing "flatten vectors"
    (is (= [] (flatten-seq [])))
    (is (= [1] (flatten-seq [1])))
    (is (= [1 2] (flatten-seq [[1] [2]])))
    (is (= [1 2 3] (flatten-seq [[1] [2 3]])))
    (is (= [1 2 3 4] (flatten-seq [[1] [2] [3 4]])))))

(deftest eliminate-consec-dups-test
  (testing "eliminate number consecutive duplicates"
    (is (= [] (eliminate-consec-dups [])))
    (is (= [1] (eliminate-consec-dups [1])))
    (is (= [1] (eliminate-consec-dups [1 1])))
    (is (= [1 2 1 3 1 3 2 1] (eliminate-consec-dups [1 1 2 2 1 3 3 1 3 2 1]))))
  (testing "eliminate string consecutive duplicates"
    (is (= "" (join (eliminate-consec-dups ""))))
    (is (= "ab" (join (eliminate-consec-dups "aabb"))))
    (is (= "abacd" (join (eliminate-consec-dups "aabbacccd"))))
    (is (= "abcec" (join (eliminate-consec-dups "aaaaabbceec"))))))

(deftest pack-consec-dups-test
  (testing "pack consecutive duplicates"
    (is (= [] (pack-consec-dups [])))
    (is (= [[1]] (pack-consec-dups [1])))
    (is (= [[1 1] [2] [3]] (pack-consec-dups [1 1 2 3]))))

  (testing "pack consecutive string duplicates"
    (is (= '((a a a a) (b) (c c) (a a) (d) (e e e e)) (pack-consec-dups '(a a a a b c c a a d e e e e))))))

(deftest encode-test
  (testing "length encode a string list"
    (is (= () (encode "")))
    (is (= '((1 \a)) (encode "a")))
    (is (= '((4 \a) (2 \b) (3 \c) (1 \d)) (encode "aaaabbcccd")))
    ))






