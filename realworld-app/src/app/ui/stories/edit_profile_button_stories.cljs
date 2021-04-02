(ns app.ui.stories.edit-profile-button-stories
  (:require
   [app.ui.components.edit-profile-button :as edit_button]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]))


(def ^:export default
  #js {:title "Edit Profile Button"
       :component edit_button/EditProfileButton})

(defn ^:export Default []
  ($ edit_button/EditProfileButton))