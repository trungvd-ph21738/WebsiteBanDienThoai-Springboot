package com.poly.sd17322.services;

import com.poly.sd17322.models.HoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface IHoaDonChiTietService {
    public List<HoaDonChiTiet> findAll();

    public HoaDonChiTiet findById(UUID id);

    public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet);

    public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> hoaDonChiTiets);

    public HoaDonChiTiet update(UUID id, HoaDonChiTiet hoaDonChiTiet);

    public Boolean delete(UUID id);

    public List<HoaDonChiTiet> findByHoaDonId(UUID id);
}
