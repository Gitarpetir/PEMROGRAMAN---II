package service;

import dao.KeanggotaanDAO;
import model.Keanggotaan;
import model.Member;

import java.time.LocalDate;
import java.util.ArrayList;

public class KeanggotaanService {

    private KeanggotaanDAO keanggotaanDAO = new KeanggotaanDAO();

    private static final int HARGA_PER_BULAN = 150_000;

    public void buatKeanggotaanBaru(Member member, int durasiBulan) {

        LocalDate mulai = LocalDate.now();
        LocalDate berakhir = mulai.plusMonths(durasiBulan);
        int totalBayar = durasiBulan * HARGA_PER_BULAN;

        Keanggotaan k = new Keanggotaan(member, mulai, berakhir, durasiBulan, HARGA_PER_BULAN, totalBayar);
        keanggotaanDAO.insert(k);
        }

    public void perpanjangKeanggotaan(Member member, int tambahanBulan) {

        Keanggotaan lama = keanggotaanDAO.getByMember(member);
        if (lama == null) return;

        int durasiBaru = lama.getDurasiBulan() + tambahanBulan;
        int totalBaru = lama.getTotalBayar() + (tambahanBulan * lama.getHargaPerBulan());
        LocalDate tanggalBaru = lama.getTanggalBerakhir().plusMonths(tambahanBulan);

        lama.setDurasiBulan(durasiBaru);
        lama.setTanggalBerakhir(tanggalBaru);
        lama.setTotalBayar(totalBaru);

        keanggotaanDAO.update(lama);
        }

    public boolean sudahPunyaKeanggotaan(Member member) {
        return keanggotaanDAO.getByMember(member) != null;
        }

    public ArrayList<Keanggotaan> getSemuaKeanggotaan() {
        return keanggotaanDAO.getAll();
        }
    }
