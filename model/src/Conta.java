public class Conta {
    private static int contadorId = 1;

    private int id;
    private String emailAcademico;
    private String senha;
    private String numeroTelefonico;
    private String grauAcademico;
    private boolean status;

    public Conta(String emailAcademico, String senha, String numeroTelefonico, String grauAcademico, boolean status) {
        this.id = contadorId;
        contadorId++;

        this.emailAcademico = emailAcademico;
        this.senha = senha;
        this.numeroTelefonico = numeroTelefonico;
        this.grauAcademico = grauAcademico;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getEmailAcademico() {
        return emailAcademico;
    }

    public void setEmailAcademico(String emailAcademico) {
        this.emailAcademico = emailAcademico;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean validarEmail(String validacao) {
        // Exemplo simples de regra: e-mail deve conter o domínio da universidade
        return this.emailAcademico.contains("@") && this.emailAcademico.endsWith(".edu.br");
    }

    public boolean validarTelefone(String telefone) {
        // Validação básica de tamanho de número telefônico
        return telefone != null && telefone.length() >= 10;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso!");
    }

    public void desativarConta() {
        this.ativa = false;
        System.out.println("Conta desativada.");
    }

    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

}
