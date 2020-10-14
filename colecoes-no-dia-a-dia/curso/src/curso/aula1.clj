(ns curso.aula1)

;(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest []))
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (seq []))
(println (seq [1 2 3 5]))

(println "\nMEU MAPA")


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])



(println "\n\nMEU MAPA")

;deu loop infinito
;(defn meu-mapa
;  [funcao sequencia]
;  (let [primeiro (first sequencia)]
;    (funcao primeiro)
;    (meu-mapa funcao (rest sequencia))))
;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])


;corrigiu pq colocamos o if p verificar se o simbolo primeiro é false ou vazio
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (funcao primeiro)
      (meu-mapa funcao(rest sequencia)))
    ))
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])


(println "\n\nMEU MAPA")
;usa-se 'do' quando o bloco do if (exemplo) tiver mais de uma chamada
;porque quando se tem duas linhas, é if e else, e para que as duas linhas sejam o if, coloca o 'do'
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao(rest sequencia))))
    ))
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])



;colocado o 'nil?' porque o 'nil? verifica se é nulo
;sem isso estava verificando se era nulo ou vazio
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao(rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])



;;usando 'recur' para fazer a recursao, ou seja, chamar a mesma funcao novamente
;o 'recur' está substituindo a chamada 'meu-mapa'
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

