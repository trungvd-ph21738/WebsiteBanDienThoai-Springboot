package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.ChucVu;
import com.poly.sd17322.repositories.ChucVuRepository;
import com.poly.sd17322.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public Page<ChucVu> getAll(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public List<ChucVu> findAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu findById(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    @Override
    public ChucVu addOrUpdate(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu update(UUID id, ChucVu chucVu) {
        if(chucVu!=null){
            ChucVu chucVuUpdate = chucVuRepository.getReferenceById(id);
            if(chucVuUpdate!=null){
                chucVuUpdate.setMa(chucVu.getMa());
                chucVuUpdate.setTen(chucVu.getTen());

                return chucVuRepository.save(chucVuUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            ChucVu chucVu = chucVuRepository.findById(id).orElse(null);
            chucVuRepository.delete(chucVu);
            return true;
        }
        return  false;
    }

    @Override
    public Boolean existsByMa(String ma) {
        if(chucVuRepository.existsByMa(ma)){
            return true;
        }
        return false;
    }
}
