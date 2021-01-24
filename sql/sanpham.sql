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
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(10) NOT NULL,
  `TenSanPham` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` int(10) NOT NULL,
  `GiaNhap` int(10) NOT NULL,
  `LuongTonKho` int(10) NOT NULL,
  `ThoiGianNhap` date NOT NULL,
  `Loai` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaNhaCungCap` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `GiaBan`, `GiaNhap`, `LuongTonKho`, `ThoiGianNhap`, `Loai`, `MaNhaCungCap`) VALUES
(1, 'Bia Budweiser 350ml', 16000, 5000, 9600, '2020-06-25', 'bia', 1),
(2, 'Bia Corona Extra 355ml', 35000, 0, 9600, '2020-06-25', 'L01', 1),
(3, 'Strongbow táo lon 330ml', 19000, 0, 9600, '2020-06-25', 'L01', 1),
(4, 'Bia Tiger Crystal 330ml', 16000, 0, 9600, '2020-06-25', 'L01', 2),
(5, 'Bia Heineken Sleek 330ml', 18000, 0, 9600, '2020-06-25', 'L02', 1),
(6, 'Nước gạo Hàn Quốc Woongjin 15 lít', 35000, 0, 4800, '2020-06-25', 'L02', 3),
(7, 'Nước tăng lực Redbull 250ml', 9500, 0, 96000, '2020-06-25', 'L02', 3),
(8, 'Cà phê sữa Boss 180ml', 10500, 0, 960000, '2020-06-25', 'L02', 3),
(9, 'Nước tăng lực Coca Cola Energy 250ml', 10000, 0, 96000, '2020-06-25', 'L02', 3),
(10, 'Trà xanh matcha Tea Plus 455ml', 9000, 0, 9600, '2020-06-25', 'L02', 4),
(11, 'Thùng 48 hộp sữa tiệt trùng có đường Dutch Lady Cao khoẻ 170ml', 275000, 0, 4800, '2020-06-25', 'L03', 3),
(12, 'Thùng 48 bịch sữa tiệt trùng socola Dutch Lady Canxi & Protein 220ml', 285000, 0, 9600, '2020-06-25', 'L03', 5),
(13, 'Kem đặc có đường Ngôi sao Phương Nam xanh lá hộp 1284kg', 60000, 0, 14400, '2020-06-25', 'L03', 5),
(14, 'Thức uống lúa mạch Milo Active Go hũ 400g', 64000, 0, 19200, '2020-06-25', 'L03', 6),
(15, 'Sữa chua uống thanh trùng có đường Lothamilk Yaourt chai 490ml', 27000, 0, 96000, '2020-06-25', 'L03', 5),
(16, 'Thùng 30 gói mì 3 Miền tôm chua cay 65g', 66000, 0, 4800, '2020-06-25', 'L04', 5),
(17, 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', 98000, 0, 9600, '2020-06-25', 'L04', 7),
(18, 'Thùng 50 gói cháo thịt bằm Gấu Đỏ 50g', 150000, 0, 4800, '2020-06-25', 'L04', 7),
(19, 'Thùng 24 gói miến Phú Hương thịt bằm 58g', 205000, 0, 9600, '2020-06-25', 'L04', 8),
(20, 'Thùng 18 gói phở thịt bò Vifon Hoàng Gia 120g', 332000, 0, 4800, '2020-06-25', 'L04', 8),
(21, 'Dầu đậu nành nguyên chất Simply can 5 lít', 230000, 0, 9600, '2020-06-25', 'L05', 9),
(22, 'Dầu thực vật Tường An Cooking oil can 5 lít', 179000, 0, 9600, '2020-06-25', 'L05', 10),
(23, 'Nước tương tỏi ớt Chinsu chai 250ml', 15000, 0, 96000, '2020-06-25', 'L05', 11),
(24, 'Nước mắm Nam Ngư 10 độ đạm chai 900ml', 44000, 0, 9600, '2020-06-25', 'L05', 11),
(25, 'Hạt nêm thịt thăn, xương ống, tủy Knorr gói 900g', 61000, 0, 48000, '2020-06-25', 'L05', 11),
(26, 'Bánh bơ trứng Richy gói 270g', 37000, 0, 19200, '2020-06-25', 'L06', 12),
(27, 'Bánh bông lan vị cappuccino Solite hộp 276g (12 cái)', 50000, 0, 19200, '2020-06-25', 'L06', 13),
(28, 'Bánh quế vị kem sô cô la Cosy gói 132g', 14000, 0, 28800, '2020-06-25', 'L06', 13),
(29, 'Socola đen nhân hạnh nhân Hershey`s Nuggets gói 56g', 40000, 0, 96000, '2020-06-25', 'L06', 14),
(30, 'Nhân hạt mắc ca nướng Nutty hộp 150g', 182000, 0, 9600, '2020-06-25', 'L06', 14),
(31, 'Dầu gội sạch gàu Head & Shoulders hương chanh sảng khoái 625ml', 135000, 0, 9600, '2020-06-25', 'L07', 14),
(32, 'Sữa tắm nước hoa X-Men For Boss Intense 650g', 185000, 0, 9600, '2020-06-25', 'L07', 14),
(33, 'Khẩu trang vải kháng khuẩn dpNano 2 lớp hộp 4 cái (size L)', 59000, 0, 19200, '2020-06-25', 'L07', 14),
(34, 'Kem rửa mặt Oxy Total Anti-Acne làm dịu da kiểm soát nhờn sạch khuẩn mụn 100g', 65000, 0, 96000, '2020-06-25', 'L07', 15),
(35, 'Hộp 3 cái bao cao su Okamoto 003 Platinum 52mm', 148000, 0, 192000, '2020-06-25', 'L07', 16),
(36, 'Nước giặt OMO Matic bền đẹp túi 22 lít', 125000, 0, 19200, '2020-06-25', 'L08', 15),
(37, 'Nước rửa chén NET Sạch Vitamin E hương chanh can 388 lít', 59000, 0, 9600, '2020-06-25', 'L08', 15),
(38, 'Khử mùi tủ lạnh Farcent than hoạt tính 150g', 50000, 0, 9600, '2020-06-25', 'L08', 15),
(39, 'Bình xịt côn trùng Raid hương dầu khuynh diệp 600ml', 65000, 0, 9600, '2020-06-25', 'L08', 15),
(40, 'Nước lau sàn Sunlight hương hoa diên vỹ chai 1kg', 28000, 0, 9600, '2020-06-25', 'L08', 14),
(41, 'Gạo thơm hương lài Vua Gạo túi 5kg', 125000, 0, 9600, '2020-06-25', 'L09', 14),
(42, 'Ngũ cốc Nestlé Koko Krunch vị socola hộp 330g', 83000, 0, 28800, '2020-06-25', 'L09', 6),
(43, 'Mì Ý Spaghetti số 5 Castello gói 500g', 37000, 0, 28800, '2020-06-25', 'L09', 14),
(44, 'Lạp xưởng tôm Vissan gói 500g', 145500, 0, 5280, '2020-06-25', 'L09', 17),
(45, 'Pate gan Vissan hộp 170g', 24000, 0, 9600, '2020-06-25', 'L09', 17),
(46, 'Xúc xích cocktail xông khói CP gói 250g', 34000, 0, 96000, '2020-06-25', 'L10', 17),
(47, 'Chả ram tôm đất LC FOODS gói 500g', 84000, 0, 9600, '2020-06-25', 'L10', 17),
(48, 'Chả cá trứng cút Tân Việt Sin gói 500g', 75500, 0, 19200, '2020-06-25', 'L10', 18),
(49, 'Kim chi cải thảo cắt lát Bibigo Ông Kim`s hộp 500g', 44000, 0, 9600, '2020-06-25', 'L10', 18),
(50, 'Thịt ba rọi bò Mỹ Thảo Tiên Foods khay 300g', 91000, 0, 9600, '2020-06-25', 'L10', 18),
(51, 'sản phẩm thử thêm', 50000, 35000, 2400, '2020-06-25', 'quần áo', 2),
(52, 'sản phẩm thử sửa', 50000, 35000, 240, '2020-06-25', 'quần áo', 2),
(53, 'sản phẩm thử', 50000, 35000, 2400, '2020-06-25', 'nước', 15),
(54, 'sản phẩm 54', 50000, 35000, 120, '2020-06-25', 'quần áo', 14),
(55, ' sản phẩm thử sửa', 50000, 35000, 60, '2020-06-25', 'nước', 15),
(56, 'sản phẩm thử thêm', 500000, 350000, 3000, '2020-06-25', 'đồ ăn', 15),
(57, 'sản phẩm thử thêm', 50000, 35000, 1000, '2020-06-25', 'quần áo', 26),
(58, 'sản phẩm thử thêm 1', 50000, 35000, 1000, '2020-06-25', 'quần áo', 17);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `MaNhaCungCap` (`MaNhaCungCap`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`MaNhaCungCap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
