# ProjetoFinalJava
Projeto em Java envolvendo os conceitos trabalhados em sala na disciplina de Programação Concorrente.

- **A estrutura do projeto foi baseada no padrão de projeto [strategy](https://medium.com/@akshatsharma0610/strategy-design-pattern-in-java-6ee96f87d807)**
+ **Foi utilizado o java 17 para o projeto**♨️
* **Maven para controle de dependências**
+ **Foi utilizada a biblioteca jackson para trabalhar com arquivos .json**

# Tutorial de como utilizar:
Ordem para que o projeto funcione: compile primeiro os servidores A, B e C e, após isso, compile o cliente. O terminal solicitará que você insira a palavra-chave.


## Estrutura dos packages
```text
src
└── main
    ├── java
    │   └── com
    │       └── sistemabusca
    │           ├── cliente
    │           ├── context
    │           │   └── buscalinear
    │           ├── servidor
    │           │   ├── servidorA
    │           │   ├── servidorB
    │           │   └── servidorC
    │           └── strategy
    │               ├── buscas
    │               └── servidor
    ├── resources
└── test
```
**Como foi especificado acima, o projeto segue o padrão de projeto Strategy. Por isso, temos os pacotes strategy e context. O pacote strategy é responsável por implementar a lógica dos métodos de busca, ou seja, ele contém as diferentes estratégias que podem ser utilizadas. Já o pacote context é responsável por chamar esses métodos, funcionando como uma camada intermediária entre as estratégias de busca e os servidores, facilitando a comunicação entre eles.**

## Lógica de principais métodos

### BuscaDentroDoJsonStrategy
- Temos o método principal chamado montarLista(String enderecoDoJson), que recebe como parâmetro o endereço do arquivo .json. Inicialmente, declaramos uma variável do tipo File chamada arquivoJson, passando o endereço recebido como argumento para o seu construtor. Em seguida, criamos uma lista do tipo List<ArtigoServidorDTO> chamada itens, utilizando o método readValue do ObjectMapper, onde passamos o arquivoJson como parâmetro para realizar a leitura dos dados.
Logo abaixo, declaramos uma nova lista chamada listaParaVerificacao, também do tipo List<ArtigoServidorDTO>. Utilizamos um laço for para percorrer a lista itens e adicionar seu conteúdo à listaParaVerificacao. Por fim, o método retorna a listaParaVerificacao. É importante ressaltar que tudo é executado dentro de um try catch para tratar um possível erro.

### BuscaLinearStrategy
- Temos o método fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString) que espera como parâmetro uma lista do tipo ArtigoServidorDTO e uma String subString. Primeiro é criada a listaDeVerificados do tipo ArrayList<ArtigoServidorDTO>, após isso é criado um laço for de ArtigoDTO, em cada item é feito a seguinte verificação `item.getTitle().toLowerCase().contains(subString.toLowerCase()) || item.getAbstract().toLowerCase().contains(subString.toLowerCase()) || item.getLabel().toLowerCase().contains(subString.toLowerCase()`, caso caia nesse if a listaDeVerificados adiciona o item. Esse método fazerBuscaLinear retorna a listaDeVerificados.

### ServidorA
- Dentro da classe ServidorA temos -> `abrirServerRecebendoDados()` que desempenha a função de iniciar o servidorA e aceitar uma conexão no ServidorA. Temos a função `enviarParaOCliente(Socket clientSocket, String dados)` que serve para enviar para o cliente o resultado dos artigos que contém a subString. Tem o método `receberString(Socket clientSocket)` que serve para receber a subString e retorna a mesma. E temos o método `enviarParaServidoresBeCeObterRetornoParaEnviarCliente(String string)` que tem a funcionalidade de enviar para o ServidorB e o ServidorC a subString dentro dos servidores é chamada a lógica para verificação, e no final é retornado em um StringBuilder a resposta do ServidorB e do ServidorC.


### ServidorB
- rodamos tudo no main, que é basicamente para criar o ServidorB, receber a subString, cria uma `List<ArtigoServidorDTO> resultados` que é igual `buscaLinearContext.fazerBuscaDeManeiraLinear(dados);`, verificamos se está nulo, se estiver ele solta no console "EMPTY", caso não esteja ele solta no console "START" e inicia um laço for para printar os artigoServidorDTO no console do ServidorA, ao final ele printa "END!"

### ServidorC
- Temos a mesma dinâmica do servidorB

### Cliente

- Temos o método main e o método `enviarSubString()`, que serve basicamente para pedir ao usuário digitar a subString e retorna essa subString, já no método main ele se conecta ao servidorA que está na porta 8080, e chama dentro do out o método `enviarSubString()` para enviar a subString para o servidorA, abaixo ele entra em um loop while que se for diferente de null é exibido no console a variável linhaResposta que a cada execução é um `in.readLine()` e temos uma verificação, se a linhaResposta for "END OF ARTICLES" ele encerra. Ao final ele fecha a conexão com servidor.


## Diagrama básico do sistema

![Minha imagem](https://github.com/lzhar/ProjetoFinalJava/blob/feature/busca-distribuida/src/main/imagens/Captura%20de%20tela%202025-06-11%20012935.png)
