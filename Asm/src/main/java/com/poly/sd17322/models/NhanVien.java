package com.poly.sd17322.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Table(name = "nhan_vien")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ten_dem")
    private String tenDem;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ho")
    private String ho;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "gioi_tinh")
    private String gioiTinh;

//    @NotNull(message = "Ngày sinh không để trống")
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "dia_chi")
    private String diaChi;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "sdt")
    private String sdt;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ch")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;

//    @ManyToOne
//    @JoinColumn(name = "IdGuiBC")
//    private NhanVien baoCao;

    @Column(name = "trang_thai")
    private int trangThai;
}
