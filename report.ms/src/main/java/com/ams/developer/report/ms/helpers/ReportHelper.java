package com.ams.developer.report.ms.helpers;

import com.ams.developer.report.ms.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportHelper {
    @Value("${report.template}")
    private String reportTemplate;

    public  String readTemplate(Company company){
        return this.reportTemplate
                .replace("{company", company.getName())
                .replace("{foundation_date", company.getFoundationDate().toString())
                .replace("{founder",company.getFounder())
                .replace("{web_sites}",company.getWebSites().toString());
    }
}
