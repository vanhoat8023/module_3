drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table dich_vu_di_kem (
	id_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem varchar(45) not null,
    gia int,
    don_vi int,
    trang_thai_kha_dung varchar(45)
);

create table vi_tri(
id_vi_tri int primary key,
ten_vi_tri varchar(45)
);

create table trinh_do (
id_trinh_do int primary key,
trinh_do varchar(45)
);

create table bo_phan(
id_bo_phan int primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien (
	id_nhan_vien int primary key,
    ho_ten varchar(50),
	id_bo_phan int,
    id_trinh_do int,
    id_vi_tri int,
    ngay_sinh date,
    so_chung_minh_nhan_dan varchar(15),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    foreign key (id_bo_phan) references bo_phan(id_bo_phan),
    foreign key (id_trinh_do) references trinh_do(id_trinh_do),
    foreign key (id_vi_tri) references vi_tri(id_vi_tri)
);

create table loai_khach (
	id_loai_khach int primary key,
    ten_loai_khach varchar(45)
);

create table khach_hang (
	id_khach_hang int primary key,
    id_loai_khach int,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    so_dt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue(
	id_kieu_thue int primary key,
    ten_kieu_thue varchar(45),
    gia int
);

create table loai_dich_vu(
	ten_loai_dich_vu varchar(45),
    id_loai_dich_vu int primary key
);

create table dich_vu (
	id_dich_vu int primary key,
    ten_dich_vu varchar(50),
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    chi_phi_thue varchar(45),
    so_nguoi_toi_da varchar(45),
    dien_tich int,
    so_tang int,
    foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);


create table hop_dong (
	id_hop_dong int primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
    foreign key (id_khach_hang) references khach_hang(id_khach_hang),
    foreign key (id_dich_vu) references dich_vu(id_dich_vu)
    );
    
create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int primary key,
	id_hop_dong int,
	id_dich_vu_di_kem int,
	so_luong int not null,
	foreign key (id_hop_dong) references hop_dong(id_hop_dong),
	foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- vị trí
INSERT INTO `vi_tri` (`id_vi_tri`, `ten_vi_tri`) VALUES 
('1', 'tổ trưởng'),
('2', 'quản lý'),
('3', 'nhân viên');
--  bộ phận
INSERT INTO `bo_phan` (`id_bo_phan`, `ten_bo_phan`) VALUES 
('1', 'kinh doanh'),
('2', 'nhân sự'),
('3', 'lễ tân'),
('4', 'phục vụ'),
('5', 'bảo vệ');
-- trình độ
INSERT INTO `trinh_do` (`id_trinh_do`, `trinh_do`) VALUES 
('1', 'thạc sỹ'),
('2', 'đại học'),
('3', 'cao đẵng'),
('4', 'phổ thông');
-- nhân viên
INSERT INTO `nhan_vien` (`id_nhan_vien`, `ho_ten`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`, `ngay_sinh`, `so_chung_minh_nhan_dan`, `luong`, `sdt`, `email`, `dia_chi`) VALUES 
('7', 'toàn', '1', '3', '2', '1995-2-2', '34667', '1000', '12987', 'fgd@gmail.com', 'đà nẵng'),
('8', 'ánh', '2', '4', '3', '1995-1-1', '096', '800', '12340', 'fggs@gmail.com', 'đà nẵng'),
('1', 'chương', '1', '1', '1', '2000-1-1', '123', '1000', '12345', 'abc@gmail.com', 'đà nẵng'),
('2', 'tùng', '2', '2', '2', '1997-1-1', '234', '800', '123456', 'dff@gmail.com', 'đà nẵng'),
('3', 'hải', '3', '3', '3', '1995-12-12', '567', '500', '12344', 'hhg@gmail.com', 'đà nẵng'),
('4', 'khánh', '1', '4', '4', '1999-1-1', '454', '1000', '12346', 'dgh@gmail.com', 'đà nẵng'),
('5', 'hà', '2', '1', '5', '1998-12-12', '0887', '800', '12367', 'tff@gmail.com', 'đà nẵng'),
('6', 'khá', '3', '2', '1', '1996-2-2', '4343', '500', '12349', 'fghh@gmail.com', 'đà nẵng'),
('9', 'my', '3', '1', '4', '1995-2-1', '3578', '500', '45667', 'dhfthh@gmail.com', 'đà nẵng'),
('10', 'nguyệt', '1', '2', '5', '1995-1-1', '6797', '1000', '35787', 'ghggh@gmail.com', 'đà nẵng');
-- loại khách hàng
INSERT INTO `loai_khach` (`id_loai_khach`, `ten_loai_khach`) VALUES 
('1', 'diamond'),
('2', 'platinum'),
('3', 'gold'),
('4', 'silver'),
('5', 'copper');
-- khách hàng
INSERT INTO`khach_hang` (`id_khach_hang`, `id_loai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dt`, `email`, `dia_chi`) VALUES 
('1', '1', 'từ sĩ tùng', '1995-12-12', '1234', '1234', 'qwe@gmai.com', 'quảng bình'),
('2', '1', 'hoàng kim văn chương', '2010-12-12', '2345', '2345', 'ád@gmai.com', 'đà nẵng'),
('3', '1', 'lê toàn', '1910-12-12', '3456', '3456', 'hgf@gmai.com', 'quảng trị'),
('4', '2', 'lê nhật', '1992-12-12', '4567', '4567', 'hgh@gmai.com', 'huế'),
('5', '3', 'phan quốc khánh', '2015-12-12', '5678', '5678', 'gfđ@gmai.com', 'đà nẵng'),
('6', '2', 'trần thanh hoàng', '1993-12-12', '7890', '6789', 'vcfg@gmai.com', 'quảng trị'),
('7', '3', 'nguyễn tiến hải', '1991-12-12', '0123', '7890', 'gggjj@gmai.com', 'huế'),
('8', '4', 'lê văn hoạt', '1212-12-12', '1203', '1245', 'ggjh@gmai.com', 'quảng nam'),
('9', '5', 'nguyễn hữu quang', '1996-12-12', '1256', '3478', 'jhghh@gmai.com', 'quảng trị'),
('10', '1', 'trần hữu hiên', '1996-12-12', '3478', '2378', 'rfg@gmai.com', 'đà nẵng');
-- loại dịch vụ
INSERT INTO `loai_dich_vu` (`id_loai_dich_vu`, `ten_loai_dich_vu`) VALUES 
('1', 'villa'),
('2', 'house'),
('3', 'room');
-- kiểu thuê
INSERT INTO `kieu_thue` (`id_kieu_thue`, `ten_kieu_thue`, `gia`) 
VALUES 
('2', 'gia đình', '2000'),
('3', 'theo đoàn', '1000');
insert into `kieu_thue` (`id_kieu_thue`, `ten_kieu_thue`, `gia`) 
VALUES ('1', 'cặp đôi', '3000');
-- dịch vụ đi kèm
INSERT INTO `dich_vu_di_kem` (`id_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) 
VALUES 
('1', 'massage', '300', '1', 'khả dụng'),
('2', 'karaoke ', '250', '1', 'khả dụng'),
('3', 'đồ ăn', '100', '1', 'khả dụng'),
('4', 'nước uống', '75', '1', 'khả dụng'),
('5', 'xe', '500', '1', 'khả dụng');
-- dịch vụ
select * from dich_vu;
INSERT INTO `dich_vu` (`id_dich_vu`, `ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `id_kieu_thue`, `id_loai_dich_vu`, `trang_thai`) 
VALUES 
('1', 'mer viila', '200', '3', '5', '100000', '1', '1', 'còn phòng'),
('2', 'king villa', '180', '3', '5', '90000', '2', '1', 'còn phòng'),
('3', 'beautifuly villa', '160', '3', '5', '80000', '3', '1', 'còn phòng'),
('4', 'luxury villa', '140', '3', '5', '70000', '2', '2', 'còn phòng'),
('5', 'fleur house', '120', '3', '5', '60000', '1', '2', 'còn phòng'),
('6', 'jhon house', '100', '3', '5', '50000', '2', '2', 'còn phòng'),
('7', 'ocean house', '80', '3', '5', '40000', '3', '3', 'còn phòng'),
('8', '301 room', '60', '3', '5', '30000', '1', '3', 'còn phòng'),
('9', '302 room', '55', '3', '5', '20000', '2', '3', 'còn phòng'),
('10', '303 room', '50', '3', '5', '10000', '3', '1', 'còn phòng'),
('11', '304 room', '50', '3', '5', '10000', '3', '1', 'còn phòng');
-- hợp đồng
INSERT INTO `hop_dong` (`id_hop_dong`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) 
VALUES 
('1', '1', '6', '1', '2020-12-12', '2020-12-30', '1000', '10000'),
('2', '1', '4', '1', '2020-12-12', '2020-12-30', '1000', '10000'),
('3', '1', '3', '1', '2018-12-12', '2020-12-30', '1000', '10000'),
('4', '6', '2', '1', '2019-12-12', '2020-12-30', '1000', '10000'),
('5', '6', '1', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('6', '6', '2', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('7', '6', '1', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('8', '1', '3', '3', '2018-12-12', '2020-12-30', '1000', '10000'),
('9', '1', '4', '3', '2019-12-12', '2020-12-30', '1000', '10000'),
('10', '1', '2', '3', '2020-12-12', '2020-12-30', '1000', '10000');

-- hợp đồng chi tiết
INSERT INTO `hop_dong_chi_tiet` (`id_hop_dong_chi_tiet`, `id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) 
VALUES 
('1', '1', '1', '1'),
('2', '2', '2', '2'),
('3', '3', '3', '3'),
('4', '4', '4', '1'),
('5', '5', '5', '2'),
('6', '6', '1', '3'),
('7', '7', '2', '1'),
('8', '8', '3', '2'),
('9', '9', '4', '3'),
('10', '10', '5', '1');

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự

select * 
from `nhan_vien`
where ho_ten like 'h%' or ho_ten like 'k%' or ho_ten like 't%'
and length(ho_ten) <=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from khach_hang
where datediff( now(), khach_hang.ngay_sinh)/365 between 18 and 50
and 
dia_chi in ('đà nẵng','quảng trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo 
-- số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.ho_ten , count(hop_dong.id_hop_dong) as 'số lần đặt phòng'
from  khach_hang
right join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1
group by khach_hang.id_khach_hang
order by count(hop_dong.id_hop_dong);

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
--  cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng
-- thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, hop_dong.ngay_lam_hop_dong, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (datediff(hop_dong.ngay_lam_hop_dong, '2019-01-01')<0) and (datediff(hop_dong.ngay_lam_hop_dong, '2019-03-31')>0);

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ
-- đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019

select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where year(hop_dong.ngay_lam_hop_dong) =2018
	and hop_dong.id_hop_dong not in( select hop_dong.id_khach_hang
									 from hop_dong 
                                     where year(hop_dong.ngay_lam_hop_dong)=2019);
select * from hop_dong;

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.

-- cách 1:
select distinct ho_ten
from khach_hang;

-- cách 2:
select *
from khach_hang
group by ho_ten;

-- cách 3:
select *
from khach_hang
union
select *
from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
select month(hop_dong.ngay_lam_hop_dong) as tháng, count(hop_dong.id_hop_dong) as 'số lượng', sum(hop_dong.tong_tien) as 'doanh thu'
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2019'
group by month(hop_dong.ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong,
-- NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, hop_dong_chi_tiet.so_luong
from hop_dong
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai_kha_dung, loai_khach.ten_loai_khach, khach_hang.dia_chi
from dich_vu_di_kem 
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem
left join hop_dong on hop_dong.id_hop_dong=hop_dong_chi_tiet.id_hop_dong
left join khach_hang on khach_hang.id_khach_hang=hop_dong.id_khach_hang
left join loai_khach on loai_khach.id_loai_khach=khach_hang.id_loai_khach
where loai_khach.ten_loai_khach='diamond' and (khach_hang.dia_chi='đà nẵng'or khach_hang.dia_chi='quảng trị');

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hop_dong.id_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dt, dich_vu.ten_dich_vu, hop_dong_chi_tiet.so_luong, hop_dong.tien_dat_coc
from hop_dong
left join khach_hang on khach_hang.id_khach_hang=hop_dong.id_khach_hang
left join nhan_vien on nhan_vien.id_nhan_vien= hop_dong.id_nhan_vien
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong
left join dich_vu on dich_vu.id_dich_vu=hop_dong.id_dich_vu
where month(hop_dong.ngay_lam_hop_dong) between 10 and 12 
			and hop_dong.id_hop_dong not in(select hop_dong.id_khach_hang
											from hop_dong
											where month(hop_dong.ngay_lam_hop_dong) between 1 and 6);

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có
-- số lần sử dụng nhiều như nhau).

select *
from dich_vu_di_kem
left join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem=hop_dong_chi_tiet.id_dich_vu_di_kem
where hop_dong_chi_tiet.so_luong=
(select max(hop_dong_chi_tiet.so_luong) as max_dichVuDiKem
from hop_dong_chi_tiet);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nhan_vien.id_nhan_vien, nhan_vien.ho_ten, trinh_do.trinh_do, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi
from hop_dong
left join nhan_vien on nhan_vien.id_nhan_vien=hop_dong.id_nhan_vien
left join bo_phan on bo_phan.id_bo_phan=nhan_vien.id_bo_phan
left join trinh_do on trinh_do.id_trinh_do=nhan_vien.id_trinh_do
where 