package com.ams.developer.report.ms.controller;

import com.ams.developer.report.ms.models.Company;
import com.ams.developer.report.ms.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable String name){
        var response = Map.of("report",this.reportService.makeReport(name));
        return  ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<String> postReport(@RequestBody String report){
        return  ResponseEntity.ok(this.reportService.saveReport(report));
    }
}
