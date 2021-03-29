(ns app.ui.components.favorite-button-stories
  (:require
   ["@storybook/addon-actions" :refer (action)]
   [app.ui.components.favorite-button :as fav_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Favorite Button"
       :component fav_button/FavoriteButton})

(defn ^:export Default []
  ($ fav_button/FavoriteButton))