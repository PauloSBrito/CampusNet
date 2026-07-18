import java.util.Scanner;

public class Estudante {
    protected int id;
    protected String nome;
    protected int idade;
    protected String curso;
    protected String matricula;
    protected Conta conta;

    public Estudante(int id, String nome, int idade, String curso, String matricula) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.matricula = matricula;
    }

    public Estudante(int id, String nome, int idade, String curso, String matricula, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.matricula = matricula;
        this.conta = conta;
    }

    // --- Getters e Setters de Estudante ---
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public String getMatricula() { return matricula; }
    public Conta getConta() { return conta; }
    public void setConta(Conta conta) { this.conta = conta; }

    public boolean temConta(){
        if (this.conta != null && this.conta.isStatus()) {
            return true;
        }
        return false;
    }

    public void criarConta(){
        // Verifica se o estudante já possui uma conta ativa
        if (temConta()) {
            System.out.println("Este estudante já possui uma conta cadastrada no CampusNet!");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Conta - CampusNet ===");

        System.out.print("Digite seu e-mail acadêmico: ");
        String email = scanner.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite um número telefônico: ");
        String numeroTelefonico = scanner.nextLine();

        System.out.print("Digite o seu grau acadêmico (Ex: Graduação, Mestrado): ");
        String grauAcademico = scanner.nextLine();

        // Instancia a nova conta usando os dados lidos.
        // O último parâmetro 'true' define que a conta inicia como ATIVA (conforme o diagrama).
        this.conta = new Conta(email, senha, numeroTelefonico, grauAcademico, true);

        System.out.println("Conta criada com sucesso para o estudante " + this.nome + "!");

    }

    public void seguir(Estudante outroEstudante) {
        System.out.println(this.nome + " começou a seguir " + outroEstudante.getNome() + "!");
    }

    public void publicar(Publicacao publicacao) {
        System.out.println(this.nome + " publicou: \"" + publicacao.getTexto() + "\"");
    }

    public Comentario comentar(Publicacao publicacao, String texto) {
        Comentario novoComentario = new Comentario(texto, this, publicacao);
        publicacao.adicionarComentario(novoComentario);
        System.out.println(this.nome + " comentou na publicação de " + publicacao.getAutor().getNome());
        return novoComentario;
    }

    public Curtida curtirPublicacao(Publicacao publicacao) {
        Curtida novaCurtida = new Curtida(this);
        publicacao.adicionarCurtida(novaCurtida);
        novaCurtida.registrarCurtida();
        return novaCurtida;
    }

    public Compartilhamento compartilhar(Publicacao publicacao, String legenda) {
        Compartilhamento novoCompartilhamento = new Compartilhamento(this, publicacao, legenda);
        publicacao.adicionarCompartilhamento(novoCompartilhamento);
        novoCompartilhamento.compartilhar();
        return novoCompartilhamento;
    }

}
