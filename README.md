
# AgendaApp
Agenda simples com Spring Boot (java), Maven, PostgreSQL e Bootstrap 4

## Como executar?
- Primeiro é necessário criar um banco no PostgreSQL chamado *bdagenda*
- Depois você deverá alterar o usuário e senha de acesso ao banco da dados([agendaApp](https://github.com/luca-gouveia/agenda-spring-boot/tree/master/agendaApp)/[src](https://github.com/luca-gouveia/agenda-spring-boot/tree/master/agendaApp/src)/[main](https://github.com/luca-gouveia/agenda-spring-boot/tree/master/agendaApp/src/main)/[resources](https://github.com/luca-gouveia/agenda-spring-boot/tree/master/agendaApp/src/main/resources)/**application.properties**) 
- Feito isso, você pode executar o projeto em uma IDE (IntelliJ, Eclipse...) ou pelo terminal.

## Executando pelo terminal
 Primeiro instale o Maven Plugin:


   `sudo apt install maven`
    
Após instalado, dentro do diretório do projeto execute o seguinte comando:

   `$ mvn spring-boot:run`
   
Acesse o esse link: http://localhost:8080/
## Imagens do Sistema

### Página de início
![enter image description here](https://raw.githubusercontent.com/luca-gouveia/agenda-spring-boot/master/images/inicio.png)

### Página de adicionar contato
![enter image description here](https://raw.githubusercontent.com/luca-gouveia/agenda-spring-boot/master/images/add.png)
