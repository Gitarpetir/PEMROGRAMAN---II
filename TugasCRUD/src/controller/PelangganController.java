package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pelanggan;
import service.PelangganService;
import javafx.stage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PelangganController implements Initializable {

    @FXML
    private TableView<Pelanggan> tablePelanggan;

    @FXML
    private TableColumn<Pelanggan, Number> columnPelangganId;

    @FXML
    private TableColumn<Pelanggan, String> columnNamaPelanggan;

    @FXML
    private TableColumn<Pelanggan, String> columnAlamatPelanggan;

    @FXML
    private TableColumn<Pelanggan, String> columnNoHpPelanggan;

    @FXML
    private TextField fieldNamaPelanggan;

    @FXML
    private TextField fieldAlamatPelanggan;

    @FXML
    private TextField fieldNoHpPelanggan;

    private PelangganService pelangganService = new PelangganService();
    private ObservableList<Pelanggan> dataPelanggan = FXCollections.observableArrayList();

    private Pelanggan selectedPelanggan = null;
    
    @FXML
    private Button buttonKembaliPelanggan;

    @FXML
    private void onKembaliPelanggan() {
        Stage stage = (Stage) buttonKembaliPelanggan.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnPelangganId.setCellValueFactory(c -> c.getValue().pelangganIdProperty());
        columnNamaPelanggan.setCellValueFactory(c -> c.getValue().namaPelangganProperty());
        columnAlamatPelanggan.setCellValueFactory(c -> c.getValue().alamatPelangganProperty());
        columnNoHpPelanggan.setCellValueFactory(c -> c.getValue().noHpPelangganProperty());

        tablePelanggan.getSelectionModel().selectedItemProperty().addListener((_, __, newSel) -> {
            if (newSel != null) {
                selectedPelanggan = newSel;
                fieldNamaPelanggan.setText(newSel.getNamaPelanggan());
                fieldAlamatPelanggan.setText(newSel.getAlamatPelanggan());
                fieldNoHpPelanggan.setText(newSel.getNoHpPelanggan());
            }
        });

        loadData();
    }

    private void loadData() {
        dataPelanggan.setAll(pelangganService.getSemuaPelanggan());
        tablePelanggan.setItems(dataPelanggan);
    }

    @FXML
    private void onTambahPelanggan() {
        String nama = fieldNamaPelanggan.getText();
        String alamat = fieldAlamatPelanggan.getText();
        String noHp = fieldNoHpPelanggan.getText();

        if (nama.isEmpty() || alamat.isEmpty() || noHp.isEmpty()) {
            System.out.println("Data pelanggan belum lengkap");
            return;
        }

        pelangganService.tambahPelanggan(nama, alamat, noHp);
        clearForm();
        loadData();
    }

    @FXML
    private void onUpdatePelanggan() {
        if (selectedPelanggan == null) {
            System.out.println("Pilih pelanggan dulu");
            return;
        }

        String nama = fieldNamaPelanggan.getText();
        String alamat = fieldAlamatPelanggan.getText();
        String noHp = fieldNoHpPelanggan.getText();

        pelangganService.updatePelanggan(selectedPelanggan.getPelangganId(), nama, alamat, noHp);
        clearForm();
        loadData();
    }

    @FXML
    private void onDeletePelanggan() {
        if (selectedPelanggan == null) {
            System.out.println("Pilih pelanggan dulu");
            return;
        }

        pelangganService.hapusPelanggan(selectedPelanggan.getPelangganId());
        clearForm();
        loadData();
    }

    @FXML
    private void onRefreshPelanggan() {
        clearForm();
        loadData();
    }

    private void clearForm() {
        fieldNamaPelanggan.clear();
        fieldAlamatPelanggan.clear();
        fieldNoHpPelanggan.clear();
        tablePelanggan.getSelectionModel().clearSelection();
        selectedPelanggan = null;
    }
}
