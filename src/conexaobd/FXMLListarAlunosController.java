/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author eduardofelipe
 */
public class FXMLListarAlunosController implements Initializable {

    @FXML
    private TableView<Alunos> table_alunos;
    @FXML
    private TableColumn<Alunos, String> col_nome;
    @FXML
    private TableColumn<Alunos, String> col_sexo;
    @FXML
    private TableColumn<Alunos, String> col_endereco;
    @FXML
    private TableColumn<Alunos, String> col_datanasc;

    ObservableList<Alunos> list_alunos = FXCollections.observableArrayList();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection conn = new ConnectionFactory().getConnection();
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from Alunos");
            
            while (rs.next()){
                list_alunos.add( new Alunos(rs.getString("nome"),
                                            rs.getString("sexo"),
                                            rs.getString("endereco"),
                                            rs.getString("datanasc") ) );
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListarAlunosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        col_endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        col_datanasc.setCellValueFactory(new PropertyValueFactory<>("datanasc"));
        
        table_alunos.setItems(list_alunos);
    }    
    
}
