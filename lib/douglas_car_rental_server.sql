-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 04, 2019 at 03:25 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `douglas_car_rental_server`
--

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Make` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Year` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`id`, `Make`, `Model`, `Year`, `Type`) VALUES
(1, 'Chevrolet', 'Avalanche 2500', '2017', 'Pick-up'),
(2, 'Nissan', 'Altima', '2017', 'Car'),
(3, 'MINI', 'Clubman', '2018', 'Car'),
(7, 'Mazda ', 'CX5', '2016', 'SUV'),
(5, 'Cadillac', 'CTS-V', '2013', 'Car'),
(6, 'Hyundai', 'Elantra', '2014', 'Car'),
(8, 'Mazda', 'CX5', '2016', 'SUV'),
(9, 'Ford', 'Edge', '2004', 'SUV'),
(10, 'Ford', 'F150', '2008', 'Pick-Up'),
(11, 'Dodge', 'Caravan', '2007', 'Minivan'),
(12, 'Ford', 'Edge', '2017', 'Pick-up'),
(13, 'Dodge', 'Ram 3500 Club', '2017', 'Pick-Up'),
(14, 'Volkswagen', 'Golf GTI', '1995', 'Car'),
(15, 'Honda', 'Fit', '2004', 'Car'),
(16, 'Acura', 'Integra', '1999', 'Car'),
(17, 'GMC', 'Savana 2500', '2001', 'Pick-Up'),
(18, 'Volkswagen', 'Passat', '2013', 'Car'),
(19, 'Mitsubishi', 'Pajero', '1992', 'SUV'),
(20, 'Ford', 'F-Series', '2014', 'Pick-up'),
(21, 'Vovlo', 'S80', '1998', 'Minivan'),
(22, 'Hyundai', 'Sonata', '2009', 'Car'),
(23, 'Buick', 'Riviera', '2017', 'Car'),
(24, 'Ford', 'Explorer', '2015', 'SUV'),
(25, 'Volkswagen', 'Touareg', '2010', 'SUV'),
(26, 'Dodge', 'Caravan', '2002', 'Minivan'),
(27, 'Ford', 'Fusion', '2006', 'Car'),
(28, 'Volkswagen', 'Golf', 'GTI', '2011'),
(29, 'BMW', '330', '2018', 'Car'),
(30, 'Honda', 'Odyssey', '2013', 'Minivan'),
(31, 'BMW', 'X1', '2009', 'SUV'),
(32, 'Dodge', 'Ram 1500', '2017', 'Pick-Up'),
(33, 'Ford', 'Expedition', '2017', 'SUV'),
(34, 'GMC', 'Yukon XL 2500', '2018', 'SUV'),
(35, 'AUDI', 'Q5', '2012', 'SUV'),
(36, 'Chevrolet', 'Cruze', '2018', 'Car'),
(37, 'Chevrolet', 'Silverado 1500', '2014', 'Pick-Up'),
(38, 'Mazda', 'CX7', '1996', 'SUV'),
(39, 'Ford', 'Flex', '1993', 'Suv'),
(40, 'Ford', 'Crown Victoria', '2018', 'Car'),
(41, 'Jeep', 'Compass', '2007', 'SUV'),
(42, 'Chevrolet', 'Malibu', '2017', 'Car'),
(43, 'Mazda', '3', '2008', 'Car'),
(44, 'BMW', '128i', '2017', 'Car'),
(45, 'BMW', '330', '2001', 'Car'),
(46, 'Ford', 'Escape', '2013', 'SUV'),
(47, 'Dodge', 'Neon', '2001', 'Car');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
