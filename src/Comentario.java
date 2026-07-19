import java.time.LocalDateTime;

public class Comentario implements Interacao{
    private static int contadorId = 1;

    private int id;
    private String texto;
    private Estudante autor;
    private Publicacao publicacao;
    private LocalDateTime dataComentario;

    public Comentario(String texto, Estudante autor, Publicacao publicacao) {
        this.id = contadorId++;
        this.texto = texto;
        this.autor = autor;
        this.publicacao = publicacao;
        this.dataComentario = LocalDateTime.now();
    }

    // --- Métodos do Diagrama ---

    public void editarTexto(String novoTexto) {
        this.texto = novoTexto;
        System.out.println("Comentário editado.");
    }

    public void apagarTexto() {
        this.texto = "[Comentário removido]";
        System.out.println("O texto do comentário foi apagado.");
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getTexto() { return texto; }
    public Estudante getAutor() { return autor; }

    // --- Implementação de Interacao ---
    @Override
    public Estudante getEstudante() { return autor; }

    @Override
    public LocalDateTime getData() { return dataComentario; }

    @Override
    public void exibirResumo() {
        System.out.println("[Comentário] " + autor.getNome() + ": \"" + texto + "\"");
    }
}
