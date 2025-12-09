package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Akun;
import service.AkunService;
import javafx.stage.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AkunController implements Initializable {

    @FXML
    private TableView<Akun> tableAkun;

    @FXML
    private TableColumn<Akun, Number> columnAkunId;

    @FXML
    private TableColumn<Akun, String> columnAkunUsername;

    @FXML
    private TableColumn<Akun, String> columnAkunPassword;

    @FXML
    private TextField fieldAkunUsername;

    @FXML
    private PasswordField fieldAkunPassword;

    private AkunService akunService = new AkunService();
    private ObservableList<Akun> dataAkun = FXCollections.observableArrayList();

    private Akun selectedAkun = null;
    
    @FXML
    private Button buttonKembaliAkun;

    @FXML
    private void onKembaliAkun() {
        Stage stage = (Stage) buttonKembaliAkun.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnAkunId.setCellValueFactory(c -> c.getValue().idAkunProperty());
        columnAkunUsername.setCellValueFactory(c -> c.getValue().usernameProperty());
        columnAkunPassword.setCellValueFactory(c -> c.getValue().passwordProperty());

        tableAkun.getSelectionModel().selectedItemProperty().addListener((_, __, newSel) -> {
            if (newSel != null) {
                selectedAkun = newSel;
                fieldAkunUsername.setText(newSel.getUsername());
                fieldAkunPassword.setText(newSel.getPassword());
            }
        });

        loadData();
    }

    private void loadData() {
        dataAkun.setAll(akunService.getSemuaAkun());
        tableAkun.setItems(dataAkun);
    }

    @FXML
    private void onTambahAkun() {
        String username = fieldAkunUsername.getText();
        String password = fieldAkunPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username / Password kosong");
            return;
        }

        akunService.tambahAkun(username, password);
        clearForm();
        loadData();
    }

    @FXML
    private void onUpdateAkun() {
        if (selectedAkun == null) {
            System.out.println("Pilih akun dulu");
            return;
        }

        String username = fieldAkunUsername.getText();
        String password = fieldAkunPassword.getText();

        akunService.updateAkun(selectedAkun.getIdAkun(), username, password);
        clearForm();
        loadData();
    }

    @FXML
    private void onDeleteAkun() {
        if (selectedAkun == null) {
            System.out.println("Pilih akun dulu");
            return;
        }

        akunService.hapusAkun(selectedAkun.getIdAkun());
        clearForm();
        loadData();
    }

    @FXML
    private void onRefreshAkun() {
        clearForm();
        loadData();
    }

    private void clearForm() {
        fieldAkunUsername.clear();
        fieldAkunPassword.clear();
        tableAkun.getSelectionModel().clearSelection();
        selectedAkun = null;
    }
}
