package com.poly.sd17322.services.impl;

import com.poly.sd17322.models.MauSac;
import com.poly.sd17322.repositories.IMauSacRepository;
import com.poly.sd17322.services.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements IMauSacService {

    @Autowired
    private IMauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public List<MauSac> findAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac findById(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public MauSac add(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac update(UUID id, MauSac mauSac) {
        if(id != null){
            MauSac mauSacUpdate = mauSacRepository.findById(id).orElse(null);
            if (mauSacUpdate != null){
                mauSacUpdate.setMa(mauSac.getMa());
                mauSacUpdate.setTen(mauSac.getTen());
                return mauSacRepository.save(mauSacUpdate);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        if(id != null){
            MauSac mauSac = mauSacRepository.findById(id).orElse(null);
            if(mauSac != null){
                mauSacRepository.delete(mauSac);
                return true;
            }
        }
        return null;
    }
}
