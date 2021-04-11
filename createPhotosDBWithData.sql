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
  `album_id` int(11) NOT NULL AUTO_INCREMENT,
  `album_name` varchar(50) NOT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table photos.album: ~6 rows (approximately)
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` (`album_id`, `album_name`) VALUES
	(1, 'Max\'s 1st Birthday'),
	(2, 'Max\'s 2nd Birthday'),
	(3, 'Max\'s 3rd Birthday'),
	(4, 'Baby Maxie'),
	(5, 'Christmas'),
	(6, 'At the Park');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;

-- Dumping structure for table photos.album_a_photos
CREATE TABLE IF NOT EXISTS `album_a_photos` (
  `album_album_id` int(11) NOT NULL,
  `a_photos_photo_id` int(11) NOT NULL,
  UNIQUE KEY `UK_rck0napika02a6l3n3q2ykovk` (`a_photos_photo_id`),
  KEY `FK22s4sh6bev62q2khjkekklu54` (`album_album_id`),
  CONSTRAINT `FK22s4sh6bev62q2khjkekklu54` FOREIGN KEY (`album_album_id`) REFERENCES `album` (`album_id`),
  CONSTRAINT `FK95y89mnlrd5e4oiyde1jjv9y5` FOREIGN KEY (`a_photos_photo_id`) REFERENCES `photo` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table photos.album_a_photos: ~28 rows (approximately)
/*!40000 ALTER TABLE `album_a_photos` DISABLE KEYS */;
INSERT INTO `album_a_photos` (`album_album_id`, `a_photos_photo_id`) VALUES
	(1, 7),
	(1, 8),
	(1, 9),
	(1, 10),
	(1, 13),
	(1, 16),
	(1, 31),
	(2, 17),
	(2, 19),
	(2, 20),
	(2, 21),
	(3, 22),
	(3, 34),
	(3, 35),
	(3, 36),
	(3, 37),
	(4, 24),
	(4, 25),
	(4, 26),
	(4, 27),
	(4, 28),
	(4, 29),
	(5, 14),
	(5, 15),
	(5, 23),
	(5, 30),
	(6, 32),
	(6, 33);
/*!40000 ALTER TABLE `album_a_photos` ENABLE KEYS */;

-- Dumping structure for table photos.photo
CREATE TABLE IF NOT EXISTS `photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(250) DEFAULT NULL,
  `photo_file_name` varchar(100) NOT NULL,
  `p_album_album_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `FK4el9hrr4oewou0oc7wvteschq` (`p_album_album_id`),
  CONSTRAINT `FK4el9hrr4oewou0oc7wvteschq` FOREIGN KEY (`p_album_album_id`) REFERENCES `album` (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- Dumping data for table photos.photo: ~28 rows (approximately)
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` (`photo_id`, `caption`, `photo_file_name`, `p_album_album_id`) VALUES
	(7, 'Getting ready to smash the cake!', 'cake1stBdayReady.jpg', 1),
	(8, 'Here\'s the smash cake!', 'cake1stBday2ndcake.jpg', 1),
	(9, 'Yummy', 'cake1stBdaySmash.jpg', 1),
	(10, 'the cake everyone else had', 'cake1stBday.jpg', 1),
	(13, 'official portrait', 'P17.jpg', 1),
	(14, 'Christmas tree with the cat', 'ChristmasTree.jpg', 5),
	(15, 'Christmas nap at Grandma\'s', 'ChristmasNap.jpg', 5),
	(16, 'What a mess!', '1stBdayMess.jpg', 1),
	(17, '2020 Birthday - Happy Meal in the car', '2ndBday01.jpg', 2),
	(19, 'at the playground', '2ndBday03.jpg', 2),
	(20, 'a special treat from Blippi!', '2ndBday04.jpg', 2),
	(21, 'new car!', '2ndBday05.jpg', 2),
	(22, 'Let\'s go fly a kite', 'kite.jpg', 3),
	(23, 'Christmas 2019 - under the tree!', 'underthetree2019.jpg', 5),
	(24, 'portrait', 'E13-E.jpg', 4),
	(25, 'portrait session', 'P1.jpg', 4),
	(26, 'enjoying the trees', 'porch.jpg', 4),
	(27, 'crib time!', 'cribWithPuppy.jpg', 4),
	(28, 'a little guy and his cat, Callie', 'MaxAndCallie.jpg', 4),
	(29, 'first day home after the hospital!', 'newbornMax.jpg', 4),
	(30, 'Holiday Train!', 'holidayTrain.jpg', 5),
	(31, 'we decorated the room like Goodnight Moon', 'IMG_20190406_115609171.jpg', 1),
	(32, 'enjoying chalk art', 'abc.jpg', 6),
	(33, 'I\'m an excavator! Hey dirt, see ya later!', 'excavator.jpg', 6),
	(34, 'presents!', '3rdBday02.jpg', 3),
	(35, 'cake with Blippi colors!', '3rdBdaycake.jpg', 3),
	(36, 'When your birthday is also Easter, you decorate Peeps!', '3rdBday03.jpg', 3),
	(37, 'Happy birthday, big guy', '3rdBday04.jpg', 3);
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;

