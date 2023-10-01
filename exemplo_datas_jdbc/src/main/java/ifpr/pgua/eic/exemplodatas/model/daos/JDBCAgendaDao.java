package ifpr.pgua.eic.exemplodatas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Agenda;

public class JDBCAgendaDao implements AgendaDao{
    private static final String INSERTNOME = "INSERT INTO bdII_agenda (nome) VALUES (?)";
    private static final String INSERTTEL = "INSERT INTO bdII_telefone (telefone, codigo_agenda_id) VALUES (?, ?)";
    private static final String INSERTEMAIL = "INSERT INTO bdII_email (email, codigo_agenda_id) VALUES (?, ?)";

    private static final String SELECTSQL = "SELECT * FROM bdII_agenda";

    private static final String SELECTCODIGO = "SELECT * FROM bdII_agenda WHERE id = (?)";
    private static final String SELECTNOME = "SELECT * FROM bdII_agenda WHERE nome = (?)";

    private FabricaConexoes fabrica;

    public JDBCAgendaDao(FabricaConexoes fabrica) {
        this.fabrica = fabrica; 
    }

    @Override
    public Resultado criarNome(String nome) {
        
        try (Connection con = fabrica.getConnection()) {

            PreparedStatement pstm = con.prepareStatement(INSERTNOME);
            
            pstm.setString(1, nome);

            int ret = pstm.executeUpdate();

            if (ret == 1) {
                return Resultado.sucesso("Pessoa cadastrada", nome);
            } 
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado criarTelefone(Agenda agenda) {
        
        try (Connection con = fabrica.getConnection()) {

            PreparedStatement pstm = con.prepareStatement(INSERTTEL);
            
            int id = agenda.getCodigo();
            int telefone = agenda.getTelefone();

            pstm.setInt(1, telefone);
            pstm.setInt(2, id);

            int ret = pstm.executeUpdate();

            if (ret == 1) {
                return Resultado.sucesso("Telefone cadastrado", agenda);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado criarEmail(Agenda agenda) {
        
        try (Connection con = fabrica.getConnection()) {

            PreparedStatement pstm = con.prepareStatement(INSERTEMAIL);
            
            int id = agenda.getCodigo();
            String email = agenda.getEmail();

            pstm.setString(1, email);
            pstm.setInt(2, id);

            int ret = pstm.executeUpdate();

            if (ret == 1) {
                return Resultado.sucesso("Email cadastrado", agenda);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado criarContatoCompleto(Agenda agenda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarContatoCompleto'");
    }

    @Override
    public Resultado listar() {
        
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement(SELECTSQL);

            ResultSet rs = pstm.executeQuery();

            ArrayList<Agenda> lista = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Agenda agenda = new Agenda(id,nome);

                lista.add(agenda);
            }

            return Resultado.sucesso("Categorias listadas", lista);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarNome(String nome) {
       
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement(SELECTNOME);

            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();

            Agenda agenda = null;
            while(rs.next()){
                int codigo = rs.getInt("id");
                agenda = new Agenda(codigo, nome);
            }

            return Resultado.sucesso("Codigo: "+agenda.getCodigo()+"- Nome: "+agenda.getNome(), agenda);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado buscarEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEmail'");
    }

    @Override
    public Resultado buscarTelefone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTelefone'");
    }

    @Override
    public Resultado buscarCodigo(int codigo) {
        
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement(SELECTCODIGO);

            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();

            Agenda agenda = null;
            while(rs.next()){
                String nome = rs.getString("nome");
                agenda = new Agenda(codigo, nome);
            }

            return Resultado.sucesso("Codigo: "+agenda.getCodigo()+"- Nome: "+agenda.getNome(), agenda);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }
    
}
