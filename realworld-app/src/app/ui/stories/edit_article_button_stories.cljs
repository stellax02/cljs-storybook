(ns app.ui.stories.edit-article-button-stories
  (:require
   [app.ui.components.edit-article-button :as editArticle_button]
   [keechma.next.helix.lib :refer [defnc]]
   [helix.core :as hx :refer [$ <> suspense]]))


(def ^:export default
  #js {:title "Edit Article Button"
       :component editArticle_button/EditArticleButton})

(defn ^:export Default []
  ($ editArticle_button/EditArticleButton))