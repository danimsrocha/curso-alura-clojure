(ns curso.aula4)


(def precos [30 700 1000])

(println (get precos 0))

(println (get precos 2))

;retorna erro pq vai direto no vetor pegar o valor na posicao
; (println (precos 15))

;Nao da erro pq verifica se existe a posicao 15, se nao existe retorna nil (nulo)
(println (get precos 15))


;Se nao existir a posocao 15, retorna o valor default (ex 5) (pode ser qualquer coisa - string
(println (get precos 15 5))


;Como existe valor na posicao 1, nao retorna o valor default (5)
(println (get precos 1 5))

(println (conj precos 20))
(println precos)

(println "funcao inc soma sempre 1 -" (inc 5))
(println "funcao inc subtrai sempre 1 -" (dec 5))

(println (update precos 0 inc))
(println (update precos 0 dec))


(defn soma-3
  [valor]
  (+ valor 3))

(println "somando 3 na posicao 0(30)" (update precos 0 soma-3))

(println "soma 3 em todas as posicoes" (map soma-3 precos)) ;o map é como um foreach percorrendo a lista de precos e aplicando 'soma-3' em cada elemento
;mapeia o soma-3 em todos os elementos de precos

(println "Cria uma sequencia de numeros, exemplo até 10 posicoes" (range 10))

(println "Retona true se número é par=" (even? 11))

(println "filtra os números pares dentro do range de 10 numero" (filter even? (range 10)))
;o filter passa por cada elemento e verifica se é par
