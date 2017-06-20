package com.example.libraryisolation.util.net;

import java.util.Map;

/**
 * Created by zjt on 2017/6/20.
 * 定义请求网络的固定接口
 * get请求
 * post请求
 */
public interface IHttpProcess {
    void post(String url, Map<String,Object> params,ICallBack iCallBack);
    void get(String url, Map<String,Object> params,ICallBack iCallBack);
}
