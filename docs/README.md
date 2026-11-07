## Decisões de design - Exercício 1

O diagrama de classes foi seguido como referência. Nos pontos abaixo, a implementação diverge do diagrama ou precisou de uma escolha. Em cada caso, a decisão e o motivo estão registrados.

### 1. `toString()` na `Mensagem`

O diagrama mostra `+ toString(): void`, em itálico. Em Java, `toString()` herdado de `Object` retorna `String`, e uma subclasse não pode alterar esse tipo para `void`. Por isso a assinatura é `public String toString()`.

O itálico indica método abstrato. Torná-lo abstrato obrigaria cada subclasse a reimplementá-lo sem ganho, pois todas acrescentam apenas o próprio campo ao texto. A implementação concreta na `Mensagem` é reaproveitada com `super.toString()`, e cada subclasse só concatena o seu atributo.

**Decisão:** `toString()` concreto, retornando `String`.

### 2. Relação entre `Whatsapp` e `Mensagem`

O diagrama mostra composição (losango preenchido), que implica o `Whatsapp` criando e controlando o ciclo de vida das mensagens. O enunciado pede que `contatos` e `mensagens` sejam arrays inicializados via construtor, o que significa que as mensagens chegam prontas de fora. As duas exigências são incompatíveis: com composição estrita, o `Whatsapp` precisaria criar as mensagens internamente.

**Decisão:** inicialização via construtor, conforme o enunciado. Na prática, a relação é de agregação, e isso é registrado como divergência do diagrama.

### 3. Tipos dos atributos `contatos` e `mensagens`

O diagrama mostra `Contatinho` e `Mensagem` como tipos únicos. O enunciado pede arrays, e um único objeto não representa a lista de contatos ou de mensagens.

**Decisão:** `Contatinho[]` e `Mensagem[]`.

### 4. Agregação entre `Mensagem` e `Contatinho`

O diagrama mostra losango vazio. O destinatário existe independentemente da mensagem, que apenas o referencia.

**Decisão:** mantida como no diagrama.

## Decisões de design - Exercício 2

O diagrama de classes foi seguido como referência. Nos pontos abaixo, a implementação precisou de uma escolha ou acrescenta algo que o diagrama não traz. Em cada caso, a decisão e o motivo estão registrados.

### 1. Classes abstratas instanciadas por subclasses anônimas

O diagrama mostra `Supermercado`, `Produto`, `ItemCompra` e `ListaCompra` em itálico, o que indica classe abstrata. O diagrama não define subclasses para elas, mas a `Main` precisa instanciá-las.

**Decisão:** as classes são `abstract`, como no diagrama, e a `Main` cria instâncias com subclasses anônimas (`new Produto(astolfo) { }`). Assim não são criadas classes que o diagrama não prevê.

### 2. Desconto em percentual

O diagrama usa `double` para `desconto` e `descontoMaximo`, sem indicar a unidade. O enunciado diz apenas que o desconto varia de 0 até `descontoMaximo`.

**Decisão:** o desconto é tratado como percentual, e o preço é calculado como `preco * quantidade * (1 - desconto / 100)`.

### 3. Getters e setters

O enunciado assume que todas as classes possuem getter e setter. Por isso foram criados para todos os atributos, com duas exceções.

- `ItemCompra` não tem setter de `produto`, porque o enunciado exige que só seja possível associar um único produto ao item.
- `ListaCompra` tem `setQtdeMax`, que redimensiona o array preservando os itens já incluídos. Os setters `setItensCompra` e `setQtdeMax` não estão no diagrama.

### 4. Tratamento de erros

O enunciado não define o que acontece quando a lista está cheia ou quando o desconto está fora do intervalo.

**Decisão:** `incluir` lança `IllegalStateException` quando a lista atingiu `qtdeMax`, e o construtor e `setDesconto` lançam `IllegalArgumentException` quando o desconto está fora de 0 a `descontoMaximo`.