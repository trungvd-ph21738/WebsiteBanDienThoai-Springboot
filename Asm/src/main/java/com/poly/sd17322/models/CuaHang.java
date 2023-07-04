package com.poly.sd17322.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "cua_hang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuaHang {
    @Id
    @Column(name= "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Không để trống thông tin")
    @Size(min = 6, message = "Tên phải lớn hơn hoặc bằng 6 kí tự")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "dia_chi")
    private String diaChi;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "thanh_pho")
    private String thanhPho;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "quoc_gia")
    private String quocGia;
}
