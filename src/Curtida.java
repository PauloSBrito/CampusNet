import java.time.LocalDateTime;

public class Curtida {
    private static int contadorId = 1;

    private int id;
    private Estudante estudante;
    private LocalDateTime dataCurtida;

    public Curtida(Estudante estudante) {
        this.id = contadorId++;
        this.estudante = estudante;
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
    public Estudante getEstudante() { return estudante; }
}
