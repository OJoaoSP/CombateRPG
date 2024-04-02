# CombateRPG
Projeto realizando o projeto do seguinte link:
https://prof-rafa.gitbook.io/home/material-de-apoio/orientacao-a-objetos/katas/combate-rpg


### Intereção 1
Simples
### Intereção 2
Nessa intereção, achei que não faria sentindo implementar esse elemento: <br>
Um Personagem pode APENAS curar a ele mesmo;<br>
Simplemente não achei que faria sentindo isso com toda ideia do projeto :/
### Intereção 3
Aqui teve um desafio que já foi bem interessante, que foi a adicção do elemento de alcance <br>
Eu optei por construir uma classe e funções que simulam um tabuleiro para  realizar essa tarefa. Assim fica mais fácil 
de implementar novas funções que precisam mover personagem ou evoluir para algo maior. <br>
* Um coisa que achei engraçado, se você colocar para printar o tabuleiro com mais de uns 150x150 ele demora quase que infinitamente para "printar"
o tabuleiro inteiro. Ainda vale para uma ajuda visual para tabuleiros menores.
* Ainda não estou satifisfeito com a escrita dos testes para cada função.
* Porém foi divertido escrever o tabuleiro.
### Intereção 4
Aqui foi apresentado a adição de "Guildas" para os personagens. <br>
Foi relativamente fácil implementar -> Basicamente só adicione mais um atributo da Interface List
que seria gerenciado pelas funções Adicionar/Excluir Guilda do personagem. Parte interessante foi
usar a sobrecarga de função podendo aceitar ou uma string com o nome da guilda ou List com nomes de guildas.<br>
### Intereção 5
O desafio dessa intereção era criar uma nova classe que poderia sofrer dano, mas não sendo um personagem
(e mais algumas restrições). <br>
Como eu resolvi:<br>
A interface _ExisteParaTabuleiro_ foi a base para resolver sem quebrar as funções já feitas na classe personagem.
Alguns metodos já implementados no personagem foi colocado como requisito na interface para que fosse mais simples
saber oque era necessário implementar na nova classe "CoisaNaoPersonagem".<br> 
#### Pontos de melhoria
Coisas que ficaram meio estranhas:
1. A função Machucar da classe Personagem está muito comprida. Precisava revisar para deixa ela mais adequada para um padrao
SOLID.
2. A quinta intereção deixa algumas coisas abertas, por exemplo:
   * O objeto alvo deveria ter um nivel de dificuldade para bater? 
   assim como a regra de 5 nivel maior causa mais dano, acho que poderia ser válido.
     (Eu deixei o level padrao como 0 para fins de facilitar isso)

### Próximos passos possiveis
Teoricamente aqui acaba o desafio, mas seria interessante transformar isso em uma api com o spring.<br>
Outra ideia é implementar armas, ao invés da classe definir a distância e o dano causado.




