package com.ams.developer.companies.crud.repository;

import com.ams.developer.companies.crud.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByName(String name);
}
