package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.SanPham;
import com.poly.sd17322.repositories.ISanPhamRepository;
import com.poly.sd17322.services.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements ISanPhamService {

    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham findById(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham update(UUID id, SanPham sanPham) {
        if(id != null){
            SanPham sanPhamUpdate = sanPhamRepository.findById(id).orElse(null);
            if(sanPhamUpdate != null){
                sanPhamUpdate.setMa(sanPham.getMa());
                sanPhamUpdate.setTen(sanPham.getTen());
                sanPhamRepository.save(sanPhamUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            SanPham sanPham = sanPhamRepository.findById(id).orElse(null);
            if(sanPham!=null){
                sanPhamRepository.delete(sanPham);
                return true;
            }
        }
        return false;
    }

//    @Scheduled(cron = "1 * * * * *")
//    public void testTienTrinh(){
//        System.out.println("Hello Các bạn");
//    }
}
