(ns curso.aula-1-2-3)

(println "Olá")

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))






;higher order functions - recebe uma ou mais funcoes como argumento ou retorna uma funcao como resultado
;no exemplo o parametro 'aplica?' é uma funcao
(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

;Predicates - funcoes que fazem uma condicao e retornam true ou false
(defn mais-caro-que-100?
  [valor-bruto]
  (println "deixando claro invocação de mais-caro-que-100?")
  (> valor-bruto 100))

;higher order functions passando a funcao como parametro
;(def mais-caro-que-100?  #(> % 100))


;higher order functions passando a funcao como parametro
;(def mais-caro-que-100?  (fn [valor-bruto] (> valor-bruto 100)))


;higher order functions passando a funcao como parametro
(println (valor-descontado mais-caro-que-100? 100))