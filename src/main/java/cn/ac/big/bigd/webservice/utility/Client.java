package cn.ac.big.bigd.webservice.utility;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Client {
    private static RestHighLevelClient client;
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
//                        new HttpHost("localhost", 9200, "http")
//                        new HttpHost("192.168.118.79", 9200, "http")
                        new HttpHost("192.168.164.106", 9201, "http")
                        // 添加其他配置如认证信息等
                )
        );
    }
    public static  RestHighLevelClient getClient(){
        return client;
    }
}
