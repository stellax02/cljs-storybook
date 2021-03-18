(ns app.ui.pages.home
  "Example homepage"
  (:require [helix.dom :as d]
            [helix.core :as hx :refer [$]]
            [keechma.next.helix.core :refer [with-keechma use-sub dispatch]]
            [keechma.next.controllers.router :as router]
            [keechma.next.helix.lib :refer [defnc]]
    ;;[keechma.next.helix.template :refer [defnt fill-slot configure]]
            [keechma.next.helix.classified :refer [defclassified]]
            [app.ui.components.main :refer [Main]]
            [app.ui.components.hello :refer [Hello]]))

(defclassified HomepageWrapper :div "h-screen w-screen flex bg-gray-200")

(defnc HomeRenderer [props]
  (let []
    (d/div {:class "h-full relative bg-gray-50 overflow-hidden"}
      #_(d/div {:class "hidden sm:block smd/absolute sm:inset-y-0 sm:h-full sm:w-full", :aria-hidden "true"}
          (d/div {:class "relative h-full max-w-7xl mx-auto"}
            (d/svg {:class "absolute right-full transform translate-y-1/4 translate-x-1/4 lg:translate-x-1/2", :width "404", :height "784", :fill "none", :viewBox "0 0 404 784"}
              (d/defs
                (d/pattern {:id "f210dbf6-a58d-4871-961e-36d5016a0f49", :x "0", :y "0", :width "20", :height "20", :units "userSpaceOnUse"}
                  (d/rect {:x "0", :y "0", :width "4", :height "4", :class "text-gray-200", :fill "currentColor"})))
              (d/rect {:width "404", :height "784", :fill "url(#f210dbf6-a58d-4871-961e-36d5016a0f49)"}))
            (d/svg {:class "absolute left-full transform -translate-y-3/4 -translate-x-1/4 md:-translate-y-1/2 lg:-translate-x-1/2", :width "404", :height "784", :fill "none", :viewBox "0 0 404 784"}
              (d/defs
                (d/pattern {:id "5d0dd344-b041-4d26-bec4-8d33ea57ec9b", :x "0", :y "0", :width "20", :height "20", :patternUnits "userSpaceOnUse"}
                  (d/rect {:x "0", :y "0", :width "4", :height "4", :class "text-gray-200", :fill "currentColor"})))
              (d/rect {:width "404", :height "784", :fill "url(#5d0dd344-b041-4d26-bec4-8d33ea57ec9b)"}))))
      (d/div {:class "relative pt-6 pb-16 sm:pb-24"}
        (d/div {:class "max-w-7xl mx-auto px-4 sm:px-6"}
          (d/nav {:class "relative flex items-center justify-between sm:h-10 md:justify-center", :aria-label "Global"}
            (d/div {:class "flex items-center flex-1 mdd/absolute md:inset-y-0 md:left-0"}
              (d/div {:class "flex items-center justify-between w-full md:w-auto"}
                (d/a {:href "#"}
                  (d/span {:class "sr-only"} "Workflow")
                  (d/img {:class "h-8 w-auto sm:h-10", :src "https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg", :alt ""}))
                (d/div {:class "-mr-2 flex items-center md:hidden"}
                  (d/button {:type "button", :class "bg-gray-50 rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500", :aria-expanded "false"}
                    (d/span {:class "sr-only"} "Open main menu") "<!-- Heroicon name: outline/menu -->"
                    (d/svg {:class "h-6 w-6", :xmlns "http://www.w3.org/2000/svg", :fill "none", :viewBox "0 0 24 24", :stroke "currentColor", :aria-hidden "true"}
                      (:path {:stroke-linecap "round", :stroke-linejoin "round", :stroke-width "2", :d "M4 6h16M4 12h16M4 18h16"}))))))
            (d/div {:class "hidden md:flex md:space-x-10"}
              (d/a {:href  (router/get-url props :router {:page "articles"}),
                    :class "font-medium text-gray-500 hover:text-gray-900 mr-4"} "Articles"))
            (d/div {:class "hidden mdd/absolute md:flex md:items-center md:justify-end md:inset-y-0 md:right-0"}
              (d/span {:class "inline-flex rounded-md shadow"}
                (d/a {:href "#", :class "inline-flex items-center px-4 py-2 border border-transparent text-base font-medium rounded-md text-indigo-600 bg-white hover:bg-gray-50"} "Log in")))))
        (d/div {:class "absolute top-0 inset-x-0 p-2 transition transform origin-top-right md:hidden"}
          (d/div {:class "rounded-lg shadow-md bg-white ring-1 ring-black ring-opacity-5 overflow-hidden"}
            (d/div {:class "px-5 pt-4 flex items-center justify-between"}
              (d/div
                (d/img {:class "h-8 w-auto", :src "https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg", :alt ""}))
              (d/div {:class "-mr-2"}
                (d/button {:type "button", :class "bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"}
                  (d/span {:class "sr-only"} "Close menu") "<!-- Heroicon name: outline/x -->"
                  (d/svg {:class "h-6 w-6", :xmlns "http://www.w3.org/2000/svg", :fill "none", :viewBox "0 0 24 24", :stroke "currentColor", :aria-hidden "true"}
                    (:path {:stroke-linecap "round", :stroke-linejoin "round", :stroke-width "2", :d "M6 18L18 6M6 6l12 12"})))))
            (d/div {:class "px-2 pt-2 pb-3"}
              (d/a {:href "#", :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"} "Product")
              (d/a {:href "#", :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"} "Features")
              (d/a {:href "#", :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"} "Marketplace")
              (d/a {:href "#", :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"} "Company"))
            (d/a {:href "#", :class "block w-full px-5 py-3 text-center font-medium text-indigo-600 bg-gray-50 hover:bg-gray-100"} "Log in")))
        (d/main {:class "mt-16 mx-auto max-w-7xl px-4 sm:mt-24"}
          (d/div {:class "text-center"}
            (d/h1 {:class "text-4xl tracking-tight font-extrabold text-gray-900 sm:text-5xl md:text-6xl"}
              (d/span {:class "block xl:inline"} "Data to enrich your")
              (d/span {:class "block text-indigo-600 xl:inline"} "online business"))
            (d/p {:class "mt-3 max-w-md mx-auto text-base text-gray-500 sm:text-lg md:mt-5 md:text-xl md:max-w-3xl"} "Anim aute id magna aliqua ad ad non deserunt sunt. Qui irure qui lorem cupidatat commodo. Elit sunt amet fugiat veniam occaecat fugiat aliqua.")
            (d/div {:class "mt-5 max-w-md mx-auto sm:flex sm:justify-center md:mt-8"}
              (d/div {:class "rounded-md shadow"}
                (d/a {:href (router/get-url props :router {:page "articles"}), :class "w-full flex items-center justify-center px-8 py-3 border border-transparent text-base font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 md:py-4 md:text-lg md:px-10"} "Articles"))
              )))))))




(def Home (with-keechma HomeRenderer))

