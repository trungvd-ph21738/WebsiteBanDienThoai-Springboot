package com.poly.sd17322.services;

import com.poly.sd17322.models.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IHoaDonService {
    public List<HoaDon> findAll();

    public Page<HoaDon> getAll(Pageable pageable);

    public HoaDon findById(UUID id);

    public HoaDon save(HoaDon hoaDon);

    public HoaDon update(UUID id, HoaDon hoaDon);

    public Boolean delete(UUID id);

    public HoaDon updateTrangThai(UUID id, Integer trangThai);

    public List<HoaDon> findByKhachHangId(UUID id);
}
