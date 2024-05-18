package com.ams.developer.report.ms.service.impl;

import com.ams.developer.report.ms.repository.CompaniesRepository;
import com.ams.developer.report.ms.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;

    @Override
    public String makeReport(String nameCompany) {
        return  this.companiesRepository.getByName(nameCompany).orElseThrow().getName();

    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String nameReport) {

    }
}
