package com.poly.sd17322.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "hoa_don_chi_tiet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private BigDecimal donGia;
}
