package com.poly.sd17322.repositories;

import com.poly.sd17322.models.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IHoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("select hd from HoaDon hd where hd.khachHang.id=?1")
    List<HoaDon> findByKhachHangID(UUID id);
}
