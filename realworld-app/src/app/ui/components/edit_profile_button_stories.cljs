(ns app.ui.components.edit-profile-button-stories
  (:require
   ["@storybook/addon-actions" :refer (action)]
   [app.ui.components.edit-profile-button :as edit_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Edit Profile Button"
       :component edit_button/EditProfileButton})

(defn ^:export Default []
  ($ edit_button/EditProfileButton))