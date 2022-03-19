#language: pt
#encoding: utf-8

Funcionalidade: Realizar teste com mudança de foco

Cenário: Testar Upload de Arquivo

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Outros
Quando clicar em Upload de Arquivo
Então enviar uma imagem da pasta imagens

Cenário: Fazer Autenticação básica 

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Outros
Quando clicar Basic Auth e fazer autenticação básica
Então verificar a mensagem de autentificação bem sucedida 

Cenário: Testar Scroll

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Outros
Quando clicar em Scroll
Então rolar até o fim do texto
E esperar 3 segundo e subir para o inicio do texto