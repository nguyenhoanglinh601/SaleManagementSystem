-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2020 lúc 01:53 PM
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
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` int(10) NOT NULL,
  `TenNhaCungCap` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SDT` int(11) NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `SDT`, `Email`, `DiaChi`) VALUES
(1, 'Công ty TNHH Nhà Máy Bia Việt Nam', 0, '', ''),
(2, 'Công ty CP Thực phẩm Công Nghệ Sài Gòn', 0, '', ''),
(3, 'Công Ty TNHH MTV TM & ĐT Sài Gòn Hoàng Kim', 0, '', ''),
(4, 'Công ty Pepsico Việt Nam', 0, '', ''),
(5, 'Công ty Cổ phần Sữa Việt Nam', 0, '', ''),
(6, 'Công ty TNHH Nestlé Việt Nam', 0, '', ''),
(7, 'Công ty CP Acecook Việt Nam', 0, '', ''),
(8, 'Công ty cổ phần kỹ nghệ thực phẩm Việt Nam', 0, '', ''),
(9, 'Công ty Cái Lân', 0, '', ''),
(10, 'Công Ty cổ phần Dầu Thực Vật Tường An', 0, '', ''),
(11, 'Công ty cổ phần hàng tiêu dùng Masan', 0, '', ''),
(12, 'Công ty TNHH Thương mại và Sản xuất Hoàng Mai', 0, '', ''),
(13, 'Công ty cổ phần Kinh Đô', 0, '', ''),
(14, ' Công ty TNHH Hàng gia dụng Quốc tế', 0, '', ''),
(15, 'Công ty TNHH Quốc tế Unilever Việt Nam', 0, '', ''),
(16, 'Công ty TNHH FULL WELL TRADING Việt Nam', 0, '', ''),
(17, 'Công Ty Cổ phần Việt Nam Kỹ Nghệ Súc Sản', 0, '', ''),
(18, ' Cty TNHH CJ Foods Việt Nam', 0, '', ''),
(23, 'test', 123456789, 'tesst', 'test'),
(24, 'nhà cung cấp thử thêm', 969076447, 'test@gmail.com', '212 Nguyễn Sơn'),
(25, 'nhà cung cấp thử thêm', 969076447, 'test@gmail.com', '212 Nguyễn Sơn'),
(26, 'nhà cung cấp thử thêm 1', 969076447, 'test@gmail.com', '212 Nguyễn Sơn'),
(27, 'nhà cung cấp thử thêm 2', 969076447, 'test@gmail.com', '212 Nguyễn Sơn'),
(28, 'nhà cung cấp thử thêm 2', 969076447, 'test@gmail.com', '212 Nguyễn Sơn');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNhaCungCap`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNhaCungCap` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
