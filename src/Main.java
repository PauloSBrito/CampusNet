import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lista global para armazenar os estudantes carregados do CSV
        List<Estudante> baseEstudantes = new ArrayList<>();
        String caminhoArquivo = "estudantes.csv";

        System.out.println("=== CAMPUSNET: Inicializando Sistema ===");
        System.out.println("Carregando banco de dados de estudantes...");

        // Bloco try-with-resources para garantir que o arquivo seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                // Ignora linhas em branco ou cabeçalhos se houver
                if (linha.trim().isEmpty()) continue;

                // Separa os dados usando a vírgula como delimitador
                String[] dados = linha.split(",");

                // Faz o parsing (conversão) dos tipos primitivos
                int id = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                int idade = Integer.parseInt(dados[2].trim());
                String curso = dados[3].trim();
                String matricula = dados[4].trim();

                // Instancia o Estudante e adiciona na lista (inicialmente sem Conta)
                Estudante estudante = new Estudante(id, nome, idade, curso, matricula);
                baseEstudantes.add(estudante);
            }
            System.out.println("Sucesso! " + baseEstudantes.size() + " estudantes carregados.");

        } catch (IOException e) {
            System.err.println("Erro crítico ao ler o arquivo CSV: " + e.getMessage());
            return; // Encerra o programa se o banco de dados não carregar
        }

        // =========================================================================
        // FLUXO PRINCIPAL DO PROGRAMA (Simulação Interativa)
        // =========================================================================
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- BEM-VINDO AO CAMPUSNET ---");
        System.out.print("Digite o seu número de matrícula para entrar: ");
        String matriculaDigitada = teclado.nextLine();

        // Busca o estudante na lista pela matrícula fornecida
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

        // Verifica se ele precisa criar uma conta para usar a rede social
        if (!estudanteLogado.temConta()) {
            System.out.println("Detectamos que você ainda não possui um perfil ativo no CampusNet.");
            System.out.print("Deseja criar sua conta de acesso agora? (S/N): ");
            String resposta = teclado.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                // Executa o método criado anteriormente que usa os IDs automáticos!
                estudanteLogado.criarConta();
            } else {
                System.out.println("É necessário uma conta ativa para interagir. Até logo!");
                return;
            }
        }

        // =========================================================================
        // SIMULAÇÃO DE INTERAÇÃO SOCIAL (Demonstração da Orientação a Objetos)
        // =========================================================================
        System.out.println("\n--- MURAL DE INTERAÇÕES (SIMULAÇÃO) ---");

        // Pega um outro estudante qualquer da lista para interagir (Ex: o primeiro da lista)
        Estudante outroEstudante = baseEstudantes.get(0);

        // Evita interagir consigo mesmo na simulação
        if (outroEstudante.getId() == estudanteLogado.getId() && baseEstudantes.size() > 1) {
            outroEstudante = baseEstudantes.get(1);
        }

        // 1. O estudante logado começa a seguir o colega
        estudanteLogado.seguir(outroEstudante);

        // 2. O colega cria uma publicação na rede
        Publicacao postColega = new Publicacao("Estudando para a prova de Programação 2! Socorro!", outroEstudante);
        outroEstudante.publicar(postColega);

        // 3. O estudante logado interage com o post do colega
        System.out.print("\nDeseja curtir a publicação de " + outroEstudante.getNome() + "? (S/N): ");
        if (teclado.nextLine().equalsIgnoreCase("S")) {
            estudanteLogado.curtirPublicacao(postColega);
        }

        System.out.print("Digite um comentário para o post dele: ");
        String textoComentario = teclado.nextLine();
        estudanteLogado.comentar(postColega, textoComentario);

        System.out.println("\n=== Fim da simulação do CampusNet ===");
    }
}
