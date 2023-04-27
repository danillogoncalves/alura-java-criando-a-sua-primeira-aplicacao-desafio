import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String name = "Jacqueline Oliveira";
        String accountType = "Corrente";
        double balance = 2500;
        double enteredValue;
        int operation = 0;
        String currentBalanceMessage = "Seu saldo atual é de R$ %.2f";
        String updatedBalanceMessage = "Saldo atualizado R$ %.2f";

        String initialMessage = """
                ***********************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo conta: %s
                Saldo inicial: R$ %.2f
                ***********************""";

        String menu = """
                \nOperações
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                                
                Digite a opção desejada:""";

        System.out.printf((initialMessage) + "%n", name, accountType, balance);

        while (operation != 4) {
            System.out.println(menu);
            operation = reader.nextInt();
            switch (operation) {
                case 1 -> {
                    String queryMessage = currentBalanceMessage.formatted(balance);
                    System.out.println(queryMessage);
                }
                case 2 -> {
                    System.out.println("Informe o valor a receber:");
                    balance += reader.nextDouble();
                    String receiptMessage = updatedBalanceMessage.formatted(balance);
                    System.out.println(receiptMessage);
                }
                case 3 -> {
                    System.out.println("Informe o valor que deseja transferir:");
                    enteredValue = reader.nextDouble();
                    if (enteredValue > balance) {
                        System.out.println("Não há saldo suficiente para fazer essa transferência");
                        break;
                    }
                    balance -= enteredValue;
                    String receiptMessage = updatedBalanceMessage.formatted(balance);
                    System.out.println(receiptMessage);
                }
                case 4 -> System.out.println("Obrigado por utilizar nossos serviços!");
                default -> System.out.println("Opção inválida");
            }
        }

    }
}
