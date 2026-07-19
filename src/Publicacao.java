import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacao {
    private static int contadorId = 1;

    private int id;
    private String texto;
    private Estudante autor;
    private LocalDateTime dataDePublicacao;
    private List<Comentario> comentarios;
    private List<Curtida> curtidas;
    private List<Compartilhamento> compartilhamentos;

    public Publicacao(String texto, Estudante autor) {
        this.id = contadorId++;
        this.texto = texto;
        this.autor = autor;
        this.dataDePublicacao = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
        this.curtidas = new ArrayList<>();
        this.compartilhamentos = new ArrayList<>();
    }

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

    public List<Interacao> listarInteracoes() {
        List<Interacao> todas = new ArrayList<>();
        todas.addAll(comentarios);
        todas.addAll(curtidas);
        todas.addAll(compartilhamentos);
        return todas;
    }

    public void exibirTodasInteracoes() {
        List<Interacao> interacoes = listarInteracoes();
        if (interacoes.isEmpty()) {
            System.out.println("Nenhuma interação nesta publicação ainda.");
            return;
        }
        for (Interacao interacao : interacoes) {
            interacao.exibirResumo();
        }
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public Estudante getAutor() { return autor; }
    public LocalDateTime getDataPublicacao() { return dataDePublicacao; }
    public List<Comentario> getComentarios() { return comentarios; }
}