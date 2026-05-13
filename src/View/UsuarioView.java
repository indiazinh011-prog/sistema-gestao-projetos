package View;
import Controller.SistemaController;
import Model.Usuario;
import java.util.List;
import java.util.Scanner;
public class UsuarioView {
    private final SistemaController controller;
    private final Scanner scanner;
    public UsuarioView(SistemaController controller, Scanner scanner) { this.controller = controller; this.scanner = scanner; }
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== USUÁRIOS =====");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> listarUsuarios();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    private void cadastrarUsuario() {
        System.out.println("\n--- Cadastrar Usuário ---");
        System.out.print("Nome completo: "); String nome = scanner.nextLine().trim();
        System.out.print("CPF: "); String cpf = scanner.nextLine().trim();
        System.out.print("E-mail: "); String email = scanner.nextLine().trim();
        System.out.print("Cargo: "); String cargo = scanner.nextLine().trim();
        System.out.print("Login: "); String login = scanner.nextLine().trim();
        System.out.print("Senha: "); String senha = scanner.nextLine().trim();
        System.out.print("Perfil (ADMINISTRADOR / GERENTE / COLABORADOR): "); String perfil = scanner.nextLine().trim();
        boolean sucesso = controller.criarUsuario(nome, cpf, email, cargo, login, senha, perfil);
        if (sucesso) System.out.println("✔ Usuário cadastrado com sucesso!");
        else System.out.println("✘ Erro: verifique os campos e o perfil informado.");
    }
    private void listarUsuarios() {
        List<Usuario> usuarios = controller.listarUsuarios();
        if (usuarios.isEmpty()) { System.out.println("\nNenhum usuário cadastrado."); return; }
        System.out.println("\n--- Lista de Usuários ---");
        for (Usuario u : usuarios)
            System.out.printf("ID: %d | %s | %s | %s | Perfil: %s%n", u.getId(), u.getNome(), u.getCpf(), u.getEmail(), u.getPerfil());
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) { return -1; }
    }
}
