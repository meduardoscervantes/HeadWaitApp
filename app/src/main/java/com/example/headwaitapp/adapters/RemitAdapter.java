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

public class RemitAdapter extends RecyclerView.Adapter<RemitAdapter.RemitHolder> {
    private List<Server> servers;
    private final String remit;

    public RemitAdapter(ArrayList servers){
        this.servers = servers;
        remit = "'s remit is : ";
    }
    @NonNull
    @Override
    public RemitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.remit_item, parent, false);
        return new RemitHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull RemitHolder holder, int position) {
        Server currentServer = servers.get(position);
        holder.remitTV.setText(currentServer.getName() + remit + currentServer.getRemit());
    }
    @Override
    public int getItemCount() {
        return servers.size();
    }

    static class RemitHolder extends RecyclerView.ViewHolder{
        private TextView remitTV;
        public RemitHolder(@NonNull View itemView) {
            super(itemView);
            remitTV = itemView.findViewById(R.id.remitTV);
        }
    }
}
