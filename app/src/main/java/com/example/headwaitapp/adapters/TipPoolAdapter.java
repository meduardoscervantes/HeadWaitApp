package com.example.headwaitapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headwaitapp.R;
import com.example.headwaitapp.appclasses.Server;

import java.util.ArrayList;
import java.util.List;

public class TipPoolAdapter extends RecyclerView.Adapter<TipPoolAdapter.TipPool> {
    private List<Server> servers;
    private final String tipPool;

    public TipPoolAdapter(ArrayList servers){
        this.servers = servers;
        tipPool = " 's Tip Pool: ";
    }
    @NonNull
    @Override
    public TipPool onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_pool_item, parent, false);
        return new TipPool(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull TipPool holder, int position) {
        Server currentServer = servers.get(position);
        holder.tipPoolTV.setText(currentServer.getName() + tipPool + currentServer.getTipPool());
    }
    @Override
    public int getItemCount() {
        return servers.size();
    }

    static class TipPool extends RecyclerView.ViewHolder{
        private TextView tipPoolTV;
        public TipPool(@NonNull View itemView) {
            super(itemView);
            tipPoolTV = itemView.findViewById(R.id.TipPoolTV);
        }
    }
}
