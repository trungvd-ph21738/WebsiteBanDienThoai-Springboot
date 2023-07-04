package com.poly.sd17322.services;

import com.poly.sd17322.models.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface INhaSanXuatService {
    public Page<NhaSanXuat> getAll(Pageable pageable);

    public List<NhaSanXuat> findAll();

    public NhaSanXuat findById(UUID id);

    public NhaSanXuat add(NhaSanXuat nhaSanXuat);

    public NhaSanXuat update(UUID id, NhaSanXuat nhaSanXuat);

    public Boolean delete(UUID id);
}
