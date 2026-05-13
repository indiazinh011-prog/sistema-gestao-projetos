package Controller;
import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SistemaController {
    private List<Projeto> projetos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Equipe> equipes = new ArrayList<>();
    public boolean criarUsuario(String nome, String cpf, String email, String cargo, String login, String senha, String perfil) {
        if (nome == null || nome.isBlank() || cpf == null || cpf.isBlank() || email == null || email.isBlank()
            || cargo == null || cargo.isBlank() || login == null || login.isBlank()
            || senha == null || senha.isBlank() || perfil == null || perfil.isBlank()) return false;
        Perfil p;
        try { p = Perfil.valueOf(perfil.toUpperCase()); }
        catch (IllegalArgumentException e) { return false; }
        usuarios.add(new Usuario(usuarios.size() + 1, nome.trim(), cpf.trim(), email.trim(), cargo.trim(), login.trim(), senha.trim(), p));
        return true;
    }
    public List<Usuario> listarUsuarios() { return Collections.unmodifiableList(usuarios); }
    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) if (u.getId() == id) return u;
        return null;
    }
    public boolean criarProjeto(String nome, String descricao, String dataInicio, String dataTermino, int gerenteId) {
        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()
            || dataInicio == null || dataInicio.isBlank() || dataTermino == null || dataTermino.isBlank()) return false;
        Usuario gerente = buscarUsuario(gerenteId);
        if (gerente == null) return false;
        projetos.add(new Projeto(projetos.size() + 1, nome.trim(), descricao.trim(), dataInicio.trim(), dataTermino.trim(), gerente));
        return true;
    }
    public List<Projeto> listarProjetos() { return Collections.unmodifiableList(projetos); }
    public Projeto buscarProjeto(int index) {
        if (index >= 0 && index < projetos.size()) return projetos.get(index);
        return null;
    }
    public boolean criarTarefa(int projetoIndex, String nome, String descricao, String prazo, int usuarioId) {
        Projeto projeto = buscarProjeto(projetoIndex);
        Usuario usuario = buscarUsuario(usuarioId);
        if (projeto == null || usuario == null) return false;
        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank() || prazo == null || prazo.isBlank()) return false;
        projeto.adicionarTarefa(new Tarefa(projeto.getTarefas().size() + 1, nome.trim(), descricao.trim(), prazo.trim(), usuario));
        return true;
    }
    public boolean criarEquipe(String nome, String descricao) {
        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank()) return false;
        equipes.add(new Equipe(equipes.size() + 1, nome.trim(), descricao.trim()));
        return true;
    }
    public boolean adicionarMembroEquipe(int equipeId, int usuarioId) {
        Equipe equipe = null;
        for (Equipe e : equipes) if (e.getId() == equipeId) { equipe = e; break; }
        Usuario usuario = buscarUsuario(usuarioId);
        if (equipe == null || usuario == null) return false;
        equipe.adicionarMembro(usuario);
        return true;
    }
    public List<Equipe> listarEquipes() { return Collections.unmodifiableList(equipes); }
}
