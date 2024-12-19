package com.dairyapplication.dairyApplication.controller;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.RateChartDto;
import com.dairyapplication.dairyApplication.service.RateChartIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RateChartController {
    @Autowired
    private RateChartIface rateChartIface;

    @PostMapping("/createratechart")
    public ApiResponse createRateChart(@RequestBody RateChartDto rateChartDto){
        return rateChartIface.createRateChart(rateChartDto);
    }
    @PutMapping("/updatechart/{id}")
    public ApiResponse updaterateChart(@PathVariable Long id, @RequestBody RateChartDto rateChartDto){
        return rateChartIface.updateRateChart(id,rateChartDto);
    }
    @GetMapping("/getallratechartdata")
    public ApiResponse getAllRateChartData(){
        return rateChartIface.getRateChart();
    }
}
