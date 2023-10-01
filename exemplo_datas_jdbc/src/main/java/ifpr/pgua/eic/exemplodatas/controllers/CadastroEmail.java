package ifpr.pgua.eic.exemplodatas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.entities.Agenda;
import ifpr.pgua.eic.exemplodatas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroEmail implements Initializable{
    
    @FXML
    private TextField tfEmail;

    @FXML
    private ComboBox<Agenda> cbUsuario;

    private RepositorioAgenda repositorioAgenda;

    public CadastroEmail(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    @FXML
    void cadastrar(ActionEvent event){
        String email = tfEmail.getText();
        Agenda usuario = cbUsuario.getValue();
        int id = usuario.getCodigo();
        String nome = usuario.getNome();

        Alert alert;
        
        Resultado resultado = repositorioAgenda.criarEmail(id,nome, email);

        String msg;

        msg = resultado.getMsg();
        if(resultado.foiErro()){
            alert = new Alert(AlertType.ERROR,msg);
        }else{
            alert = new Alert(AlertType.INFORMATION,msg);  
        }
        alert.showAndWait();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        Resultado r1 = repositorioAgenda.listar();

        if(r1.foiSucesso()){
            List<Agenda> list = (List)r1.comoSucesso().getObj();
            cbUsuario.getItems().addAll(list);
        }else{
            Alert alert = new Alert(AlertType.ERROR,r1.getMsg());
            alert.showAndWait();
        }
    }
    
    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
