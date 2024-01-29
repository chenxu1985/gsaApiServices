package cn.ac.big.bigd.webservice.mapper.elasticsearch;

import cn.ac.big.bigd.webservice.model.elasticsearch.Experiment;

public interface ElasticsearchMapper {
    Experiment getExperiment(String term);
    Experiment getCra(String term);
}
