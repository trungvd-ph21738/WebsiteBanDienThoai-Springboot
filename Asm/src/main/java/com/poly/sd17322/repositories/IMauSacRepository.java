package com.poly.sd17322.repositories;

import com.poly.sd17322.models.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IMauSacRepository extends JpaRepository<MauSac, UUID> {
}
