(require '[cucumber-crud.core :refer :all])
(require '[clojure.test :refer :all])

(def result (atom {}))

(Given #"^Authors list is set up as \"([^\"]*)\"$" [listed-names]
  (load-names listed-names))

(When #"^I add name \"([^\"]*)\"$" [name]
  (add-name name))

(When #"^I request name \"([^\"]*)\"$" [requested-name]
  (reset! result (find-name requested-name)))

(Then #"^I should get \"([^\"]*)\"$" [output-string]
  (is (= @result output-string)))
