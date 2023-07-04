package com.poly.sd17322.repositories;

import com.poly.sd17322.models.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {
}
