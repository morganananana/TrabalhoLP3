import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    Contato(String nome, String telefone, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.dataNascimento = dataNascimento;
    }

//    @Override
//    public String toString() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        return dateFormat.format(dataNascimento);
//    }
}

