package com.poly.sd17322.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "chi_tiet_sp")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSanPham {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nsx")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dong_sp")
    private DongSanPham dongSanPham;

    @NotNull(message = "Không để trống thông tin")
    @Min(value = 1,message = "Năm bảo hành phải lớn hơn 1")
    @Column(name = "nam_bh")
    private Integer namBaoHanh;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "mo_ta")
    private String moTa;

    @NotNull(message = "Không để trống thông tin")
    @Min(value = 1,message = "Phải lớn hơn 1")
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @NotNull(message = "Không để trống thông tin")
    @Min(value = 1,message = "Phải lớn hơn 1")
    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @NotNull(message = "Không để trống thông tin")
    @Min(value = 1,message = "Phải lớn hơn 1")
    @Column(name = "gia_ban")
    private BigDecimal giaBan;
}
