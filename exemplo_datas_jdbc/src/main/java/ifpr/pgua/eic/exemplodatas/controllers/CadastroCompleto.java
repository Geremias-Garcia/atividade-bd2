package ifpr.pgua.eic.exemplodatas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadastroCompleto {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    private RepositorioAgenda repositorioAgenda;

    public CadastroCompleto(RepositorioAgenda repositorioAgenda) {
    }

    @FXML
    void cadastrar(ActionEvent event){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telString = tfTelefone.getText();

        Alert alert;

        if(telString.isBlank() || telString.isEmpty()){
            alert = new Alert(AlertType.ERROR,"Telefone inválido");
        }else if(!(telString.matches("\\d+"))){
            alert = new Alert(AlertType.ERROR,"Formato inválido");
        }else{
            int telefone = Integer.parseInt(telString);

            System.out.println(nome+" "+email+" "+telefone);
            alert = new Alert(AlertType.INFORMATION, telString);
            /*Resultado resultado = repositorioAgenda.criarContatoCompleto(nome, email, telefone);

            String msg;

            msg = resultado.getMsg();
            if(resultado.foiErro()){
                alert = new Alert(AlertType.ERROR,msg);
            }else{
                alert = new Alert(AlertType.INFORMATION,msg);  
            }*/
        }
        alert.showAndWait();
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
