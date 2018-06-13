package com.xh.study.bcy.utils;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xh.study.bcy.App;
import com.xh.study.bcy.network.AskService;
import com.xh.study.bcy.network.BangumiService;
import com.xh.study.bcy.network.CircleService;
import com.xh.study.bcy.network.CoreService;
import com.xh.study.bcy.network.GroupService;
import com.xh.study.bcy.network.IllustService;
import com.xh.study.bcy.network.TagService;
import com.xh.study.bcy.network.TimeLineService;
import com.xh.study.bcy.network.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by XH on 2018/1/29.
 * 网络通信服务
 */

public class RestProvider {
    private static final String END_POINT = "https://api.bcy.net/";

    private static OkHttpClient okHttpClient;

    //定义基本json解析的格式
    public final static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();

    public static OkHttpClient provideOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RestProvider.class) {
                if (okHttpClient == null) {
                    Cache cache = new Cache(new File(App.getInstance().getCacheDir(), "HttpCache"), 1024 * 1024 * 10);
                    OkHttpClient.Builder client = new OkHttpClient.Builder()
                            .cache(cache)
                            .connectTimeout(5, TimeUnit.SECONDS)
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                            .addInterceptor(new RequestInterceptor());
                    okHttpClient = client.build();
                }
            }
        }
        return okHttpClient;
    }

    private static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(END_POINT)
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * 替换 User-Agent 头信息
     */
    private static class RequestInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            //这里有些参数值是动态获取
            HttpUrl url = originalRequest.url().newBuilder()
                    .addQueryParameter("_rticket",String.valueOf( System.currentTimeMillis()))
                    .addQueryParameter("iid","30996599603")
                    .addQueryParameter("device_id","47191513829")
                    .addQueryParameter("ac","wifi")
                    .addQueryParameter("channel","Qihu 360")
                    .addQueryParameter("aid","1250")
                    .addQueryParameter("app_name","banciyuan")
                    .addQueryParameter("version_code","411")
                    .addQueryParameter("version_name","4.1.1")
                    .addQueryParameter("device_platform","android")
                    .addQueryParameter("ssmix","a")
                    .addQueryParameter("device_type","Mi-4c")
                    .addQueryParameter("device_brand","Xiaomi")
                    .addQueryParameter("language","en")
                    .addQueryParameter("update_version_code","1")
                    .addQueryParameter("dpi","480")
                    .addQueryParameter("resolution","1080*1920")
                    .addQueryParameter("manifest_version_code","20180522")
                    .addQueryParameter("openudid","5c8f73c972f5dff8")
                    .addQueryParameter("uuid","869634027816020")
                    .addQueryParameter("os_version","7.0")
                    .addQueryParameter("os_api","24")
                    .build();

            Request requestWithUserAgent = originalRequest
                    .newBuilder()
                    .addHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 7.0; Mi-4c MIUI/8.4.26)")
                    .addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("Pragma", "no-cache")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("X-BCY-Version", "Android-4.1.1")
                    .addHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 7.0; Mi-4c MIUI/8.4.26)")
                    .addHeader("Connection", "Keep-Alive")
                    .url(url)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }

    @NonNull public static TimeLineService getTimelineService() {
        return provideRetrofit().create(TimeLineService.class);
    }

    @NonNull public static BangumiService getBangumiService() {
        return provideRetrofit().create(BangumiService.class);
    }

    @NonNull public static CoreService getCoreService() {
        return provideRetrofit().create(CoreService.class);
    }


    @NonNull public static TagService getTagService() {
        return provideRetrofit().create(TagService.class);
    }

    @NonNull public static CircleService getCircleService() {
        return provideRetrofit().create(CircleService.class);
    }

    @NonNull public static IllustService getIllustService() {
        return provideRetrofit().create(IllustService.class);
    }

    @NonNull public static GroupService getGroupService() {
        return provideRetrofit().create(GroupService.class);
    }

    @NonNull public static UserService getUserService() {
        return provideRetrofit().create(UserService.class);
    }

    @NonNull public static AskService getAskService() {
        return provideRetrofit().create(AskService.class);
    }
}
