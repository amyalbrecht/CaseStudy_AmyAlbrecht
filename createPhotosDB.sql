-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6250
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for photos
CREATE DATABASE IF NOT EXISTS `photos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `photos`;

-- Dumping structure for table photos.album
CREATE TABLE IF NOT EXISTS `album` (
  `albumId` int(11) NOT NULL AUTO_INCREMENT,
  `albumName` varchar(50) NOT NULL,
  PRIMARY KEY (`albumId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.album_photo
CREATE TABLE IF NOT EXISTS `album_photo` (
  `Album_albumId` int(11) NOT NULL,
  `aPhotos_photoId` int(11) NOT NULL,
  UNIQUE KEY `UK_g7rwuy2uq3jl6940cxxllkfap` (`aPhotos_photoId`),
  KEY `FKo27xvg8w4lwop3nh062dujim0` (`Album_albumId`),
  CONSTRAINT `FKo27xvg8w4lwop3nh062dujim0` FOREIGN KEY (`Album_albumId`) REFERENCES `album` (`albumId`),
  CONSTRAINT `FKrv138gxbw41gtvj4c7c0ukag6` FOREIGN KEY (`aPhotos_photoId`) REFERENCES `photo` (`photoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.photo
CREATE TABLE IF NOT EXISTS `photo` (
  `photoId` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(250) DEFAULT NULL,
  `photoFileName` varchar(50) NOT NULL,
  `pAlbum_albumId` int(11) DEFAULT NULL,
  PRIMARY KEY (`photoId`),
  KEY `FKtd9p8tjr9eo28c3fvwnspuviw` (`pAlbum_albumId`),
  CONSTRAINT `FKtd9p8tjr9eo28c3fvwnspuviw` FOREIGN KEY (`pAlbum_albumId`) REFERENCES `album` (`albumId`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.photo_tag
CREATE TABLE IF NOT EXISTS `photo_tag` (
  `Photo_photoId` int(11) NOT NULL,
  `pTags_tagId` int(11) NOT NULL,
  KEY `FKj57yp8wxwighnt5sx49g5vkgk` (`pTags_tagId`),
  KEY `FKi5y6myijvk6gvx6hj2lwo4g5f` (`Photo_photoId`),
  CONSTRAINT `FKi5y6myijvk6gvx6hj2lwo4g5f` FOREIGN KEY (`Photo_photoId`) REFERENCES `photo` (`photoId`),
  CONSTRAINT `FKj57yp8wxwighnt5sx49g5vkgk` FOREIGN KEY (`pTags_tagId`) REFERENCES `tag` (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(10) NOT NULL,
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `authLevel` bit(1) NOT NULL,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table photos.user_photo
CREATE TABLE IF NOT EXISTS `user_photo` (
  `User_userId` int(11) NOT NULL,
  `uPhotos_photoId` int(11) NOT NULL,
  UNIQUE KEY `UK_elrjrlx4eg6xobxy6bqyr0h2k` (`uPhotos_photoId`),
  KEY `FKebcwtr2y910j9dsb28hue84wv` (`User_userId`),
  CONSTRAINT `FK7tu1tmxnd3mlnuno0tvtlq174` FOREIGN KEY (`uPhotos_photoId`) REFERENCES `photo` (`photoId`),
  CONSTRAINT `FKebcwtr2y910j9dsb28hue84wv` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
