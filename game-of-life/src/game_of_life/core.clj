(ns game-of-life.core)

(defn play-life
	[life-board]
	(if (= (count life-board) 0) (list))	
	)

(defn -main
  "I don't do a whole lot."
  [& args]
  (println args "Hello, World!")
  (def life-board(list))
  (play-life life-board))

