(ns markiki.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [reagent.core :as r]
            [goog.events :as events]
            [reagent.core :as reagent :refer [atom]]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            [markiki.handlers]
            [markiki.subs]
            [markiki.views])
  (:import [goog History]
           [goog.history EventType]))

(enable-console-print!)

;; -- Routes and History ------------------------------------------------------

;; TODO: Routes

(def history
  (doto (History.)
    (events/listen EventType.NAVIGATE
                   (fn [event] (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


;; -- Entry Point -------------------------------------------------------------

(defn ^:export main
  []
  (dispatch-sync [:initialize-db])
  (r/render [markiki.views/markiki-app]
                  (.getElementById js/document "app")))