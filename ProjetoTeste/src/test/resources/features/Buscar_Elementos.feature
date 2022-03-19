#language: pt
#encoding: utf-8

Funcionalidade: Realizar teste sobre modos de interação

Cenário: Testar link Sucess

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
E clico em Links
Quando clicar no link Sucess
Então é obtida a mensagem Sucess!!

Cenário: Testar link Bad Request

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
E clico em Links
Quando clicar no link bad request
Então é obtida a mensagem Bad Request!!

Cenário: Testar link Page Not Found

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
E clico em Links
Quando clicar no link page not found
Então é obtida a mensagem Page Not Found!!

Cenário: Testar link Internal Server Error

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
E clico em Links
Quando clicar no link internal server error
Então é obtida a mensagem Internal Server Error!!

Cenário: Testar Text Field e Text Area

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
Quando clicar em Inputs e TextField
Então preencher todos os campos

Cenário: Testar Botões

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
Quando clicar em Botões
E clicar em todos botões ativos
Então verificar a mensagem de Você Clicou no Botão!

Cenário: Testar Radio e Check Box

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
Quando clicar em Radio e Checkbox
E selecionar o radio Red do tipo um e o radio Yellow do tipo dois
E selecionar o checkbox purple do tipo um e o checkbox black do tipo dois
Então selecionar o radio Blue do tipo um e o radio Green do tipo dois 
E selecionar o checkbox Grey do tipo um e o checkbox White do tipo dois

Cenário: Testar Dropdown e Select

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
Quando clicar em Dropdown e Select
E clicar no button Mail Box
E clicar na opção Unread
E em Desenho Favorito selecionar a opção Naruto
E escolher os jogadores Ronaldo, Ronaldinho Gaucho e Romario
E escolher o Pais Brasil
E em genero escolher a opção Homem
E em sexo escolher a opção Masculino
E em Browser Favorito escolher a opção Chrome
Então verificar a mensagem de sucesso do click em Dropdown Unread

Cenário: Testar Tabela

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Busca de elementos
Quando clicar em Tabela
Então verificar o preço do feijao, arroz e carne



