package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.NhaSanXuat;
import com.poly.sd17322.models.SanPham;
import com.poly.sd17322.repositories.INhaSanXuatRepository;
import com.poly.sd17322.services.INhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements INhaSanXuatService {
    @Autowired
    private INhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public Page<NhaSanXuat> getAll(Pageable pageable) {
        return nhaSanXuatRepository.findAll(pageable);
    }

    @Override
    public List<NhaSanXuat> findAll() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public NhaSanXuat findById(UUID id) {
        return nhaSanXuatRepository.findById(id).orElse(null);
    }

    @Override
    public NhaSanXuat add(NhaSanXuat nhaSanXuat) {
        return nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public NhaSanXuat update(UUID id, NhaSanXuat nhaSanXuat) {
        if(id != null){
            NhaSanXuat nhaSanXuatUpdate = nhaSanXuatRepository.findById(id).orElse(null);
            if(nhaSanXuatUpdate != null){
                nhaSanXuatUpdate.setMa(nhaSanXuat.getMa());
                nhaSanXuatUpdate.setTen(nhaSanXuat.getTen());
                nhaSanXuatRepository.save(nhaSanXuatUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(id).orElse(null);
            if(nhaSanXuat!=null){
                nhaSanXuatRepository.delete(nhaSanXuat);
                return true;
            }
        }
        return false;
    }
}
