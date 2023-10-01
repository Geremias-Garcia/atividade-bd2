package ifpr.pgua.eic.exemplodatas.controllers;

import ifpr.pgua.eic.exemplodatas.App;
import javafx.fxml.FXML;

public class Principal {
    
    @FXML
    private void cadastrar(){
        App.pushScreen("CADASTRAR");
    }

    @FXML
    private void pesquisar(){
        App.pushScreen("PESQUISAR");
    }
}
