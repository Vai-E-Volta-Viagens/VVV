# PASSO A PASSO - GIT FLOW

Importante: qualquer branch pode ser apagada com: git branch -D <nome da branch>

Essa organização é majoritáriamente local. Quase tudo isso vai ocorrer apenas do seu pc. Apenas quando a alteração for para a main você pode realizar o push para o github.

## Criando o git flow

>>>>>>>>>>>>> Branch atual: main

Vá para o diretório do projeto com o git bash e execute: 
git flow init

(Dê enter em tudo)

Ele te enviará para a branch develop

Nessa branch que você pode realizer os seus desenvolvimentos.

## FEATURE:
É uma branch para desenvolvimentos mais isolados, ou seja, sua falta não corrompe o funcionamento do restante.

>>>>>>>>>>>>> Branch atual: develop

Como criar uma feature para um desenvolvimento:
git flow feature start <nome>

>>>>>>>>>>>>> Branch atual: feature/< nome >

Para monitorar TODOS os arquivos novos e já pôr eles no staged para um commit:
git add .

Processo de commit na feature é como em qualquer outro: 
git commit -m "<mensagem>"

OBS: Caso alguém queira te ajudar nessa feature, faça:  git flow feature publish <nome>

Importante: Não finalize a branch feature sem fazer o committ de todas as alterações.

Após terminar o desenvolvimento, mate essa branch feature e retorne para a develop com (todas as alterações dessas branch irão para a develop):
git flow feature finish <nome da adição>

## RELEASE:

A branch release serve para o ambiente de testes e pequenas correções. Aqui você roda o programa e vê se está OK.

>>>>>>>>>>>>> Branch atual: develop

Quando um desenvolvimento for finalizado e puder ser testado:
git flow release start <versão>

>>>>>>>>>>>>> Branch atual: release/<versão>

OBS: Caso alguém queira te ajudar nesse release, faça:  git flow release publish <versão>

Se o projeto estiver funcionando bem, essa ação mandará suas alterações para a main e apagará essa branch release/<versão> (se modificou algo na branch release/<versão> o flow também mandará para a develop):
git flow release finish <versão>

Essa <versão> se tornará a tag da main e da develop

#### O git pedirá para escrever um pequeno texto nessa tag. A ideia é, resumidamente, escrever o que foi desenvolvido nessa versão.

## HOTFIX

A Hotfix server para correções pequenas que voltarão direto para a branch main e develop.
Na minha cabeça: Vish, deu ruim. Pior que já está na main. Espera, sei o que pode corrigir isso rapidinho.

OBS: Não acho uma boa cultura usarmos a hotfix, isso porque as correções quase sempre demoram mais do que imaginavamos e se alguém der um push na main enquanto você está na hotfix podem ocorrer confusões nas tag de <versão> da main.

BUT.... Caso a alteração seja realmente rápida:

>>>>>>>>>>>>> Branch atual: main

git flow hotfix start <nova versão>

Para monitorar TODOS os arquivos novos e já pôr eles no staged para um commit:
git add .

Processo de commit na hotfix é como em qualquer outro: 
git commit -m "<mensagem>"

OBS: Caso alguém queira te ajudar nesse hotfix, faça:  git flow hotfix publish <nova versão>

Ao finalizar a alteração, o finish irá enviar a alteração para a develop e para a main: 
git flow hotfix finish <nova versão>


# Enviando sua branch develop e main para o github
git push --all

OBS: Lembre-se de ter finalizado todas as branch feature, release e hotfix. Isso porque essas branch devem ser temporárias e locais, enviá-las para o github sem querer irá poluir o ambiente.
