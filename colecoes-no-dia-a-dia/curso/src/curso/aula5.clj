(ns curso.aula5
  (:require [curso.db :as db]
            [curso.logic :as logic]))

(def pedidos (db/todos-os-pedidos))
(def resumo (logic/resumo-por-usuario pedidos))


(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))
;o keep manter o resultado da funcao
;se a funcao verificasse se é true, ele iria mostrar os boleanos de todos (false e true)
(println "keep" (keep gastou-bastante? resumo))

;o filter filtra, ou seja, se a funcao verificasse se é true, ele só iria retornar quem é true
(println "\nfilter" (filter gastou-bastante? resumo))


(println "\ntake de 10" (take 2 (range 10)))
(println "take de 10000000000000000" (take 2 (range 10000000000000000)))

