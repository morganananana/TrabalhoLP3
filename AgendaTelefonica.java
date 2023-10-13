import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

public class AgendaTelefonica {
    ArrayList<Contato> contatos = new ArrayList<>();

    public void listaRegistro() {
        ComparaContato c = new ComparaContato();
        Collections.sort(contatos, c);
        System.out.println("----------------------------------------");
        System.out.println("Lista de registros em ordem alfabética: ");
        for (Contato contato : contatos) {
            System.out.println("----------------------------------------");
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Data de nascimento: " + contato.getDataNascimento());
            System.out.println("----------------------------------------");
        }
    }

    public boolean adicionarRegistro(Contato contato) {

        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                System.out.println("Esse contato já existe!");
                return false;
            }
        }
        System.out.println("Contato adicionado com sucesso!");
        contatos.add(contato);
        return true;
    }

    public boolean excluirRegistro(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(c);
                System.out.println("Contato removido com sucesso!");
                return true;
            }
        }
        System.out.println("Esse contato não existe!");
        return false;
    }

    public void aniversariantes() {
        LocalDate hoje = LocalDate.now();
        boolean aniversariante = false;
        for (Contato contato : contatos) {
            if (contato.getDataNascimento().getDayOfMonth() == hoje.getDayOfMonth() && contato.getDataNascimento().getMonth() == hoje.getMonth()) {
                aniversariante = true;
                System.out.println("Aniversariante(s) do dia: ");
                System.out.println("Parabéns " + contato.getNome() + "!");
            }
        }
        if (aniversariante == false) {
            System.out.println("Não há aniversariantes hoje!");
        }
    }


    public void listaDataNascimento() {
        ComparaNascimento c = new ComparaNascimento();
        Collections.sort(contatos, c);
        System.out.println("Lista de registros em ordem de nascimento: ");
        for (Contato contato : contatos) {
            System.out.println("----------------------------------------");
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Data de nascimento: " + contato.getDataNascimento());
            System.out.println("----------------------------------------");
        }
    }

    public void listaEmail() {
        ComparaEmail c = new ComparaEmail();
        Collections.sort(contatos, c);
        System.out.println("Lista de registros em ordem de nascimento: ");
        for (Contato contato : contatos) {
            System.out.println("----------------------------------------");
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Data de nascimento: " + contato.getDataNascimento());
            System.out.println("----------------------------------------");
        }
    }

    public Contato procurarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato encontrado: ");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
                System.out.println("E-mail: " + contato.getEmail());
                System.out.println("Data de nascimento: " + contato.getDataNascimento());
                return contato;
            }
        }
        return null;
    }
}