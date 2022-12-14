(ns day01-borkdude
  (:require ["fs" :as fs]
            [clojure.string :as str]))

(def input
  (mapv js/parseInt (str/split (str/trim (fs/readFileSync "2021/input/day01.txt" "utf-8")) "\n")))

(defn increases [nums]
  (filter true? (map #(< %1 %2) nums (rest nums))))

(def answer-01 (time (prn (count (increases input)))))

(def sums
  (map #(+ % %2 %3) input (rest input) (rest (rest input))))

(def answer-02 (time (prn (count (increases sums)))))
