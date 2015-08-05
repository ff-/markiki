(ns markiki.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

;; -- Subscription handlers and registration  ---------------------------------

(register-sub
  :loading?
  (fn [db _]
      (reaction (:loading? @db))))

(register-sub
  :last-article
  (fn [db _]
      (reaction (:last-article @db))))

(register-sub
  :searchbar
  (fn [db _]
      (reaction (:searchbar @db))))

(register-sub
  :articles
  (fn [db _]
      (reaction (:articles @db))))