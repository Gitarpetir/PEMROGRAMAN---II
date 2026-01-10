package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import model.Keanggotaan;
import model.Member;
import service.KartuService;
import service.KeanggotaanService;
import service.MemberService;

public class KeanggotaanController {

    @FXML private ComboBox<Member> cbMember;
    @FXML private TextField txtDurasi;

    @FXML private TableView<Keanggotaan> tableKeanggotaan;
    @FXML private TableColumn<Keanggotaan, String> colNama;
    @FXML private TableColumn<Keanggotaan, Number> colDurasi, colTotal;
    @FXML private TableColumn<Keanggotaan, String> colBerakhir;

    @FXML private ImageView imgPreview;

    private MemberService memberService = new MemberService();
    private KeanggotaanService keanggotaanService = new KeanggotaanService();
    private KartuService kartuService = new KartuService();

    @FXML
    private void initialize() {

        cbMember.setItems(FXCollections.observableArrayList(memberService.getSemuaMember()));

        colNama.setCellValueFactory(d -> d.getValue().getMember().namaProperty());
        colDurasi.setCellValueFactory(d -> d.getValue().durasiBulanProperty());
        colTotal.setCellValueFactory(d -> d.getValue().totalBayarProperty());
        colBerakhir.setCellValueFactory(d -> d.getValue().tanggalBerakhirProperty().asString());
        loadData();
    }

    private void loadData() {
        tableKeanggotaan.setItems(FXCollections.observableArrayList(keanggotaanService.getSemuaKeanggotaan()));
    }

    @FXML
    private void handleTambah() {
        Member m = cbMember.getValue();
        if (m == null || txtDurasi.getText().isEmpty()) return;

        int durasi = Integer.parseInt(txtDurasi.getText());

        if (keanggotaanService.sudahPunyaKeanggotaan(m)) {
            keanggotaanService.perpanjangKeanggotaan(m, durasi);
        } else {
            keanggotaanService.buatKeanggotaanBaru(m, durasi);
        }

        loadData();
        txtDurasi.clear();
    }

    @FXML
    private void handlePreview() {
        Keanggotaan k =
                tableKeanggotaan.getSelectionModel().getSelectedItem();
        if (k == null) return;

        imgPreview.setImage(
                kartuService.generatePreview(k)
        );
    }

    @FXML
    private void handleSimpan() {

        Keanggotaan k =
                tableKeanggotaan.getSelectionModel().getSelectedItem();

        if (k == null) {
            showInfo("Info", "Pilih data keanggotaan terlebih dahulu");
            return;
        }

        kartuService.simpanKartu(k);

        showInfo(
            "Berhasil",
            "Kartu berhasil disimpan.\nCek folder: kartu/"
        );
    }
    
    @FXML
    private void handleKembali() {
        ((Stage) tableKeanggotaan.getScene().getWindow()).close();
    }
    
    private void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }


}
