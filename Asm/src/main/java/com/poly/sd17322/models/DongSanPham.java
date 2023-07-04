package com.poly.sd17322.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "dong_sp")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DongSanPham {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Mã không được để trống")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Tên không để trống thông tin")
    @Column(name = "ten")
    private String ten;
}
