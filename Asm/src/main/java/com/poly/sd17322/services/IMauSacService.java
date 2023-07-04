package com.poly.sd17322.services;

import com.poly.sd17322.models.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IMauSacService {
    public Page<MauSac> getAll(Pageable pageable);

    public List<MauSac> findAll();

    public MauSac findById(UUID id);

    public MauSac add(MauSac mauSac);

    public MauSac update(UUID id, MauSac mauSac);

    public Boolean delete(UUID id);
}
