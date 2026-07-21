# CampusNet - Instruções de Execução

## Requisitos
- JDK 17 ou superior instalado.
- Terminal Linux / Prompt de Comando ou IDE (IntelliJ IDEA, Eclipse, VS Code).

## Estrutura de Arquivos
Certifique-se de que o arquivo `estudantes.csv` está no mesmo diretório em que o programa será executado.

## Como Executar via IDE (IntelliJ IDEA)
1. Abra a pasta do projeto no IntelliJ.
2. Verifique se a pasta `src` está configurada como 'Sources Root'.
3. Certifique-se de que o arquivo `estudantes.csv` está na raiz do projeto.
4. Abra a classe `Main2.java` e clique no botão 'Run' (Shift + F10).

## Como Executar via Terminal (Linux/Windows)
1. Navegue até a pasta do projeto:
   cd caminho/para/CampusNet
2. Compile todas as classes Java:
   javac -d bin src/*.java
3. Copie o arquivo CSV para a pasta de execução:
   cp estudantes.csv bin/
4. Execute o programa:
   cd bin
   java Main2
