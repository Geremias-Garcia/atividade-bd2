package ifpr.pgua.eic.exemplodatas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.daos.AgendaDao;
import ifpr.pgua.eic.exemplodatas.model.entities.Agenda;

public class RepositorioAgenda {

    private AgendaDao dao;

    public RepositorioAgenda(AgendaDao agendaDAO) {
        this.dao = agendaDAO;
    }

    public Resultado criarNome(String nome) {
        if (nome.isEmpty() || nome.isBlank()) {
            return Resultado.erro("Nome inválido!");
        }

        return dao.criarNome(nome);
    }

    public Resultado criarTelefone(int id, String nome, int telefone) {

        Agenda agenda = new Agenda(id, nome, telefone);
        return dao.criarTelefone(agenda);
    }

    public Resultado criarEmail(int id, String nome, String email) {
        if(email.isBlank() || email.isEmpty()){
            return Resultado.erro("Nome inválido!");
        }

        Agenda agenda = new Agenda(id, nome, email);
        return dao.criarEmail(agenda);
    }

    public Resultado criarContatoCompleto(String nome, String email, int telefone) {
        if (nome.isEmpty() || nome.isBlank()) {
            return Resultado.erro("Nome inválido!");
        }
        if(email.isBlank() || email.isEmpty()){
            return Resultado.erro("Nome inválido!");
        }

        Agenda agenda = new Agenda(nome, email, telefone);
        return dao.criarContatoCompleto(agenda);
    }
    
    
    public Resultado listar() {
        return dao.listar();
    }

    public Resultado buscarCodigo(int codigo) {
        return dao.buscarCodigo(codigo);
    }

    public Resultado buscarNome(String nome) {
        return dao.buscarNome(nome);
    }

}
