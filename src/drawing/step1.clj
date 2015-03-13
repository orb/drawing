(ns drawing.practice
  (:require [quil.core :as q]))

(def flake      (atom nil))
(def background (atom nil))

(defn setup []
  (reset! flake      (q/load-image "images/white_flake.png"))
  (reset! background (q/load-image "images/blue_background.png")))

(defn draw []
  (q/background-image @background)
  (q/image @flake 400 10))

(q/defsketch practice
  :title "Clara's Quil practice"
  :size [1000 1000]
  :setup setup
  :draw draw)


