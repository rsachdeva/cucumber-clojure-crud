(ns cucumber-crud.core
  (:require [clojure.string :as string]
            [clojure.set :as set]))

(def authors (atom #{}))

(defn load-names [initial-names]
  (reset! authors (set (map name (string/split initial-names #",")))))

(defn find-name [raw-name]
  (let [requested-name (string/capitalize raw-name)]
    (str "Your name " requested-name (if (contains? @authors requested-name) " IS " " IS NOT ")  "in the Authors Club")))

(defn add-name [raw-name]
  (swap! authors conj (string/capitalize raw-name)))

