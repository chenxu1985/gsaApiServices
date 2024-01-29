package cn.ac.big.bigd.webservice.utility;
public class ElasticsearchTools {
    //正则表达式判断
    public static boolean checkRegExp(String name,int flag){
        boolean checkFlag = true;
        Boolean strResult = true;
        if(flag==1){
            //GSA实验编号校验
            strResult = name.matches("^(CRX\\d{6,7}|SRX\\d{6,8}|DRX\\d{6,8}|ERX\\d{6,8})$");
        } else if(flag==2){
            //GSA Run编号校验
            strResult = name.matches("^(CRR\\d{6,7}|SRR\\d{6,8}|DRR\\d{6,8}|ERR\\d{6,8})$");
        } else if(flag==3){
            //GSA CRA编号校验
            strResult = name.matches("^CRA\\d{6}$");
        }
        if(!strResult){
            checkFlag = false;
        }
        return checkFlag;
    }

}
