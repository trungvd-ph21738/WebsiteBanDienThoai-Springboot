package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.CuaHang;
import com.poly.sd17322.repositories.ICuaHangRepository;
import com.poly.sd17322.services.ICuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceIpml implements ICuaHangService {

    @Autowired
    private ICuaHangRepository cuaHangRepository;

    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }

    @Override
    public List<CuaHang> findAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang findById(UUID id) {
        return cuaHangRepository.findById(id).orElse(null);
    }

    @Override
    public CuaHang add(CuaHang cuaHang) {
        return cuaHangRepository.save(cuaHang);
    }

    @Override
    public CuaHang update(UUID id, CuaHang cuaHang) {
        if(id != null){
            CuaHang cuaHangUpdate = cuaHangRepository.findById(id).orElse(null);
            if(cuaHangUpdate!=null){
                cuaHangUpdate.setMa(cuaHang.getMa());
                cuaHangUpdate.setTen(cuaHang.getTen());
                cuaHangUpdate.setDiaChi(cuaHang.getDiaChi());
                cuaHangUpdate.setThanhPho(cuaHang.getThanhPho());
                cuaHangUpdate.setQuocGia(cuaHang.getQuocGia());
                return cuaHangRepository.save(cuaHangUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            CuaHang cuaHang = cuaHangRepository.findById(id).orElse(null);
            cuaHangRepository.delete(cuaHang);
            return true;
        }
        return false;
    }
}
