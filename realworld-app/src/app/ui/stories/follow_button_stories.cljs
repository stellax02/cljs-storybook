(ns app.ui.stories.follow-button-stories
  (:require
   [app.ui.components.follow-button :as follow_button]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]))


(def ^:export default
  #js {:title "Follow Button"
       :component follow_button/FollowButton})

(defn ^:export Online []
  ($ follow_button/FollowButton))


(defn ^:export Design [text]
  (d/button
   {:class ["btn btn-sm btn-secondary"]}
   (d/i {:class "ion-plus-round"}) " Follow"))