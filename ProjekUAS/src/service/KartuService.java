package service;

import model.Keanggotaan;
import model.Member;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class KartuService {
    private BufferedImage generateImage(Keanggotaan k) {

        Member m = k.getMember();

        int width = 500;
        int height = 300;

        BufferedImage img = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(0, 0, 0, 40));
        g.fillRoundRect(8, 8, width - 10, height - 10, 30, 30);

        GradientPaint gradient = new GradientPaint(0, 0, new Color(45, 52, 71), 0, height, new Color(88, 94, 120));
        g.setPaint(gradient);
        g.fill(new RoundRectangle2D.Double(0, 0, width - 10, height - 10, 30, 30));

        g.setColor(new Color(255, 255, 255, 230));
        g.fillRoundRect(0, 0, width - 10, 60, 30, 30);

        g.setColor(new Color(45, 52, 71));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("GYM MEMBERSHIP CARD", 25, 40);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.setColor(Color.WHITE);

        int labelX = 30;
        int valueX = 150;
        int startY = 110;
        int gapY = 35;

        g.drawString("Nama", labelX, startY);
        g.drawString(":", valueX - 15, startY);
        g.drawString(m.getNama(), valueX, startY);

        g.drawString("Alamat", labelX, startY + gapY);
        g.drawString(":", valueX - 15, startY + gapY);
        g.drawString(m.getAlamat(), valueX, startY + gapY);

        g.drawString("ID Member", labelX, startY + gapY * 2);
        g.drawString(":", valueX - 15, startY + gapY * 2);
        g.drawString(String.valueOf(m.getIdMember()), valueX, startY + gapY * 2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        g.drawString("Berlaku s/d", labelX, startY + gapY * 3);
        g.drawString(":", valueX - 15, startY + gapY * 3);
        g.drawString(k.getTanggalBerakhir().format(formatter),valueX,startY + gapY * 3);

        g.setFont(new Font("Arial", Font.ITALIC, 12));
        g.setColor(new Color(220, 220, 220));
        g.drawString("SIMAGYM • Digital Membership Card",30, height - 30);

        g.dispose();
        return img;
    }

    public Image generatePreview(Keanggotaan k) {
        try {
            BufferedImage img = generateImage(k);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, "png", os);
            return new Image(new ByteArrayInputStream(os.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void simpanKartu(Keanggotaan k) {

        File folder = new File("kartu");
        if (!folder.exists()) folder.mkdir();

        try {
            BufferedImage img = generateImage(k);
            ImageIO.write(
                    img,
                    "png",
                    new File("kartu/Kartu_" + k.getMember().getIdMember() + ".png")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
