package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import model.*;
import service.*;
import java.time.LocalDate;

public class PenjualanController {
    
    @FXML private ComboBox<Pelanggan> pelangganComboBox;
    @FXML private ComboBox<Buku> bukuComboBox;
    @FXML private TextField jumlahField;
    @FXML private DatePicker tanggalPicker;
    @FXML private Label totalHargaLabel;
    
    @FXML private TableView<Penjualan> penjualanTable;
    
    @FXML private TableColumn<Penjualan, Integer> idColumn;
    @FXML private TableColumn<Penjualan, String> colNamaPelanggan;
    @FXML private TableColumn<Penjualan, String> colJudulBuku;  
    @FXML private TableColumn<Penjualan, Integer> jumlahColumn;
    @FXML private TableColumn<Penjualan, Double> hargaColumn;
    @FXML private TableColumn<Penjualan, LocalDate> tanggalColumn;

    private PenjualanService pService = new PenjualanService();
    private PelangganService pelService = new PelangganService();
    private BukuService buService = new BukuService();

    @FXML 
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("penjualanId"));
        
        colNamaPelanggan.setCellValueFactory(new PropertyValueFactory<>("namaPelanggan"));
        colJudulBuku.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));
        
        jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        hargaColumn.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        
        loadData();
        setupComboBox(); 
        
        pelangganComboBox.setOnShowing(e -> refreshPelangganData());
        bukuComboBox.setOnShowing(e -> refreshBukuData());
        
        jumlahField.textProperty().addListener((obs, old, newVal) -> hitungTotal());
        bukuComboBox.valueProperty().addListener((obs, old, newVal) -> hitungTotal());
    }

    private void refreshPelangganData() {
        try {
            Pelanggan current = pelangganComboBox.getValue();
            pelangganComboBox.setItems(FXCollections.observableArrayList(pelService.getAll()));
            if (current != null) pelangganComboBox.setValue(current);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void refreshBukuData() {
        try {
            Buku current = bukuComboBox.getValue();
            bukuComboBox.setItems(FXCollections.observableArrayList(buService.getAll()));
            if (current != null) bukuComboBox.setValue(current);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadData() {
        try { 
            penjualanTable.setItems(FXCollections.observableArrayList(pService.getAll())); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void setupComboBox() {
        try {
            refreshPelangganData();
            refreshBukuData();
            
            pelangganComboBox.setConverter(new StringConverter<Pelanggan>() {
                public String toString(Pelanggan p) { return p != null ? p.getNama() : ""; }
                public Pelanggan fromString(String s) { return null; }
            });
            bukuComboBox.setConverter(new StringConverter<Buku>() {
                public String toString(Buku b) { return b != null ? b.getJudul() : ""; }
                public Buku fromString(String s) { return null; }
            });
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void hitungTotal() {
        try {
            if(bukuComboBox.getValue() != null && !jumlahField.getText().isEmpty()) {
                double total = bukuComboBox.getValue().getHarga() * Integer.parseInt(jumlahField.getText());
                totalHargaLabel.setText("Total: Rp " + String.format("%.0f", total));
            }
        } catch (Exception e) {
            totalHargaLabel.setText("Total: Rp 0");
        }
    }

    @FXML 
    private void handleAdd() {
        try {
            Pelanggan p = pelangganComboBox.getValue();
            Buku b = bukuComboBox.getValue();
            
            if (jumlahField.getText().isEmpty() || tanggalPicker.getValue() == null) {
                throw new Exception("Lengkapi data transaksi!");
            }
            
            int jum = Integer.parseInt(jumlahField.getText());
            LocalDate tgl = tanggalPicker.getValue();
            
            if(p!=null && b!=null) {
                pService.addTransaksi(new Penjualan(jum, b.getHarga() * jum, tgl, p.getPelangganId(), b.getBukuId()));
                
                loadData();
                new Alert(Alert.AlertType.INFORMATION, "Sukses!").show();
                
                jumlahField.clear();
                pelangganComboBox.getSelectionModel().clearSelection();
                bukuComboBox.getSelectionModel().clearSelection();
                totalHargaLabel.setText("Total: Rp 0");
                tanggalPicker.setValue(null);
            }
        } catch (Exception e) { new Alert(Alert.AlertType.ERROR, e.getMessage()).show(); }
    }

    @FXML 
    private void handleDelete() {
        Penjualan p = penjualanTable.getSelectionModel().getSelectedItem();
        if(p != null) {
            try { 
                pService.deleteTransaksi(p.getPenjualanId()); 
                loadData(); 
                new Alert(Alert.AlertType.INFORMATION, "Berhasil Menghapus Transaksi!").show();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}