# Sistema de Gestão de Academia - Projeto CRUD em Java Swing

  Este projeto foi desenvolvido ao longo de seis meses e utiliza Java Swing para criar uma interface gráfica que simula as operações CRUD (Create, Read, Update, Delete) em um ambiente de academia e ginástica. Sendo implementado na disciplina de Programação Orientada a Objetos II do professor do Ifes Campus Colatina - Jean Glazar.

  O objetivo principal deste projeto é fornecer uma aplicação de gerenciamento para uma academia, permitindo a manipulação de informações sobre alunos, professores, modalidades de exercícios, aulas e turmas. O sistema busca utilizar os princípios da Programação Orientada a Objetos.

## 🚀 Indrodução

  Abaixo deixarei algumas telas que desenvolvi, alguns erros podem ter passado despercebidos durante a fase de testes, por isso, deixo esse projeto em aberto para futuras atualizações,
é um projeto que tirei como foco para meu desenvolvimento pessoal e particularmente gostei muito de trabalhar com Java Swing. 
Meu foco foi nas funcionalidades e menos na interface, problemas relacionados a tamanhos de botão, ícones errados e falta de cores interativas serão trabalhadas futuramente.
Deixarei dentro do projeto o diagrama de classes para uma melhor compreensão do sistema.

Diagrama de Classes

[diagram.pdf](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/files/14046277/diagram.pdf)

*----

Tela de Login 

![WhatsApp Image 2024-01-25 at 00 12 10 (3)](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/8076a671-066f-4487-ab36-5ebd2ac58490)

*----


Tela Principal

![Captura de tela 2024-01-24 232451](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/3906d49e-f916-47c7-82d9-24ec0d2310be)


*----


Telas de Consultas


![Captura de tela 2024-01-24 232506](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/f9d30aa0-43c7-4fd9-a251-010a699aa900)



![Captura de tela 2024-01-24 232521](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/639dc68f-3c39-4326-8d71-1c4be7c52ba4)



![Captura de tela 2024-01-24 232537](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/f67911ff-bc15-4039-afd3-f467e55f2c34)


*----

Janelas de atribuições

![Captura de tela 2024-01-24 232638](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/73f8a1d9-a35a-4b81-aa9d-b7cdbe9659fc)

![Captura de tela 2024-01-24 232623](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/e8ddedfd-d0c7-45c5-a4a5-ad70a7f09388)


*----

Menus com ícones 


![Captura de tela 2024-01-24 232724](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/e7831c71-bb34-4b3f-8855-a34e539d3d69)
![Captura de tela 2024-01-24 232653](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/3bbe56e7-0290-4857-bba9-0fa5e14b0b44)
![Captura de tela 2024-01-24 232734](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/5458a952-2c27-4dd5-9742-84441e376983)


*----

Janela de Ajuda


![Captura de tela 2024-01-24 232755](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/9a743fe4-5c71-4b25-83a4-7b4c7b5b6044)


*----

Janela de Relatórios

![Captura de tela 2024-01-24 232808](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/aa46f1b7-f23b-40f2-969d-7d189f71f4da)


*----

Relatórios


![WhatsApp Image 2024-01-25 at 00 12 10](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/05200306-380c-4e82-8e8b-17ffe1841a6b)
![WhatsApp Image 2024-01-25 at 00 12 10 (1)](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/f193d07f-f5e4-4471-9ade-c96d4293505f)
![WhatsApp Image 2024-01-25 at 00 12 10 (2)](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/65016d09-8069-47f2-94b5-f0db3ddca6c3)


Janela de Edição

![Captura de tela 2024-01-24 232825](https://github.com/voidGustavoNunes/gymSystem---Java-Swing/assets/105016559/a5b2f6fc-ab7a-4f67-bc12-906fff90fef7)



## ⚙️ Comentários
Tela de Login: 

Login: voidGustavoNunes

Senha: gustavo


Apenas uma tela simples de login que achei que seria interessante incluir, como base para uma futura atualização onde incluirei a parte financeira da gestão de academia, login de professor e aluno com senha e códigos já definidos nas janelas de cadastro e atribuições e permissões diferentes para cada tipo de usuário.


Janela Principal:   Meu objetivo aqui foi deixar os principais botões que um usuário viria a utilizar no seu dia a dia no gerenciamento da academia, como cadastro de alunos e consultas. Nos menus, ele tem acessoa a todas as funcionalidades do sistema, devidamente classificadas com atalhos do teclado para uma maior acessibilidade.

Janela de Consultas: A janela de consultas possui todas as consultas atualmente presentes no sistema: Aluno, Professor, Turma, Aulas e Exercícios.

Janelas de Atribuições: As janelas de atribuições serão denominadas para atribuir uma turma a um aluno, por exemplo, onde você pode também dar manutenção a turma ao acessar a edição, onde o botão retirar aluno será habilitado.

Janela de Relatórios: Todos os relatórios foram feitos utilizando iReport, não me preocupei muito com estética, pois como é o meu primeiro contato com a ferramenta tive muitos problemas em relação a gerar subreports, mas estão todos funcionais, desde que ao fazer o clone, mude o Subreport_Dir de cada relatório setando a pasta target do diretório.

Janela de Edição: Assim como em relatórios e em consultas, criei uma tela de edição centralizada que abre a tela de cadastro de cada entidade com os campos já preenchidos buscado do banco de dados, onde o torna muito mais fácil do que gerar uma nova janela apenas para edição.

Janela de Ajuda: A janela de ajuda é o diferencial do sistema, onde o usuário ao preencher os campos e clicar em enviar, é gerado um email para o endereço aplicacaoJavaAcademy@outlook.com com a dúvida, tudo automaticamente utilizando a biblioteca mail.SimpleMail.


## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* Java Swing - Widget Toolkit GUI Utilizado
* Hibernate - Framework de Mapeamento
* Banco de Dados MYSQL

## 📌 Versão

v1.0

## ✒️ Autores
Gustavo Nunes Guedes

## 📄 Licença

Livre

## 🎁 Expressões de gratidão

* Um agradecimento especial ao meu professor de Programação Orientada a Objetos II -  Jean Glazar por todo o apoio e ensinamento.

---
