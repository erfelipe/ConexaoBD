/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author eduardofelipe
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private MenuItem mnuCadAluno;
    @FXML
    private MenuItem mnuListaAlunos;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            label.setText("Conexão: " + conn.isValid(0));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @FXML
    private void evtCadastrarAluno(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLCadastrarAluno.fxml"));
        Parent raiz = (Parent) fxmlLoader.load();
        Stage palco = new Stage();
        palco.setScene(new Scene(raiz));
        palco.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void evtListarAlunos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLListarAlunos.fxml"));
        Parent raiz = (Parent) fxmlLoader.load();
        Stage palco = new Stage();
        palco.setScene(new Scene(raiz));
        palco.show();
    }

}
