/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx;

import it.ad.learning.tqtarademofx.entity.Apparecchiature;
import it.ad.learning.tqtarademofx.services.DbService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author alfonso
 */
public class DettagliController {

    @FXML
    TextArea tDescrizione;

    @FXML
    TextField tLaboratorio;

    @FXML
    TextField tCodice;

    private Stage stage;
    private Apparecchiature current;

    public void onSalva(ActionEvent e) {
        viewToModel();
        DbService.salva(current);
        current = null;
        stage.hide();
    }

    public void onAnnulla(ActionEvent e) {
        System.out.println("annulla...");
        stage.hide();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCurrent(Apparecchiature current) {
        this.current = current;
        modelToView();
    }

    private void modelToView() {
        tDescrizione.setText(current.getDescrizione());
        tLaboratorio.setText(current.getLaboratorio());
        tCodice.setText(current.getCodice());
    }

    private void viewToModel() {
        current.setDescrizione(tDescrizione.getText());
        current.setCodice(tCodice.getText());
        current.setLaboratorio(tLaboratorio.getText());
    }
}
