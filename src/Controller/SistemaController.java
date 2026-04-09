package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.List;

        public class SistemaController {

            private List<Projeto> projetos = new ArrayList<>();
            private List<Colaborador> colaboradores = new ArrayList<>();

            // ==================== COLABORADOR =======================

            public void criarColaborador(String nome, String cargo) {
                Colaborador c = new Colaborador(colaboradores.size() + 1, nome, cargo);
                colaboradores.add(c);
            }

            public List<Colaborador> listarColaboradores() {
                return colaboradores;
            }

            public Colaborador buscarColaborador(int id) {
                for (Colaborador c : colaboradores) {
                    if (c.getId() == id) return c;
                }
                return null;
            }

            // ====================== PROJETO ==========================

            public void criarProjeto(String nome, String descricao, String prazo) {
                Projeto p = new Projeto(projetos.size() + 1, nome, descricao, prazo);
                projetos.add(p);
            }

            public List<Projeto> listarProjetos() {
                return projetos;
            }

            public Projeto buscarProjeto(int index) {
                if (index >= 0 && index < projetos.size()) {
                    return projetos.get(index);
                }

                return null;
            }

            // ========================= TAREFA ==========================

            public void criarTarefa (int projetoIndex, String nome, String descricao, String prazo,int colaboradorId) {
                Projeto projeto = buscarProjeto(projetoIndex);
                Colaborador colaborador = buscarColaborador(colaboradorId);

                if (projeto != null && colaborador != null) {
                    Tarefa t= new Tarefa(projeto.getTarefas().size() + 1, nome,descricao,prazo,colaborador);
                    projeto.adicionarTarefa(t);
                }
            }

        }