package cn.ac.big.bigd.webservice.model.elasticsearch;
import java.util.List;

public class Experiment {
	private String center;
	private String type;
	private String accession;
	private String downloadable;
	private List<FileType> fileTypes;
	private String title;
	private String libraryName;
	private String libDesign;
	private String libLayout;
	private List<Platform> platforms;
	private String source;
	private String strategy;
	private String selection;
	private String insertSize;
	private String releaseTime;
	private String dataset;
	private String projectAcc;
	private String projectTitle;
	private String projectDesc;
	private String sampleAcc;
	private String sampleName;
	private String sampleTitle;
	private String sampleDesc;
	private String sampleType;
	private String taxId;
	private String organism;
	private String properties;
	private String releaseState;
	private String url;
	private String createTime;
	private String submitter;
	private String organization;
	private List<Run> runs;
	private Integer libNominalSize;
	private Integer libNominalStandardDeviation;
	private Integer plannedReadLength;
	private Integer plannedReadLengthMate1;
	private Integer plannedReadLengthMate2;
	private Integer plannedNumberOfCycles;
	private Relation experiment_runs_relation;
	private int expCount;

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}

	public String getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibDesign() {
		return libDesign;
	}

	public void setLibDesign(String libDesign) {
		this.libDesign = libDesign;
	}

	public String getLibLayout() {
		return libLayout;
	}

	public void setLibLayout(String libLayout) {
		this.libLayout = libLayout;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getInsertSize() {
		return insertSize;
	}

	public void setInsertSize(String insertSize) {
		this.insertSize = insertSize;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		if(releaseTime!=null&&releaseTime!=""&&!releaseTime.equals("")){
			releaseTime = releaseTime.substring(0,10);
			if(releaseTime.contains(" ")){
				releaseTime = releaseTime.substring(0,8);
			}
		} else {
			releaseTime = "-";
		}
		this.releaseTime = releaseTime;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String getProjectAcc() {
		return projectAcc;
	}

	public void setProjectAcc(String projectAcc) {
		this.projectAcc = projectAcc;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getSampleAcc() {
		return sampleAcc;
	}

	public void setSampleAcc(String sampleAcc) {
		this.sampleAcc = sampleAcc;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSampleTitle() {
		return sampleTitle;
	}

	public void setSampleTitle(String sampleTitle) {
		this.sampleTitle = sampleTitle;
	}

	public String getSampleDesc() {
		return sampleDesc;
	}

	public void setSampleDesc(String sampleDesc) {
		this.sampleDesc = sampleDesc;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getOrganism() {
		return organism;
	}

	public void setOrganism(String organism) {
		this.organism = organism;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getReleaseState() {
		return releaseState;
	}

	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		createTime = createTime.substring(0,10);
		this.createTime = createTime;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<Run> getRuns() {
		return runs;
	}

	public void setRuns(List<Run> runs) {
		this.runs = runs;
	}

	public Integer getLibNominalSize() {
		return libNominalSize;
	}

	public void setLibNominalSize(Integer libNominalSize) {
		this.libNominalSize = libNominalSize;
	}

	public Integer getLibNominalStandardDeviation() {
		return libNominalStandardDeviation;
	}

	public void setLibNominalStandardDeviation(Integer libNominalStandardDeviation) {
		this.libNominalStandardDeviation = libNominalStandardDeviation;
	}

	public Integer getPlannedReadLength() {
		return plannedReadLength;
	}

	public void setPlannedReadLength(Integer plannedReadLength) {
		this.plannedReadLength = plannedReadLength;
	}

	public Integer getPlannedReadLengthMate1() {
		return plannedReadLengthMate1;
	}

	public void setPlannedReadLengthMate1(Integer plannedReadLengthMate1) {
		this.plannedReadLengthMate1 = plannedReadLengthMate1;
	}

	public Integer getPlannedReadLengthMate2() {
		return plannedReadLengthMate2;
	}

	public void setPlannedReadLengthMate2(Integer plannedReadLengthMate2) {
		this.plannedReadLengthMate2 = plannedReadLengthMate2;
	}

	public Integer getPlannedNumberOfCycles() {
		return plannedNumberOfCycles;
	}

	public void setPlannedNumberOfCycles(Integer plannedNumberOfCycles) {
		this.plannedNumberOfCycles = plannedNumberOfCycles;
	}

	public Relation getExperiment_runs_relation() {
		return experiment_runs_relation;
	}

	public void setExperiment_runs_relation(Relation experiment_runs_relation) {
		this.experiment_runs_relation = experiment_runs_relation;
	}

	public int getExpCount() {
		return expCount;
	}

	public void setExpCount(int expCount) {
		this.expCount = expCount;
	}

	public List<FileType> getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(List<FileType> fileTypes) {
		this.fileTypes = fileTypes;
	}

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}
}