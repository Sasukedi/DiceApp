package com.bayer.diceapp.mock;

import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.network.PlayApi;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockPlayApi implements PlayApi {
    @Override
    public Call<RollResult> playroll(final Integer rollId) {
        final RollResult result1 =  new RollResult();
        result1.setResult(Integer.valueOf(1));
        final RollResult result2 =  new RollResult();
        result2.setResult(Integer.valueOf(2));

        Call<RollResult> call = new Call<RollResult>() {

            @Override
            public Response<RollResult> execute() throws IOException {
                if (rollId == 1)
                    return Response.success(result1);
                else
                    return Response.success(result2);
            }

            @Override
            public void enqueue(Callback<RollResult> callback) {

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
            public Call<RollResult> clone() {
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
