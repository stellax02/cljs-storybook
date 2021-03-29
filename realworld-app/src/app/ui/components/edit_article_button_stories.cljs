(ns app.ui.components.edit-article-button-stories
  (:require
   ["@storybook/addon-actions" :refer (action)]
   [app.ui.components.edit-article-button :as editArticle_button]
   [app.ui.lib :refer ($)]))


(def ^:export default
  #js {:title "Edit Article Button"
       :component editArticle_button/EditArticleButton})

(defn ^:export Default []
  ($ editArticle_button/EditArticleButton))