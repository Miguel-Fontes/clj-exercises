(ns clj-exercises.problems1to10
  (require [clj-exercises.sequences.sequences]))

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
    ()
    (let [[x & xs] sequence]
      (if (nil? xs)
        [x]
        (conj (reverse-seq xs) x)))))

(defn safe-seq
  "Creates a new sequence containing the give data.
   If the seq is evaluated to nil, returns a empty sequence"
  [sequence]
  (let [built-seq (seq sequence)]
    (if (nil? built-seq)
      ()
      built-seq)))

(defn palindrome?
  "P06 (*) Find out whether a list is a palindrome.
   A palindrome can be read forward or backward; e.g. (x a m a x)."
  [sequence]
  (= (safe-seq sequence) (reverse-seq sequence)))

(defn flatten-seq
  "P07 (**) Flatten a nested list structure.
   Transform a list, possibly holding lists as elements into a `flat' list by replacing each list with its elements (recursively).

   Example:
   * (my-flatten '(a (b (c d) e)))
   (A B C D E)"
  [sequence]
  (let [[x & xs] sequence]
    (if (nil? x)
      []
      (if (coll? x)
        (concat x (flatten-seq xs))
        (concat [x] (flatten-seq xs))))))

(defn eliminate-consec-dups
  "P08 (**) Eliminate consecutive duplicates of list elements.
   If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

   Example:
   * (compress '(a a a a b c c a a d e e e e))
   (A B C A D E)"
  [sequence]
  (if (or (nil? sequence) (empty? sequence))
    ()
    (let [[x y & xs] sequence]
      (if (nil? y)
        [x]
        (if (= x y)
          (eliminate-consec-dups (cons y xs))
          (cons x (eliminate-consec-dups (cons y xs))))))))

(defn pack-consec-dups
  "P09 (**) Pack consecutive duplicates of list elements into sublists.
   If a list contains repeated elements they should be placed in separate sublists.

   Example:
   * (pack '(a a a a b c c a a d e e e e))
   ((A A A A) (B) (C C) (A A) (D) (E E E E))"
  [sequence]
  (if (or (nil? sequence) (empty? sequence))
    ()
    (let [x (first sequence)]
      (cons (take-while #(= x %) sequence) (pack-consec-dups (drop-while #(= x %) sequence))))))

