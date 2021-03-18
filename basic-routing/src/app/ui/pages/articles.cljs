(ns app.ui.pages.articles
  "Example articles page"
  (:require [helix.dom :as d]
            [helix.core :as hx :refer [$]]
            [keechma.next.helix.core :refer [with-keechma use-sub dispatch]]
            [keechma.next.controllers.router :as router]
            [keechma.next.helix.lib :refer [defnc]]
    ;;[keechma.next.helix.template :refer [defnt fill-slot configure]]
            [keechma.next.helix.classified :refer [defclassified]]
            [app.ui.components.main :refer [Main]]
            [clojure.string :as str]
            [app.ui.components.hello :refer [Hello]]))

(defclassified ArticleWrapper :div "h-screen w-screen flex bg-gray-200")

(defnc RenderArticle [{:keys [item] :as props}]
  (d/div {:class "flex flex-col rounded-lg shadow-lg overflow-hidden"}
    (d/div {:class "flex-shrink-0"}
      (d/img {:class "h-48 w-full object-cover", :src (:largePicture item), :alt ""}))
    (d/div {:class "flex-1 bg-white p-6 flex flex-col justify-between"}
      (d/div {:class "flex-1"}
        (d/p {:class "text-sm font-medium text-indigo-600"}
          (d/a {:href "#", :class "hover:underline"} (map #(str % " ") (:tags item))))
        (d/a {:href "#", :class "block mt-2"}
          (d/p {:class "text-xl font-semibold text-gray-900"} (map #(str % " ") (take 4 (str/split (:lead item) #" "))))
          (d/p {:class "mt-3 text-base text-gray-500"} (map #(str % " ") (take-last (- (count (str/split (:lead item) #" ")) 4) (str/split (:lead item) #" "))))))
      (d/div {:class "mt-6 flex items-center"}
        (d/div {:class "flex-shrink-0"}
          (d/a {:href "#"}
            (d/span {:class "sr-only"} "Daniela Metz")
            (d/img {:class "h-10 w-10 rounded-full", :src "https://images.unsplash.com/photo-1487412720507-e7ab37603c6f?ixlib=rb-1.2.1&ixqx=coHlS3s3a1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80", :alt ""})))
        (d/div {:class "ml-3"}
          (d/p {:class "text-sm font-medium text-gray-900"}
            (d/a {:href "#", :class "hover:underline"} (str (get-in item [:author :firstName]) " " (get-in item [:author :lastName]))))
          (d/div {:class "flex space-x-1 text-sm text-gray-500"}
            (d/time (:registered item))
            (d/span {:aria-hidden "true"} "·")
            (d/span "11 min read")))))))

(defnc ArticleRenderer [props]
  (let [articles (use-sub props :articles)]
    (d/div {:class "relative bg-gray-50 pt-16 pb-20 px-4 smd/px-6 lgd/pt-24 lg:pb-28 lg:px-8"}
      (d/div {:class "absolute inset-0"}
        (d/div {:class "bg-white h-1/3 sm:h-2/3"}))
      (d/div {:class "relative max-w-7xl mx-auto"}
        (d/div {:class "text-center"}
          (d/h2 {:class "text-3xl tracking-tight font-extrabold text-gray-900 sm:text-4xl"} "From the blog")
          (d/p {:class "mt-3 max-w-2xl mx-auto text-xl text-gray-500 sm:mt-4"} "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ipsa libero labore natus atque, ducimus sed."))
        (d/div {:class "mt-12 max-w-lg mx-auto grid gap-5 lg:grid-cols-3 lg:max-w-none"}
          (map #($ RenderArticle {:key (:id %)
                                  :item %
                                  & props}) articles))))))


(def Articles (with-keechma ArticleRenderer))

