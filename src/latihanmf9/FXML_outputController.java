/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihanmf9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class FXML_outputController implements Initializable {

    @FXML
    private Label lblnama;
    @FXML
    private Label lbltransaksicd;
    @FXML
    private Label lblhasilsewa;
    @FXML
    private Label lbltarif;
    @FXML
    private Label lblpenyewaan;
    @FXML
    private Label lbldiskon;
    @FXML
    private Label lblbayar;
    @FXML
    private Label lblsewa;
    @FXML
    private Label lbllama;
    @FXML
    private Button btnkembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kembaliklik(ActionEvent event) {
        btnkembali.getScene().getWindow().hide();
    }
    
    public void hitung(LatihanMF9Model d){
            int tarif = 0, batas = 0, lebih = 0, bayar = 0, diskon = 0;
            String ket = "";
            switch(d.getFilm()){
               case 0 : if(d.getCd() == 0){tarif = 500;} else {tarif = 2000; batas = 3;break;}
               case 1 : if(d.getCd() == 0){tarif = 300;} else {tarif = 1500;batas = 7;break;}
               case 2 : if(d.getCd() == 0){tarif = 300;} else {tarif = 1000;batas = 5;break;}
               }
            
            if(d.getTransaksi() == 1){
                if (d.getLama() > batas) {
                lebih = (d.getLama() - batas);
                }else {lebih =0;}
                if(d.getCd() == 0) ket = "vcd"; else ket ="dvd";
                bayar = (int) (lebih*tarif*0.5);
                lblnama.setText(d.getPenyewa());
                lbltransaksicd.setText("Kembali" + ket);
                lblhasilsewa.setText(String.valueOf(bayar));
                lbltarif.setText(String.valueOf(tarif));
                lblpenyewaan.setText(String.valueOf(bayar));
                lbldiskon.setText("0");
                lblbayar.setText(String.valueOf(bayar));
                lblsewa.setText(String.valueOf(tarif*0.5));
                lbllama.setText(String.valueOf(lebih)); 
                
            }else{
                if(d.getCd() == 0) ket = "vcd"; else ket ="dvd";
                if(d.getLama()>=10) diskon = 150;
                else if(d.getLama() >=7) diskon = 100;
                else if(d.getLama() >=5) diskon = 50;
                else diskon =0;
                bayar  = (tarif - diskon)*d.getLama();
                lblnama.setText(d.getPenyewa());
                lbltransaksicd.setText("Pinjam" + ket);
                lblhasilsewa.setText(String.valueOf(d.getLama()*tarif));
                lbltarif.setText(String.valueOf(tarif));
                lblpenyewaan.setText(String.valueOf(d.getLama()*tarif));
                lbldiskon.setText(String.valueOf(diskon*d.getLama()));
                lblbayar.setText(String.valueOf(bayar));
                lblsewa.setText(String.valueOf(tarif));
                lbllama.setText(String.valueOf(d.getLama())); 
            }
            
    
    }
    
}
