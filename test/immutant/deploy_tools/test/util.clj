(ns immutant.deploy-tools.test.util
  (:use immutant.deploy-tools.util
        clojure.test)
  (:require [clojure.java.io :as io]))

(let [app-root (io/file (io/resource "app-root"))]
  (deftest descriptor-name-with-a-project-should-use-the-project-name
    (is (= "ham.clj" (descriptor-name {:name "ham"} app-root nil))))

  (deftest descriptor-name-without-a-project-should-use-the-dir-name
    (is (= "app-root.clj" (descriptor-name nil app-root nil))))

  (deftest descriptor-name-with-a-name-opt-should-use-that-name
    (is (= "biscuit.clj" (descriptor-name nil app-root {:name "biscuit"}))))

  (deftest archive-name-with-a-project-should-use-the-project-name
    (is (= "ham.ima" (archive-name {:name "ham"} app-root nil))))

  (deftest archive-name-without-a-project-should-use-the-dir-name
    (is (= "app-root.ima" (archive-name nil app-root nil))))

  (deftest archive-name-with-a-name-opt-should-use-that-name
    (is (= "biscuit.ima" (archive-name nil app-root {:name "biscuit"})))))
