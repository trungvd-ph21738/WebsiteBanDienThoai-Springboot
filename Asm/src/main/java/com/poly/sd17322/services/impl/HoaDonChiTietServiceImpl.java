package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.HoaDonChiTiet;
import com.poly.sd17322.models.IdHoaDonChiTiet;
import com.poly.sd17322.repositories.IHoaDonChiTietRepository;
import com.poly.sd17322.services.IHoaDonChiTietService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HoaDonChiTietServiceImpl implements IHoaDonChiTietService {

    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet findById(UUID id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> hoaDonChiTiets) {
        return hoaDonChiTietRepository.saveAll(hoaDonChiTiets);
    }

    @Override
    public HoaDonChiTiet update(UUID id, HoaDonChiTiet hoaDonChiTiet) {
        if(hoaDonChiTiet != null){
            HoaDonChiTiet hoaDonChiTietUpdate = hoaDonChiTietRepository.findById(id).orElse(null);
            if(hoaDonChiTietUpdate != null){
                BeanUtils.copyProperties(hoaDonChiTiet, hoaDonChiTietUpdate);
                return  hoaDonChiTietRepository.save(hoaDonChiTietUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
           HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id).orElse(null);
           hoaDonChiTietRepository.delete(hoaDonChiTiet);
           return true;
        }
        return false;
    }

    @Override
    public List<HoaDonChiTiet> findByHoaDonId(UUID hoaDonId) {
        return hoaDonChiTietRepository.findByHoaDonId(hoaDonId);
    }

}
