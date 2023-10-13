import java.util.Comparator;

public class ComparaNascimento implements Comparator<Contato> {
    @Override
    public int compare(Contato o1, Contato o2) {
        return o1.getDataNascimento().compareTo(o2.getDataNascimento());
    }
}
