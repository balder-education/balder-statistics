# balder-statistics

Sistema de estatistica do TCC da Unitri 

O sistema usa Spring Boot, com spring MVC, spring segurity, spring data para mongo DB

O Sistem usa MongoDB como persistencia.

Tutorial 1 - https://rogeriofontespsi.wordpress.com/2015/03/26/bora-la-mongodb/
Tutorial 2 - https://rogeriofontespsi.wordpress.com/2015/03/26/instalacao-do-mongodb/
Tutorial 3 - https://rogeriofontespsi.wordpress.com/2015/03/26/tipo-de-dados-suportados-no-mongodb/
Tutorial 4 - https://rogeriofontespsi.wordpress.com/2015/03/26/mongodb-comandos-basicos-de-manipulacao/
Tutorial 5 - https://rogeriofontespsi.wordpress.com/2015/03/26/serie-comando-de-manipulacao-criar-uma-base-de-dados-no-mongodb/
Tutorial 6 - https://rogeriofontespsi.wordpress.com/2015/03/26/serie-comando-de-manipulacao-excluindo-uma-base-de-dados-no-mongodb/
Tutorial 7 - mais...
.
.
. 

tutorial de Spring boot - https://spring.io/guides/gs/spring-boot/

Serviços ja disponiveis

para rodar -> run it using maven (http://maven.apache.org):

$ mvn spring-boot:run

mvn package && java -jar target/balder-statistics-0.1.0.jar

utilizar o docker: ......

Servicos:

GET

$ curl localhost:8989/api/stundents

{
id: "56342a2ea8262edd638b8240"
name: "rogerio"
email: "fontestz@gmail.com"
code: null
cpf: null
rg: null
bornDate: null
registerNumber: null
genterType: null
}

$ curl localhost:8989/api/progressions

 {
id: "5634f47da82690ab6ec92d0a"
contentNumber: "2341234"
progress: 1
progressDate: 978307200000
studentCode: "5499"
}

$ curl localhost:8989/api/statistics/total-media-age-student
{ }

$ curl localhost:8989/api/statistics/total-male-student
{ }

$ curl localhost:8989/api/statistics/total-female-student
{ }

$ curl localhost:8989/api/statistics/bad-progression-student
{ }

$ curl localhost:8989/api/statistics/good-progression-student
{ }

POST

$ curl -X POST localhost:8989/api/stundents
{"name":"rogerio-test1", "email":"fontestz-test@gmail.com","code":"5499"}

$ curl -X POST localhost:8989/api/progressions
{"contentNumber":"2341234","progress":1, "progressDate":"2001-01-01","studentCode":"5499"}

continuar atualizando......esse doc.
