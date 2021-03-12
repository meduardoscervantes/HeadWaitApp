package com.example.headwaitapp.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TipPoolAdapter extends RecyclerView.Adapter<TipPoolAdapter.TipPool> {

    static class TipPool extends RecyclerView.ViewHolder{
        private
        public TipPool(@NonNull View itemView) {
            super(itemView);
        }
    }
}
