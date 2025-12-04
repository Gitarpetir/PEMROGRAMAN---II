package util;

import java.util.regex.Pattern;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;

public class ValidationUtil {

    // --- POLA REGEX (Aturan Dasar) ---
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+$";
    private static final String NUMERIC_REGEX = "\\d+";

    // 1. VALIDASI GASAN PELANGGAN
    public static class ValidasiPelanggan {
        
        public static void validate(Pelanggan p) throws Exception {
            // Validasi Nama
            if (p.getNama() == null || p.getNama().trim().isEmpty()) {
                throw new Exception("Nama pelanggan wajib diisi!");
            }
            if (!Pattern.matches(NAME_REGEX, p.getNama())) {
                throw new Exception("Nama tidak boleh mengandung angka atau simbol!");
            }

            // Validasi Email
            if (p.getEmail() == null || p.getEmail().trim().isEmpty()) {
                throw new Exception("Email wajib diisi!");
            }
            if (!Pattern.matches(EMAIL_REGEX, p.getEmail())) {
                throw new Exception("Format email salah! (Harus user@domain.com)");
            }

            // Validasi Telepon
            if (p.getTelepon() == null || p.getTelepon().trim().isEmpty()) {
                throw new Exception("Nomor telepon wajib diisi!");
            }
            if (!p.getTelepon().matches(NUMERIC_REGEX)) {
                throw new Exception("Nomor telepon harus berupa angka!");
            }
            if (p.getTelepon().length() < 10 || p.getTelepon().length() > 13) {
                throw new Exception("Nomor telepon harus terdiri dari 10 - 13 angka!");
            }
        }
    }

    // 2. VALIDASI GASAN BUKU
    public static class ValidasiBuku {
        
        public static void validate(Buku b) throws Exception {
            // Validasi Judul
            if (b.getJudul() == null || b.getJudul().trim().isEmpty()) {
                throw new Exception("Judul buku tidak boleh kosong!");
            }

            // Validasi Penulis
            if (b.getPenulis() == null || b.getPenulis().trim().isEmpty()) {
                throw new Exception("Nama penulis tidak boleh kosong!");
            }
            // Validasi Penulis angka
            if (!Pattern.matches(NAME_REGEX, b.getPenulis())) {
                throw new Exception("Nama penulis tidak boleh mengandung angka!");
            }

            // Validasi Harga
            if (b.getHarga() <= 0) {
                throw new Exception("Harga buku harus lebih besar dari 0!");
            }

            // Validasi Stok
            if (b.getStok() < 0) {
                throw new Exception("Stok buku tidak boleh negatif!");
            }
        }
    }

    // 3. VALIDASI GASAN PENJUALAN
    public static class ValidasiPenjualan {
        
        public static void validate(Penjualan p, int stokTersedia) throws Exception {
            // Validasi Jumlah Beli
            if (p.getJumlah() <= 0) {
                throw new Exception("Jumlah pembelian harus minimal 1!");
            }

            // Validasi Ketersediaan Stok
            if (p.getJumlah() > stokTersedia) {
                throw new Exception("Stok tidak mencukupi! Tersedia: " + stokTersedia);
            }
            
            // Validasi Relasi misal si pelanggan kada tepilih
            if (p.getPelangganId() <= 0) {
                throw new Exception("Pelanggan belum dipilih!");
            }
            if (p.getBukuId() <= 0) {
                throw new Exception("Buku belum dipilih!");
            }
        }
    }
}