package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Barang;
import service.BarangService;
import javafx.stage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BarangController implements Initializable {

    @FXML
    private TableView<Barang> tableBarang;

    @FXML
    private TableColumn<Barang, Number> columnBarangId;

    @FXML
    private TableColumn<Barang, String> columnNamaBarang;

    @FXML
    private TableColumn<Barang, Number> columnHargaBarang;

    @FXML
    private TableColumn<Barang, Number> columnStokBarang;

    @FXML
    private TextField fieldNamaBarang;

    @FXML
    private TextField fieldHargaBarang;

    @FXML
    private TextField fieldStokBarang;
    
    @FXML
    private Button buttonKembaliBarang;

    private BarangService barangService = new BarangService();
    private ObservableList<Barang> dataBarang = FXCollections.observableArrayList();

    private Barang selectedBarang = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnBarangId.setCellValueFactory(c -> c.getValue().barangIdProperty());
        columnNamaBarang.setCellValueFactory(c -> c.getValue().namaBarangProperty());
        columnHargaBarang.setCellValueFactory(c -> c.getValue().hargaBarangProperty());
        columnStokBarang.setCellValueFactory(c -> c.getValue().stokBarangProperty());

        tableBarang.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                selectedBarang = newSel;
                fieldNamaBarang.setText(newSel.getNamaBarang());
                fieldHargaBarang.setText(String.valueOf(newSel.getHargaBarang()));
                fieldStokBarang.setText(String.valueOf(newSel.getStokBarang()));
            }
        });

        loadData();
    }

    private void loadData() {
        dataBarang.setAll(barangService.getSemuaBarang());
        tableBarang.setItems(dataBarang);
    }

    @FXML
    private void onTambahBarang() {
        try {
            String nama = fieldNamaBarang.getText();
            double harga = Double.parseDouble(fieldHargaBarang.getText());
            int stok = Integer.parseInt(fieldStokBarang.getText());

            barangService.tambahBarang(nama, harga, stok);
            clearForm();
            loadData();
        } catch (NumberFormatException e) {
            System.out.println("Input harga/stok tidak valid");
        }
    }

    @FXML
    private void onUpdateBarang() {
        if (selectedBarang == null) {
            System.out.println("Pilih data dulu untuk di-update");
            return;
        }

        try {
            String nama = fieldNamaBarang.getText();
            double harga = Double.parseDouble(fieldHargaBarang.getText());
            int stok = Integer.parseInt(fieldStokBarang.getText());

            barangService.updateBarang(selectedBarang.getBarangId(), nama, harga, stok);
            clearForm();
            loadData();
        } catch (NumberFormatException e) {
            System.out.println("Input harga/stok tidak valid");
        }
    }

    @FXML
    private void onDeleteBarang() {
        if (selectedBarang == null) {
            System.out.println("Pilih data dulu untuk dihapus");
            return;
        }

        barangService.hapusBarang(selectedBarang.getBarangId());
        clearForm();
        loadData();
    }

    @FXML
    private void onRefreshBarang() {
        clearForm();
        loadData();
    }

    private void clearForm() {
        fieldNamaBarang.clear();
        fieldHargaBarang.clear();
        fieldStokBarang.clear();
        tableBarang.getSelectionModel().clearSelection();
        selectedBarang = null;
    }
    
    @FXML
    private void onKembaliBarang() {
        Stage stage = (Stage) buttonKembaliBarang.getScene().getWindow();
        stage.close(); 
    }

}
