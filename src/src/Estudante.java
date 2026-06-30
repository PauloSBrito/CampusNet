public class Estudante {
    protected int id;
    protected String nome;
    protected int idade;
    protected String curso;
    protected String matricula;
    protected Conta conta;

    public Estudante(int id, String nome, int idade, String curso, String matricula, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.matricula = matricula;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void criarConta(Conta conta){
    }
}
