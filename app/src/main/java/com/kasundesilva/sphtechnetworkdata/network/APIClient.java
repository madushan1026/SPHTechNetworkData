package com.kasundesilva.sphtechnetworkdata.network;

import android.content.Context;

import com.kasundesilva.sphtechnetworkdata.Utills.NetworkUtills;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(final Context context) {

        int cacheSize = 100 * 1024 * 1024; // 10 MB

        File httpCacheDirectory = new File(context.getCacheDir(), "responses_cache");

        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(new Interceptor() {
                    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        if (NetworkUtills.isNetworkAvailable(context)) {
                            int maxAge = 30; // read from cache for 1 minute
                            return originalResponse.newBuilder()
                                    .header("Cache-Control", "public, max-age=" + maxAge)
                                    .build();
                        } else {
                            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                            return originalResponse.newBuilder()
                                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                    .build();
                        }
                    }}).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(GovDataService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }


}
