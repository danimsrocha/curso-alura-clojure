(ns curso.aula2)

(defn conta
  [total-ate-agora elementos]
  (println total-ate-agora)
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))


(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))
(minha-funcao 1)
(minha-funcao 1 2)


;é possível fazer peracoes diferentes quando se recebe aridades diferetes
; essa funcao diferentes
;entao quando a funcao recebe apenas 1 parametro, ela faz uma coisa
;quando recebe 2 parametros ela faz outra coisa
(defn conta

  ;; 1 aridade
  ([elementos]
   (conta 0 elementos))

  ;; 2 aridades
  ([total-ate-agora elementos]
   ;seq verifica se tem elementos
   (if (seq elementos)
     ;inc acrescente sempre +1    ;next pega os proximos elementos da lista
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))




; for total-ate-agora 0, elementos-restantes elementos-restantes   ;; 1 next

(defn conta
  [elementos]
  ;; o loop aqui esta recebendo 2 aridades diferentes e para cada, esta tendo acoes diferentes
  ;; os loops devem sempre sempre estar separados e isolados em outra funcao, aqui é só um ex
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      ;; o 'recur' aqui, nao esta chamando a funcao novamente, esta chamando o loop
      ;; o loop esta se comportando como uma funcao, ele tbm recebe parametros, recebe até mesmo 2 aridades diferentes
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))


