#language: pt
#encoding: utf-8

Funcionalidade: Realizar teste com mudança de foco

Cenário: Testar Alerts

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Mudança de foco
Quando clicar em Alert
Então clicar no button CLIQUE PARA JS ALERT
E confirmar o alert e fazer a assertiva no result
E clicar no button CLIQUE PARA JS CONFIRM
E confirmar o alert e fazer a validação no result
E clicar no button CLIQUE PARA JS PROMPT
E digitar validado e fazer a assertiva no result

Cenário: Testar iFrame

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Mudança de foco
Quando clicar em IFrame
Então dentro do iframe preencher as informações
E clicar no botão voltar fora do iFrame

Cenário: Testar Nova Janela

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Mudança de foco
Quando clicar em Janela
Então clicar em Abra uma nova Janela
E validar na nova janela aberta a mensagem Você Abriu uma nova janela!!

Cenário: Testar Modal Dialog Box

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Mudança de foco
Quando clicar em Modal
Então clicar no botão Abrir
E validar o titulo do Modal como Modal Teste