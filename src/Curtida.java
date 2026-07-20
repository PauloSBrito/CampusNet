import java.time.LocalDateTime;

public class Curtida implements Interacao{
    private static int contadorId = 1;

    private int id;
    private Estudante estudante;
    private Publicacao publicacao;
    private LocalDateTime dataCurtida;

    public Curtida(Estudante estudante) {
        this.id = contadorId++;
        this.estudante = estudante;
        this.dataCurtida = LocalDateTime.now();
    }

    // para que o método em Dataseeder funcione
    public Curtida(Estudante estudante, Publicacao publicacao) {
        this.id = contadorId++;
        this.estudante = estudante;
        this.publicacao = publicacao;
        this.dataCurtida = LocalDateTime.now();
    }

    // --- Métodos do Diagrama ---

    public void registrarCurtida() {
        System.out.println("Curtida registrada por " + estudante.getNome() + " em " + dataCurtida);
    }

    public void removerCurtida() {
        System.out.println("Curtida de " + estudante.getNome() + " removida.");
    }


    // --- Getters ---
    public int getId() { return id; }

    // --- Implementação de Interacao ---
    @Override
    public Estudante getEstudante() { return estudante; }

    @Override
    public LocalDateTime getData() { return dataCurtida; }

    @Override
    public void exibirResumo() {
        System.out.println("[Curtida] " + estudante.getNome() + " curtiu a publicação.");
    }
}
