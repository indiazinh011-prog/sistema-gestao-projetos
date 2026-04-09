package Model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private int id;
    private String nome;
    private String descricao;
    private String prazo;
    private List<Tarefa>tarefas;

    public Projeto(int id, String nome,String descricao,String prazo) {
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.prazo=prazo;
        this.tarefas= new ArrayList<>();
    }
    public void adicionarTarefa(Tarefa t) {
        tarefas.add(t);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getNome() {
        return nome;
    }

    public void exibirProgresso () {
        int total = tarefas.size();
        int concluidas = 0;

        for (Tarefa t : tarefas) {
            if (t.getStatus().equalsIgnoreCase("Concluído")) {
            }
        }

        System.out.println(nome + " → " + concluidas + "/" + total + concluidas);
    }
}
