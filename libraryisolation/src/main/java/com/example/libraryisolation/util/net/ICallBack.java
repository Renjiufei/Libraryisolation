package com.example.libraryisolation.util.net;

/**
 * Created by zjt on 2017/6/20.
 * 定义请求网络接口
 * 网络传输数据最终都是String的形式
 * 会有两个方法
 * 请求成功的方法，请求失败的方法
 */
public interface ICallBack {

    void onSuccess(String result);

    void onFailure(String e);
}
