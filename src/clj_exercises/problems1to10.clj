(ns clj-exercises.problems1to10)

(defn find-last
  "P01 (*) Find the last items of a list.
    Example:>
    * (my-last '(a b c d))
    (d)"
  [list]
  (let [[x & xs] list]
    (if (empty? xs)
      x
      (find-last xs))))

(defn find-last-but-one
  "P02 (*) Find the last but one box of a list.
    Example:
    * (my-but-last '(a b c d))
    (C D)"
  [list]
  (let [[x & xs] list]
    (if (or (nil? xs) (<= (count xs) 1))
      x
      (find-last-but-one xs))))

(defn find-k-element
  "P03 (*) Find the K'th element of a list.
    The first element in the list is number 1.
    Example:
    * (element-at '(a b c d e) 3)
    C"
  ([k list] (find-k-element 1 k list))
  ([n k list]
   (let [[x & xs] list]
     (if (= n k)
       x
       (find-k-element (inc n) k xs)))))

(defn size
  "P04 (*) Find the number of elements of a list."
  [sequence]
  (clj-exercises.sequences.sequences/size sequence))

(defn reverse-seq
  "P05 (*) Reverse a list."
  [sequence]
  (if (or (nil? sequence) (empty? sequence))
    []
    (let [[x & xs] sequence]
      (if (nil? xs)
        [x]
        (cons (reverse-seq xs) x)))))




(defn palindrome?
  "P06 (*) Find out whether a list is a palindrome.
  A palindrome can be read forward or backward; e.g. (x a m a x)."
  [sequence] 5)


