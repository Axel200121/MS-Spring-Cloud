package com.ams.developer.report.ms.repository;

import com.ams.developer.report.ms.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
@Slf4j
public class CompaniesFallBackRepository {

    private final WebClient webClient;
    private final String uri;

    public CompaniesFallBackRepository(WebClient webClient, @Value("${fallback.uri}")String uri) {
        this.webClient = webClient;
        this.uri = uri;
    }

    public Company getCompany(String name){
        log.warn("LLAMANDO A COMPANIES FALLBACK {}", uri);
        return this.webClient
                .get()
                .uri(uri,name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Company.class)
                .log()
                .block();
    }

}
