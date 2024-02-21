package cn.ac.big.bigd.webservice.controller.survey;

import cn.ac.big.bigd.webservice.model.api.Api;
import cn.ac.big.bigd.webservice.model.gsa.Run;
import cn.ac.big.bigd.webservice.model.gsa.RunDataFile;
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
public class SurveyController {

    /**
     * 通过run的accession获取run的信息
     */
    @RequestMapping(value = "/getSurvey")
    public String getSurvey(HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        String survey = "success";
        return survey;
    }


}
