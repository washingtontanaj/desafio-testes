#language: pt
#encoding: utf-8

Funcionalidade: Realizar teste de interação com Widgets

Cenário: Testar Accordion

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Widgets
Quando clicar em Accordion
Então clicar no accordion first e validar a mensagem de Primeiro Texto
E clicar no accordion second e validar a mensagem de Segundo Texto
E clicar no accordion third e validar a mensagem de Terceiro Texto

Cenário: Testar Autocomplete

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Widgets
Quando clicar em Autocomplete
Então digitar no campo de estado a Letra S
E clicar na opção São Paulo

Cenário: Testar DataPicker

Dado que eu acesso a página inicial do site Automação com Batista
E extendo as opções de Widgets
Quando clicar em Datapicker
Então clicar no campo de Data
E escolher a data do Natal de 2015