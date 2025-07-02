package com.demo.bootcamp.bc_mtr_station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.bootcamp.bc_mtr_station.model.Scheme;
import com.demo.bootcamp.bc_mtr_station.model.dto.ScheduleDTO;
import com.demo.bootcamp.bc_mtr_station.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService {
  @Value("${service-url.mtr.host}")
  private String host;
  @Value("${service-url.mtr.api.mtr-schedule.version}")
  private String serviceVer;
  @Value("${service-url.mtr.api.mtr-schedule.endpoint}")
  private String serviceEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public ScheduleDTO getSchedule(String line, String station) {
    // String url = "https://" + this.host + this.serviceVer + this.serviceEndpoint
    //     + "?line=" + line + "&sta=" + station;
    // return this.restTemplate.getForObject(url, ScheduleDTO.class);
    String url = UriComponentsBuilder.newInstance()
          .scheme(Scheme.HTTPS.getName())
          .host(this.host)
          .pathSegment(this.serviceVer)
          .path(serviceEndpoint)
          .queryParam("line", line)
          .queryParam("sta", station)
          .build()
          .toString();

    return this.restTemplate.getForObject(url, ScheduleDTO.class);

    
  }

  // @Override
  // public EarliestScheduleDTO getEarliestSchedule(String station) {
    
  // }
  
}
