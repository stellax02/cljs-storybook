(ns app.ui.stories.edit-profile-button-stories
  (:require
   [app.ui.components.edit-profile-button :as edit_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Edit Profile Button"
       :component edit_button/EditProfileButton})

(defn ^:export Default []
  ($ edit_button/EditProfileButton))