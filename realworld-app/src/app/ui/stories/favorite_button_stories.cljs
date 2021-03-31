(ns app.ui.stories.favorite-button-stories
  (:require
   [app.ui.components.favorite-button :as fav_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Favorite Button"
       :component fav_button/FavoriteButton})

(defn ^:export Default []
  ($ fav_button/FavoriteButton))