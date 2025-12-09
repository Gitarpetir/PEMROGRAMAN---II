package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Transaksi;
import service.TransaksiService;
import javafx.stage.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TransaksiController implements Initializable {

    @FXML
    private TableView<Transaksi> tableTransaksi;

    @FXML
    private TableColumn<Transaksi, Number> columnTransaksiId;

    @FXML
    private TableColumn<Transaksi, Number> columnTransaksiPelangganId;

    @FXML
    private TableColumn<Transaksi, Number> columnTransaksiBarangId;

    @FXML
    private TableColumn<Transaksi, Number> columnTransaksiJumlahBarang;

    @FXML
    private TableColumn<Transaksi, Number> columnTransaksiTotalHarga;

    @FXML
    private TableColumn<Transaksi, LocalDate> columnTransaksiTanggal;

    @FXML
    private TextField fieldTransaksiPelangganId;

    @FXML
    private TextField fieldTransaksiBarangId;

    @FXML
    private TextField fieldTransaksiJumlahBarang;

    private TransaksiService transaksiService = new TransaksiService();
    private ObservableList<Transaksi> dataTransaksi = FXCollections.observableArrayList();

    private Transaksi selectedTransaksi = null;
    
    @FXML
    private Button buttonKembaliTransaksi;

    @FXML
    private void onKembaliTransaksi() {
        Stage stage = (Stage) buttonKembaliTransaksi.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnTransaksiId.setCellValueFactory(c -> c.getValue().transaksiIdProperty());
        columnTransaksiPelangganId.setCellValueFactory(c -> c.getValue().pelangganIdProperty());
        columnTransaksiBarangId.setCellValueFactory(c -> c.getValue().barangIdProperty());
        columnTransaksiJumlahBarang.setCellValueFactory(c -> c.getValue().jumlahBarangProperty());
        columnTransaksiTotalHarga.setCellValueFactory(c -> c.getValue().totalHargaProperty());
        columnTransaksiTanggal.setCellValueFactory(c -> c.getValue().tanggalTransaksiProperty());

        tableTransaksi.getSelectionModel().selectedItemProperty().addListener((_, __, newSel) -> {
            if (newSel != null) {
                selectedTransaksi = newSel;
                fieldTransaksiPelangganId.setText(String.valueOf(newSel.getPelangganId()));
                fieldTransaksiBarangId.setText(String.valueOf(newSel.getBarangId()));
                fieldTransaksiJumlahBarang.setText(String.valueOf(newSel.getJumlahBarang()));
            }
        });

        loadData();
    }

    private void loadData() {
        dataTransaksi.setAll(transaksiService.getSemuaTransaksi());
        tableTransaksi.setItems(dataTransaksi);
    }

    @FXML
    private void onTambahTransaksi() {
        try {
            int pelangganId = Integer.parseInt(fieldTransaksiPelangganId.getText());
            int barangId = Integer.parseInt(fieldTransaksiBarangId.getText());
            int jumlah = Integer.parseInt(fieldTransaksiJumlahBarang.getText());

            transaksiService.tambahTransaksi(pelangganId, barangId, jumlah);
            clearForm();
            loadData();
        } catch (NumberFormatException e) {
            System.out.println("Input ID/jumlah tidak valid");
        }
    }

    @FXML
    private void onUpdateTransaksi() {
        if (selectedTransaksi == null) {
            System.out.println("Pilih transaksi dulu");
            return;
        }

        try {
            int pelangganId = Integer.parseInt(fieldTransaksiPelangganId.getText());
            int barangId = Integer.parseInt(fieldTransaksiBarangId.getText());
            int jumlah = Integer.parseInt(fieldTransaksiJumlahBarang.getText());

            transaksiService.updateTransaksi(selectedTransaksi.getTransaksiId(), pelangganId, barangId, jumlah);
            clearForm();
            loadData();
        } catch (NumberFormatException e) {
            System.out.println("Input ID/jumlah tidak valid");
        }
    }

    @FXML
    private void onDeleteTransaksi() {
        if (selectedTransaksi == null) {
            System.out.println("Pilih transaksi dulu");
            return;
        }

        transaksiService.hapusTransaksi(selectedTransaksi.getTransaksiId());
        clearForm();
        loadData();
    }

    @FXML
    private void onRefreshTransaksi() {
        clearForm();
        loadData();
    }

    private void clearForm() {
        fieldTransaksiPelangganId.clear();
        fieldTransaksiBarangId.clear();
        fieldTransaksiJumlahBarang.clear();
        tableTransaksi.getSelectionModel().clearSelection();
        selectedTransaksi = null;
    }
}
