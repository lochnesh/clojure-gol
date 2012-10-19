(ns game-of-life.core)

(defn play-life
	[life-board]
	
	;all cells die if board has two or less live cells
	(if (<= (count life-board) 2) '())) 

(defn -main
  "I don't do a whole lot."
  [& args]
  (println args "Hello, World!")
  (def life-board '())
  (play-life life-board))

