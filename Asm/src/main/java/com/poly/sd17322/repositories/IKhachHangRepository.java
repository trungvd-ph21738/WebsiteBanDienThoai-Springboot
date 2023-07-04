package com.poly.sd17322.repositories;

import com.poly.sd17322.models.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang, UUID> {
}
