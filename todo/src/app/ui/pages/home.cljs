(ns app.ui.pages.home
  "Example homepage 2 3"
  (:require [helix.dom :as d]
            [helix.core :as hx :refer [$]]
            [keechma.next.helix.core :refer [with-keechma use-sub dispatch]]
            [keechma.next.helix.lib :refer [defnc]]
    ;;[keechma.next.helix.template :refer [defnt fill-slot configure]]
            [keechma.next.helix.classified :refer [defclassified]]
            [app.ui.components.main :refer [Main]]
            [app.ui.components.hello :refer [Hello]]))

(defclassified HomepageWrapper :div "h-screen w-screen flex bg-gray-200")

(defclassified Container :div "h-100 w-full flex items-center justify-center bg-teal-lightest font-sans")

(defnc HomeRenderer [props]
  (let [todos (use-sub props :todos)
        _ (cljs.pprint/pprint todos)
        stored-todos (:todos todos)
        current-todo-value (get-in todos [:current-todo :value])]
    ($ HomepageWrapper
      ($ Container
        (d/div {:class "bg-white rounded shadow p-6 m-4 w-full lg:max-w-lg lg:w-3/4"}
          (d/div {:class ["mb-4"]}
            (d/h1 {:class "text-grey-darkest "} "Todo List")
            (d/div {:class "flex mt-4"}
              (d/form {:onSubmit (fn [e]
                                   (.preventDefault e)
                                   (dispatch props :todos :on-submit))}
                (d/input {:onChange    (fn [e]
                                         (dispatch props :todos :on-change (.. e -target -value)))
                          :value       current-todo-value
                          :class       "shadow appearance-none border rounded w-full py-2 px-3 mr-4 text-grey-darker "
                          :placeholder "Add Todo"})
                (d/button {:class "flex-no-shrink p-2 border-2 rounded text-teal border-teal hover:text-white hover:bg-teal"} "Add")))
            (d/div
              (map
                (fn [t]
                  (d/div {:key (:id t)
                          :class "flex mb-4 items-center"}
                    (d/p {:class "w-full text-grey-darkest"} (:value t))
                    (d/button {:class "flex-no-shrink p-2 ml-4 mr-2 border-2 rounded hover:text-white text-green border-green hover:bg-green"
                               :onClick #(dispatch props :todos :toggle-status (:id t))}
                      (if (:is-done t) "Done" "Not done"))
                    (d/button {:class "flex-no-shrink p-2 ml-2 border-2 rounded text-red border-red hover:text-white hover:bg-red"
                               :onClick #(dispatch props :todos :remove-todo (:id t))} "Remove")))
                stored-todos))))))))


  (def Home (with-keechma HomeRenderer))

