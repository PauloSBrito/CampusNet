import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    // Carrega o "banco de dados" em memória diretamente via DataSeeder
    private static List<Estudante> baseEstudantes = DataSeeder.carregarEstudantesDoCSV("estudantes.csv");
    private static List<Publicacao> feed = DataSeeder.carregarPublicacoesIniciais(baseEstudantes);
    private static List<Comunidade> comunidades = new ArrayList<>();

    public static void main(String[] args) {

        Estudante estudanteLogado = fazerLogin();
        if (estudanteLogado == null) {
            return;
        }

        garantirConta(estudanteLogado);

        menuUsuarioLogado(estudanteLogado);

        System.out.println("\n=== Fim da sessão no CampusNet ===");
    }

    // ==================== LOGIN / CONTA ====================

    private static Estudante fazerLogin() {
        System.out.println("\n--- BEM-VINDO AO CAMPUSNET ---");
        System.out.print("Digite o seu número de matrícula para entrar: ");

        // Remove espaços e caracteres de controle invisíveis
        String matriculaDigitada = teclado.nextLine().replaceAll("[^a-zA-Z0-9]", "").trim();

        for (Estudante est : baseEstudantes) {
            // Garante que a matrícula armazenada também seja limpa antes de comparar
            String matriculaCadastrada = est.getMatricula().replaceAll("[^a-zA-Z0-9]", "").trim();

            if (matriculaCadastrada.equalsIgnoreCase(matriculaDigitada)) {
                System.out.println("\nOlá, " + est.getNome() + " (" + est.getCurso() + ")!");
                return est;
            }
        }

        System.out.println("\n[!] Matrícula não encontrada.");
        System.out.println("Lista de matrículas disponíveis para teste:");
        for (Estudante est : baseEstudantes) {
            System.out.println(" - " + est.getNome() + " | Matrícula: " + est.getMatricula());
        }

        return null;
    }

    private static void garantirConta(Estudante estudante) {
        if (estudante.temConta()) {
            return;
        }

        System.out.println("Detectamos que você ainda não possui um perfil ativo no CampusNet.");
        System.out.print("Deseja criar sua conta de acesso agora? (S/N): ");
        String resposta = teclado.nextLine();

        if (!resposta.equalsIgnoreCase("S")) {
            System.out.println("É necessário uma conta ativa para interagir. Até logo!");
            System.exit(0);
        }

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
        estudante.criarConta(novaConta);
    }

    // ==================== MENU DO USUÁRIO LOGADO ====================

    private static void menuUsuarioLogado(Estudante estudanteLogado) {
        int opcao;
        do {
            System.out.println("\n=========================================");
            System.out.println("   CampusNet - Logado como: " + estudanteLogado.getNome());
            System.out.println("=========================================");
            System.out.println("1 - Ver Feed (publicações)");
            System.out.println("2 - Fazer uma publicação");
            System.out.println("3 - Seguir um colega");
            System.out.println("4 - Comunidades");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> verFeed(estudanteLogado);
                case 2 -> fazerPublicacao(estudanteLogado);
                case 3 -> seguirColega(estudanteLogado);
                case 4 -> menuComunidades(estudanteLogado);
                case 0 -> System.out.println("Saindo... até logo, " + estudanteLogado.getNome() + "!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // ==================== FEED / PUBLICAÇÕES ====================

    private static void fazerPublicacao(Estudante autor) {
        System.out.print("\nDigite o texto da sua publicação: ");
        String texto = teclado.nextLine();

        Publicacao publicacao = new Publicacao(texto, autor);
        feed.add(publicacao);
        autor.publicar(publicacao);
    }

    private static void verFeed(Estudante estudanteLogado) {
        System.out.println("\n--- FEED DE PUBLICAÇÕES ---");

        if (feed.isEmpty()) {
            System.out.println("Nenhuma publicação por aqui ainda. Que tal ser o primeiro a postar?");
            return;
        }

        for (int i = 0; i < feed.size(); i++) {
            Publicacao p = feed.get(i);
            System.out.println((i + 1) + " - " + p.getAutor().getNome() + ": \"" + p.getTexto() + "\""
                    + " (curtidas: " + p.obterTotalCurtidas() + ", comentários: " + p.getComentarios().size() + ")");
        }

        System.out.print("\nDigite o número da publicação para interagir (0 para voltar): ");
        int escolha = lerInteiro();

        if (escolha == 0) return;
        if (escolha < 1 || escolha > feed.size()) {
            System.out.println("Publicação inválida.");
            return;
        }

        interagirComPublicacao(feed.get(escolha - 1), estudanteLogado);
    }

    private static void interagirComPublicacao(Publicacao publicacao, Estudante estudanteLogado) {
        int opcao;
        do {
            System.out.println("\n--- Publicação de " + publicacao.getAutor().getNome() + " ---");
            System.out.println("\"" + publicacao.getTexto() + "\"");
            System.out.println("1 - Curtir");
            System.out.println("2 - Comentar");
            System.out.println("3 - Compartilhar");
            System.out.println("4 - Ver todas as interações");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> estudanteLogado.curtirPublicacao(publicacao);
                case 2 -> {
                    System.out.print("Digite seu comentário: ");
                    String texto = teclado.nextLine();
                    estudanteLogado.comentar(publicacao, texto);
                }
                case 3 -> {
                    System.out.print("Digite uma legenda para o compartilhamento: ");
                    String legenda = teclado.nextLine();
                    estudanteLogado.compartilhar(publicacao, legenda);
                }
                case 4 -> publicacao.exibirTodasInteracoes();
                case 0 -> System.out.println("Voltando ao feed...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // ==================== SEGUIR ====================

    private static void seguirColega(Estudante estudanteLogado) {
        System.out.println("\n--- SEGUIR UM COLEGA ---");
        List<Estudante> outros = new ArrayList<>();

        for (Estudante est : baseEstudantes) {
            if (est.getId() != estudanteLogado.getId()) {
                outros.add(est);
                System.out.println(outros.size() + " - " + est.getNome() + " (" + est.getCurso() + ")");
            }
        }

        if (outros.isEmpty()) {
            System.out.println("Não há outros estudantes cadastrados.");
            return;
        }

        System.out.print("Digite o número do colega para seguir (0 para voltar): ");
        int escolha = lerInteiro();

        if (escolha == 0) return;
        if (escolha < 1 || escolha > outros.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        estudanteLogado.seguir(outros.get(escolha - 1));
    }

    // ==================== COMUNIDADES ====================

    private static void menuComunidades(Estudante estudanteLogado) {
        int opcao;
        do {
            System.out.println("\n--- COMUNIDADES ---");
            System.out.println("1 - Ver comunidades existentes");
            System.out.println("2 - Criar nova comunidade");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> verComunidades(estudanteLogado);
                case 2 -> criarComunidade(estudanteLogado);
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void criarComunidade(Estudante criador) {
        System.out.print("\nNome da comunidade: ");
        String nome = teclado.nextLine();
        System.out.print("Descrição: ");
        String descricao = teclado.nextLine();

        Comunidade comunidade = new Comunidade(nome, descricao, criador);
        comunidades.add(comunidade);
        System.out.println("Comunidade \"" + nome + "\" criada com sucesso!");
    }

    private static void verComunidades(Estudante estudanteLogado) {
        if (comunidades.isEmpty()) {
            System.out.println("Nenhuma comunidade criada ainda.");
            return;
        }

        for (int i = 0; i < comunidades.size(); i++) {
            Comunidade c = comunidades.get(i);
            System.out.println((i + 1) + " - " + c.getNome() + " (" + c.listarMembros().size() + " membros)");
        }

        System.out.print("\nDigite o número da comunidade (0 para voltar): ");
        int escolha = lerInteiro();

        if (escolha == 0) return;
        if (escolha < 1 || escolha > comunidades.size()) {
            System.out.println("Comunidade inválida.");
            return;
        }

        interagirComComunidade(comunidades.get(escolha - 1), estudanteLogado);
    }

    private static void interagirComComunidade(Comunidade comunidade, Estudante estudanteLogado) {
        int opcao;
        do {
            System.out.println("\n--- " + comunidade.getNome() + " ---");
            System.out.println("1 - Entrar na comunidade");
            System.out.println("2 - Postar na comunidade");
            System.out.println("3 - Ver membros");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> comunidade.adicionarMembro(estudanteLogado);
                case 2 -> {
                    System.out.print("Texto da publicação: ");
                    String texto = teclado.nextLine();
                    Publicacao publicacao = new Publicacao(texto, estudanteLogado);
                    estudanteLogado.publicar(publicacao);
                    comunidade.criarPublicacao(publicacao);
                    feed.add(publicacao);
                }
                case 3 -> {
                    System.out.println("Membros:");
                    for (Estudante membro : comunidade.listarMembros()) {
                        System.out.println("- " + membro.getNome());
                    }
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // ==================== UTILITÁRIO DE ENTRADA ====================

    private static int lerInteiro() {
        while (!teclado.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            teclado.next();
        }
        int valor = teclado.nextInt();
        teclado.nextLine(); // limpa o \n pendente
        return valor;
    }
}