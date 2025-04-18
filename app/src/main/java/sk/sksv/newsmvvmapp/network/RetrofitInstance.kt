package sk.sksv.newsmvvmapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sk.sksv.newsmvvmapp.utils.BASE_URL

class RetrofitInstance {


    companion object {
        private val retrofit by lazy {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val networkClient =
                OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).build()
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(networkClient).build()
        }

        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}