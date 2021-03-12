(ns app.controllers.todos
  (:require [keechma.next.controller :as ctrl]
            [clojure.string :as str]))

(derive :todos :keechma/controller)

(def initial-todo
  {:value   ""
   :is-done false})

(defmethod ctrl/start :todos [ctrl params prev]
  {:current-todo initial-todo
   :todos        []})

(defn update-current-todo-value [state payload]
  (assoc-in state [:current-todo :value] payload))

(defn store-current-todo [{:keys [current-todo] :as state}]
  (let [id            (-> "todo" gensym str)
        current-todo' (assoc current-todo :id id)]
    (update state :todos conj current-todo')))

(defn save-todo [{:keys [current-todo] :as state}]
  (if (-> current-todo :value str/trim seq)
    (-> state
        store-current-todo
        (assoc :current-todo initial-todo))
    state))

(defn toggle-todo-status [{:keys [todos] :as state} id]
  (let [todos' (mapv (fn [t]
                       (if (= id (:id t))
                         (assoc t :is-done (not (:is-done t)))
                         t))
                 todos)]
    (assoc state :todos todos')))

(defn remove-todo [{:keys [todos] :as state} id]
  (let [todos' (into [] (remove #(= id (:id %)) todos))]
    (assoc state :todos todos')))

(defmethod ctrl/handle :todos [{:keys [state*] :as ctrl} ev payload]
  (case ev
    :on-change (swap! state* update-current-todo-value payload)
    :on-submit (swap! state* save-todo)
    :toggle-status (swap! state* toggle-todo-status payload)
    :remove-todo (swap! state* remove-todo payload)
    nil))




;; dodati id na value
;; pospremiti value
;; resetirati current-todo