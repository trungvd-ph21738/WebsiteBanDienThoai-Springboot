package com.poly.sd17322.repositories;

import com.poly.sd17322.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, UUID> {
}
