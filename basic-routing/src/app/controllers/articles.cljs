(ns app.controllers.articles
  (:require [keechma.next.controller :as ctrl]
            [keechma.next.controllers.pipelines :as pipelines]
            [keechma.next.controllers.entitydb :as edb]
            [keechma.next.controllers.dataloader :as dl]
            [keechma.pipelines.core :as pp :refer-macros [pipeline!]]
            [app.data.articles :as da]))

(derive :articles ::pipelines/controller)

(def load-articles
  (pipeline!  [value {:keys [deps-state* state*] :as ctrl}]
    (pp/swap! state* assoc :data da/all-articles)))

(def pipelines
  {:keechma.on/start load-articles,
   :keechma.on/stop (pipeline! [_ {:keys [deps-state* state*] :as ctrl}]
                      (pp/swap! state* assoc :data nil))})

(defmethod ctrl/prep :articles [ctrl] (pipelines/register ctrl pipelines))

(defmethod ctrl/derive-state :articles
  [_ state deps-state]
  (:data state))