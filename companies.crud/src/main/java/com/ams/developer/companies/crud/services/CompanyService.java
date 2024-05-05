package com.ams.developer.companies.crud.services;

import com.ams.developer.companies.crud.entity.Company;

import java.awt.*;

public interface CompanyService {

    Company readByName(String name);
    Company create(Company company);
    Company update(String name, Company company);
    void delete(String name);

}
