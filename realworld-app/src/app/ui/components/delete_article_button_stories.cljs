(ns app.ui.components.delete-article-button-stories
  (:require
   ["@storybook/addon-actions" :refer (action)]
   [app.ui.components.delete-article-button :as deleteArticle_button]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Delete Article Button"
       :component deleteArticle_button/DeleteButton})

(defn ^:export Default []
  ($ deleteArticle_button/DeleteButton))

(defn ^:export Extra []
  (d/button {:class "btn btn-sm btn-outline-danger"}
            (d/i {:class "ion-trash-b"})
            " Makit Article"))