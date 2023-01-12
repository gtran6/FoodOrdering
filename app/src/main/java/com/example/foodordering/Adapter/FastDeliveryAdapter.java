package com.example.foodordering.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodordering.Domain.FastDeliveryDomain;
import com.example.foodordering.R;

import java.util.ArrayList;

public class FastDeliveryAdapter extends RecyclerView.Adapter<FastDeliveryAdapter.ViewHolder>{
    ArrayList<FastDeliveryDomain> fastDeliveryDomains;

    public FastDeliveryAdapter(ArrayList<FastDeliveryDomain> fastDeliveryDomains) {
        this.fastDeliveryDomains = fastDeliveryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_fastdelivery, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.time.setText(fastDeliveryDomains.get(position).getTime() + " min");
        holder.title.setText(fastDeliveryDomains.get(position).getTitle());
        holder.star.setText(String.valueOf(fastDeliveryDomains.get(position).getStar()));

        int drawableResourceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier(fastDeliveryDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return fastDeliveryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, time, star;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            star = itemView.findViewById(R.id.star);
            time = itemView.findViewById(R.id.time);
        }
    }
}
