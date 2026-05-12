package View;
import Controller.SistemaController;
import Model.Equipe;
import Model.Usuario;
import java.util.List;
import java.util.Scanner;
public class EquipeView {
    private final SistemaController controller;
    private final Scanner scanner;
    public EquipeView(SistemaController controller, Scanner scanner) { this.controller = controller; this.scanner = scanner; }
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== EQUIPES =====");
            System.out.println("1. Criar equipe");
            System.out.println("2. Adicionar membro à equipe");
            System.out.println("3. Listar equipes");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> criarEquipe();
                case 2 -> adicionarMembro();
                case 3 -> listarEquipes();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    private void criarEquipe() {
        System.out.println("\n--- Criar Equipe ---");
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Descrição: "); String descricao = scanner.nextLine().trim();
        boolean sucesso = controller.criarEquipe(nome, descricao);
        if (sucesso) System.out.println("✔ Equipe criada com sucesso!");
        else System.out.println("✘ Erro: nome e descrição são obrigatórios.");
    }
    private void adicionarMembro() {
        List<Equipe> equipes = controller.listarEquipes();
        if (equipes.isEmpty()) { System.out.println("\nNenhuma equipe cadastrada."); return; }
        System.out.println("\n--- Equipes disponíveis ---");
        for (Equipe e : equipes) System.out.printf("ID: %d | %s%n", e.getId(), e.getNome());
        System.out.print("ID da equipe: "); int equipeId = lerInt();
        List<Usuario> usuarios = controller.listarUsuarios();
        if (usuarios.isEmpty()) { System.out.println("\nNenhum usuário cadastrado."); return; }
        System.out.println("\n--- Usuários disponíveis ---");
        for (Usuario u : usuarios) System.out.printf("ID: %d | %s | %s%n", u.getId(), u.getNome(), u.getPerfil());
        System.out.print("ID do usuário: "); int usuarioId = lerInt();
        boolean sucesso = controller.adicionarMembroEquipe(equipeId, usuarioId);
        if (sucesso) System.out.println("✔ Membro adicionado com sucesso!");
        else System.out.println("✘ Erro: equipe ou usuário não encontrado.");
    }
    private void listarEquipes() {
        List<Equipe> equipes = controller.listarEquipes();
        if (equipes.isEmpty()) { System.out.println("\nNenhuma equipe cadastrada."); return; }
        System.out.println("\n--- Lista de Equipes ---");
        for (Equipe e : equipes) {
            System.out.printf("ID: %d | %s | %s%n", e.getId(), e.getNome(), e.getDescricao());
            for (Usuario u : e.getMembros()) System.out.printf("   → %s (%s)%n", u.getNome(), u.getPerfil());
        }
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) { return -1; }
    }
}
