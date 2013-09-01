(ns cucumber-crud.core
  (:require [clojure.string :as string]
            [clojure.set :as set]))

; this could be your database
(def authors (atom #{}))

;Create
(defn load-names [initial-names]
  (reset! authors (set (map name (string/split initial-names #",")))))

(defn add-name [raw-name]
  (swap! authors conj (string/capitalize raw-name)))

;Delete
(defn remove-name [raw-name]
  (reset! authors (set (remove #{raw-name} @authors))))

;Read
(defn find-name [raw-name]
  (let [requested-name (string/capitalize raw-name)]
    (str "Your name " requested-name (if (contains? @authors requested-name) " IS " " IS NOT ")  "in the Authors Club")))
