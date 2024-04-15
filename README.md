# Spring SSE Sample

Este projeto é um exemplo prático que demonstra como consumir uma API externa de previsão do tempo e disponibilizar uma API para realizar requisições Server-Sent Events (SSE), permitindo que os clientes recebam a stream de dados de previsão do tempo continuamente por um período de um minuto. A aplicação utiliza tecnologias modernas do ecossistema Spring, como RestTemplate para fazer requisições à API externa, Jackson para processamento de dados JSON, Lombok para redução da verbosidade do código Java e OpenAPI para documentação automática da API.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para criação de aplicações Java.
- **RestTemplate:** Utilizado para fazer requisições HTTP à API externa.
- **Jackson:** Biblioteca para serialização/deserialização de JSON.
- **Lombok:** Biblioteca para reduzir a verbosidade do código Java.
- **OpenAPI:** Especificação para documentação de APIs REST.

## Como Executar o Projeto

1. Clone o repositório: `git clone https://github.com/acbueno/spring-sse-sample.git`
2. Navegue até o diretório do projeto: `cd spring-sse-sample`
3. Execute a aplicação: `./mvnw spring-boot:run`
4. Acesse a documentação da API: [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)
5. Experimente fazer uma requisição SSE para a rota `/weather/stream` para receber a stream da previsão do tempo por um minuto.

## Observações

- Para mais informações sobre o projeto, consulte a documentação da API disponível em [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/).
