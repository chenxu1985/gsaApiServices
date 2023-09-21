package cn.ac.big.bigd.webservice.model.gsa;

import java.util.List;

public class Run {
    private String accession;
	private List<RunDataFile> runDataFiles;
	private String ftpUrl;

	public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}

	public List<RunDataFile> getRunDataFiles() {
		return runDataFiles;
	}

	public void setRunDataFiles(List<RunDataFile> runDataFiles) {
		this.runDataFiles = runDataFiles;
	}

	public String getFtpUrl() {
		return ftpUrl;
	}

	public void setFtpUrl(String ftpUrl) {
		this.ftpUrl = ftpUrl;
	}
}