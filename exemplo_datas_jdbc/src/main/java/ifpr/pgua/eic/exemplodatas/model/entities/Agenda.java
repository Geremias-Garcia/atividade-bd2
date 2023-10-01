package ifpr.pgua.eic.exemplodatas.model.entities;

public class Agenda {
    
    private int codigo;
    private String nome;
    private String email;
    private int telefone;

    public Agenda(String nome) {
        this.nome = nome;
    }

    public Agenda(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }


    public Agenda(int codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }
    
    public Agenda(int codigo, String nome, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Agenda(String nome, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return codigo+" - "+nome;
    }
}