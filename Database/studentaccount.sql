-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 19, 2022 at 09:01 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentaccount`
--

-- --------------------------------------------------------

--
-- Table structure for table `projectlist`
--

CREATE TABLE `projectlist` (
  `proId` int(11) NOT NULL,
  `projectTitle` varchar(250) DEFAULT NULL,
  `projectCatagory` varchar(250) DEFAULT NULL,
  `projectDesc` varchar(2048) DEFAULT NULL,
  `projectPrice` float DEFAULT NULL,
  `projectStatus` int(11) DEFAULT NULL,
  `imagePath` varchar(1024) NOT NULL,
  `studId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projectlist`
--

INSERT INTO `projectlist` (`proId`, `projectTitle`, `projectCatagory`, `projectDesc`, `projectPrice`, `projectStatus`, `imagePath`, `studId`) VALUES
(1, 'Student Project repository', NULL, 'One of the pillars of an academic institution is research outputs such as research projects made by students and academic staff. Collected and digitally archived research projects preserve the academic work of students and academic staff as evidence of an institution’s scholarly output, as vital resource of references for future researchers to collaborate, and a bold indicator to active research activities. However, there are few colleges/universities in the sultanate that has a web-based digital archiving repository of research projects. And significantly most of these', 100000, 1, 'E:\\Student_Project_Repository\\src\\main\\resources\\com\\example\\student_project_repository\\studentRepoAssets\\pro3.png', 1207418),
(2, 'HAHU Gebeta', NULL, 'school management system that helps for the society choosing the title.', 40000, 1, 'E:\\Student_Project_Repository\\src\\main\\resources\\com\\example\\student_project_repository\\studentRepoAssets\\projectloggin.png', 1207424),
(4, 'Kasingo', 'computing', 'E bingo system Android application eBingo Tour developed by Videli is listed under category Casino. The current version is 3.22.00, released on 2022-07-18. According to Google Play eBingo Tour achieved more than 114 thousand installs. eBingo Tour currently has 3 thousand ratings with average rating value of 4.3', 20000, 1, 'C:\\Users\\USER\\Desktop\\bingo table sample.png', 1207418),
(6, 'Bdu facerecognition', 'computing', 'faceRecognition', 80000, 1, 'E:\\sorry.jpg', 1207418);

-- --------------------------------------------------------

--
-- Table structure for table `studentprojects`
--

CREATE TABLE `studentprojects` (
  `id` int(11) NOT NULL,
  `studId` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `projectNumbers` int(11) DEFAULT NULL,
  `Balance` float DEFAULT NULL,
  `notification` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentprojects`
--

INSERT INTO `studentprojects` (`id`, `studId`, `password`, `firstName`, `lastName`, `gender`, `projectNumbers`, `Balance`, `notification`) VALUES
(1, 1207418, 'new', 'Fanuel', 'Almaw', 'm', 5, 900, '1'),
(2, 1207424, 'pas', 'kidist', NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `projectlist`
--
ALTER TABLE `projectlist`
  ADD PRIMARY KEY (`proId`);

--
-- Indexes for table `studentprojects`
--
ALTER TABLE `studentprojects`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `projectlist`
--
ALTER TABLE `projectlist`
  MODIFY `proId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `studentprojects`
--
ALTER TABLE `studentprojects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
