package com.ams.developer.companies.crud.repository;

import com.ams.developer.companies.crud.entity.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite,Long> {
}
