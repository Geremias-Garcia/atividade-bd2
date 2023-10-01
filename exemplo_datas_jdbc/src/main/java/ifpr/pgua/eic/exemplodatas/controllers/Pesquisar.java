package ifpr.pgua.eic.exemplodatas.controllers;

import ifpr.pgua.eic.exemplodatas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Pesquisar {
    
    @FXML
    void pesquisarCodigo(ActionEvent event){
        App.pushScreen("PESQUISARCODIGO");
    }

    @FXML
    void pesquisarNome(ActionEvent event){
        App.pushScreen("PESQUISARNOME");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
