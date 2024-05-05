package com.ams.developer.companies.crud.services.impl;

import com.ams.developer.companies.crud.entity.Category;
import com.ams.developer.companies.crud.entity.Company;
import com.ams.developer.companies.crud.repository.CompanyRepository;
import com.ams.developer.companies.crud.services.CompanyService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("Compañia no encontrada"));
    }

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
            if (Objects.isNull(webSite.getCategory())){
                webSite.setCategory(Category.NONE);
            }
        });
        return this.companyRepository.save(company);
    }

    @Override
    public Company update(String name, Company company) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("Compañia no encontrada"));

        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = this.companyRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("Compañia no encontrada"));
        this.companyRepository.delete(companyToDelete);
    }
}
