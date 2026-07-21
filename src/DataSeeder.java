import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSeeder {

    public static List<Estudante> carregarEstudantesDoCSV(String caminhoArquivo) {
        List<Estudante> estudantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true; // Pula o cabeçalho de CSV

            while ((linha = br.readLine()) != null) {
                // Tratar entrada de dados UTF-8
                if (linha.startsWith("\uFEFF")) {
                    linha = linha.substring(1);
                }

                // Pula a linha do cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Pula linhas em branco
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Separa os valores pela vírgula
                String[] dados = linha.split(",");

                // 4 linhas do arquivo csv
                if (dados.length >= 4) {
                    try {
                        // mapear dados do arquivo csv
                        int id = Integer.parseInt(dados[0].trim());
                        String nome = dados[1].trim();
                        int idade = Integer.parseInt(dados[2].trim());
                        String curso = dados[3].trim();
                        String matricula = dados[4].trim();

                        // Instancia o estudante
                        Estudante estudante = new Estudante(id, nome, curso, matricula);
                        estudantes.add(estudante);
                    } catch (NumberFormatException e) {
                        System.err.println("Aviso: Falha ao converter ID para número na linha: " + linha);
                    }
                }
            }
            System.out.println("Sucesso: " + estudantes.size() + " estudantes carregados do CSV!");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return estudantes;

    }
    public static List<Publicacao> carregarPublicacoesIniciais (List<Estudante> estudantes) {
        List<Publicacao> feedInicial = new ArrayList<>();

        // Se por algum motivo a lista de estudantes estiver vazia, não cria os posts
        if (estudantes == null || estudantes.size() < 3) {
            return feedInicial;
        }

        // Pega alguns estudantes da lista do CSV para serem os autores/interagentes
        Estudante e1 = estudantes.get(0); // Ex: Ana Silva
        Estudante e2 = estudantes.get(1); // Ex: Carlos Eduardo
        Estudante e3 = estudantes.get(2); // Ex: Beatriz Lima

        // 1. Criar as Publicações
        Publicacao p1 = new Publicacao("Primeiro dia de aula no CampusNet! Ansioso para o semestre 🚀", e1);
        Publicacao p2 = new Publicacao("Alguém tem o resumo da aula de POO?", e2);

        // 2. Adicionar Comentários nas publicações
        Comentario c1 = new Comentario("Boa sorte no semestre, Ana!", e1, p1);
        Comentario c2 = new Comentario( "Seja bem-vinda!", e3, p1);
        Comentario c3 = new Comentario( "Tenho sim, Carlos! Te mando no grupo do curso.", e1, p2);

        p1.adicionarComentario(c1);
        p1.adicionarComentario(c2);
        p2.adicionarComentario(c3);

        // 3. Adicionar Curtidas
        Curtida curtida1 = new Curtida(e2, p1);
        Curtida curtida2 = new Curtida(e3, p1);
        Curtida curtida3 = new Curtida(e1, p2);

        p1.adicionarCurtida(curtida1);
        p1.adicionarCurtida(curtida2);
        p2.adicionarCurtida(curtida3);

        // 4. Guardar no feed inicial
        feedInicial.add(p1);
        feedInicial.add(p2);

        System.out.println("Sucesso: " + feedInicial.size() + " publicações iniciais geradas no feed!");

        return feedInicial;
    }
}