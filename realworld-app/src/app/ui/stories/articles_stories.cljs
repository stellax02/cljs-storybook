(ns app.ui.stories.articles-stories
  (:require
   [app.ui.components.articles :as articles]
   [app.ui.components.favorite-button :refer [FavoriteButton]]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]))


(def ^:export default
  #js {:title "Articles"
       :component articles/Articles})

(defn ^:export Article []
  (d/div
   {:class "article-preview"}
   (d/div {:class "article-meta"}
          (d/a (d/img))
          (d/div {:class "info"}
                 (d/a)
                 (d/span {:class "date"}))
          ($ FavoriteButton))
   (d/a {:class "preview-link"}
        (d/h1)
        (d/p)
        (d/span "Read more..."))))