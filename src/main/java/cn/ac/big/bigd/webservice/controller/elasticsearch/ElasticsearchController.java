package cn.ac.big.bigd.webservice.controller.elasticsearch;
import cn.ac.big.bigd.webservice.model.elasticsearch.Experiment;
import cn.ac.big.bigd.webservice.utility.Client;
import cn.ac.big.bigd.webservice.utility.ElasticsearchTools;
import com.alibaba.fastjson2.JSON;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * author chenxu
 */
@RestController
public class ElasticsearchController {

    /**
     * 通过GSA search 查询出数量
     */
    @RequestMapping(value = "/getCountByGsa/{term}")
    public Integer getCountByGsa(HttpServletResponse httpServletResponse, @PathVariable("term") String term, HttpServletRequest request) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        Client clientConfig = new Client();
        RestHighLevelClient restHighLevelClient= clientConfig.restHighLevelClient();
        int count = 0;
        StringUtils sutils = new StringUtils();
        term = sutils.deleteWhitespace(term);
        if (ElasticsearchTools.checkRegExp(term,1)) {
            Experiment exp = this.getExperiment(term,restHighLevelClient);
            if(exp!=null){
                count =1;
            }
        }else if(ElasticsearchTools.checkRegExp(term,3)){
            Experiment exp  = this.getCra(term,restHighLevelClient);
            if(exp!=null){
                count =1;
            }
        } else {
            SearchRequest searchRequest = new SearchRequest("gsatime");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
            QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(term);
            MatchQueryBuilder matchNotQueryBuilder = new MatchQueryBuilder("type", "Run");
            MatchQueryBuilder matchNotQueryBuilderR = new MatchQueryBuilder("releaseState", "1");
            boolQueryBuilder.mustNot(matchNotQueryBuilder);
            boolQueryBuilder.mustNot(matchNotQueryBuilderR);
            boolQueryBuilder.must(queryStringQueryBuilder);
            sourceBuilder.trackTotalHits(true);
            sourceBuilder.query(boolQueryBuilder);
            searchRequest.source(sourceBuilder);
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            count = (int) searchResponse.getHits().getTotalHits().value;
        }
        return count;
    }
    public Experiment getExperiment(String keyword,RestHighLevelClient restHighLevelClient) throws IOException {
        Experiment experiment = new Experiment();
        SearchRequest searchRequest = new SearchRequest("gsatime");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(keyword);
        boolQueryBuilder.must(queryStringQueryBuilder);
//        HasChildQueryBuilder hasChildQueryBuilder = JoinQueryBuilders.hasChildQuery(
//                "run",QueryBuilders.matchAllQuery(), ScoreMode.None).innerHit(new InnerHitBuilder());
        searchSourceBuilder.size(10);
        searchSourceBuilder.timeout(new TimeValue(60,TimeUnit.SECONDS));
//        boolQueryBuilder.must(hasChildQueryBuilder);
        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (SearchHit hit : searchHits) {
            experiment= JSON.parseObject(JSON.toJSONString(hit.getSourceAsMap()),Experiment.class);
            break;
        }
        if(searchHits.length==0){
            SearchSourceBuilder expSourceBuilder = new SearchSourceBuilder();
            MatchQueryBuilder expMatchBuilder = new MatchQueryBuilder("accession", keyword);
            expSourceBuilder.trackTotalHits(true);
            expSourceBuilder.query(expMatchBuilder);
            SearchRequest expCountRequest = new SearchRequest("gsatime");
            expCountRequest.source(expSourceBuilder);
            SearchResponse expResponse = restHighLevelClient.search(expCountRequest, RequestOptions.DEFAULT);
            SearchHit[] expHits = expResponse.getHits().getHits();
            for (SearchHit hit : expHits) {
                experiment= JSON.parseObject(JSON.toJSONString(hit.getSourceAsMap()),Experiment.class);
                break;
            }
        }
        return experiment;
    }
    public Experiment getCra(String keyword,RestHighLevelClient restHighLevelClient) throws IOException {
        Experiment experiment = new Experiment();
        SearchRequest searchRequest = new SearchRequest("gsatime");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        MatchQueryBuilder craBuilder = new MatchQueryBuilder("accession", keyword);
        boolQueryBuilder.must(craBuilder);
        searchSourceBuilder.size(10);
        searchSourceBuilder.timeout(new TimeValue(60,TimeUnit.SECONDS));
        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (SearchHit hit : searchHits) {
            experiment= JSON.parseObject(JSON.toJSONString(hit.getSourceAsMap()),Experiment.class);
            break;
        }
        return experiment;
    }
}
