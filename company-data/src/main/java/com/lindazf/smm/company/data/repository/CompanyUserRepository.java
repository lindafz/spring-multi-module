package com.lindazf.smm.company.data.repository;

import com.lindazf.smm.company.data.domain.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, Long> {

}
