/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx;

import it.ad.learning.tqtarademofx.entity.Apparecchiature;
import it.ad.learning.tqtarademofx.services.DbService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfonso
 */
public class AppController implements Initializable {

    @FXML
    private TableView<Apparecchiature> tblApparecchiature;

    @FXML
    private TableColumn<Apparecchiature, Long> idCol;
    @FXML
    private TableColumn<Apparecchiature, String> descrCol;
    @FXML
    private TableColumn<Apparecchiature, String> labCol;
    @FXML
    private TableColumn<Apparecchiature, String> codCol;

    ObservableList<Apparecchiature> dati;

    private Apparecchiature currentApparecchiatura;

    private Stage mainStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dati = FXCollections.observableArrayList();
        loadApparecchiature();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        descrCol.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        labCol.setCellValueFactory(new PropertyValueFactory<>("laboratorio"));
        codCol.setCellValueFactory(new PropertyValueFactory<>("codice"));

        tblApparecchiature.setItems(dati);

        tblApparecchiature
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(this::onSelApparecchiatura);
    }

    public void onSelApparecchiatura(
            ObservableValue<? extends Apparecchiature> observable,
            Apparecchiature oldValue, Apparecchiature newValue) {
        this.currentApparecchiatura = newValue;
    }

    @FXML
    public void onCrea(ActionEvent e) {
        openDialogDettagli(true);
        loadApparecchiature();
    }

    @FXML
    public void onModifica(ActionEvent e) {
        openDialogDettagli(false);
        loadApparecchiature();
    }

    @FXML
    public void onElimina(ActionEvent e) {
        try {
            if (currentApparecchiatura == null) {
                Alerts.showWarning("Nessuna apparecchiatura selezionata");
                return;
            }
            if (Alerts.showConfirm("Sicuro di voler eliminare l'apparecchiatura selezionata?")) {
                DbService.elimina(currentApparecchiatura);
                dati.remove(currentApparecchiatura);
                currentApparecchiatura = null;
            }
        } catch (RuntimeException ex) {
            //Alerts.showError(ex.getMessage());
            loadApparecchiature();
        }
    }

    @FXML
    public void onRefresh(ActionEvent e) {
        loadApparecchiature();
    }

    @FXML
    public void onClose(ActionEvent e) {
        if (Alerts.showConfirm("Sicuro di voler uscire??")) {
            Platform.exit();
        }
    }

    private void loadApparecchiature() {
        dati.clear();
        dati.addAll(DbService.findAll());
    }

    private void openDialogDettagli(boolean crea) {
        try {
            Stage st = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/dettagli.fxml"));
            Scene s = new Scene(loader.load());
            st.setScene(s);
            DettagliController controller = loader.getController();
            controller.setStage(st);
            controller.setCurrent(crea ? 
                    new Apparecchiature() : currentApparecchiatura);
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(mainStage);
            st.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    
    
}
