#language: pt
#encoding: utf-8

Funcionalidade: validar criação de usuário e manutenção do mesmo

Cenário: criar usuário com sucesso

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de formulário 
E clico no link para criação de um novo usuário
Quando preencher todos os dados necessários
E clicar no botão Criar 
Então o cadastro de novo usuário é finalizado com uma mensagem de sucesso
E se obtem todas as informações preenchidas

Cenário: listar contas e editar informações

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de formulário
E clico no link para listagem de usuários
E procurar pelo email do usuário entre as páginas
Quando clicar no botão de editar usuário 
Então alterar as informações incorretas
E clicar no botão Criar
E verificar se foi recebido mensagem de cadastro atualizado com sucesso
E se obtem todas as informações preenchidas
