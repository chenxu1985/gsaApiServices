package cn.ac.big.bigd.webservice.controller.kingfisher;

import cn.ac.big.bigd.webservice.mapper.api.ApiMapper;
import cn.ac.big.bigd.webservice.mapper.gsa.GsaMapper;
import cn.ac.big.bigd.webservice.model.api.Api;
import cn.ac.big.bigd.webservice.model.gsa.CraList;
import cn.ac.big.bigd.webservice.model.gsa.Run;
import cn.ac.big.bigd.webservice.model.gsa.RunDataFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * author chenxu
 */
@RestController
public class KingfisherController {

    @Autowired
    private GsaMapper gsaMapper;
    @Autowired
    private ApiMapper apiMapper;

    /**
     * 通过run的accession获取run的信息
     */
    @RequestMapping(value = "/getRunAccession/{accession}")
    public Run getRunAccession(HttpServletResponse httpServletResponse, @PathVariable("accession") String accession, HttpServletRequest request) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        Run run = this.gsaMapper.getRunByAccession(accession);
        List<RunDataFile> runDataFiles = this.gsaMapper.getRunDataFileList(accession);
        run.setRunDataFiles(runDataFiles);
        String ip = getIp(request);
        Api api = new Api();
        api.setIp(ip);
        api.setApi_type_id(1);
        api.setApi_subType_id(1);
        int apiCount = this.apiMapper.saveApi(api);
        return run;
    }

    /**
     * 获取全部已经发布CRA编号
     */
    @RequestMapping(value = "/getCraList")
    public List<CraList> getCraList(HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        List<CraList> craLists = this.gsaMapper.getCraList();
        String ip = getIp(request);
        Api api = new Api();
        api.setIp(ip);
        api.setApi_type_id(1);
        api.setApi_subType_id(2);
        int apiCount = this.apiMapper.saveApi(api);
        return craLists;
    }

    public String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
