package com.example.headwaitapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.headwaitapp.R;
import com.example.headwaitapp.adapters.TipRetrievalAdapter;
import com.example.headwaitapp.appclasses.Headwait;

public class TipRetrievalFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private TextView totalTipRetrieval;
    private RecyclerView recyclerView;
    private TipRetrievalAdapter adapter;

    public TipRetrievalFragment() {
        // Required empty public constructor
    }
    public static TipRetrievalFragment newInstance() {
        TipRetrievalFragment fragment = new TipRetrievalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        manuel = TipRetrievalFragmentArgs.fromBundle(getArguments()).getHeadWait();
        navController = Navigation.findNavController(view);

        totalTipRetrieval = view.findViewById(R.id.TRF_total_tip_retrieval);
        totalTipRetrieval.setText("Total Tip Retrieval: " + manuel.getTotalTipRetrieval());

        recyclerView = view.findViewById(R.id.tip_retrieval_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TipRetrievalAdapter(manuel.getTipRetrievalServers());
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.FTR_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipRetrievalFragmentDirections.ActionTipRetrievalFragmentToServersFragment action =
                        TipRetrievalFragmentDirections.actionTipRetrievalFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip_retrieval, container, false);
    }
}