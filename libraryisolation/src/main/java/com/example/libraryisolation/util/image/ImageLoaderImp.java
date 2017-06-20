package com.example.libraryisolation.util.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by zjt on 2017/6/20.
 * 图片加载器功能接口
 * 添加或者替换新的图片加载器实现该接口即可
 * 接口命名规范ImageLoaderImp 例如 XXX
 */
public interface ImageLoaderImp {
    void init(Context context);
    //加载图片的方法
    void diplayImage(String url, ImageView imageView, int defaultImage);

}
