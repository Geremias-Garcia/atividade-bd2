package ifpr.pgua.eic.exemplodatas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Agenda;

public interface AgendaDao {
    Resultado criarNome(String nome);

    Resultado criarTelefone(Agenda agenda);

    Resultado criarEmail(Agenda agenda);

    Resultado criarContatoCompleto(Agenda agenda);

    Resultado listar();

    Resultado buscarNome(String nome);

    Resultado buscarEmail();

    Resultado buscarTelefone();

    Resultado buscarCodigo(int codigo);

}
