import java.util.ArrayList;
import java.util.List;

public class Comunidade {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private String descricao;
    private Estudante criador;
    private List<Estudante> membros;
    private List<Publicacao> publicacoes;

    public Comunidade(String nome, String descricao, Estudante criador) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.membros = new ArrayList<>();
        this.publicacoes = new ArrayList<>();

        // O criador da comunidade entra automaticamente como primeiro membro
        this.membros.add(criador);
    }

    // --- Métodos do Diagrama ---

    public void adicionarMembro(Estudante estudante) {
        if (!membros.contains(estudante)) {
            membros.add(estudante);
            System.out.println(estudante.getNome() + " entrou na comunidade " + this.nome + "!");
        } else {
            System.out.println("Este estudante já é membro desta comunidade.");
        }
    }

    public void removerMembro(Estudante estudante) {
        if (membros.contains(estudante)) {
            membros.remove(estudante);
            System.out.println(estudante.getNome() + " saiu da comunidade " + this.nome + ".");
        } else {
            System.out.println("Estudante não pertence a esta comunidade.");
        }
    }

    public void criarPublicacao(Publicacao publicacao) {
        this.publicacoes.add(publicacao);
        System.out.println("Nova publicação postada no mural da comunidade " + this.nome + ".");
    }

    public List<Estudante> listarMembros() {
        return this.membros;
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getNome() { return nome; }
}
