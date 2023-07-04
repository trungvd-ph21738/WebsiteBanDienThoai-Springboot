package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.HoaDon;
import com.poly.sd17322.repositories.IHoaDonRepository;
import com.poly.sd17322.services.IHoaDonService;
//import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements IHoaDonService {
    @Autowired
    private IHoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> findAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public Page<HoaDon> getAll(Pageable pageable) {
        return hoaDonRepository.findAll(pageable);
    }

    @Override
    public HoaDon findById(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public HoaDon save(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon update(UUID id, HoaDon hoaDon) {
        if(hoaDon != null){
            HoaDon hoaDonUpdate = hoaDonRepository.findById(id).orElse(null);
            if(hoaDonUpdate != null){
                BeanUtils.copyProperties(hoaDon, hoaDonUpdate);
                hoaDonRepository.save(hoaDonUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            HoaDon hoaDon = hoaDonRepository.findById(id).orElse(null);
            hoaDonRepository.delete(hoaDon);
            return true;
        }
        return false;
    }

    @Override
    public HoaDon updateTrangThai(UUID id, Integer trangThai) {
            HoaDon hoaDonUpdate = hoaDonRepository.findById(id).orElse(null);
            if(hoaDonUpdate != null){
                hoaDonUpdate.setTinhTrang(trangThai);
                return hoaDonRepository.save(hoaDonUpdate);
            }
        return null;
    }

    @Override
    public List<HoaDon> findByKhachHangId(UUID id) {
        return hoaDonRepository.findByKhachHangID(id);
    }
}
