import java.time.LocalDateTime;

public interface Interacao {
        Estudante getEstudante();
        LocalDateTime getData();

        void exibirResumo();
}
