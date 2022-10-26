package com.example.homework1_7m.di

import androidx.viewbinding.BuildConfig
import com.example.core.Const
import com.example.core.core.AppDispatcher
import com.example.data.brand.data.BrandApi
import com.example.data.brand.model.BrandDto
import com.example.data.brand.repository.BrandRepositoryImpl
import com.example.domain.brand.repo.BrandRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder().apply {
//            if (BuildConfig.DEBUG) {
//                addInterceptor(HttpLoggingInterceptor().apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                })
//            }
//            addInterceptor(object : Interceptor {
//                override fun intercept(chain: Interceptor.Chain): Response {
//                    val original: Request = chain.request()
//                    val originalHttpUrl: HttpUrl = original.url
//
//                    val url = originalHttpUrl.newBuilder()
//                        .addQueryParameter("api_key", BuildConfig.LIBRARY_PACKAGE_NAME)
//                        .build()
//                    val requestBuilder: Request.Builder = original.newBuilder()
//                        .url(url)
//                    val request: Request = requestBuilder.build()
//                    return chain.proceed(request)
//                }
//            })
//        }.build()
        val levelType: HttpLoggingInterceptor.Level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun retrofitBooks(okHttpClient: OkHttpClient): BrandApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(BrandApi::class.java)
    }

    @Provides
    @Singleton
    fun bookService(retrofit: Retrofit): BrandDto {
        return retrofit.create(BrandDto::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: BrandApi): BrandRepository {
        return BrandRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAppDispatcher(): com.example.core.core.Dispatcher {
        return AppDispatcher()
    }
}