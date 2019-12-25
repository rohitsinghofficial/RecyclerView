package com.example.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {
    @GET("/cardData")
    Call<List<PersonsModel>> getPersonsJson();
}
