import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Estudante> baseEstudantes = new ArrayList<>();
        String caminhoArquivo = "estudantes.csv";

        System.out.println("=== CAMPUSNET: Inicializando Sistema ===");
        System.out.println("Carregando banco de dados de estudantes...");

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(",");

                int id = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                int idade = Integer.parseInt(dados[2].trim());
                String curso = dados[3].trim();
                String matricula = dados[4].trim();

                Estudante estudante = new Estudante(id, nome, curso, matricula);
                baseEstudantes.add(estudante);
            }
            System.out.println("Sucesso! " + baseEstudantes.size() + " estudantes carregados.");

        } catch (IOException e) {
            System.err.println("Erro crítico ao ler o arquivo CSV: " + e.getMessage());
            return;
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- BEM-VINDO AO CAMPUSNET ---");
        System.out.print("Digite o seu número de matrícula para entrar: ");
        String matriculaDigitada = teclado.nextLine();

        Estudante estudanteLogado = null;
        for (Estudante est : baseEstudantes) {
            if (est.getMatricula().equals(matriculaDigitada)) {
                estudanteLogado = est;
                break;
            }
        }

        if (estudanteLogado == null) {
            System.out.println("Matrícula não cadastrada no sistema. Encerrando.");
            return;
        }

        System.out.println("\nOlá, " + estudanteLogado.getNome() + " (" + estudanteLogado.getCurso() + ")!");

        if (!estudanteLogado.temConta()) {
            System.out.println("Detectamos que você ainda não possui um perfil ativo no CampusNet.");
            System.out.print("Deseja criar sua conta de acesso agora? (S/N): ");
            String resposta = teclado.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("=== Cadastro de Conta - CampusNet ===");

                System.out.print("Digite seu e-mail acadêmico: ");
                String email = teclado.nextLine();

                System.out.print("Digite uma senha: ");
                String senha = teclado.nextLine();

                System.out.print("Digite um número telefônico: ");
                String numeroTelefonico = teclado.nextLine();

                System.out.print("Digite o seu grau acadêmico (Ex: Graduação, Mestrado): ");
                String grauAcademico = teclado.nextLine();

                Conta novaConta = new Conta(email, senha, numeroTelefonico, grauAcademico, true);
                estudanteLogado.criarConta(novaConta);
            } else {
                System.out.println("É necessário uma conta ativa para interagir. Até logo!");
                return;
            }
        }

        System.out.println("\n--- MURAL DE INTERAÇÕES (SIMULAÇÃO) ---");

        Estudante outroEstudante = baseEstudantes.get(0);

        if (outroEstudante.getId() == estudanteLogado.getId() && baseEstudantes.size() > 1) {
            outroEstudante = baseEstudantes.get(1);
        }

        estudanteLogado.seguir(outroEstudante);

        Publicacao postColega = new Publicacao("Estudando para a prova de Programação 2! Socorro!", outroEstudante);
        outroEstudante.publicar(postColega);

        System.out.print("\nDeseja curtir a publicação de " + outroEstudante.getNome() + "? (S/N): ");
        if (teclado.nextLine().equalsIgnoreCase("S")) {
            estudanteLogado.curtirPublicacao(postColega);
        }

        System.out.print("Digite um comentário para o post dele: ");
        String textoComentario = teclado.nextLine();
        estudanteLogado.comentar(postColega, textoComentario);

        System.out.print("\nDeseja compartilhar a publicação de " + outroEstudante.getNome() + "? (S/N): ");
        if (teclado.nextLine().equalsIgnoreCase("S")) {
            System.out.print("Digite uma legenda para o compartilhamento: ");
            String legenda = teclado.nextLine();
            estudanteLogado.compartilhar(postColega, legenda);
        }

        System.out.println("\n--- Todas as interações da publicação de " + outroEstudante.getNome() + " ---");
        postColega.exibirTodasInteracoes();

        System.out.println("\n--- COMUNIDADES ---");
        Comunidade comunidade = new Comunidade(
                "Comunidade de " + estudanteLogado.getCurso(),
                "Espaço para estudantes de " + estudanteLogado.getCurso() + " trocarem ideias.",
                estudanteLogado
        );
        comunidade.adicionarMembro(outroEstudante);

        Publicacao postComunidade = new Publicacao(
                "Bem-vindos à nossa comunidade de " + estudanteLogado.getCurso() + "!",
                estudanteLogado
        );
        estudanteLogado.publicar(postComunidade);
        comunidade.criarPublicacao(postComunidade);

        System.out.println("Membros da comunidade \"" + comunidade.getNome() + "\":");
        for (Estudante membro : comunidade.listarMembros()) {
            System.out.println("- " + membro.getNome());
        }

        System.out.println("\n=== Fim da simulação do CampusNet ===");
    }
}