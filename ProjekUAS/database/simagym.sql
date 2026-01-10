/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - simagym
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`simagym` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `simagym`;

/*Table structure for table `admin_gym` */

DROP TABLE IF EXISTS `admin_gym`;

CREATE TABLE `admin_gym` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `nama_admin` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `shift` enum('PAGI','SORE') NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `admin_gym` */

insert  into `admin_gym`(`id_admin`,`nama_admin`,`username`,`password`,`shift`) values 
(1,'Admin Pagi','admin_pagi','12345','PAGI'),
(2,'Admin Sore','admin_sore','12345','SORE');

/*Table structure for table `keanggotaan` */

DROP TABLE IF EXISTS `keanggotaan`;

CREATE TABLE `keanggotaan` (
  `id_member` int(11) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_berakhir` date NOT NULL,
  `durasi_bulan` int(11) NOT NULL,
  `harga_per_bulan` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL,
  PRIMARY KEY (`id_member`),
  CONSTRAINT `fk_keanggotaan_member` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `keanggotaan` */

insert  into `keanggotaan`(`id_member`,`tanggal_mulai`,`tanggal_berakhir`,`durasi_bulan`,`harga_per_bulan`,`total_bayar`) values 
(1,'2025-12-22','2026-01-22',1,150000,150000),
(2,'2025-12-22','2026-01-22',1,150000,150000),
(3,'2025-12-22','2026-03-22',3,150000,450000),
(4,'2025-12-22','2026-05-22',5,150000,750000),
(6,'2025-12-22','2026-03-22',3,150000,450000),
(7,'2025-12-22','2026-02-22',2,150000,300000),
(8,'2025-12-22','2026-03-22',3,150000,450000),
(9,'2025-12-22','2026-01-22',1,150000,150000);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `nama_lengkap` varchar(150) NOT NULL,
  `alamat` text NOT NULL,
  `no_telepon` varchar(20) NOT NULL,
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

insert  into `member`(`id_member`,`nama_lengkap`,`alamat`,`no_telepon`) values 
(1,'Muhammad Alfi Gunawan','Jalan Ratu Zaleha No. 153','081251080786'),
(2,'Muhammad Azriel Akbar','Jalan Beruntung No. 111','085812398272'),
(3,'Muhammad Rakha Athallah','Jalan Zahri Saleh No. 21','081209887291'),
(4,'Muhammad  Ibnu Sina','Jalan Sungai Lulut No. 505','081209871212'),
(6,'Muhammad Azma Al Faqih','Jalan Manarap No. 1','081234567891'),
(7,'Daniel Noprianto','Jalan Cendana No. 12','087170912890'),
(8,'Rendy Arafat','Jalan Zahri Saleh No. 200','085809871234'),
(9,'William Jovaski','Jalan Kenangan No. 313','-');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
