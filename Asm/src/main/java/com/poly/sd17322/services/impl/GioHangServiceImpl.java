package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.GioHang;
import com.poly.sd17322.repositories.IGioHangRepository;
import com.poly.sd17322.services.IGioHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements IGioHangService {
    @Autowired
    private IGioHangRepository gioHangRepository;

    @Override
    public Page<GioHang> getAll(Pageable pageable) {
        return gioHangRepository.findAll(pageable);
    }

    @Override
    public List<GioHang> findAll() {
        return gioHangRepository.findAll();
    }

    @Override
    public GioHang findById(UUID id) {
        return gioHangRepository.findById(id).orElse(null);
    }

    @Override
    public GioHang add(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }

    @Override
    public GioHang update(UUID id, GioHang gioHang) {
        if(gioHang!=null){
            GioHang gioHangUpdate = gioHangRepository.findById(id).orElse(null);
            if(gioHangUpdate!=null){
                BeanUtils.copyProperties(gioHang,gioHangUpdate);
                return gioHangRepository.save(gioHangUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            GioHang gioHang = gioHangRepository.findById(id).orElse(null);
            gioHangRepository.delete(gioHang);
            return true;
        }
        return  false;
    }
}
