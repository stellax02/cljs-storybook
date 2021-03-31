(ns app.ui.components.edit-article-button
  (:require [keechma.next.helix.core :refer [with-keechma dispatch]]
            [keechma.next.helix.lib :refer [defnc]]
            [helix.core :as hx :refer [$ <> suspense]]
            [helix.dom :as d]
            ["react" :as react]
            ["react-dom" :as rdom]
            [keechma.next.controllers.router :as router]))

(defnc EditArticleButtonRenderer
  []
  (d/a {:class "btn btn-outline-secondary btn-sm"}
       (d/i {:class "ion-edit"})
       " Edit Article"))

(def EditArticleButton (with-keechma EditArticleButtonRenderer))