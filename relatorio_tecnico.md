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
