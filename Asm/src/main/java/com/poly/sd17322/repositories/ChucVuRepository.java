package com.poly.sd17322.repositories;

import com.poly.sd17322.models.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    Boolean existsByMa(String ma);
}
