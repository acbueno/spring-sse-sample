Spring SSE Sample
Este projeto é um exemplo de como consumir uma API externa de previsão do tempo e disponibilizar uma API para realizar requisições SSE que enviam a stream por um minuto.

Tecnologias Utilizadas
Spring Boot: Framework para criação de aplicações Java.
RestTemplate: Utilizado para fazer requisições HTTP à API externa.
Jackson: Biblioteca para serialização/deserialização de JSON.
Lombok: Biblioteca para reduzir a verbosidade do código Java.
OpenAPI: Especificação para documentação de APIs REST.
Como Executar o Projeto
Clone o repositório: git clone https://github.com/acbueno/spring-sse-sample.git
Navegue até o diretório do projeto: cd spring-sse-sample
Execute a aplicação: ./mvnw spring-boot:run
Acesse a documentação da API: http://localhost:8080/swagger-ui/
Experimente fazer uma requisição SSE para a rota /weather/stream para receber a stream da previsão do tempo por um minuto.

Observações
Para mais informações sobre o projeto, consulte a documentação da API disponível em http://localhost:8080/swagger-ui/.
