import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class TesteAgendaTelefonica {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("-----------AGENDA TELEFONICA-----------");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Listar por ordem alfabética");
            System.out.println("2- Listar por data de nascimento");
            System.out.println("3- Listar por e-mails");
            System.out.println("4- Listar o(s) aniversariante(s) do dia");
            System.out.println("5- Inserir registro");
            System.out.println("6- Remover um registro");
            System.out.println("7- Procurar um registro");
            System.out.println("8- Editar um registro");
            System.out.println("9- Encerrar o programa");
            System.out.println("----------------------------------------");

            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    agenda.listaRegistro();
                    break;
                case 2:
                    agenda.listaDataNascimento();
                    break;
                case 3:
                    agenda.listaEmail();
                    break;
                case 4:
                    agenda.aniversariantes();
                    break;
                case 5:
                    System.out.println("Digite o nome: ");
                    teclado.nextLine();
                    String nome = teclado.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = teclado.nextLine();
                    System.out.println("Digite o e-mail: ");
                    String email = teclado.nextLine();
                    System.out.println("Digite a data de nascimento(dia/mes/ano): ");
                    int dia = teclado.nextInt();
                    int mes = teclado.nextInt();
                    int ano = teclado.nextInt();
                    try {
                        LocalDate data = LocalDate.of(ano, mes, dia);
                        Contato contato = new Contato(nome, telefone, email, data);
                        agenda.adicionarRegistro(contato);
                    } catch (DateTimeException e) {
                        System.err.println("Erro: Verifique se você digitou corretamente a data de nascimento!");
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do contato que você deseja remover:");
                    teclado.nextLine();
                    String nomeC = teclado.nextLine();
                    agenda.excluirRegistro(nomeC);
                    break;
                case 7:
                    System.out.println("Digite o nome do contato que você quer procurar:");
                    teclado.nextLine();
                    String nomePC = teclado.nextLine();
                    Contato procurar = agenda.procurarContato(nomePC);
                    if (procurar == null) {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 8:
                    System.out.println("Digite o nome do contato que você quer editar: ");
                    teclado.nextLine();
                    String nomeEditar = teclado.nextLine();
                    Contato contatoEditar = agenda.procurarContato(nomeEditar);

                    if (contatoEditar != null) {
                        System.out.println("Digite o novo nome: ");
                        String nomeNovo = teclado.nextLine();
                        System.out.println("Digite o novo telefone: ");
                        String telefoneNovo = teclado.nextLine();
                        System.out.println("Digite o novo e-mail: ");
                        String emailNovo = teclado.nextLine();
                        System.out.println("Digite a nova data de nascimento (dia/mes/ano): ");
                        int diaNovo = teclado.nextInt();
                        int mesNovo = teclado.nextInt();
                        int anoNovo = teclado.nextInt();
                        if(!nomeNovo.equalsIgnoreCase(nomeEditar) && agenda.contatos.contains(nomeNovo)){
                            System.err.println("Esse contato já existe!");
                        }
                        try {
                            LocalDate dataNova = LocalDate.of(anoNovo, mesNovo, diaNovo);
                            Contato contato = new Contato(nomeNovo, telefoneNovo, emailNovo, dataNova);
                            contatoEditar.setNome(nomeNovo);
                            contatoEditar.setTelefone(telefoneNovo);
                            contatoEditar.setEmail(emailNovo);
                            contatoEditar.setDataNascimento(dataNova);
                            System.out.println("Registro editado com sucesso!");
                        } catch (DateTimeException e) {
                            System.err.println("Erro: Verifique se a data está correta (dia-mes-ano)!");
                        }
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 9:
                    System.out.println("programa encerrado!");
                    break;
                default:
                    System.err.println("opcao invalida!!");
                    break;
            }
        } while (opcao < 9);
    }
}


