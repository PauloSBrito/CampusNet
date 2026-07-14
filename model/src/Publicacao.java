import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacao {
    private static int contadorId = 1;

    private int id;
    private String texto;
    private Estudante autor;
    private LocalDateTime dataDePublicacao;
    private Comentario[] comentarios;
    private Curtida[] curtidas;
    private Compartilhamento[] compartilhamentos;

    public Publicacao(String texto, Estudante autor) {
        this.id = contadorId++;
        this.texto = texto;
        this.autor = autor;
        this.dataPublicacao = LocalDateTime.now(); // Define a data/hora atual da postagem
        this.comentarios = new ArrayList<>();
        this.curtidas = new ArrayList<>();
        this.compartilhamentos = new ArrayList<>();
    }

    // --- Métodos do Diagrama ---

    public void editarTexto(String novoTexto) {
        this.texto = novoTexto;
        System.out.println("Publicação atualizada.");
    }

    public void apagarPublicacao() {
        this.texto = "[Esta publicação foi apagada pelo autor]";
        this.comentarios.clear();
        this.curtidas.clear();
        this.compartilhamentos.clear();
        System.out.println("Conteúdo da publicação removido.");
    }

    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public void adicionarCurtida(Curtida curtida) {
        this.curtidas.add(curtida);
    }

    public void adicionarCompartilhamento(Compartilhamento compartilhamento) {
        this.compartilhamentos.add(compartilhamento);
    }

    public int obterTotalCurtidas() {
        return this.curtidas.size();
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getTexto() { return texto; }
    public Estudante getAutor() { return autor; }
    public LocalDateTime getDataPublicacao() { return dataPublicacao; }
    public List<Comentario> getComentarios() { return comentarios; }

}
