# Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot
aplicação criado através do curso da Digital Innovation

Link para Heroku

https://peopleaplication.herokuapp.com

#O que é possivel realizar

&raquo; Inserir pessoa

&raquo; Procurar pessoas

&raquo; Procurar pessoa por ID

&raquo; Atualizar pessoa

&raquo; Excluir pessoa

# Endpoint
&raquo; https://peopleaplication.herokuapp.com

&raquo; /api/v1/people - metodo POST - inserir pessoa

{
  "firstName" : "Heitor",
  "lastName" : "Fernando Barbosa Ramos",
  "cpf" : "371.802.200-19",
  "phones" : [
      {
          "type" : "MOBILE",
          "number" : "(11) 97637-9988"
      },
      {
          "type" : "HOME",
          "number" : "(11) 4611-3329"
      }
  ]
}


&raquo; /api/v1/people/{id} - metodo PUT - atualizar pessoa

{
  "id" : 1,
  "firstName" : "Heitor",
  "lastName" : "Fernando Barbosa Ramos",
  "cpf" : "371.802.200-19",
  "phones" : [
      {
          "type" : "MOBILE",
          "number" : "(11) 97637-9988"
      },
      {
          "type" : "HOME",
          "number" : "(11) 4611-3329"
      },
      {
          "type" : "COMMERCIAL",
          "number" : "(11) 4611-1545"
      }
  ]
}




&raquo; /api/v1/people/{id} - metodo GET - busca pessoa por id


&raquo; /api/v1/people - metodo GET - busca todas as pessoa 

&raquo; /api/v1/people/{id} - metodo DELETE - deleta pessoa por id


