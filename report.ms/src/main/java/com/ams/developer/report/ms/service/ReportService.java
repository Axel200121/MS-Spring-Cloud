package com.ams.developer.report.ms.service;

public interface ReportService {

    String makeReport(String nameCompany);
    String saveReport(String nameReport);
    void deleteReport(String nameReport);
}
