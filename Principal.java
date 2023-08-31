import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        String opcao = "";

        System.out.println("Seja bem vindo ao 'Busca CEP'\n" +
                "Aqui você não se perde!");

        do {
            System.out.println("Digite o CEP que deseja pesquisar ou digite 'sair' para finalizar:");
            opcao = leitura.nextLine();

            if (!opcao.equalsIgnoreCase("sair")) {
                try {
                    Endereco novoEndereco = consultaCep.buscaEndereco(opcao);
                    System.out.println(novoEndereco);
                    GeradorJson gerador = new GeradorJson();
                    gerador.SalvaJson(novoEndereco);
                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (!opcao.equalsIgnoreCase("sair"));

        System.out.println("Finalizando a aplicação");
    }
}
