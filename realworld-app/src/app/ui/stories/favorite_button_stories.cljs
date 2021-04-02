(ns app.ui.stories.favorite-button-stories
  (:require
   [app.ui.components.favorite-button :as fav_button]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]))


(def ^:export default
  #js {:title "Favorite Button"
       :component fav_button/FavoriteButton})

(defn ^:export Default []
  ($ fav_button/FavoriteButton))