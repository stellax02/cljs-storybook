(ns app.ui.stories.delete-article-button-stories
  (:require
   [app.ui.components.delete-article-button :as deleteArticle_button]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]
   [app.ui.lib :refer ($)]))

(def ^:export default
  #js {:title "Delete Article Button"
       :component deleteArticle_button/DeleteButton})

(defn ^:export Normal []
  ($ deleteArticle_button/DeleteButton))

(defn ^:export Variation [text]
  (d/button {:class "btn btn-sm btn-outline-danger"}
            (d/i {:class "ion-trash-b"})
            " Delete Variation Article"))

(defn ^:export Variation2 [text]
  (d/button {:class "btn btn-sm btn-outline-danger"}
            (d/i {:class "ion-close-circled"})
            " Delete Variation2 Article"))