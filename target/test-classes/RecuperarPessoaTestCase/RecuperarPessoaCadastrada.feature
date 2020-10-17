#language:pt
Funcionalidade: Recuperar Pessoa Cadastrada

Cenario: Recuperar dados de uma pessoa cadastrada

Dado que queira Recuperar dados de uma pessoa cadastrada
Quando informar o DDD cadastrado
E informar o número cadastrado
Então devo seceber status code 200 Created
E o response body de retornar os dados da pessoa cadastrada
 
Cenario: Recuperar dados de uma pessoa cadastrada informando dados errados

Dado que queira realizar um cadastro de uma pessoa
Quando informar o DDD cadastrado errado
E informar o número cadastrado errado
Então deve apresentar status code 404 Not Found
E deve apresentar a mensagem "Não existe pessoa com o telefone (xx)xxxxxxxxx"

Cenario: Recuperar dados de uma pessoa informando DDD não cadastrado

Dado que queira realizar um cadastro de uma pessoa
Quando informar o DDD não cadastrado 
E informar o número cadastrado corretamente
Então deve apresentar status code 404 Not Found
E deve apresentar a mensagem "Não existe pessoa com o telefone (xx)xxxxxxxxx"

Cenario: Recuperar dados de uma pessoa informando número não cadastrado

Dado que queira realizar um cadastro de uma pessoa
Quando informar o DDD cadastrado corretamente
E informar o número não cadastrado 
Então deve apresentar status code 404 Not Found
E deve apresentar a mensagem "Não existe pessoa com o telefone (xx)xxxxxxxxx" 