package com.a20112981.retrofit;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {

    private static final String TAG = "StarAdapter";
    private List<Results> model;
    private Context context;
    public MainActivity mainActivity;
    private List<Planets> planets;

    public StarAdapter(Context context, List<Results> model, List<Planets> planets) {
        this.model = model;
        this.context = context;
        this.planets = planets;
    }

    @Override
    public StarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_row, null);
        StarViewHolder usersViewHolder = new StarViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(StarViewHolder holder, int position) {
        holder.name.setText("Name : " + model.get(position).getName());
        holder.gender.setText("Gender : " + model.get(position).getGender());
        holder.homeworld.setText("Homeworld : " + planets.get(position).getName() + " (" + planets.get(position).getTerrain() + ")");
        holder.birthYear.setText("Birth Year : " + model.get(position).getBirth_year());
    }

    @Override
    public int getItemCount() {

        return model.size();
    }

    public class StarViewHolder extends RecyclerView.ViewHolder {
        TextView name, gender, homeworld, birthYear;

        public StarViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            homeworld = itemView.findViewById(R.id.homeworld);
            birthYear = itemView.findViewById(R.id.birth_year);

        }
    }


}
