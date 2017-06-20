package com.example.libraryisolation.util.net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjt on 2017/6/20.
 * Volley框架被代理类
 */
public class VolleyHttpProcess implements IHttpProcess {
    //voelley框架使用需要创建请求队列
    private static RequestQueue mQueue = null;

    public VolleyHttpProcess(Context context) {
        //传入上下文，说明请求队列和app是在同一个线程中
        mQueue= Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack iCallBack) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.onFailure(error.toString());
            }
        });

        mQueue.add(stringRequest);
    }

    @Override
    public void get(String url, Map<String, Object> params,final ICallBack iCallBack) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.onFailure(error.toString());
            }
        });

        mQueue.add(stringRequest);
    }
}
