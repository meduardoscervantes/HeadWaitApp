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

public class ServersCashedOutAdapter extends RecyclerView.Adapter <ServersCashedOutAdapter.ServerHolder> {
    private List<Server> servers;

    public ServersCashedOutAdapter(ArrayList servers){
        this.servers = servers;
    }
    @NonNull
    @Override
    public ServersCashedOutAdapter.ServerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.server_cashed_out_item, parent, false);
        return new ServerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServersCashedOutAdapter.ServerHolder holder, int position) {
        Server currentServer = servers.get(position);
        holder.serverName.setText(currentServer.getName());
        holder.serverTipPool.setText("Tip Pool: " + currentServer.getTipPool());
        holder.serverRemit.setText("Remit: " + currentServer.getRemit());
    }

    @Override
    public int getItemCount() {
        return servers.size();
    }

    static class ServerHolder extends RecyclerView.ViewHolder{
        private TextView serverName;
        private TextView serverTipPool;
        private TextView serverRemit;
        public ServerHolder(@NonNull View itemView) {
            super(itemView);
            serverName = itemView.findViewById(R.id.SCO_server_name);
            serverTipPool = itemView.findViewById(R.id.SCO_tip_pool);
            serverRemit = itemView.findViewById(R.id.SCO_server_remit);
        }
    }
}
