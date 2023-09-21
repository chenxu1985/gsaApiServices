package cn.ac.big.bigd.webservice.model.api;

public class Api {
    private Integer api_type_id;
	private Integer api_subType_id;
	private String ip;

	public Integer getApi_type_id() {
		return api_type_id;
	}

	public void setApi_type_id(Integer api_type_id) {
		this.api_type_id = api_type_id;
	}

	public Integer getApi_subType_id() {
		return api_subType_id;
	}

	public void setApi_subType_id(Integer api_subType_id) {
		this.api_subType_id = api_subType_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}