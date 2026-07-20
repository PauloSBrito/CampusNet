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
            boolean primeiraLinha = true; // Para pular o cabeçalho (id,nome,curso,matricula)

            while ((linha = br.readLine()) != null) {
                // Remove o caractere invisível UTF-8 BOM, se existir
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
}