package ifpr.pgua.eic.exemplodatas.controllers;

import ifpr.pgua.eic.exemplodatas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Cadastrar {
    
    @FXML
    private void cadastroUm(){
        App.pushScreen("CADASTROUM");
    }

    @FXML
    private void cadastroTelefone(){
        App.pushScreen("CADASTROTELEFONE");
    }

    @FXML
    private void cadastroEmail(){
        App.pushScreen("CADASTROEMAIL");
    }

    @FXML
    private void cadastroCompleto(){
        App.pushScreen("CADASTROCOMPLETO");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
