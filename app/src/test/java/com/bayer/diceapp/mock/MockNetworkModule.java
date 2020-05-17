package com.bayer.diceapp.mock;

import com.bayer.diceapp.network.PlayApi;
import com.bayer.diceapp.network.RollApi;
import com.bayer.diceapp.network.RollsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public RollsApi provideRollsApi(Retrofit.Builder retrofitBuilder) {
        return new MockRollsApi();
    }

    @Provides
    @Singleton
    public RollApi provideRollApi(Retrofit.Builder retrofitBuilder) {
        return new MockRollApi();
    }

    @Provides
    @Singleton
    public PlayApi providePlayApi(Retrofit.Builder retrofitBuilder) {
        return new MockPlayApi();
    }
}
