package ifpr.pgua.eic.exemplodatas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PesquisarNome {
    
    @FXML
    private TextField tfNome;

    private RepositorioAgenda repositorioAgenda;

    public PesquisarNome(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    @FXML
    void buscar(ActionEvent event){
        String nome = tfNome.getText();

        Resultado resultado = repositorioAgenda.buscarNome(nome);
        
        String msg;

        Alert alert;
        msg = resultado.getMsg();
        if(resultado.foiErro()){
            alert = new Alert(AlertType.ERROR,msg);
        }else{
            alert = new Alert(AlertType.INFORMATION,msg);  
        }

        alert.showAndWait();
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
