package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Member;
import service.MemberService;

public class MemberController {

    @FXML private TextField txtNama;
    @FXML private TextField txtAlamat;
    @FXML private TextField txtTelepon;

    @FXML private TableView<Member> tableMember;
    @FXML private TableColumn<Member, Number> colId;
    @FXML private TableColumn<Member, String> colNama;
    @FXML private TableColumn<Member, String> colAlamat;
    @FXML private TableColumn<Member, String> colTelepon;

    private MemberService memberService = new MemberService();

    @FXML
    private void initialize() {

        colId.setCellValueFactory(
                data -> data.getValue().idMemberProperty()
        );
        colNama.setCellValueFactory(
                data -> data.getValue().namaProperty()
        );
        colAlamat.setCellValueFactory(
                data -> data.getValue().alamatProperty()
        );
        colTelepon.setCellValueFactory(
                data -> data.getValue().teleponProperty()
        );

        loadData();

        tableMember.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        txtNama.setText(newVal.getNama());
                        txtAlamat.setText(newVal.getAlamat());
                        txtTelepon.setText(newVal.getTelepon());
                    }
                });
    }

    private void loadData() {
        tableMember.setItems(
                FXCollections.observableArrayList(
                        memberService.getSemuaMember()
                )
        );
    }

    @FXML
    private void handleTambah() {
        if (txtNama.getText().isEmpty()) {
            alert("Nama tidak boleh kosong");
            return;
        }

        memberService.tambahMember(
                txtNama.getText(),
                txtAlamat.getText(),
                txtTelepon.getText()
        );

        loadData();
        clearForm();
    }

    @FXML
    private void handleUpdate() {
        Member m = tableMember.getSelectionModel().getSelectedItem();
        if (m == null) {
            alert("Pilih data terlebih dahulu");
            return;
        }

        memberService.updateMember(
                m.getIdMember(),
                txtNama.getText(),
                txtAlamat.getText(),
                txtTelepon.getText()
        );

        loadData();
        clearForm();
    }

    @FXML
    private void handleHapus() {
        Member m = tableMember.getSelectionModel().getSelectedItem();
        if (m == null) {
            alert("Pilih data terlebih dahulu");
            return;
        }

        memberService.hapusMember(m.getIdMember());
        loadData();
        clearForm();
    }

    @FXML
    private void handleKembali() {
        Stage stage = (Stage) txtNama.getScene().getWindow();
        stage.close();
    }

    private void clearForm() {
        txtNama.clear();
        txtAlamat.clear();
        txtTelepon.clear();
    }

    private void alert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}
