package com.ams.developer.companies.crud.fallback.controller;

import com.ams.developer.companies.crud.fallback.models.Company;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;

@RestController
@RequestMapping(path = "company")
@Slf4j
public class CompanyController {

    public static  final Company DEFAULT_COMPANY = Company
            .builder()
            .id(0L)
            .founder("Fallback")
            .name("Fallback company")
            .logo("http://logo.png")
            .foundationDate(LocalDate.now())
            .webSites(Collections.emptyList())
            .build();

    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET IN FALLBACK: company {}", name);
        return ResponseEntity.ok(DEFAULT_COMPANY);
    }
}
