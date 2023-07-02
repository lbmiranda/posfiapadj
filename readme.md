**Relatório Técnico: Desenvolvimento de APIs com Java + Spring Boot**

**1. Introdução**

Este relatório técnico descreve o processo de desenvolvimento de uma API utilizando Java com o framework Spring Boot. A API foi construída para gerenciar uma lista de usuários, eletrodomésticos e endereços e foram utilizadas as tecnologias e ferramentas mencionadas, incluindo as bibliotecas Lombok, DTOs (Data Transfer Objects) e a validação com Bean Validation. Durante o desenvolvimento, foram encontrados desafios relacionados à incompatibilidade do JMapper com o Java 17, os quais foram solucionados através do mapeamento manual dos objetos recebidos nos formulários para o objeto que será persistido futuramente em banco de dados.


**2. Tecnologias e Ferramentas Utilizadas**

- Java: A linguagem de programação principal utilizada no desenvolvimento da API.
- Spring Boot: Um framework para desenvolvimento de aplicativos Java baseados em Spring.
- Lombok: Uma biblioteca que simplifica a criação de classes Java, gerando automaticamente código repetitivo, como getters, setters e construtores.
- DTOs (Data Transfer Objects): Classes que representam objetos de transferência de dados entre diferentes camadas da aplicação.

**3. Desafios Encontrados e Soluções Implementadas**

Durante o desenvolvimento da API, foram encontrados desafios relacionados à incompatibilidade do JMapper com o Java 17. O JMapper não suporta nativamente o Java 17, o que resultou em erros de compilação e execução.

Para resolver esse problema, foram implementadas as seguintes soluções:

**3.1. Utilização de outra biblioteca de mapeamento de objetos**

Diante da incompatibilidade do JMapper com o Java 17, foi necessário buscar uma alternativa viável para o mapeamento de objetos. Após uma análise das opções disponíveis, optamos por realizar o mapeamento manualmente, tendo em vista o mapeamento entre as classes ser simples e direto e não serem vislumbradas necessidades de funcionalidades mais avançadas, como mapeamento de propriedades com nomes diferentes ou outras conversões personalizadas.


**4. Conclusão**

Através do uso de Java com o framework Spring Boot, a biblioteca Lombok, a utilização de DTOs e a resolução dos problemas de incompatibilidade do JMapper com o Java 17, foi possível desenvolver uma API de gerenciamento de usuários, eletrônicos e endereços de forma eficiente e simples. 
O aprendizado adquirido durante a resolução desses desafios ressalta a importância de estar ciente das dependências utilizadas e suas compatibilidades, bem como a necessidade de estar preparado para buscar alternativas e soluções quando confrontado com limitações ou incompatibilidades tecnológicas.


## API de Gerenciamento de Usuários, Endereços e Eletrônicos

A API permite criar e recuperar registros de Pessoas, Endereços e Eletrônicos.

### Base URL
`http://localhost:8080`

### Endpoints

#### 1. Criar uma Pessoa

- **URL:** `/pessoas`
- **Método:** POST
- **Descrição:** Cria um objeto Pessoa.

##### Parâmetros de entrada
```json
{
    "nome": "João das Cenouras",
    "parentesco": "PAI",
    "dataNascimento": "1990-05-15",
    "sexo": "MASCULINO",    
    "idade": 50    
}
```

##### Exemplo de resposta
```json
{
    "nome": "João das Cenouras",
    "dataNascimento": "1990-05-15T00:00:00.000+00:00",
    "sexo": "MASCULINO",
    "parentesco": "PAI",
    "idade": 50,
    "idPessoa": 0
}

```

#### 2. Recuperar pessoa

- **URL:** `/pessoas/{id}`
- **Método:** GET
- **Descrição:** Recupera pessoa cadastrada com base no atributo idPessoa.

##### Parâmetros de URL
- `id` (obrigatório): ID do usuário a ser recuperado.

##### Exemplo de resposta
```json
{
    "nome": "João das Cenouras",
    "dataNascimento": "1990-05-15T00:00:00.000+00:00",
    "sexo": "MASCULINO",
    "parentesco": "PAI",
    "idade": 50
}
```

#### 3. Criar um endereço
- **URL:** `/enderecos`
- **Método:** POST
- **Descrição:** Cria um objeto Endereco.

##### Parâmetros de entrada
```json
{
    "rua": "Rua de Teste da Silva",
    "numero": 456,
    "bairro": "Teste Grande",
    "cidade": "Testópolis",
    "estado": "SC"
}
```

##### Exemplo de resposta
```json
{
    "idEndereco": 0,
    "rua": "Rua de Teste da Silva",
    "numero": 456,
    "bairro": "Teste Grande",
    "cidade": "Testópolis",
    "estado": "SC"
}
```

#### 4. Recuperar um endereço
- **URL:** `/enderecos/{id}`
- **Método:** GET
- **Descrição:** Recupera endereço cadastrado com base no atributo idEndereco.

##### Parâmetros de URL
- `id` (obrigatório): ID do endereço a ser recuperado.

##### Exemplo de resposta
```json
{
    "rua": "Rua de Teste da Silva",
    "numero": 456,
    "bairro": "Teste Grande",
    "cidade": "Testópolis",
    "estado": "SC"
}
```


#### 5. Criar um eletrônico

- **URL:** `/eletrodomesticos`
- **Método:** POST
- **Descrição:** Cria um objeto Eletronicos.

##### Parâmetros de entrada
```json
{
    "nome": "Teste Power 5000",
    "modelo": "A54etR",
    "marca": "Panasonic", 
    "potencia": 400,    
    "tensao":"_220v"
}
```

##### Exemplo de resposta
```json
{
    "idEletronico": 0,
    "nome": "Teste Power 5000",
    "modelo": "A54etR",
    "marca": "Panasonic",
    "tensao": "_220v",
    "potencia": 400
}
```

#### 6. Recuperar um eletrônico
- **URL:** `/eletrodomesticos/{id}`
- **Método:** GET
- **Descrição:** Recupera eletrônico cadastrado com base no atributo idEletronico.

##### Parâmetros de URL
- `id` (obrigatório): ID do eletrônico a ser recuperado.

##### Exemplo de resposta
```json
{
    "nome": "Teste Power 5000",
    "modelo": "A54etR",
    "marca": "Panasonic",
    "tensao": "_220v",
    "potencia": 400
}
```

