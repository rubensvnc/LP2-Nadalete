# LP2-Nadalete
Atividades relacionadas à disciplina de Linguagem de Programação 2 do terceiro semestre de Banco de Dados.

# Exercício 1 - Sistema de Mensagens (WhatsApp simplificado)

Projeto da disciplina de Linguagem de Programação II (LP2), FATEC.

## Estrutura

- Pacote raiz: `edu.fatec.lp2.exercicio1`, onde fica a `Main`.
- Subpacote `edu.fatec.lp2.exercicio1.mensagens`, com as abstrações:
  - `Contatinho`
  - `Mensagem` (abstrata)
  - `MsgTexto`, `MsgAudio`, `MsgFoto`
  - `Whatsapp`

As classes do subpacote são `public` porque a `Main`, em outro pacote, as utiliza. Visibilidade package-private não funcionaria, pois exigiria todas as classes no mesmo pacote.

## Requisitos

- JDK 22
- Maven 3.x

## Como compilar e executar

```bash
mvn compile
java -cp target/classes edu.fatec.lp2.exercicio1.Main
```

A saída lista os três contatos e as três mensagens, com os campos extras de cada subclasse.

## Testes

Não há testes automatizados neste exercício. A verificação é feita pela execução da `Main`, cuja saída deve listar os três contatos e as três mensagens.

# Exercício 2 - Domínio de Compras

Projeto da disciplina de Linguagem de Programação II (LP2), FATEC.

## Estrutura

- Pacote raiz: `edu.fatec.lp2.exercicio2`, onde fica a `Main`.
- Subpacote `edu.fatec.lp2.exercicio2.compras`, com as abstrações:
  - `Calculavel` (interface)
  - `Supermercado` (abstrata)
  - `Produto` (abstrata)
  - `ItemCompra` (abstrata, implementa `Calculavel`)
  - `ListaCompra` (abstrata, implementa `Calculavel`)

As classes do subpacote são `public` porque a `Main`, em outro pacote, as utiliza.

## Requisitos

- JDK 22
- Maven 3.x

## Como compilar e executar

```bash
mvn compile
java -cp target/classes edu.fatec.lp2.exercicio2.Main
```

A saída lista os itens da lista de compras, com quantidade, desconto e preço de cada um, seguida do total, e depois as duas regras de validação: o limite da lista e o intervalo do desconto.

## Testes

Não há testes automatizados neste exercício. A verificação é feita pela execução da `Main`, cuja saída deve mostrar os dois itens, o total de R$ 22.5 e as duas mensagens de erro.