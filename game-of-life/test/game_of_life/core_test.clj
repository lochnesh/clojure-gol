(ns game-of-life.core-test
  (:use clojure.test
        game-of-life.core))

(deftest canary
  (testing "canary test"
    (is (= true true))))

(def base-board #{[1,1]})
(def one-neighbor-board (conj base-board [0,0]))	
(def two-neighbor-board (conj one-neighbor-board [0,1]))
(def three-neighbor-board (conj two-neighbor-board [0,2]))
(def four-neighbor-board (conj three-neighbor-board [1,0]))
(def five-neighbor-board (conj four-neighbor-board [1,2]))
(def six-neighbor-board (conj five-neighbor-board [2,0]))
(def seven-neighbor-board (conj six-neighbor-board [2,1]))
(def eight-neighbor-board (conj seven-neighbor-board [2,2]))

	
(deftest all-life-dies
  (testing "all cells die in board with two cells or less"
    (is (= #{} (play-life #{})))
	(is (= #{} (play-life base-board)))
	(is (= #{} (play-life base-board)))))
	
(deftest lives-to-next-generation
	(testing "cell with two or three neighbors lives"
	  (is (contains? (play-life two-neighbor-board) [1,1]))
	  (is (contains? (play-life three-neighbor-board) [1,1]))))
	  
(deftest over-crowding
	(testing "cell with more than four neighbors dies"
	  (is (not(contains? (play-life four-neighbor-board) [1,1])))
	  (is (not(contains? (play-life five-neighbor-board) [1,1])))
	  (is (not(contains? (play-life six-neighbor-board) [1,1])))
	  (is (not(contains? (play-life seven-neighbor-board) [1,1])))
	  (is (not(contains? (play-life eight-neighbor-board) [1,1])))))	
	  
(deftest reproduction
	(testing "any dead cell with exactly 3 neighbors comes to life"
	  (is (contains? (play-life (disj three-neighbor-board [1,1])) [1,1])))) 

(deftest build-full-board
	(testing "building a full board"
		(is (= (count full-board) 9))
		(is (contains? full-board [0,0]))))
	
(deftest neighbor-counts
	(testing "test finding neighbors"
		(is (= 0 (count-neighbors [1,1] base-board)))
		(is (= 1 (count-neighbors [1,1] one-neighbor-board)))
		(is (= 2 (count-neighbors [1,1] two-neighbor-board)))
		(is (= 3 (count-neighbors [1,1] three-neighbor-board)))
		(is (= 4 (count-neighbors [1,1] four-neighbor-board)))
		(is (= 5 (count-neighbors [1,1] five-neighbor-board)))
		(is (= 6 (count-neighbors [1,1] six-neighbor-board)))
		(is (= 7 (count-neighbors [1,1] seven-neighbor-board)))		
		(is (= 8 (count-neighbors [1,1] eight-neighbor-board)))))				