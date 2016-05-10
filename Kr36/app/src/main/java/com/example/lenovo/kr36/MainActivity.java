package com.example.lenovo.kr36;

import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.lenovo.kr36.base.BaseActivity;

import com.google.gson.Gson;

public class MainActivity extends BaseActivity {
    private TextView tv;
    private Button btn;
    private ImageView iv;
    private Bean bean;
    private String url;
    private RequestQueue requestQueue;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        tv = bindView(R.id.tv);
        btn = bindView(R.id.btn);
        iv=bindView(R.id.iv);
    }

    @Override
    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
               catchData();
                //catchPic();
                catchImageLoader();
               break;
            default:
                break;
        }
    }

    private void catchImageLoader() {
        //ImageLoader的构造函数接收两个参数，
        // 第一个参数就是RequestQueue对象，
        // 第二个参数是一个ImageCache对象，这里我们先new出一个空的ImageCache的实现即可。
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        //ImageLoader的getImageListener()方法能够获取到一个ImageListener对象，
        // getImageListener()方法接收三个参数，
        // 第一个参数指定用于显示图片的ImageView控件，
        // 第二个参数指定加载图片的过程中显示的图片，
        // 第三个参数指定加载图片失败的情况下显示的图片。
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        //最后，调用ImageLoader的get()方法来加载图片
        //Log.e("~~~~~~~~~~~~~~~~`", "1111111111111111111111111111"+listener);
        imageLoader.get("http://pic10.nipic.com/20101020/3650425_202918301404_2.jpg",listener);
    }

    private void catchPic() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ImageRequest imageRequest = new ImageRequest("http://pic10.nipic.com/20101020/3650425_202918301404_2.jpg",
                new com.android.volley.Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.ALPHA_8, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iv.setImageResource(R.mipmap.ic_launcher);
            }
        });
        requestQueue.add(imageRequest);
//ImageRequest的构造函数接收六个参数，
// 第一个参数就是图片的URL地址，这个没什么需要解释的。
// 第二个参数是图片请求成功的回调，这里我们把返回的Bitmap参数设置到ImageView中。
// 第三,第四个参数分别用于指定允许图片最大的宽度和高度，
// 如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，
// 指定成0的话就表示不管图片有多大，都不会进行压缩。
// 第五个参数用于指定图片的颜色属性
// ，Bitmap.Config下的几个常量都可以在这里使用，其中ARGB_8888可以展示最好的颜色属性，
// 每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大小。
// 第六个参数是图片请求失败的回调，这里我们当请求失败时在ImageView中显示一张默认图片.

    }

    public void catchData(){
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                StringRequest request;
                request = new StringRequest("http://api.liwushuo.com/v2/search/hot_words "// 第一个参数为url
                        ,new Response.Listener<String>() {//第二个参数为请求成功
                             @Override
                             public void onResponse(String response) {
                                            Gson gson = new Gson();
                                            bean = new Bean();
                                            Bean bean = gson.fromJson(response, Bean.class);
                                            tv.setText(bean.getMessage());
                             }
                          }
                        , new Response.ErrorListener() {//第三个参数为请求失败
                            @Override
                            public void onErrorResponse(VolleyError error) {

                             }
                         });
            requestQueue.add(request);
    }
    @Override
    public void initData() {
        tv.setText("sdfsdf");
        btn.setOnClickListener(this);
    }

}
