package com.example.libraryisolation.util.net;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by zjt on 2017/6/20.
 * 请求网络的抽象类
 * 这里使用泛型，做框架的要领
 */
public abstract class HttpCallBack<Result> implements ICallBack{
    //做解析数据的处理
    @Override
    public void onSuccess(String result) {
        Gson gson=new Gson();
        Class<?> clz=analysisClassInfo(this);
        Result objResult=(Result)gson.fromJson(result,clz);
        onSuccess(objResult);
    }
    public abstract void onSuccess(Result result);

    protected static Class<?> analysisClassInfo(Object object){
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>)params[0];

    }

}
