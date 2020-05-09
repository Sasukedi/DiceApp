package com.bayer.diceapp.mock;

import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.Rolls;
import com.bayer.diceapp.network.RollsApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MockRollsApi implements RollsApi {
    @Override
    public Call<Rolls> getrolls() {
        final Rolls resultRolls = new Rolls();
        List<Roll> rollList = new ArrayList<Roll>();
        Roll r1 = new Roll();
        r1.setId(1);
        r1.setName("1");
        r1.setNumberOfDice(1);
        r1.setNumberOfSides(1);
        r1.setModifier(1);
        Roll r2 = new Roll();
        r2.setId(2);
        r2.setName("2");
        r2.setNumberOfDice(2);
        r2.setNumberOfSides(2);
        r2.setModifier(2);
        rollList.add(r1);
        rollList.add(r2);
        resultRolls.setRolls(rollList);

        Call<Rolls> call = new Call<Rolls>() {
            @Override
            public Response<Rolls> execute() {
                return Response.success(resultRolls);
            }

            @Override
            public void enqueue(Callback<Rolls> callback) {

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
            public Call<Rolls> clone() {
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
