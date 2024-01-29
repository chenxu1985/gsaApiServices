package cn.ac.big.bigd.webservice.model.elasticsearch;

import java.util.List;

public class Run {
	private String runAcc;
	private String expAcc;
	private String type;
	private String downloadPath;
	private String url;
	private String fileName;
	private String fileSize;
	private List<RunDataFile> runDataFiles;
	private Relation experiment_runs_relation;

	public String getRunAcc() {
		return runAcc;
	}

	public void setRunAcc(String runAcc) {
		this.runAcc = runAcc;
	}

	public String getExpAcc() {
		return expAcc;
	}

	public void setExpAcc(String expAcc) {
		this.expAcc = expAcc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Relation getExperiment_runs_relation() {
		return experiment_runs_relation;
	}

	public List<RunDataFile> getRunDataFiles() {
		return runDataFiles;
	}

	public void setRunDataFiles(List<RunDataFile> runDataFiles) {
		this.runDataFiles = runDataFiles;
	}

	public void setExperiment_runs_relation(Relation experiment_runs_relation) {
		this.experiment_runs_relation = experiment_runs_relation;
	}
}