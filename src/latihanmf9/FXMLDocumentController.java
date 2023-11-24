/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihanmf9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Ramdani
 */
public class FXMLDocumentController implements Initializable {
    
    LatihanMF9Model dt = new LatihanMF9Model();
    

    @FXML
    private CheckBox chkpinjam;
    @FXML
    private CheckBox chkdvd;
    @FXML
    private ComboBox<String> chbfilm;
    @FXML
    private TextField txtpenyewa;
    @FXML
    private TextField txtlama;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbfilm.setItems(FXCollections.observableArrayList("Action", "Komedi", "Horror"));
        chbfilm.setEditable(false);
        chbfilm.getSelectionModel().selectFirst();
    }    

    @FXML
    private void hitungklik(ActionEvent event) {
        dt.setPenyewa(txtpenyewa.getText());
        dt.setFilm(chbfilm.getSelectionModel().getSelectedIndex());
        dt.setLama(Integer.parseInt(txtlama.getText()));
        dt.setCd(chkdvd.isSelected()?1:0);
        dt.setTransaksi(chkpinjam.isSelected()?0:1);
        
        try{  FXMLLoader loader=new    
          FXMLLoader(getClass().getResource("FXML_output.fxml"));    
          Parent root = (Parent)loader.load();
//koding untuk mengirim data ke tampilan output
          FXML_outputController isidt=     
          (FXML_outputController)loader.getController();
          isidt.hitung(dt);
//membuat windows baru
          Scene scene = new Scene(root);
          Stage stg=new Stage();  
//koding untuk windows dialog / modal       
          stg.initModality(Modality.APPLICATION_MODAL);
          stg.setResizable(false);
          stg.setIconified(false);
          //koding untuk /menampilkan windows
          stg.setScene(scene);
          stg.show();
          }catch (IOException e){   e.printStackTrace();}
        
        
        
    }

    @FXML
    private void hapusklik(ActionEvent event) {
            chkpinjam.setSelected(false);
            chkdvd.setSelected(false);
            chbfilm.getSelectionModel().select(0);
            txtpenyewa.setText("");
            txtlama.setText("");
    }

    @FXML
    private void btnkeluar(ActionEvent event) {
        System.exit(0);
    }
    
}
