package com.lindazf.smm.company.data.service;

import com.lindazf.smm.company.data.exception.CompanyExceptionDetails;
import com.lindazf.smm.company.data.exception.ErrorCode;
import com.lindazf.smm.company.data.exception.ErrorMessage;
import com.lindazf.smm.company.data.domain.Company;
import com.lindazf.smm.company.data.domain.CompanyUser;
import com.lindazf.smm.company.data.repository.CompanyRepository;
import com.lindazf.smm.company.data.repository.CompanyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    public List<CompanyUser> getCompanyUserList() {
        return companyUserRepository.findAll();
    }

    public Company createCompany(Company company) throws CompanyExceptionDetails {
        if (company.getCompanyId() != null || findCompanyByName(company.getCompanyName()).getCompanyId() != null) {
            throw new CompanyExceptionDetails(ErrorMessage.COMPANY_NAME_EXIST + ", NAME = " + company.getCompanyName(), ErrorCode.CONFLICT);
        }
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company) throws CompanyExceptionDetails {
        if (company.getCompanyId() == null) {
            company.setCompanyId(findCompanyByName(company.getCompanyName()).getCompanyId());
        }
        return companyRepository.save(company);
    }

    public CompanyUser createCompanyUser(CompanyUser user) throws CompanyExceptionDetails {
           return companyUserRepository.save(user);
    }

    public CompanyUser updateUser(CompanyUser user) throws CompanyExceptionDetails {
        return companyUserRepository.save(user);
    }

    public Company findCompanyById(Long companyId) throws CompanyExceptionDetails {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyExceptionDetails(ErrorMessage.COMPANY_NOT_EXIST + ", ID = " + companyId, ErrorCode.NOT_FOUND));
        return company;
    }

    public CompanyUser findCompanyUserById(Long userId) throws CompanyExceptionDetails {
        CompanyUser user = companyUserRepository.findById(userId).orElseThrow(() -> new CompanyExceptionDetails(ErrorMessage.COMPANY_NOT_EXIST + ",ID =" + userId, ErrorCode.NOT_FOUND));
        return user;
    }

    public Company findCompanyByName(String companyName) throws CompanyExceptionDetails {
        Company company = companyRepository.findByCompanyName(companyName).orElseThrow(() -> new CompanyExceptionDetails(ErrorMessage.COMPANY_NAME_EXIST + ", NAME =" + companyName, ErrorCode.NOT_FOUND));
        return company;
    }
}
