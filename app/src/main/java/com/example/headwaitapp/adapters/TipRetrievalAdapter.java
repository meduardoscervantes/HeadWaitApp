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

public class TipRetrievalAdapter extends RecyclerView.Adapter<TipRetrievalAdapter.TipRetrieval> {
    private List<Server> servers;

    public TipRetrievalAdapter(ArrayList servers){
        this.servers = servers;
    }
    @NonNull
    @Override
    public TipRetrieval onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_retrieval_item, parent, false);
        return new TipRetrieval(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TipRetrieval holder, int position) {
        Server currentServer = servers.get(position);
        holder.textView.setText(currentServer.getName() + ": " + currentServer.getRemit());
    }

    @Override
    public int getItemCount() {
        return servers.size();
    }

    static class TipRetrieval extends RecyclerView.ViewHolder{
        private TextView textView;
        public TipRetrieval(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tip_retrieval_item);
        }
    }
}
