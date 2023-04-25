-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2020 at 04:09 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jiayingwang18`
--

-- --------------------------------------------------------

--
-- Table structure for table `chef`
--

CREATE TABLE `chef` (
  `Chefname` varchar(20) NOT NULL,
  `MONDAY` varchar(3) NOT NULL,
  `TUESDAY` varchar(3) NOT NULL,
  `WEDNESDAY` varchar(3) NOT NULL,
  `THURSDAY` varchar(3) NOT NULL,
  `FRIDAY` varchar(3) NOT NULL,
  `SATURDAY` varchar(3) NOT NULL,
  `SUNDAY` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chef`
--

INSERT INTO `chef` (`Chefname`, `MONDAY`, `TUESDAY`, `WEDNESDAY`, `THURSDAY`, `FRIDAY`, `SATURDAY`, `SUNDAY`) VALUES
('KarenAdam', 'T', 'T', 'T', 'T', 'T', 'F', 'F'),
('HariPhilip', 'F', 'F', 'T', 'T', 'T', 'T', 'T'),
('ThaliaHensley', 'T', 'F', 'F', 'T', 'F', 'T', 'F'),
('NishaMoss', 'F', 'T', 'F', 'F', 'F', 'T', 'T');

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `PassportID` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `UsernameG` varchar(100) NOT NULL,
  `PasswordG` varchar(100) NOT NULL,
  `TelephoneNum` varchar(100) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`PassportID`, `LastName`, `FirstName`, `UsernameG`, `PasswordG`, `TelephoneNum`, `Email`) VALUES
('111', 'Zhang', 'San', 'ZhangSan', '0101', '1822789', '13749@qq.com'),
('123', 'Huai', 'Ren', 'HAHA', 'abc', '140976', '123@qq.com'),
('333', 'Wang', 'Jiaying', 'SLYX', 'wywy03030808', '18258742237', 'Jiaying.Wang18@student.xjtlu.edu.cn');

-- --------------------------------------------------------

--
-- Table structure for table `meal`
--

CREATE TABLE `meal` (
  `Chefname` varchar(20) NOT NULL,
  `DishA` varchar(40) NOT NULL,
  `DishB` varchar(40) NOT NULL,
  `DishC` varchar(40) NOT NULL,
  `DishD` varchar(40) NOT NULL,
  `DishE` varchar(40) NOT NULL,
  `DishF` varchar(40) NOT NULL,
  `DishG` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`Chefname`, `DishA`, `DishB`, `DishC`, `DishD`, `DishE`, `DishF`, `DishG`) VALUES
('KarenAdam', 'AShrimpSoup', 'BCauliflowerAndMushroomStew', 'CSpicyChickenNuggets', 'DSteamedCodFish', 'ETurkeyBurger', 'FVeggieBurger', 'GFriedEgg'),
('HariPhilip', 'AChickenCurry', 'BChickenMasala', 'CMuttonKorma', 'DKeemaCurry', 'EMushroomTikka', 'FFriedEgg', 'GCurryRice'),
('ThaliaHensley', 'ATofuTeriyaki', 'BShrimpTempura', 'CYakiUdon', 'DChickenKatsu', 'ESalmonSashimi', 'FFriedEgg', 'GCurryRice'),
('NishaMoss', 'ABlackPepperBeef', 'BPorkChowmein', 'CSweet&SourPork', 'DGongbaoChicken', 'EPorkJiaozi', 'FSoyGlazedPorkChops', 'GCurry rice');

-- --------------------------------------------------------

--
-- Table structure for table `orderinfor`
--

CREATE TABLE `orderinfor` (
  `PassportID` varchar(100) DEFAULT NULL,
  `Roomnumber` varchar(3) NOT NULL,
  `Checkindate` date NOT NULL,
  `Checkoutdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `Roomtype` varchar(20) NOT NULL,
  `Roomnumber` varchar(3) NOT NULL,
  `Status` varchar(2) NOT NULL,
  `Book` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Roomtype`, `Roomnumber`, `Status`, `Book`) VALUES
('LD', '001', 'T', 'Y'),
('LD', '002', 'T', 'Y'),
('LS', '003', 'T', 'N'),
('LS', '004', 'T', 'N'),
('SS', '005', 'T', 'N'),
('SS', '006', 'T', 'N'),
('SS', '007', 'T', 'N'),
('SS', '008', 'T', 'N'),
('LS', '009', 'T', 'N'),
('LS', '010', 'T', 'N'),
('LD', '011', 'T', 'N'),
('LD', '012', 'T', 'N'),
('VIP', '013', 'T', 'N'),
('LD', '101', 'T', 'N'),
('LD', '102', 'T', 'N'),
('LS', '103', 'T', 'N'),
('LS', '104', 'T', 'N'),
('SS', '105', 'T', 'N'),
('SS', '106', 'T', 'N'),
('SS', '107', 'T', 'N'),
('SS', '108', 'T', 'N'),
('LS', '109', 'T', 'N'),
('LS', '110', 'T', 'N'),
('LD', '111', 'T', 'N'),
('LD', '112', 'T', 'N'),
('VIP', '113', 'T', 'N'),
('LD', '201', 'T', 'N'),
('LD', '202', 'T', 'N'),
('LS', '203', 'T', 'N'),
('LS', '204', 'T', 'N'),
('SS', '205', 'T', 'N'),
('SS', '206', 'T', 'N'),
('SS', '207', 'T', 'N'),
('SS', '208', 'T', 'N'),
('LS', '209', 'T', 'N'),
('LS', '210', 'T', 'N'),
('LD', '211', 'T', 'N'),
('LD', '212', 'T', 'N'),
('VIP', '213', 'T', 'N');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `UsernameS` varchar(100) NOT NULL,
  `PasswordS` varchar(100) NOT NULL,
  `TelephoneNumS` varchar(100) NOT NULL,
  `StaffID` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`UsernameS`, `PasswordS`, `TelephoneNumS`, `StaffID`) VALUES
('teacher', '0303', '112233', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD UNIQUE KEY `PassportID` (`PassportID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD UNIQUE KEY `Roomnumber` (`Roomnumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
