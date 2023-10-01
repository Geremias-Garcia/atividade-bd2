package ifpr.pgua.eic.exemplodatas;


import ifpr.pgua.eic.exemplodatas.controllers.Cadastrar;
import ifpr.pgua.eic.exemplodatas.controllers.CadastroCompleto;
import ifpr.pgua.eic.exemplodatas.controllers.CadastroEmail;
import ifpr.pgua.eic.exemplodatas.controllers.CadastroTelefone;
import ifpr.pgua.eic.exemplodatas.controllers.CadastroUm;
import ifpr.pgua.eic.exemplodatas.controllers.Pesquisar;
import ifpr.pgua.eic.exemplodatas.controllers.PesquisarCodigo;
import ifpr.pgua.eic.exemplodatas.controllers.PesquisarNome;
import ifpr.pgua.eic.exemplodatas.controllers.Principal;
import ifpr.pgua.eic.exemplodatas.model.daos.AgendaDao;
import ifpr.pgua.eic.exemplodatas.model.daos.FabricaConexoes;
import ifpr.pgua.eic.exemplodatas.model.repositories.RepositorioAgenda;
import ifpr.pgua.eic.exemplodatas.model.daos.JDBCAgendaDao;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private AgendaDao agendaDAO = new JDBCAgendaDao(FabricaConexoes.getInstance());
    private RepositorioAgenda  repositorioAgenda = new RepositorioAgenda(agendaDAO);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Tarefas";
    }

    
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o -> new Principal()));

        registraTela("CADASTRAR",
                new ScreenRegistryFXML(App.class,
                        "cadastrar.fxml",
                        o -> new Cadastrar()));
    
        registraTela("CADASTROUM",
                new ScreenRegistryFXML(App.class,
                        "cadastroUm.fxml",
                        o -> new CadastroUm(repositorioAgenda)));

        registraTela("CADASTROTELEFONE",
                new ScreenRegistryFXML(App.class,
                        "cadastroTelefone.fxml",
                        o -> new CadastroTelefone(repositorioAgenda)));

        registraTela("CADASTROEMAIL",
                new ScreenRegistryFXML(App.class,
                        "cadastroEmail.fxml",
                        o -> new CadastroEmail(repositorioAgenda)));

        registraTela("CADASTROCOMPLETO",
                new ScreenRegistryFXML(App.class,
                        "cadastroCompleto.fxml",
                        o -> new CadastroCompleto(repositorioAgenda)));

        registraTela("PESQUISAR",
                new ScreenRegistryFXML(App.class,
                        "pesquisar.fxml",
                        o -> new Pesquisar()));

        registraTela("PESQUISARCODIGO",
                new ScreenRegistryFXML(App.class,
                        "pesquisarCodigo.fxml",
                        o -> new PesquisarCodigo(repositorioAgenda)));
                       
        registraTela("PESQUISARNOME",
                new ScreenRegistryFXML(App.class,
                        "pesquisarNome.fxml",
                        o -> new PesquisarNome(repositorioAgenda)));

    }
}