#language: pt
#encoding: utf-8

Funcionalidade: excluir usuário antes cadastrado

Cenário: excluir usuário

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de formulário
E clico no link para listagem de usuários
E pesquisar pelo email do usuário entre as páginas
Quando clicar no botão de excluir usuário e confirmar o alert
Então a conta é excluida com uma mensagem de sucesso na operação
