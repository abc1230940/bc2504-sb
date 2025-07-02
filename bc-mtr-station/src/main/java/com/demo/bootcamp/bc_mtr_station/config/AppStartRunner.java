package com.demo.bootcamp.bc_mtr_station.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;
import com.demo.bootcamp.bc_mtr_station.repository.LineRepository;
import com.demo.bootcamp.bc_mtr_station.repository.StationRepository;

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;

  @Override
  public void run(String... args) throws Exception {

    if (this.lineRepository.count() == 0) {

      List<LineEntity> lineEntities = List.of(
          LineEntity.builder().lineCode("AEL").name("Airport Express").build(),
          LineEntity.builder().lineCode("TCL").name("Tung Chung Line").build(),
          LineEntity.builder().lineCode("TML").name("Tuen Ma Line").build(),
          LineEntity.builder().lineCode("TKL").name("Tseung Kwan O Line")
              .build(),
          LineEntity.builder().lineCode("EAL").name("East Rail Line").build(),
          LineEntity.builder().lineCode("SIL").name("South Island Line")
              .build(),
          LineEntity.builder().lineCode("TWL").name("Tsuen Wan Line").build(),
          LineEntity.builder().lineCode("ISL").name("Island Line").build(),
          LineEntity.builder().lineCode("KTL").name("Kwun Tong Line").build(),
          LineEntity.builder().lineCode("DRL").name("Disneyland Resort Line")
              .build());

      this.lineRepository.saveAll(lineEntities);

    }

    if (this.stationRepository.count() == 0) {

      LineEntity aelLine =
          this.lineRepository.findByLineCode("AEL").orElse(null);
      List<StationEntity> stationsAEL = new ArrayList<>();
      stationsAEL
          .add(StationEntity.builder().stationCode("HOK").name("Hong Kong")
              .prev(null).next("KOW").lineEntity(aelLine).build());
      stationsAEL.add(StationEntity.builder().stationCode("KOW").name("Kowloon")
          .prev("HOK").next("TSY").lineEntity(aelLine).build());
      stationsAEL
          .add(StationEntity.builder().stationCode("TSY").name("Tsing Yi")
              .prev("KOW").next("AIR").lineEntity(aelLine).build());
      stationsAEL.add(StationEntity.builder().stationCode("AIR").name("Airport")
          .prev("TSY").next("AWE").lineEntity(aelLine).build());
      stationsAEL.add(StationEntity.builder().stationCode("AWE")
          .name("AsiaWorld Expo").prev("AIR").next(null) // End of line
          .lineEntity(aelLine).build());

      LineEntity tclLine = lineRepository.findByLineCode("TCL").orElse(null);
      List<StationEntity> stationsTCL = new ArrayList<>();
      stationsTCL
          .add(StationEntity.builder().stationCode("HOK").name("Hong Kong")
              .prev(null).next("KOW").lineEntity(tclLine).build());
      stationsTCL.add(StationEntity.builder().stationCode("KOW").name("Kowloon")
          .prev("HOK").next("OLY").lineEntity(tclLine).build());
      stationsTCL.add(StationEntity.builder().stationCode("OLY").name("Olympic")
          .prev("KOW").next("NAC").lineEntity(tclLine).build());
      stationsTCL
          .add(StationEntity.builder().stationCode("NAC").name("Nam Cheong")
              .prev("OLY").next("LAK").lineEntity(tclLine).build());
      stationsTCL
          .add(StationEntity.builder().stationCode("LAK").name("Lai King")
              .prev("NAC").next("TSY").lineEntity(tclLine).build());
      stationsTCL
          .add(StationEntity.builder().stationCode("TSY").name("Tsing Yi")
              .prev("LAK").next("SUN").lineEntity(tclLine).build());
      stationsTCL
          .add(StationEntity.builder().stationCode("SUN").name("Sunny Bay")
              .prev("TSY").next("TUC").lineEntity(tclLine).build());
      stationsTCL
          .add(StationEntity.builder().stationCode("TUC").name("Tung Chung")
              .prev("SUN").next(null).lineEntity(tclLine).build());

      LineEntity tmlLine = lineRepository.findByLineCode("TML").orElse(null);
      List<StationEntity> stationsTML = new ArrayList<>();
      stationsTML
          .add(StationEntity.builder().stationCode("WKS").name("Wu Kai Sha")
              .prev(null).next("MOS").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("MOS").name("Ma On Shan")
              .prev("WKS").next("HEO").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("HEO").name("Heng On")
          .prev("MOS").next("TSH").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("TSH").name("Tai Shui Hang")
              .prev("HEO").next("SHM").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("SHM").name("Shek Mun")
              .prev("TSH").next("CIO").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("CIO").name("City One")
              .prev("SHM").next("STW").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("STW").name("Sha Tin Wai")
              .prev("CIO").next("CKT").lineEntity(tmlLine).build());
      stationsTML.add(
          StationEntity.builder().stationCode("CKT").name("Che Kung Temple")
              .prev("STW").next("TAW").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("TAW").name("Tai Wai")
          .prev("CKT").next("HIK").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("HIK").name("Hin Keng")
              .prev("TAW").next("DIH").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("DIH").name("Diamond Hill")
              .prev("HIK").next("KAT").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("KAT").name("Kai Tak")
          .prev("DIH").next("SUW").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("SUW").name("Sung Wong Toi")
              .prev("KAT").next("TKW").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("TKW").name("To Kwa Wan")
              .prev("SUW").next("HOM").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("HOM").name("Ho Man Tin")
              .prev("TKW").next("HUH").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("HUH").name("Hung Hom")
              .prev("HOM").next("ETS").lineEntity(tmlLine).build());
      stationsTML.add(
          StationEntity.builder().stationCode("ETS").name("East Tsim Sha Tsui")
              .prev("HUH").next("AUS").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("AUS").name("Austin")
          .prev("ETS").next("NAC").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("NAC").name("Nam Cheong")
              .prev("AUS").next("MEF").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("MEF").name("Mei Foo")
          .prev("NAC").next("TWW").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("TWW").name("Tsuen Wan West")
              .prev("MEF").next("KSR").lineEntity(tmlLine).build());
      stationsTML.add(
          StationEntity.builder().stationCode("KSR").name("Kam Sheung Road")
              .prev("TWW").next("YUL").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("YUL").name("Yuen Long")
              .prev("KSR").next("LOP").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("LOP").name("Long Ping")
              .prev("YUL").next("TIS").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("TIS").name("Tin Shui Wai")
              .prev("LOP").next("SIH").lineEntity(tmlLine).build());
      stationsTML
          .add(StationEntity.builder().stationCode("SIH").name("Siu Hong")
              .prev("TIS").next("TUM").lineEntity(tmlLine).build());
      stationsTML.add(StationEntity.builder().stationCode("TUM")
          .name("Tuen Mun").prev("SIH").next(null).lineEntity(tmlLine).build());

      LineEntity tklLine = lineRepository.findByLineCode("TKL").orElse(null);
      List<StationEntity> stationsTKL = new ArrayList<>();
      stationsTKL
          .add(StationEntity.builder().stationCode("NOP").name("North Point")
              .prev(null).next("QUB").lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("QUB").name("Quarry Bay")
              .prev("NOP").next("YAT").lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("YAT").name("Yau Tong")
              .prev("QUB").next("TIK").lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("TIK").name("Tiu Keng Leng")
              .prev("YAT").next("TKO").lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("TKO").name("Tseung Kwan O")
              .prev("TIK").next("LHP").lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("LHP").name("LOHAS Park")
              .prev("TKO").next(null).lineEntity(tklLine).build());
      stationsTKL
          .add(StationEntity.builder().stationCode("HAH").name("Hang Hau")
              .prev("TKO").next("POA").lineEntity(tklLine).build());
      stationsTKL.add(StationEntity.builder().stationCode("POA").name("Po Lam")
          .prev("HAH").next(null).lineEntity(tklLine).build());

      LineEntity ealLine = lineRepository.findByLineCode("EAL").orElse(null);
      List<StationEntity> stationsEAL = new ArrayList<>();
      stationsEAL
          .add(StationEntity.builder().stationCode("ADM").name("Admiralty")
              .prev(null).next("EXC").lineEntity(ealLine).build());
      stationsEAL.add(
          StationEntity.builder().stationCode("EXC").name("Exhibition Centre")
              .prev("ADM").next("HUH").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("HUH").name("Hung Hom")
              .prev("EXC").next("MKK").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("MKK").name("Mong Kok East")
              .prev("HUH").next("KOT").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("KOT").name("Kowloon Tong")
              .prev("MKK").next("TAW").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("TAW").name("Tai Wai")
          .prev("KOT").next("SHT").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("SHT").name("Sha Tin")
          .prev("TAW").next("FOT").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("FOT").name("Fo Tan")
          .prev("SHT").next("RAC").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("RAC").name("Racecourse")
              .prev("FOT").next("UNI").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("UNI").name("University")
              .prev("RAC").next("TAP").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("TAP").name("Tai Po Market")
              .prev("UNI").next("TWO").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("TWO").name("Tai Wo")
          .prev("TAP").next("FAN").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("FAN").name("Fanling")
          .prev("TWO").next("SHS").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("SHS").name("Sheung Shui")
              .prev("FAN").next("LOW").lineEntity(ealLine).build());
      stationsEAL.add(StationEntity.builder().stationCode("LOW").name("Lo Wu")
          .prev("SHS").next("LMC").lineEntity(ealLine).build());
      stationsEAL
          .add(StationEntity.builder().stationCode("LMC").name("Lok Ma Chau")
              .prev("LOW").next(null).lineEntity(ealLine).build());

      LineEntity silLine =
          lineRepository.findByLineCode("SIL").orElseThrow(null);
      List<StationEntity> stationsSIL = new ArrayList<>();
      stationsSIL
          .add(StationEntity.builder().stationCode("ADM").name("Admiralty")
              .prev(null).next("OCP").lineEntity(silLine).build());
      stationsSIL
          .add(StationEntity.builder().stationCode("OCP").name("Ocean Park")
              .prev("ADM").next("WCH").lineEntity(silLine).build());
      stationsSIL
          .add(StationEntity.builder().stationCode("WCH").name("Wong Chuk Hang")
              .prev("OCP").next("LET").lineEntity(silLine).build());
      stationsSIL
          .add(StationEntity.builder().stationCode("LET").name("Lei Tung")
              .prev("WCH").next("SOH").lineEntity(silLine).build());
      stationsSIL
          .add(StationEntity.builder().stationCode("SOH").name("South Horizons")
              .prev("LET").next(null).lineEntity(silLine).build());

      LineEntity twlLine = lineRepository.findByLineCode("TWL").orElse(null);
      List<StationEntity> stationsTWL = new ArrayList<>();
      stationsTWL.add(StationEntity.builder().stationCode("CEN").name("Central")
          .prev(null).next("ADM").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("ADM").name("Admiralty")
              .prev("CEN").next("TST").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("TST").name("Tsim Sha Tsui")
              .prev("ADM").next("JOR").lineEntity(twlLine).build());
      stationsTWL.add(StationEntity.builder().stationCode("JOR").name("Jordan")
          .prev("TST").next("YMT").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("YMT").name("Yau Ma Tei")
              .prev("JOR").next("MOK").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("MOK").name("Mong Kok")
              .prev("YMT").next("PRE").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("PRE").name("Prince Edward")
              .prev("MOK").next("SSP").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("SSP").name("Sham Shui Po")
              .prev("PRE").next("CSW").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("CSW").name("Cheung Sha Wan")
              .prev("SSP").next("LCK").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("LCK").name("Lai Chi Kok")
              .prev("CSW").next("MEF").lineEntity(twlLine).build());
      stationsTWL.add(StationEntity.builder().stationCode("MEF").name("Mei Foo")
          .prev("LCK").next("LAK").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("LAK").name("Lai King")
              .prev("MEF").next("KWF").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("KWF").name("Kwai Fong")
              .prev("LAK").next("KWH").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("KWH").name("Kwai Hing")
              .prev("KWF").next("TWH").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("TWH").name("Tai Wo Hau")
              .prev("KWH").next("TSW").lineEntity(twlLine).build());
      stationsTWL
          .add(StationEntity.builder().stationCode("TSW").name("Tsuen Wan")
              .prev("TWH").next(null).lineEntity(twlLine).build());

      LineEntity islLine = lineRepository.findByLineCode("ISL").orElse(null);
      List<StationEntity> stationsISL = new ArrayList<>();
      stationsISL
          .add(StationEntity.builder().stationCode("KET").name("Kennedy Town")
              .prev(null).next("HKU").lineEntity(islLine).build());
      stationsISL.add(StationEntity.builder().stationCode("HKU").name("HKU")
          .prev("KET").next("SYP").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("SYP").name("Sai Ying Pun")
              .prev("HKU").next("SHW").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("SHW").name("Sheung Wan")
              .prev("SYP").next("CEN").lineEntity(islLine).build());
      stationsISL.add(StationEntity.builder().stationCode("CEN").name("Central")
          .prev("SHW").next("ADM").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("ADM").name("Admiralty")
              .prev("CEN").next("WAC").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("WAC").name("Wan Chai")
              .prev("ADM").next("CAB").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("CAB").name("Causeway Bay")
              .prev("WAC").next("TIH").lineEntity(islLine).build());
      stationsISL.add(StationEntity.builder().stationCode("TIH").name("Tin Hau")
          .prev("CAB").next("FOH").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("FOH").name("Fortress Hill")
              .prev("TIH").next("NOP").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("NOP").name("North Point")
              .prev("FOH").next("QUB").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("QUB").name("Quarry Bay")
              .prev("NOP").next("TAK").lineEntity(islLine).build());
      stationsISL.add(StationEntity.builder().stationCode("TAK").name("Tai Koo")
          .prev("QUB").next("SWH").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("SWH").name("Sai Wan Ho")
              .prev("TAK").next("SKW").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("SKW").name("Shau Kei Wan")
              .prev("SWH").next("HFC").lineEntity(islLine).build());
      stationsISL
          .add(StationEntity.builder().stationCode("HFC").name("Heng Fa Chuen")
              .prev("SKW").next("CHW").lineEntity(islLine).build());
      stationsISL.add(StationEntity.builder().stationCode("CHW")
          .name("Chai Wan").prev("HFC").next(null).lineEntity(islLine).build());

      LineEntity ktlLine = lineRepository.findByLineCode("KTL").orElse(null);
      List<StationEntity> stationsKTL = new ArrayList<>();
      stationsKTL.add(StationEntity.builder().stationCode("WHA").name("Whampoa")
          .prev(null).next("HOM").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("HOM").name("Ho Man Tin")
              .prev("WHA").next("YMT").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("YMT").name("Yau Ma Tei")
              .prev("HOM").next("MOK").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("MOK").name("Mong Kok")
              .prev("YMT").next("PRE").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("PRE").name("Prince Edward")
              .prev("MOK").next("SKM").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("SKM").name("Shek Kip Mei")
              .prev("PRE").next("KOT").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("KOT").name("Kowloon Tong")
              .prev("SKM").next("LOF").lineEntity(ktlLine).build());
      stationsKTL.add(StationEntity.builder().stationCode("LOF").name("Lok Fu")
          .prev("KOT").next("WTS").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("WTS").name("Wong Tai Sin")
              .prev("LOF").next("DIH").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("DIH").name("Diamond Hill")
              .prev("WTS").next("CHH").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("CHH").name("Choi Hung")
              .prev("DIH").next("KOB").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("KOB").name("Kowloon Bay")
              .prev("CHH").next("NTK").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("NTK").name("Ngau Tau Kok")
              .prev("KOB").next("KWT").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("KWT").name("Kwun Tong")
              .prev("NTK").next("LAT").lineEntity(ktlLine).build());
      stationsKTL.add(StationEntity.builder().stationCode("LAT").name("Lam Tin")
          .prev("KWT").next("YAT").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("YAT").name("Yau Tong")
              .prev("LAT").next("TIK").lineEntity(ktlLine).build());
      stationsKTL
          .add(StationEntity.builder().stationCode("TIK").name("Tiu Keng Leng")
              .prev("YAT").next(null).lineEntity(ktlLine).build());

      LineEntity drlLine = lineRepository.findByLineCode("DRL").orElse(null);
      List<StationEntity> stationsDRL = new ArrayList<>();
      stationsDRL
          .add(StationEntity.builder().stationCode("SUN").name("Sunny Bay")
              .prev(null).next("DIS").lineEntity(drlLine).build());
      stationsDRL.add(
          StationEntity.builder().stationCode("DIS").name("Disneyland Resort")
              .prev("SUN").next(null).lineEntity(drlLine).build());

      this.stationRepository.saveAll(stationsAEL);
      this.stationRepository.saveAll(stationsTCL);
      this.stationRepository.saveAll(stationsTML);
      this.stationRepository.saveAll(stationsTKL);
      this.stationRepository.saveAll(stationsEAL);
      this.stationRepository.saveAll(stationsSIL);
      this.stationRepository.saveAll(stationsTWL);
      this.stationRepository.saveAll(stationsISL);
      this.stationRepository.saveAll(stationsKTL);
      this.stationRepository.saveAll(stationsDRL);



    }



  }
}
