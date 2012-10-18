(ns game-of-life.core-test
  (:use clojure.test
        game-of-life.core))

(deftest a-test
  (testing "canary test"
    (is (= true true))))

(deftest b-test
  (testing "play-life"
    (is (= (list) (play-life (list))))))
