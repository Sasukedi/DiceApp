package com.bayer.diceapp.mock;

import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.network.RollApi;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockRollApi implements RollApi {
    @Override
    public Call<Void> putroll(Roll body) {
        Call<Void> call = new Call<Void>() {

            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Void> postroll(Roll body) {
        Call<Void> call = new Call<Void>() {

            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Roll> getroll(Integer rollId) {
        final Roll r1 = new Roll();
        r1.setId(1);
        r1.setName("1");
        r1.setNumberOfDice(1);
        r1.setNumberOfSides(1);
        r1.setModifier(1);
        Call<Roll> call = new Call<Roll>() {

            @Override
            public Response<Roll> execute() throws IOException {
                return Response.success(r1);
            }

            @Override
            public void enqueue(Callback<Roll> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Roll> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Void> deleteroll(Integer rollId) {
        Call<Void> call = new Call<Void>() {

            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
