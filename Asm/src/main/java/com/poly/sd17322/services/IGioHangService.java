package com.poly.sd17322.services;

import com.poly.sd17322.models.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IGioHangService {
    public Page<GioHang> getAll(Pageable pageable);

    public List<GioHang> findAll();

    public GioHang findById(UUID id);

    GioHang add(GioHang gioHang);

    public GioHang update(UUID id, GioHang gioHang);

    public Boolean delete(UUID id);
}
