(ns app.ui.stories.follow-button-stories
  (:require
   [app.ui.components.follow-button :as follow_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Follow Button"
       :component follow_button/FollowButton})

(defn ^:export Default []
  ($ follow_button/FollowButton))