package cn.ac.big.bigd.webservice.controller.kingfisher;

import cn.ac.big.bigd.webservice.mapper.gsa.GsaMapper;
import cn.ac.big.bigd.webservice.model.gsa.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * author chenxu
 */
@RestController
public class KingfisherController {

    @Autowired
    private GsaMapper gsaMapper;

    /**
     * 通过run的accession获取run的信息
     */
    @RequestMapping(value = "/getRunAccession/{accession}")
    public Run getRunAccession(HttpServletResponse httpServletResponse,@PathVariable("accession") String accession) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        Run run = this.gsaMapper.getRunByAccession(accession);
        return run;
    }

}
