package com.poly.sd17322.repositories;

import com.poly.sd17322.models.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {

//    @Query("SELECT hdct FROM HoaDonChiTiet hdct " +
//            "JOIN FETCH hdct.id.hoaDon d " +
//            "JOIN FETCH hdct.id.chiTietSanPham c " +
//            "WHERE d.id = :hoaDonId")
//    List<HoaDonChiTiet> findByHoaDonId(@Param("hoaDonId") UUID hoaDonId);

    @Query("select hdct from HoaDonChiTiet hdct where hdct.id.hoaDon.id=?1")
    List<HoaDonChiTiet> findByHoaDonId(UUID id);
}

