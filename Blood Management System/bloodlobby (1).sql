-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 27, 2019 at 06:24 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodlobby`
--

-- --------------------------------------------------------

--
-- Table structure for table `donors`
--

CREATE TABLE `donors` (
  `id` int(10) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `bg` varchar(10) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `slno` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donors`
--

INSERT INTO `donors` (`id`, `fullname`, `bg`, `contact`, `slno`) VALUES
(16, 'Asef Hossain Khan', 'O+', '01878120028', 1);

-- --------------------------------------------------------

--
-- Table structure for table `forgotpass`
--

CREATE TABLE `forgotpass` (
  `username` varchar(20) NOT NULL,
  `qsn` varchar(50) NOT NULL,
  `ans` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forgotpass`
--

INSERT INTO `forgotpass` (`username`, `qsn`, `ans`) VALUES
('Asef', 'What was your childhood nickname?', 'Antik'),
('rifat', 'What is the name of your favourite teacher?', 'Victor'),
('user1', 'What school did you attend for sixth grade?', 'Ideal');

-- --------------------------------------------------------

--
-- Table structure for table `requests`
--

CREATE TABLE `requests` (
  `id` int(10) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `hospital` varchar(20) NOT NULL,
  `location` varchar(50) NOT NULL,
  `bg` varchar(10) NOT NULL,
  `bq` varchar(10) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requests`
--

INSERT INTO `requests` (`id`, `fullname`, `hospital`, `location`, `bg`, `bq`, `contact`, `date`, `username`) VALUES
(16, 'Tamim', 'LabAid', 'Dhanmondi', 'A+', '2', '01296854787', '20-September-2001', 'Asef'),
(17, 'abcds', 'xyz', 'Kuril', 'B+', '3', '789456132', '6-August-1960', 'Asef');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `bg` varchar(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `admin` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `fullname`, `contact`, `dob`, `bg`, `email`, `gender`, `admin`) VALUES
('Asef', '123', 'Asef Hossain Khan', '01878120028', '21-September-1998', 'O+', 'asefhossain123@gmail.com', 'Male', 'yes'),
('rifat', '1234', 'Rifat', '01878110256', '7-September-1998', 'B+', 'johnrifat29@gmail.com', 'Male', 'yes'),
('user1', '12', 'User1', '12345678910', '5-August-1953', 'B-', 'abc@yahoo.com', 'Female', 'no');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donors`
--
ALTER TABLE `donors`
  ADD PRIMARY KEY (`slno`);

--
-- Indexes for table `forgotpass`
--
ALTER TABLE `forgotpass`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donors`
--
ALTER TABLE `donors`
  MODIFY `slno` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
