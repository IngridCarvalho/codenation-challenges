# Backend para gerenciar times de futebol

Você é responsável por construir o backend de um novo gerenciador de times de futebol. Após fecharem o escopo do projeto, você e sua equipe definiram a `@interface` que o software deve implementar. A interface é a seguinte :


    public interface MeuTimeInterface {

		@Desafio("incluirTime")
		public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario);

		@Desafio("incluirJogador")
		public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario);

		@Desafio("definirCapitao")
		public void definirCapitao(Long idJogador);

		@Desafio("buscarCapitaoDoTime")
		public Long buscarCapitaoDoTime(Long idTime);

		@Desafio("buscarNomeJogador")
		public String buscarNomeJogador(Long idJogador);

		@Desafio("buscarNomeTime")
		public String buscarNomeTime(Long idTime);

		@Desafio("buscarMaiorSalario")
		public Long buscarJogadorMaiorSalario(Long idTime);

		@Desafio("buscarSalarioDoJogador")
		public BigDecimal buscarSalarioDoJogaodor(Long idJogador);

		@Desafio("buscarJogadoresDoTime")
		public List<Long> buscarJogadoresDoTime(Long idTime);

		@Desafio("buscarMelhorJogadorDoTime")
		public Long buscarMelhorJogadorDoTime(Long idTime);

		@Desafio("buscarJogadorMaisVelho")
		public Long buscarJogadorMaisVelho(Long idTime);

		@Desafio("buscarTimes")
		public List<Long> buscarTimes();
		
		@Desafio("buscarTopJogadores")
		public List<Long> buscarTopJogadores(Integer top);
	}

Os dados devem ficar armazenados na memória.

## Requisitos de Sistema

- Parâmetros com `*` são obrigatórios.
- Os parâmetros, com exceção de identificadores, são sempre íntegros e farão sentido.

### @Desafio("incluirTime)"

Realiza a inclusão de um novo team.

Long `id`* Identificador do team
String `nome`* Nome do Time
LocalDate `dataCriacao`* Data de criação do team
String `corUniformePrincipal`* Cor do uniforme principal do team
String `corUniformeSecundario`* Cor do uniforme secundário do team

**Exceções:**

Caso o `identificador` já exista, retornar `br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException`

### @Desafio("incluirJogador)"

Realiza a inclusão de um novo player.

Long `id`* Identificador do Jogador
Long `idTime`* Identificador do team
String `nome`* Nome do Jogador
LocalDate `dataNascimento`* Data de nascimento do Jogador
Integer `nivelHabilidade`* Nível de habilidade do player (0 a 100)
BigDecimal `salario`* Salário do player

**Exceções:**

Caso o `identificador` já exista, retornar `br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException`
Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("definirCapitao")

Define um player como capitão do seu team. Um team deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas player.

Long `idJogador`* Identificador do player.

**Exceções:**

Caso o player informado não exista, retornar `br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException`

### @Desafio("buscarCapitaoDoTime")

Mostra o `identificador` do capitão do team.

Long `idTime`* Identificador do Time

**Exceções:**

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

Caso o team informado não tenha um capitão, retornar `br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException`

### @Desafio("buscarNomeJogador")

Retorna o `nome` do player.

Long `idJogador`* Identificador do player

**Exceções**

Caso o player informado não exista, retornar `br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException`

### @Desafio("buscarNomeTime")

Retorna o `nome` do team.

Long `idTime`* Identificador do Time

**Exceções**

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("buscarJogadoresDoTime")

Retorna a lista com o `identificador` de todos os jogadores do team, ordenada pelo `id`.

Long `idTime`* Identificador do Time

**Exceções**

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("buscarMelhorJogadorDoTime")

Retorna o `identificador` do melhor player do team.

Long `idTime`* Identificador do team.

**Exceções**:

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("buscarJogadorMaisVelho")

Retorna o `identificador` do player mais velho do team. Usar o menor `identificador` como critério de desempate.

Long idTime* Identificador do team

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("buscarTimes")

Retorna uma lista com o `identificador` de todos os times cadastrado, ordenada pelo `identificador`.
Retornar uma lista vazia caso não encontre times cadastrados.

### @Desafio("buscarJogadorMaiorSalario")

Retorna o `identificador` do player com maior salário do team. Usar o menor `identificador` como critério de desempate.

Long `idTime`* Identificador do team.

**Exceções**:

Caso o team informado não exista, retornar `br.com.codenation.desafio.exceptions.TimeNaoEncontradoException`

### @Desafio("buscarSalarioDoJogador")

Retorna o `salário` do player.

Long `idJogador`* Identificador do player

**Exceções**:

Caso o player informado não exista, retornar `br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException`

### @Desafio("buscarTopJogadores")

Retorna uma lista com o `identificador` dos `top` melhores jogadores, utilizar o menor `identificador` como critério de desempate.

Integer `top`* Quantidade de jogares na lista

**Exceções**:

Caso não exista nenhum player cadastrado, retornar uma lista vazia.

### @Desafio("buscarCorCamisaTimeDeFora")

Retorna a `cor da camisa` do team adversário. 
Caso a `cor principal` do team da casa seja **igual** a `cor principal` do team de fora, retornar `cor secundária` do team de fora.
Caso a `cor principal` do team da casa seja **diferente** da `cor principal` do team de fora, retornar `cor principal` do team de fora.

Long `idTimeDaCasa`* Identificador do team da casa
Long `idTimeDeFora`* Identificador do team de fora

## Tópicos

Neste desafio você aprenderá:

- Variáveis e métodos
- Operadores matemáticos
- Controle de fluxo
- Listas
- Tratamento de exceções

## Requisitos
​
​Para este desafio você precisará :

- Java 8 +

Para instalar no MacOS, usando o HomeBrew basta executar:

    brew cask install java

dPara instalar no Linux e Windows confira os links na sessão de conteúdo