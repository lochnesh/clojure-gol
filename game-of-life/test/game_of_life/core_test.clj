(ns game-of-life.core-test
  (:use clojure.test
        game-of-life.core))

(deftest canary
  (testing "canary test"
    (is (= true true))))

(deftest life-empty
  (testing "life with empty list return empty list"
    (is (= #{} (play-life #{})))))

(deftest life-one-cell
	(testing "life with one cell returns empty list"
	  (is (= #{} (play-life #{[1,1]})))))
	
(deftest life-two-cell
	(testing "life with two cells returns empty list"
	  (is (= #{} (play-life #{[1,1],[2,1]})))))
	
(deftest two-neighbors-lives
	(testing "cell with two neighbors lives"
	  (is (= #{[1,1]} (play-life #{[0,1],[1,1],[2,1]})))))
	
(deftest one-neighbor
	(testing "finds one neighbor"
		(is (= 1 (count-neighbors [1,1] #{[0,1],[1,1]})))))
		
(deftest two-neighbors
	(testing "finds two neighbors"
		(is (= 2 (count-neighbors [1,1] #{[0,1],[1,1],[2,1]})))))