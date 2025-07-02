package com.bootcamp.demo.demo_mte_caller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_mte_caller.model.dto.ApiResp;
import com.bootcamp.demo.demo_mte_caller.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mte_caller.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService {
  @Autowired
  private RestTemplate restTemplate;
  @Value("${service.api.mtr.host}")
  private String host;
  @Value("${service.api.mtr.schedule.version}")
  private String serviceVer;
  @Value("${service.api.mtr.schedule.endpoint}")
  private String serviceEndpoint;
  

  // !! getForObject doesnot support generic
  @Override
  public ScheduleDTO getSchedule(String lineCode, String stationCode) {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(this.host) //
        .path(this.serviceEndpoint) //
        .buildAndExpand(lineCode, stationCode)
        .toUriString();

    System.out.println("url " + url);

  ResponseEntity<ApiResp<ScheduleDTO>> responseEntity
    = this.restTemplate.exchange(url, //  
        HttpMethod.GET, //
        null,
        new ParameterizedTypeReference<ApiResp<ScheduleDTO>>() {}
        // object downcasts ErrorDTO or ScheduleDTO
    );

  if (responseEntity.getStatusCode() == HttpStatus.OK) { // 200
    ScheduleDTO scheduleDTO = responseEntity.getBody().getData();
    return scheduleDTO;
  }
  return null;
  }
}
