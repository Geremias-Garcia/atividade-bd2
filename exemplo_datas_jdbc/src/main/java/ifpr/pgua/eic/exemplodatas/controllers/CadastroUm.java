package ifpr.pgua.eic.exemplodatas.controllers;

import com.github.hugoperlin.results.Resultado;
import com.mysql.cj.result.StringValueFactory;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadastroUm {
    
    @FXML
    private TextField tfNome;

    private RepositorioAgenda repositorioAgenda;

    public CadastroUm(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    @FXML
    void cadastrar(ActionEvent event){
        String nome = tfNome.getText();

        Resultado resultado = repositorioAgenda.criarNome(nome);
        System.out.println(nome);

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
