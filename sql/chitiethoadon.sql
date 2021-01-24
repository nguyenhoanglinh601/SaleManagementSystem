-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2020 lúc 01:52 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlibanhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHoaDon` int(10) NOT NULL,
  `MaSanPham` int(10) NOT NULL,
  `GiaBan` float NOT NULL,
  `SoLuong` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHoaDon`, `MaSanPham`, `GiaBan`, `SoLuong`) VALUES
(50, 17, 98000, 5),
(50, 49, 44000, 1),
(51, 1, 15000, 1),
(51, 47, 84000, 4),
(51, 50, 91000, 1),
(52, 15, 27000, 1),
(52, 40, 28000, 2),
(52, 43, 37000, 3),
(53, 1, 15000, 5),
(53, 14, 64000, 4),
(53, 20, 332000, 5),
(54, 1, 15000, 1),
(54, 3, 19000, 5),
(54, 8, 10500, 3),
(55, 3, 19000, 3),
(55, 16, 66000, 3),
(56, 1, 16000, 3),
(56, 13, 60000, 2),
(57, 1, 16000, 1),
(57, 3, 19000, 3),
(57, 8, 10500, 3),
(58, 1, 16000, 1),
(58, 4, 16000, 3),
(58, 5, 18000, 5),
(59, 1, 16000, 1),
(59, 3, 19000, 3),
(59, 5, 18000, 5),
(60, 1, 16000, 1),
(60, 3, 19000, 3),
(60, 5, 18000, 5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHoaDon`,`MaSanPham`),
  ADD KEY `MaSanPham` (`MaSanPham`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`),
  ADD CONSTRAINT `fk_hoadon_chitiethoadon` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
