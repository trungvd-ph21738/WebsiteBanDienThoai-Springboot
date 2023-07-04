package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.DongSanPham;
import com.poly.sd17322.repositories.IDongSanPhamRepository;
import com.poly.sd17322.services.IDongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements IDongSanPhamService {

    @Autowired
    private IDongSanPhamRepository dongSanPhamRepository;

    @Override
    public Page<DongSanPham> getAll(Pageable pageable) {
        return dongSanPhamRepository.findAll(pageable);
    }

    @Override
    public List<DongSanPham> findAll() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public DongSanPham findById(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public DongSanPham add(DongSanPham dongSanPham) {
        return dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public DongSanPham update(UUID id, DongSanPham dongSanPham) {
        if (id != null) {
            DongSanPham dongSanPhamUpdate = dongSanPhamRepository.findById(id).orElse(null);
            dongSanPhamUpdate.setMa(dongSanPham.getMa());
            dongSanPhamUpdate.setTen(dongSanPham.getTen());
            return dongSanPhamRepository.save(dongSanPhamUpdate);
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if (id != null) {
            DongSanPham dongSanPham = dongSanPhamRepository.findById(id).orElse(null);
            if (dongSanPham != null) {
                dongSanPhamRepository.delete(dongSanPham);
                return true;
            }
        }
        return false;
    }
}
