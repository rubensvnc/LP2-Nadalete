## Decisões de design

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

