
Feature: Cadastar Pessoa

Scenario: Realizar novo cadastro

Given que queira realizar um novo cadastro de uma pessoa
When informar os dados corretamente
Then devo seceber status code 201 Created
And o response body de retornar os dados informados nos parêmetros de entrada


Scenario: Realizar cadastro informando CPF já cadastrado

Given que queira realizar um cadastro de uma pessoa
When informar um CPF já cadastrado
Then deve apresentar status code 400 Bad Request
And deve apresentar a mensagem "Já existe pessoa cadastrada com o CPF 12345678910"

Scenario: Realizar cadastro informando número de telefone já cadastrado

Given que queira realizar um cadastro de uma pessoa
When informar um número de telefone já cadastrado
Then deve apresentar status code 400 Bad Request
And deve apresentar a mensagem "Já existe pessoa cadastrada com o Telefone (XX)XXXXXXXXX"