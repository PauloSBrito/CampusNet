public class Conta {
    private int id;
    private String emailAcademico;
    private String senha;
    private String numeroTelefonico;
    private String grauAcademico;
    private boolean status;

    public Conta(int id, String emailAcademico, String senha, String numeroTelefonico, String grauAcademico, boolean status) {
        this.id = id;
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


}
