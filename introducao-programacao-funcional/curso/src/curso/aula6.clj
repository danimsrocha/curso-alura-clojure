(ns curso.aula6)

(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  (println "tipo do valor:" (class valor))
  15)

(println (map imprime-e-15 pedido))


;Fazendo destruct (desestruturar) o "vetor" recebido em dois parametros
(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)

(println (map imprime-e-15 pedido))


(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))

;somando os valores da multiplicacao 'preco-dos-produto s
(println (reduce + (map preco-dos-produtos pedido)))


;usa-se _ quando nao esta usando o parametro
(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))


(defn total-do-pedido [pedido]
  (reduce + (map preco-dos-produtos pedido)))
(println (total-do-pedido pedido))


(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))


;destruct
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals ,,,
       (map preco-total-do-produto ,,,)
       (reduce + ,,,))

  ;como seria sem o destruct
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))



;;;;;;;;;;;;;;;;

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter gratuito? (vals pedido)))


;fazendo destruct
(defn gratuito?
  [[chave item]]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")
(println (filter gratuito? pedido))


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")

;usando funcao lambida - poderia ser [_ item]
(println (filter (fn [[chave item]] (gratuito? item)) pedido))


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")

;usando funcao anonima
;second devolve o segundo elemento, no exemplo, o item
(println (filter #(gratuito? (second %)) pedido))





(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

;o comp compoe funcoes
;no exemplo ele esta com a funcao not e funcao gratuito?
(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))



;atividade
(def clientes [
               { :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])

;Como calcular o total de certificados de todos os clientes?

(->> clientes
     (map :certificados)
     (map count)
     (reduce +)
     (println))