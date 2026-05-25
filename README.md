# Fila de Prioridade Heap

## Compilar

```bash
javac -d out src/entidades/Pessoa.java src/estatica/FilaEstatica.java src/estatica/FilaComPrioridade.java src/heap/FilaComPrioridadeHeap.java src/Main.java
```

## Executar

```bash
java -cp out Main
```

## Gerar Javadoc

```bash
javadoc -d doc -sourcepath src -subpackages estatica:heap:entidades
```

## Descrição

Este projeto implementa um sistema de triagem para o Hospital São Binário.

A fila comum foi substituída por uma fila de prioridade baseada em Heap Binário. Assim os pacientes são atendidos conforme a prioridade e não apenas pela ordem de chegada.

## Estrutura utilizada

Foi utilizada uma Fila de Prioridade implementada com Heap Binário máximo.
- Enfileirar: utiliza o algoritmo Sobe Heap.
- Desenfileirar: utiliza o algoritmo Desce Heap.

## Entidade Paciente

Cada paciente possui:

- nome
- nível de urgência
- tempo de espera em minutos
- grupo vulnerável

## Regras de prioridade

A prioridade entre pacientes segue três critérios:

1. Maior nível de urgência.
2. Em caso de empate, maior tempo de espera.
3. Em caso de novo empate, paciente de grupo vulnerável tem prioridade.

## Níveis de urgência

| Nível | Cor | Classificação |
|---|---|---|
| 5 | Vermelho | Imediato |
| 4 | Laranja | Muito Urgente |
| 3 | Amarelo | Urgente |
| 2 | Verde | Pouco Urgente |
| 1 | Azul | Não Urgente |

## Pacientes de teste

| Nome | Urgência | Espera | Vulnerável |
|---|---:|---:|---|
| Carlos | 2 | 45 | false |
| Maria | 5 | 5 | false |
| João | 3 | 20 | false |
| Beatriz | 3 | 35 | true |
| Pedro | 5 | 2 | false |
| Helena | 2 | 45 | true |

## Ordem esperada de atendimento

1. Maria
2. Pedro
3. Beatriz
4. João
5. Helena
6. Carlos

## Requisitos

- Java JDK 17 ou superior

Abrir a documentação: `doc/index.html`
