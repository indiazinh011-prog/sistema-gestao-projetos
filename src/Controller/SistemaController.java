package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaController {

    private List<Projeto> projetos = new ArrayList<>();
    private List<Colaborador> colaboradores = new ArrayList<>();

    // ==================== COLABORADOR =======================

    public boolean criarColaborador(String nome, String cargo) {
        if (nome == null || nome.isBlank() || cargo == null || cargo.isBlank()) {
            return false;
        }

        Colaborador c = new Colaborador(colaboradores.size() + 1, nome.trim(), cargo.trim());
        colaboradores.add(c);
        return true;
    }

    public List<Colaborador> listarColaboradores() {
        return Collections.unmodifiableList(colaboradores);
    }

    public Colaborador buscarColaborador(int id) {
        for (Colaborador c : colaboradores) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // ====================== PROJETO ==========================

    public boolean criarProjeto(String nome, String descricao, String prazo) {
        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()
            || prazo == null || prazo.isBlank()) {
            return false;
        }

        Projeto p = new Projeto(projetos.size() + 1, nome.trim(), descricao.trim(), prazo.trim());
        projetos.add(p);
        return true;
    }

    public List<Projeto> listarProjetos() {
        return Collections.unmodifiableList(projetos);
    }

    public Projeto buscarProjeto(int index) {
        if (index >= 0 && index < projetos.size()) {
            return projetos.get(index);
        }

        return null;
    }

    // ========================= TAREFA ==========================

    public boolean criarTarefa(int projetoIndex, String nome, String descricao, String prazo, int colaboradorId) {
        Projeto projeto = buscarProjeto(projetoIndex);
        Colaborador colaborador = buscarColaborador(colaboradorId);

        if (projeto == null || colaborador == null) {
            return false;
        }

        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()
            || prazo == null || prazo.isBlank()) {
            return false;
        }

        Tarefa t = new Tarefa(
            projeto.getTarefas().size() + 1,
            nome.trim(),
            descricao.trim(),
            prazo.trim(),
            colaborador
        );
        projeto.adicionarTarefa(t);
        return true;
    }
}
