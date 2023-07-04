package com.poly.sd17322.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "khach_hang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class KhachHang {
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

//    @NotNull(message = "Ngày không để trống")
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "sdt")
    private String sdt;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "dia_chi")
    private String diaChi;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "thanh_pho")
    private String thanhPho;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "quoc_gia")
    private String quocGia;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "mat_khau")
    private String matKhau;

}
