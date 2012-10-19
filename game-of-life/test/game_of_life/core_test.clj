(ns game-of-life.core-test
  (:use clojure.test
        game-of-life.core))

(deftest canary
  (testing "canary test"
    (is (= true true))))

(deftest life-empty
  (testing "life with empty list"
    (is (= '() (play-life '())))))

(deftest life-one-cell
	(testing "life with one cell"
	(is (= '() (play-life '("1"))))))