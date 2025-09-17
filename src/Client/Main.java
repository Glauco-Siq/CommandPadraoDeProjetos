package Client;
import java.util.Scanner;
import Receiver.*;
import Invoker.*;
import ConcreteCommands.*;

public class Main {
    public static void main(String[] args) {
        EditorDeTexto editor = new EditorDeTexto();
        GerenciadorDeAcoes gerenciador = new GerenciadorDeAcoes();
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("--- Editor de Texto Interativo ---");
        System.out.println("Opções:");
        System.out.println("1 - Digitar texto");
        System.out.println("2 - Apagar caracteres");
        System.out.println("z - Desfazer (Undo)");
        System.out.println("y - Refazer (Redo)");
        System.out.println("s - Sair");
        System.out.println("---------------------------------");

        do {
            System.out.print("\nDigite sua opção: ");
            entrada = scanner.nextLine();

            switch (entrada.toLowerCase()) {
                case "1":
                    System.out.print("Digite o texto a ser adicionado: ");
                    String texto = scanner.nextLine();
                    gerenciador.executar(new DigitarCommand(editor, texto));
                    break;

                case "2":
                    System.out.print("Quantos caracteres deseja apagar? ");
                    try {
                        int num = Integer.parseInt(scanner.nextLine());
                        gerenciador.executar(new ApagarCommand(editor, num));
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número.");
                    }
                    break;

                case "z":
                    gerenciador.desfazer();
                    break;

                case "y":
                    gerenciador.refazer();
                    break;

                case "s":
                    System.out.println("Saindo do editor. Adeus!");
                    break;

                default:
                    System.out.println("Opção desconhecida. Tente novamente.");
                    break;
            }

        } while (!entrada.equalsIgnoreCase("s"));

        scanner.close();
    }
}

