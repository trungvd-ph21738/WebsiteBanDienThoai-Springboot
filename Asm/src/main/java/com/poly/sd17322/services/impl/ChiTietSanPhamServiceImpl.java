package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.ChiTietSanPham;
import com.poly.sd17322.models.ChucVu;
import com.poly.sd17322.models.NhanVien;
import com.poly.sd17322.repositories.IChiTietSanPhamRepository;
import com.poly.sd17322.services.IChiTietSanPhamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements IChiTietSanPhamService {
     @Autowired
     private IChiTietSanPhamRepository chiTietSanPhamRepository;


    @Override
    public Page<ChiTietSanPham> getAll(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public List<ChiTietSanPham> findAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSanPham findById(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham update(UUID id, ChiTietSanPham chiTietSanPham) {
        if(id != null){
            ChiTietSanPham chiTietSanPhamUpdate = chiTietSanPhamRepository.findById(id).orElse(null);
            if(chiTietSanPhamUpdate != null){
                BeanUtils.copyProperties(chiTietSanPham, chiTietSanPhamUpdate);
                chiTietSanPhamRepository.save(chiTietSanPhamUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElse(null);
            if(chiTietSanPham != null){
                chiTietSanPhamRepository.delete(chiTietSanPham);
                return true;
            }
        }
        return false;
    }
}
