package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.KhachHang;
import com.poly.sd17322.repositories.IKhachHangRepository;
import com.poly.sd17322.services.IKhachHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements IKhachHangService {
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang update(UUID id, KhachHang khachHang) {
        if(id != null){
            KhachHang khachHangUpdate = khachHangRepository.findById(id).orElse(null);
            if (khachHangUpdate != null){
                BeanUtils.copyProperties(khachHang,khachHangUpdate);
                khachHangRepository.save(khachHangUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
            if(khachHang != null){
                khachHangRepository.delete(khachHang);
                return true;
            }
        }
        return false;
    }
}