-- Dumping structure for table photos.photo_p_tags
CREATE TABLE IF NOT EXISTS `photo_p_tags` (
  `photo_photo_id` int(11) NOT NULL,
  `p_tags_tag_id` int(11) NOT NULL,
  KEY `FK99llsx4a3is2868nmdgv5g1yq` (`p_tags_tag_id`),
  KEY `FKt6wpka3su0lgb176nd371uw0r` (`photo_photo_id`),
  CONSTRAINT `FK99llsx4a3is2868nmdgv5g1yq` FOREIGN KEY (`p_tags_tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKt6wpka3su0lgb176nd371uw0r` FOREIGN KEY (`photo_photo_id`) REFERENCES `photo` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table photos.photo_p_tags: ~66 rows (approximately)
/*!40000 ALTER TABLE `photo_p_tags` DISABLE KEYS */;
INSERT INTO `photo_p_tags` (`photo_photo_id`, `p_tags_tag_id`) VALUES
	(7, 10),
	(7, 11),
	(7, 12),
	(8, 11),
	(8, 13),
	(9, 11),
	(9, 14),
	(10, 15),
	(10, 11),
	(10, 16),
	(13, 21),
	(13, 22),
	(14, 23),
	(14, 25),
	(15, 23),
	(15, 24),
	(15, 26),
	(16, 10),
	(16, 11),
	(16, 14),
	(17, 10),
	(17, 27),
	(17, 28),
	(17, 29),
	(19, 31),
	(19, 32),
	(20, 10),
	(20, 33),
	(20, 34),
	(20, 35),
	(21, 10),
	(21, 27),
	(22, 10),
	(22, 36),
	(23, 23),
	(23, 25),
	(23, 37),
	(24, 21),
	(24, 22),
	(25, 21),
	(25, 22),
	(26, 38),
	(26, 39),
	(27, 40),
	(27, 41),
	(28, 25),
	(29, 42),
	(29, 43),
	(30, 23),
	(30, 44),
	(31, 10),
	(31, 15),
	(31, 16),
	(32, 45),
	(32, 46),
	(33, 47),
	(33, 46),
	(34, 10),
	(34, 48),
	(35, 10),
	(35, 11),
	(35, 34),
	(36, 10),
	(36, 49),
	(36, 50),
	(37, 10);
/*!40000 ALTER TABLE `photo_p_tags` ENABLE KEYS */;

-- Dumping structure for table photos.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(20) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Dumping data for table photos.tag: ~38 rows (approximately)
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`tag_id`, `tag_name`) VALUES
	(10, 'birthday'),
	(11, 'cake'),
	(12, 'bib'),
	(13, 'smash'),
	(14, 'mess'),
	(15, 'moon'),
	(16, 'goodnight'),
	(17, 'Mommy'),
	(21, 'portrait'),
	(22, 'professional'),
	(23, 'Christmas'),
	(24, 'nap'),
	(25, 'cat'),
	(26, 'Grandma'),
	(27, 'car'),
	(28, 'McDonald\'s'),
	(29, '2020'),
	(30, 'Thomas'),
	(31, 'hoodie'),
	(32, 'playground'),
	(33, 'candy'),
	(34, 'Blippi'),
	(35, 'chocolate'),
	(36, 'kite'),
	(37, 'tree'),
	(38, 'porch'),
	(39, 'trees'),
	(40, 'puppy'),
	(41, 'crib'),
	(42, 'newborn'),
	(43, 'fresh'),
	(44, 'train'),
	(45, 'abc\'s'),
	(46, 'park'),
	(47, 'excavator'),
	(48, 'presents'),
	(49, 'Easter'),
	(50, 'Peeps');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;

-- Dumping structure for table photos.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_level` bit(1) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table photos.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `auth_level`, `email`, `first_name`, `last_name`, `password`) VALUES
	(1, b'1', 'admin@admin.com', 'Amy', 'Albrecht', 'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table photos.user_u_photos
CREATE TABLE IF NOT EXISTS `user_u_photos` (
  `user_user_id` int(11) NOT NULL,
  `u_photos_photo_id` int(11) NOT NULL,
  UNIQUE KEY `UK_si042gsnj2dj90tuqdp7voow3` (`u_photos_photo_id`),
  KEY `FKdab93ymps5r5jb3ksb076sfab` (`user_user_id`),
  CONSTRAINT `FKdab93ymps5r5jb3ksb076sfab` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKs8dugar38n131iuclruhfavib` FOREIGN KEY (`u_photos_photo_id`) REFERENCES `photo` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table photos.user_u_photos: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_u_photos` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_u_photos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
