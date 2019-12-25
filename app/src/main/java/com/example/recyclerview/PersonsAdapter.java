package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;
import java.util.Hashtable;

import static java.nio.file.Files.size;


public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder>{

    private ArrayList<PersonsModel> personsModel = new ArrayList<>();
    private Context context;
    private ViewHolder viewholder;
    private View person_image;


    public PersonsAdapter(Context context, ArrayList<PersonsModel> personsModel){
           this.personsModel = personsModel;
           this.context = context;

       }

       @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_list_item, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           viewholder.name.setText( personsModel.get( position ).getName() );
           viewholder.age.setText( personsModel.get( position).getAge());
        viewholder.location.setText( personsModel.get( position).getLocation());

        Picasso.Builder builder = new Picasso.Builder( context );
        builder.downloader(new OkHttp3Downloader( context ) );
        builder.build().load( personsModel.get(position).getUrl() )

                .into(viewholder.person_image);


    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        private  ImageView person_image;
           private TextView name, age, location;


           public ViewHolder(@NonNull View itemView){
               super(itemView);



               person_image= itemView.findViewById(R.id.person_image);
                   name = itemView.findViewById(R.id.name);
                   age=itemView.findViewById(R.id.age);
                   location=itemView.findViewById(R.id.location);


           }


       }
   }
