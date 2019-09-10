package com.example.gsonexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GsonAdapter extends RecyclerView.Adapter<GsonAdapter.MyViewHolder> {

    private List<DataGson> gsonList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama;
        public ImageView img;
        public ImageView img1;

        public MyViewHolder(View view) {
            super(view);
            nama = view.findViewById(R.id.txtnama);
            img = view.findViewById(R.id.imagview);
//            img1 = view.findViewById(R.id.imgview1);
        }
    }


    public GsonAdapter(List<DataGson> gsonList) {
        this.gsonList = gsonList;
    }
/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gson_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataGson gson = gsonList.get(position);
        holder.nama.setText(gson.getNama());;
        Picasso.get().load(gson.getImg()).into(holder.img);
//        Picasso.get().load(gson.getImg1().into(holder.img1);

    }

    @Override
    public int getItemCount() {
        return gsonList.size();
    }
}
