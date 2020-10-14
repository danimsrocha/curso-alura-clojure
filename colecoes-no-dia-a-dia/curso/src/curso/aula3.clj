(ns curso.aula3
  (:require [curso.db :as db]))

(println (db/todos-os-pedidos))

(println "\n\nAgrupados por usuários:")
;;usando o 'group-by' feito um agrupamento pela keyword :usuario
(println (group-by :usuario (db/todos-os-pedidos)))


(println "\n\nCriada funçao de agrupamento customizada:")
(defn minha-funcao-de-agrupamento
  [elemento]
  (println "\nelemento" elemento)
  (:quantidade elemento))
;; pode ser criada uma funcao de agrupagamento e ser chamada no group-by'
(println (group-by minha-funcao-de-agrupamento (db/todos-os-pedidos)))

(println "\n\nDevolvendo todos dos dados de compra por usuário:")
;;o 'vals' retorna retorna apenas os valores dentro da keyword usuario
(println (vals (group-by :usuario (db/todos-os-pedidos))))


(println "\n\nRetornando total de pedidos por usuário:")

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id       usuario
   :total-de-pedidos (count pedidos)})

;;usando thread last macro
(->> (db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)




(println "\n\nPEDIDOS")

;; (pedido
;; {
;; :mochila {:id :mochila, :quantidade 2, :preco-unitario 80},
;; :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40},
;; :tenis {:id :tenis, :quantidade 1
;; }}

;;No destruct a mochila é o _ e os detalhes é {:id :mochila, :quantidade 2, :preco-unitario 80}

(defn total-do-item
  ;; aqui estamos fazendo um destruct
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (println "pedido" pedido)
  (reduce + (map total-do-item pedido)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id       usuario
   :total-de-pedidos (count pedidos)
   :preco-total      (total-dos-pedidos pedidos)})

(->> (db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)



