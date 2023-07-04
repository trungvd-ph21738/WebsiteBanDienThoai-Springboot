package com.poly.sd17322.services;

import com.poly.sd17322.models.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ICuaHangService {
    public Page<CuaHang> getAll(Pageable pageable);

    public List<CuaHang> findAll();

    public CuaHang findById(UUID id);

    public CuaHang add(CuaHang cuaHang);

    public CuaHang update(UUID id, CuaHang cuaHang);

    public Boolean delete(UUID id);
}
