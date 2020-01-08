package com.ds.ximeng.kotlindemo.base.net

import android.os.Build
import com.qmuiteam.qmui.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private const val DEFAULT_TIME = 5000L

    private var mBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://172.16.0.112:18181")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClient())

    fun <T> create(clazz : Class<T>) : T {
        return mBuilder.build().create(clazz)
    }

    private fun getOkHttpClient() : OkHttpClient{
       val builder : OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(HeaderInterceptor(addHeaders()))
            .connectTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
        if(BuildConfig.DEBUG){
            builder.addInterceptor(HttpLoggingInterceptor())
        }
        return builder.build()
    }

    private fun addHeaders() : Map<String,String>{
        val headers = HashMap<String,String>()
        headers["appType"] = "1"
        headers["userKey"] = "X20EK6_2e7454d6708527c60ba1a5b11677e87e"
        headers["version"] = BuildConfig.VERSION_NAME
        headers["mobileType"] = if (Build.MODEL.contains(Build.BRAND)) Build.MODEL else Build.BRAND + " " + Build.MODEL
        headers["mac"] = ""
        return headers
    }

}

