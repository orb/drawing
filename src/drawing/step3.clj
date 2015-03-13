(ns drawing.practice
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(def flake      (atom nil))   ; reference to snowflake image
(def background (atom nil))   ; reference to blue background image

(defn setup []
  ;; loading two images
  (reset! flake      (q/load-image "images/white_flake.png"))
  (reset! background (q/load-image "images/blue_background.png"))

  (q/smooth)
  (q/frame-rate 60)

  10)

(defn update [state]
  (if (>= state (q/height))
    0              ; get it back to the 0 (top)
    (inc state)))  ; updating y parameter by one

(defn draw [state]
  ;; drawing blue background and a snowflake on it
  (q/background-image @background)
  (q/image @flake 400 state))

(q/defsketch practice
  :title "Clara's Quil practice"
  :size [1000 1000]
  :setup setup
  :update update
  :draw draw
  :middleware [m/fun-mode])
