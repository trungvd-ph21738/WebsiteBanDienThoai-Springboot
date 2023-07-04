package com.poly.sd17322.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private UUID id;
    private String tenSanPham;
    private String tenDongSanPham;
    private String mauSac;
    private String nhaSanXuat;
    private Integer soLuong;
    private BigDecimal giaBan;

}
