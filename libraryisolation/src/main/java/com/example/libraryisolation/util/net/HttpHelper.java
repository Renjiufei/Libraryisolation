package com.example.libraryisolation.util.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjt on 2017/6/20.
 * 网络代理类
 */
public class HttpHelper implements IHttpProcess {
    private static final String URL="url";
    //网络请求接口
    private static  IHttpProcess mIHttpProcess=null;
    //请求参数
    private Map<String ,Object> mParams;
    private static HttpHelper _instance;

    public static HttpHelper getInstance(){
        if(_instance==null){
            synchronized (HttpHelper.class){
                if(_instance==null){
                    _instance=new HttpHelper();
                }
            }
        }

        return _instance;
    }

    public HttpHelper() {
        mParams=new HashMap<>();
    }

    public static void initIHttpProcess(IHttpProcess iHttpProcess){
        mIHttpProcess=iHttpProcess;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack iCallBack) {
        //拼接url需要注意
        final String finalUrl=appendPayams(url,params);
        mIHttpProcess.post(finalUrl,params,iCallBack);
    }

    /**
     *
     * @param url
     * @param params
     * @return
     * params
     */
    private static String appendPayams(String url, Map<String, Object> params) {
        if(params==null||params.isEmpty()){
            return url;
        }else {
            //参数拼接根据访问链接来写 Map存储方式 url ==value
            return url+params.get(URL);
        }

    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack iCallBack) {
        final String finalUrl=appendPayams(url,params);
        mIHttpProcess.get(finalUrl,params,iCallBack);
    }
}
