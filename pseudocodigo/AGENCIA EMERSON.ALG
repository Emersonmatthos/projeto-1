Algoritmo "agencia Emerson"

Var
   cliente, destino: vetor[1..2] de caractere
   i:inteiro

Inicio

   escreval("===== Agencia Emerson =====")
   escreval("")
   // Cadastrar
   para i <- 1 ate 2 faca
      escreval("Digite o nome do ", i, "º cliente: ")
      leia(cliente[i])
   fimpara

   para i <- 1 ate 2 faca
      escreval("DIGITE O SEU ",i,"º DESTINO")
      leia(destino[i])
   fimpara
   
   // Retorne a consulta dos dados
   escreval("===== CONSULTA =====")
   escreval("")
   para i <- 1 ate 2 faca
          escreval("o cliente: ", cliente[i]," destino: ", destino[i])
   fimpara
   


Fimalgoritmo