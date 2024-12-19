package com.dairyapplication.dairyApplication.service;

import com.dairyapplication.dairyApplication.apputil.ApiResponse;
import com.dairyapplication.dairyApplication.dto.RateChartDto;
import com.dairyapplication.dairyApplication.entity.RateChart;

import java.util.List;

public interface RateChartIface {
    ApiResponse createRateChart(RateChartDto rateChartDto);
    ApiResponse updateRateChart(long id,RateChartDto rateChartDto);
    ApiResponse getRateChart();
}
