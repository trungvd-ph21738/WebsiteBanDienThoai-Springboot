package com.poly.sd17322.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "gio_hang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GioHang {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kh")
    private KhachHang khachHang;

    @Column(name = "id_nv")
    private UUID idNhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_thanh_toan")
    private LocalDate ngayThanhToan;

    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;
}
