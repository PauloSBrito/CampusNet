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

    // Agora bate com o diagrama: criarConta(conta: Conta): void
    // Quem monta a Conta (lê do teclado) é o Main; o model só recebe e valida.
    public void criarConta(Conta conta){
        if (temConta()) {
            System.out.println("Este estudante já possui uma conta cadastrada no CampusNet!");
            return;
        }
        this.conta = conta;
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
