package com.example.gsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubAdapter extends  RecyclerView.Adapter<GithubAdapter.GithubViewHolder>{

    private Context context;
    private  List<User>  data;


    public GithubAdapter(Context context, List<User> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_user,parent, false);
            return new GithubViewHolder(view);

    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {
        final User user = data.get(position);
        holder.txtUser.setText(user.getLogin());
        Picasso.get().load(user.getImage()).into(holder.imgUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin()+ "di click", Toast.LENGTH_SHORT);
            }
        });
//        Picasso.get().load(gson.getImg()).into(holder.imgUser);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView txtUser;
        public GithubViewHolder (View itemView){
            super(itemView);

            imgUser = itemView.findViewById(R.id.imgUser);
            txtUser = itemView.findViewById(R.id.txtUser);
        }
    }
}
