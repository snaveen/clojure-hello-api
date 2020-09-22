(ns hello-world.api (:require [clj-http.client :as client]
  [clj-http.conn-mgr :as conn-mgr]
  [clojure.tools.logging :as log]))

(declare handle-response handle-error)

(defn get-api
  "invoke api and handle response"
  [url param] ( try
                  (let [response (client/get "http://localhost:8090/hello2" {:throw-exceptions false} )]
                    (handle-response response))
                  (catch Exception e (println (str "caught exception: " (.toString e))))
                  (finally (println "This is our final block"))))


(defn handle-response [response] (if  (= (response :status) 200)
                                                         (print "test " (response :body))
                                                         (handle-error (response :status) (response :body))))

(defn handle-error [status body] (print status body))


