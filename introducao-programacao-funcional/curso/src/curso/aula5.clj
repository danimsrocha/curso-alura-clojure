(ns curso.aula5)

(def estoque {"Mochila" 10 "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")

(println "Chaves são:" (keys estoque))

(println "Valores são:" (vals estoque))


;com keyword
(def estoque {:mochila 10
              :camiseta 5})
(println estoque)

(println "Incluindo a keyword cadeira" (assoc estoque :cadeira 3))

;encontra a keyword mochila e associa o valor para 1
(println (assoc estoque :mochila 1))

(println estoque)
(println "Incrementa 1 no valor da kw mochila" (update estoque :mochila inc))



(defn tira-um
  [valor]
  (println "tirando um de" valor)
  (- valor 1))

(println (update estoque :mochila tira-um))

(println estoque)
;usando funcao anonima
(println "Tira 3 da kw mochila" (update estoque :mochila #(- % 3)))

(println "removido a kw mochila" (dissoc estoque :mochila))



(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})
(println "\n\n")
(println pedido)


;insere o chuveiro
(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

;imprime so a mochila
(println (pedido :mochila))
(println (get pedido :mochila))

;valor defaut nil - se nao encontrar
(println (get pedido :cadeira))
;valor default 0 - se nao encontrar
(println (get pedido :cadeira 0))
;valor default {} - se nao encontrar
(println (get pedido :cadeira {}))

;mostrando o que ha dentro de mochila
(println (:mochila pedido))

;com valor de default {} - se nao encontrar
(println (:cadeira pedido {}))

;para recuperar a quantidade dentro de mochila
(println (:quantidade (:mochila pedido)))

;incremetando 1 na quantidade da mochila
(println (update-in pedido [:mochila :quantidade] inc))

;tambem podemos obter a quantidade da mochila assim:
(println (:quantidade (:mochila pedido)))

;obtendo a quantidade da mochila dentro do pedido
(println (-> pedido
             :mochila
             :quantidade))


(println "\n")
;poderia colocar assim para executar o println no fim
(-> pedido
    :mochila ,,,
    :quantidade ,,,
    println ,,,)