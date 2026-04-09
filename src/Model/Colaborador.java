package Model;

public class Colaborador {

    private int id;
    private String nome;
    private String cargo;

    public Colaborador (int id,String nome,String cargo) {
        this.id=id;
        this.nome=nome;
        this.cargo=cargo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCargo () { return cargo;}

    @Override
    public String toString () {
        return id + "_" + nome + "(" + cargo + ")";
    }

    }