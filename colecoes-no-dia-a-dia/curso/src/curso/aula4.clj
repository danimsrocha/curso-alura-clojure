(ns curso.aula4
  (:require [curso.db :as db]
            [curso.logic :as logic]))

(def pedidos (db/todos-os-pedidos))

(println pedidos)

(println (logic/resumo-por-usuario pedidos))

(println "\nFazendo get-in dentro do pedido de posicao 0 e pegando a quantidade da mochila")
(println (get-in pedidos [0 :itens :mochila :quantidade]))

(let [resumo (logic/resumo-por-usuario pedidos)]
  (println "\nResumo" resumo)
  (println "\nOrdenado" (sort-by :preco-total resumo))
  (println "\nOrdenado ao contrário" (reverse (sort-by :preco-total resumo)))
  (println "\nOrdenado por id" (sort-by :usuario-id resumo)))


(println "\nresumo-por-usuario-ordenado-por-preco-total:")
(defn resumo-por-usuario-ordenado-por-preco-total [pedidos]
  (->> pedidos
       logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(def resumo (resumo-por-usuario-ordenado-por-preco-total pedidos))

(println resumo)
(println "\nPrimeiro" (first resumo))
(println "Segundo" (second resumo))
(println "Rest" (rest resumo))
(println "Total" (count resumo))
(println "Class" (class resumo))
(println "nth 1" (nth resumo 1));; pegar o enésimo elemento
(println "get 1" (get resumo 1));; pegar elementos por índice
(println "Take" (take 2 pedidos))


(defn top-2 [pedidos]
  (take 2 pedidos))
(println "Top-2" (top-2 resumo))

'(println "\n> 500 filter: " (filter #(> (:preco-total %) 500) resumo))

;;some' verifica se tem alguem com preco-total > 500
(println "\n> 500 some: " (some #(> (:preco-total %) 500) resumo))


