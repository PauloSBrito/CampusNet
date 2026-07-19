import java.time.LocalDateTime;

public class Compartilhamento implements Interacao{
    private static int contadorId = 1;

    private int id;
    private Estudante estudante;
    private Publicacao publicacao;
    private LocalDateTime dataCompartilhamento;
    private String legenda;

    public Compartilhamento(Estudante estudante, Publicacao publicacao, String legenda) {
        this.id = contadorId++;
        this.estudante = estudante;
        this.publicacao = publicacao;
        this.dataCompartilhamento = LocalDateTime.now();
        this.legenda = legenda;
    }

    // --- Métodos do Diagrama ---

    public void compartilhar() {
        System.out.println(estudante.getNome() + " compartilhou o post de " +
                publicacao.getAutor().getNome() + " dizendo: \"" + legenda + "\"");
    }

    public void removerCompartilhamento() {
        System.out.println("Compartilhamento removido.");
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getLegenda() { return legenda; }


    // --- Implementação de Interacao ---
    @Override
    public Estudante getEstudante() { return estudante; }

    @Override
    public LocalDateTime getData() { return dataCompartilhamento; }

    @Override
    public void exibirResumo() {
        System.out.println("[Compartilhamento] " + estudante.getNome() + " compartilhou dizendo: \"" + legenda + "\"");
    }
}
