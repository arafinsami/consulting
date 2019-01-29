-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 22, 2019 at 10:19 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tapsd_sami`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact_us`
--

CREATE TABLE `contact_us` (
  `id` int(11) NOT NULL,
  `email` text COLLATE utf8_unicode_ci,
  `message` text COLLATE utf8_unicode_ci,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gallery_content`
--

CREATE TABLE `gallery_content` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci,
  `gallery` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gallery_name`
--

CREATE TABLE `gallery_name` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu_child_content`
--

CREATE TABLE `menu_child_content` (
  `child_menu_content_id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` text COLLATE utf8_unicode_ci,
  `parent_menu_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu_parent`
--

CREATE TABLE `menu_parent` (
  `parent_menu_id` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `our_business`
--

CREATE TABLE `our_business` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `our_process`
--

CREATE TABLE `our_process` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `our_service`
--

CREATE TABLE `our_service` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `our_team`
--

CREATE TABLE `our_team` (
  `id` int(11) NOT NULL,
  `attachment` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `slider`
--

CREATE TABLE `slider` (
  `id` int(11) NOT NULL,
  `attachment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `subtitle` text COLLATE utf8_unicode_ci,
  `title` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact_us`
--
ALTER TABLE `contact_us`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gallery_content`
--
ALTER TABLE `gallery_content`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_rfx4hk8sl125eb62cybqbvy2x` (`gallery`);

--
-- Indexes for table `gallery_name`
--
ALTER TABLE `gallery_name`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu_child_content`
--
ALTER TABLE `menu_child_content`
  ADD PRIMARY KEY (`child_menu_content_id`),
  ADD KEY `FK_9pee9cwjjxmqsq2amrbu2jukn` (`parent_menu_id`);

--
-- Indexes for table `menu_parent`
--
ALTER TABLE `menu_parent`
  ADD PRIMARY KEY (`parent_menu_id`);

--
-- Indexes for table `our_business`
--
ALTER TABLE `our_business`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `our_process`
--
ALTER TABLE `our_process`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `our_service`
--
ALTER TABLE `our_service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `our_team`
--
ALTER TABLE `our_team`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `slider`
--
ALTER TABLE `slider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_role_id`),
  ADD KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  ADD KEY `FK_apcc8lxk2xnug8377fatvbn04` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact_us`
--
ALTER TABLE `contact_us`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `gallery_content`
--
ALTER TABLE `gallery_content`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `gallery_name`
--
ALTER TABLE `gallery_name`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu_child_content`
--
ALTER TABLE `menu_child_content`
  MODIFY `child_menu_content_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu_parent`
--
ALTER TABLE `menu_parent`
  MODIFY `parent_menu_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `our_business`
--
ALTER TABLE `our_business`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `our_process`
--
ALTER TABLE `our_process`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `our_service`
--
ALTER TABLE `our_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `our_team`
--
ALTER TABLE `our_team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `slider`
--
ALTER TABLE `slider`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gallery_content`
--
ALTER TABLE `gallery_content`
  ADD CONSTRAINT `FK_rfx4hk8sl125eb62cybqbvy2x` FOREIGN KEY (`gallery`) REFERENCES `gallery_name` (`id`);

--
-- Constraints for table `menu_child_content`
--
ALTER TABLE `menu_child_content`
  ADD CONSTRAINT `FK_9pee9cwjjxmqsq2amrbu2jukn` FOREIGN KEY (`parent_menu_id`) REFERENCES `menu_parent` (`parent_menu_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
