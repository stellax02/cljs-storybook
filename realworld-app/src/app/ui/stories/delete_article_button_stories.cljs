(ns app.ui.stories.delete-article-button-stories
  (:require
   [app.ui.components.delete-article-button :as deleteArticle_button]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]))

(def ^:export default
  #js {:title "Delete Article Button"
       :component deleteArticle_button/DeleteButton
       :design {:type "figma" :url "https://www.figma.com/file/KQnoZZGGPfXmVb30EvQzVE/Facebook-Ad-Template-(Copy)?node-id=0%3A1"}})

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