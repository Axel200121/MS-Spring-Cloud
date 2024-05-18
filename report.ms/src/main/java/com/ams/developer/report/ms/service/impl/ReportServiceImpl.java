package com.ams.developer.report.ms.service.impl;

import com.ams.developer.report.ms.helpers.ReportHelper;
import com.ams.developer.report.ms.models.Company;
import com.ams.developer.report.ms.models.WebSite;
import com.ams.developer.report.ms.repository.CompaniesRepository;
import com.ams.developer.report.ms.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String nameCompany) {
        return  reportHelper.readTemplate(this.companiesRepository.getByName(nameCompany).orElseThrow());
    }

    @Override
    public String saveReport(String report) {
        var formar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeholders = this.reportHelper.getPlaceholderFromTemplate(report);
        var webSites = Stream.of(placeholders.get(3)).map(webSite -> WebSite.builder().name(webSite).build()).toList();

        var company = com.ams.developer.report.ms.models.Company.builder()
                .name(placeholders.get(0))
                .foundationDate(LocalDate.parse(placeholders.get(1),formar))
                .founder(placeholders.get(2))
                .webSites(webSites)
                .build();

        this.companiesRepository.postByName(company);
        return "SAVED";
    }

    @Override
    public void deleteReport(String nameReport) {

    }
}
