package com.example.homework1_7m.di

import androidx.viewbinding.BuildConfig
import com.example.core.Const
import com.example.core.core.AppDispatcher
import com.example.data.brand.data.BrandApi
import com.example.data.brand.model.BrandDto
import com.example.data.brand.repository.BrandRepositoryImpl
import com.example.data.caps.data.CapsApi
import com.example.data.caps.model.CapsDto
import com.example.data.users.model.repo.CapsRepositoryImpl
import com.example.data.users.data.UserApi
import com.example.data.users.model.UserDto
import com.example.data.users.repo.UserRepositoryImpl
import com.example.domain.brand.repo.BrandRepository
import com.example.domain.caps.repository.CapsRepository
import com.example.domain.users.repository.UserRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    fun retrofitBrand(okHttpClient: OkHttpClient): BrandApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(BrandApi::class.java)
    }

    @Provides
    @Singleton
    fun retrofitCaps(okHttpClient: OkHttpClient): CapsApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CapsApi::class.java)
    }

    @Provides
    @Singleton
    fun retrofitUsers(okHttpClient: OkHttpClient) : UserApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(UserApi::class.java)
    }


    @Provides
    @Singleton
    fun brandService(retrofit: Retrofit): BrandDto {
        return retrofit.create(BrandDto::class.java)
    }

    @Provides
    @Singleton
    fun capsService(retrofit: Retrofit) : CapsDto {
        return retrofit.create(CapsDto::class.java)
    }

    @Provides
    @Singleton
    fun userService(retrofit: Retrofit) : UserDto {
        return retrofit.create(UserDto::class.java)
    }

    @Provides
    @Singleton
    fun provideBrandRepository(api: BrandApi): BrandRepository {
        return BrandRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCapsRepository(api: CapsApi): CapsRepository {
        return CapsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi) : UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAppDispatcher(): com.example.core.core.Dispatcher {
        return AppDispatcher()
    }
}