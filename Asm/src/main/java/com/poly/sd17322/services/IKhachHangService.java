package com.poly.sd17322.services;

import com.poly.sd17322.models.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IKhachHangService {
    public Page<KhachHang> getAll(Pageable pageable);

    public List<KhachHang> findAll();

    public KhachHang findById(UUID id);

    public KhachHang add(KhachHang khachHang);

    public KhachHang update(UUID id, KhachHang khachHang);

    public Boolean delete(UUID id);
}
