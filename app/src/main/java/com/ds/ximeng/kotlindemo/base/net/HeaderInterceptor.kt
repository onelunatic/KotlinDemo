package com.ds.ximeng.kotlindemo.base.net

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor constructor(val heads: Map<String, String>): Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request : Request  = chain.request()
        val builder = request.newBuilder()
        for ((key,value) in heads){
            builder.addHeader(key,value)
        }
        return chain.proceed(request)
    }

}