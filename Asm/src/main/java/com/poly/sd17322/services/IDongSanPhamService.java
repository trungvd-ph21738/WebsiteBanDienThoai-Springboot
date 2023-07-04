package com.poly.sd17322.services;

import com.poly.sd17322.models.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IDongSanPhamService {
    public Page<DongSanPham> getAll(Pageable pageable);

    public List<DongSanPham> findAll();

    public DongSanPham findById(UUID id);

    DongSanPham add(DongSanPham dongSanPham);

    public DongSanPham update(UUID id, DongSanPham dongSanPham);

    public Boolean delete(UUID id);
}
