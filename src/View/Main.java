package View;
import Controller.SistemaController;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        SistemaController controller = new SistemaController();
        Scanner scanner = new Scanner(System.in);
        UsuarioView usuarioView = new UsuarioView(controller, scanner);
        ProjetoView projetoView = new ProjetoView(controller, scanner);
        TarefaView tarefaView = new TarefaView(controller, scanner);
        EquipeView equipeView = new EquipeView(controller, scanner);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║  SISTEMA DE GESTÃO DE PROJETOS   ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Usuários                     ║");
            System.out.println("║  2. Projetos                     ║");
            System.out.println("║  3. Tarefas                      ║");
            System.out.println("║  4. Equipes                      ║");
            System.out.println("║  0. Sair                         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Opção: ");
            try { opcao = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { opcao = -1; }
            switch (opcao) {
                case 1 -> usuarioView.exibirMenu();
                case 2 -> projetoView.exibirMenu();
                case 3 -> tarefaView.exibirMenu();
                case 4 -> equipeView.exibirMenu();
                case 0 -> System.out.println("\nSistema encerrado. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
