package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonsModel>personsModel = new ArrayList<>();
    private PersonsAdapter personsAdapter;

    private RecyclerView persons_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







            persons_recyclerview = (RecyclerView) findViewById( R.id.persons_recyclerview );
            persons_recyclerview.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
            persons_recyclerview.setAdapter( (personsAdapter) );




         getPersonsRespose();

    }

    private void getPersonsRespose() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo8716682.mockable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        /* handle for the Retrofit */


        RequestInterface requestInterface= retrofit.create(RequestInterface.class);
        Call<List<PersonsModel>> call =requestInterface.getPersonsJson();

        call.enqueue(new Callback<List<PersonsModel>>() {

            @Override
            public void onResponse(Call<List<PersonsModel>> call, Response<List<PersonsModel>> response){
                personsModel = new ArrayList<>(response.body());
                personsAdapter= new PersonsAdapter(MainActivity.this,personsModel);


                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<PersonsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*Method to generate list*/
    private void generateList(List<PersonsModel>response) {
        persons_recyclerview = findViewById( R.id.persons_recyclerview );
        personsAdapter = new PersonsAdapter( this, personsModel );
    }


}
