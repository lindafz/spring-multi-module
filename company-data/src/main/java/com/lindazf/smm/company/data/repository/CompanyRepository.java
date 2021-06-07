package com.lindazf.smm.company.data.repository;

import com.lindazf.smm.company.data.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Long>{
    Optional<Company> findByCompanyName(String companyName);

}