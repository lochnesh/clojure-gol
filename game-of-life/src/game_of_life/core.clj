(ns game-of-life.core)

(defn count-neighbors
	[cell,life-board]
	(def row (get cell 0))
	(def col (get cell 1))
    (+ 
	  (if (contains? life-board [(- row 1),(- col 1)]) 1 0)
	  (if (contains? life-board [(- row 1),col]) 1 0)
	  (if (contains? life-board [(- row 1),(+ col 1)]) 1 0)
	  (if (contains? life-board [(+ row 1),col]) 1 0)
	  (if (contains? life-board [row,(- col 1)]) 1 0)
	  (if (contains? life-board [row,(+ col 1)]) 1 0)
	  (if (contains? life-board [(+ row 1),(- col 1)]) 1 0)
	  (if (contains? life-board [(+ row 1),(+ col 1)]) 1 0)))
	  
(defn full-board
	[rows cols] 
	(set (for [row (range 0 rows) col (range 0 cols) ] [row col])))

(defn play-life
	[life-board]
	
	;all cells die if board has two or less live cells
    (if (<= (count life-board) 2) #{}
		(set (filter 
		  (fn 
		    [it]
			(def neighbors (count-neighbors it life-board))
		      (and (>= neighbors 2)(< neighbors 4))) 
		        (full-board 3 3)))))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println args "Hello, World!")
  (def life-board #{})
  (play-life life-board)
  (count-neighbors [2,1] #{[2,1],[1,1]})
  (println full-board 3 3))

