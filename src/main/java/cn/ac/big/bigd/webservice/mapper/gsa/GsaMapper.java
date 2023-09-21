package cn.ac.big.bigd.webservice.mapper.gsa;

import cn.ac.big.bigd.webservice.model.gsa.*;

import java.util.Map;

import java.util.List;

public interface GsaMapper {
    Run getRunByAccession(String accession);
    List<RunDataFile> getRunDataFileList(String accession);
    List<CraList> getCraList();

}
