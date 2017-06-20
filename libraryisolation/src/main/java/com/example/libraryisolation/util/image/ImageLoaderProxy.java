package com.example.libraryisolation.util.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by zjt on 2017/6/20.
 * 图片加载代理类
 *需要修改框架时咱们写个被代理类实现接口即可调用initImageloader()方法替换框架
 */
public class ImageLoaderProxy implements ImageLoaderImp {
    private ImageLoaderImp imageLoaderImp=null;
    private static ImageLoaderProxy imageLoaderProxy;
    public static ImageLoaderProxy getInstance(){
        if(imageLoaderProxy==null){
            synchronized (ImageLoaderProxy.class){
                if(imageLoaderProxy==null){
                    imageLoaderProxy=new ImageLoaderProxy();
                }
            }
        }

        return imageLoaderProxy;
    }

    /**
     * 后期切换框架时需要传递进来的需要被代理的类
     * @param imageLoaderImp
     */
    public void initImagetLoader(ImageLoaderImp imageLoaderImp){
        this.imageLoaderImp=imageLoaderImp;
    }

    @Override
    public void init(Context context) {
        imageLoaderImp.init(context);

    }

    @Override
    public void diplayImage(String url, ImageView imageView, int defaultImage) {
        imageLoaderImp.diplayImage(url,imageView,defaultImage);

    }
}
