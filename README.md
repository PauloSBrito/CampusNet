<img width="1339" height="448" alt="Image" src="https://github.com/user-attachments/assets/c10b1efd-5672-4086-ab8c-673379e8a41d" />

# CampusNet — Rede Social Acadêmica

**CampusNet** é uma rede social acadêmica de linha de comando desenvolvida em Java, voltada para a comunicação e interação entre estudantes universitários. O sistema permite publicar conteúdos, interagir com publicações (curtir, comentar e compartilhar) e participar de comunidades temáticas.

> Projeto final da disciplina de **Programação 2** — Foco em **Programação Orientada a Objetos (POO)**.

---

## Pré-requisitos

- **Java JDK 17** ou superior (necessário para a sintaxe `switch` com `->`)
- Terminal / Prompt de Comando / PowerShell

Para verificar se o Java está instalado:
```bash
java -version
javac -version
```

---


### Alternativa: Compilar e executar pelo IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA
2. Localize o arquivo `src/Main.java`
3. Clique com o botão direito → **Run 'Main.main()'**

---

## Funcionalidades

### Login por Matrícula
O estudante acessa o sistema digitando seu número de matrícula. Caso não possua uma conta ativa, o sistema solicita o cadastro antes de prosseguir.

### Feed de Publicações
- Visualizar todas as publicações do feed
- Criar novas publicações de texto
- O feed já inicia com publicações de exemplo (geradas pelo `DataSeeder`)

### Interações com Publicações
- **Curtir** uma publicação
- **Comentar** em uma publicação
- **Compartilhar** uma publicação com legenda personalizada
- **Ver todas as interações** de uma publicação (curtidas, comentários e compartilhamentos exibidos de forma polimórfica)

### Seguir Colegas
- Listar todos os estudantes cadastrados
- Escolher um colega para seguir

### Comunidades
- Criar novas comunidades com nome e descrição
- Entrar em comunidades existentes
- Postar publicações dentro de uma comunidade (também aparece no feed geral)
- Ver a lista de membros de uma comunidade

---

## Conceitos de POO Aplicados

| Conceito | Onde é aplicado |
|----------|----------------|
| **Classes e Objetos** | Todas as 8 classes do modelo (`Estudante`, `Conta`, `Publicacao`, etc.) |
| **Encapsulamento** | Atributos `private` com getters/setters em todas as classes |
| **Interface** | `Interacao` define contrato para `Comentario`, `Curtida` e `Compartilhamento` |
| **Polimorfismo** | `Publicacao.exibirTodasInteracoes()` itera sobre `List<Interacao>` chamando `exibirResumo()` — cada tipo responde de forma diferente |
| **Composição** | `Publicacao` é dona de suas interações — `apagarPublicacao()` remove tudo junto |
| **Agregação** | `Comunidade` referencia `Estudante` e `Publicacao` — existem independentemente |
| **Associação** | `Estudante` possui `Conta` (0..1) |
| **Coleções** | `ArrayList` para feed, membros, comentários, curtidas, compartilhamentos |
| **Separação de Responsabilidades** | Classes de modelo (dados/regras) vs. `Main2` (interface com o usuário) vs. `DataSeeder` (carga de dados) |
| **Tratamento de Exceções** | `try-catch` para leitura do CSV e conversão de dados no `DataSeeder` |
| **Geração Automática de ID** | `static int contadorId` em `Conta`, `Publicacao`, `Comentario`, `Curtida`, `Compartilhamento` |
| **Sobrecarga de Construtor** | `Estudante` e `Curtida` possuem múltiplos construtores para diferentes contextos |

---

## Integrantes
- **Paulo Brito**
- **Anderson Lima**
- **Alessandro Andel**

---
