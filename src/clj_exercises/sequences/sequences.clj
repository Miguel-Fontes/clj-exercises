(ns clj-exercises.sequences.sequences)

(defn my-second
  "Returns the second value of a sequence, if any. Otherwise, nil"
  [seq]
  (let [[_ snd & _] seq]
    snd))

(defn size
  "Counts the lenght of a list"
  [list]
  (loop [n 0
         [x & xs] list]
    (if (nil? x)
      n
      (recur (inc n) xs))))