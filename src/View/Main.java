package View;

import Controller.SistemaController;
import Model.*;
import java.util.Scanner;

public class Main{

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaController controller = new SistemaController();

        int opcao;

        do {
            System.out.println("\n===MENU====");
            System.out.println("1-Cadastrar colaborador");
            System.out.println("2-Criar projeto");
            System.out.println("3-Criar tarefa");
            System.out.println("4-Listar projetos");
            System.out.println("5-Ver Progresso");
            System.out.println("6-Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Nome");
                    String nome = sc.nextLine();

                    System.out.println("Cargo");
                    String cargo = sc.nextLine();

                    controller.criarColaborador(nome, cargo);
                    break;

                case 2:
                    System.out.println("Nome do projeto");
                    String nomeProjeto = sc.nextLine();

                    System.out.println("Descricao: ");
                    String desc = sc.nextLine();

                    System.out.println("Prazo");
                    String prazo = sc.nextLine();

                    controller.criarProjeto(nomeProjeto, desc, prazo);
                    break;

                case 3:
                    System.out.println("Escolha o projeto (index): ");
                    for (int i = 0; i < controller.listarProjetos().size(); i++) {
                        System.out.println(i + "-" + controller.listarProjetos().get(i).getNome());
                    }
                    int ProjetoIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nome da tarefa:");
                    String nomeTarefa = sc.nextLine();

                    System.out.println("Descrição:");
                    String descTarefa = sc.nextLine();

                    System.out.println("Prazo:");
                    String prazoTarefa = sc.nextLine();

                    System.out.println("Escolha o colaborador (ID)");
                    for (Colaborador c : controller.listarColaboradores()) {
                        System.out.println(c);
                    }
                    int colaboradorId = sc.nextInt();

                    controller.criarTarefa(ProjetoIndex, nomeTarefa, descTarefa, prazoTarefa, colaboradorId);
                    break;

                case 4:
                    for (Projeto p : controller.listarProjetos()) {
                        System.out.println(p.getNome());
                    }
                    break;
                case 5:
                    for (Projeto p : controller.listarProjetos()) {
                        p.exibirProgresso();
                    }
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;
            }

        } while(opcao !=6);

        sc.close();
    }
}

