(ns hello-world.core (:require [hello-world.api :as  api]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main [& args]
   (api/get-api  "localhost" "input1"))
