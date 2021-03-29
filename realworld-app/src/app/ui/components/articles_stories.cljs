(ns app.ui.components.articles-stories
  (:require
   ["@storybook/addon-actions" :refer (action)]
   [app.ui.components.articles :as articles]
   [app.ui.components.favorite-button :refer [FavoriteButton]]
   [helix.dom :as d]
   ["react" :as react]
   ["react-dom" :as rdom]
   [app.ui.lib :refer ($)]))


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