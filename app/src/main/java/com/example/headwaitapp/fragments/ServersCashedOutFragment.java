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

import com.example.headwaitapp.R;
import com.example.headwaitapp.adapters.ServersCashedOutAdapter;
import com.example.headwaitapp.appclasses.Headwait;

public class ServersCashedOutFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private ServersCashedOutAdapter adapter;
    private RecyclerView recyclerView;

    public ServersCashedOutFragment() {
        // Required empty public constructor
    }
    public static ServersCashedOutFragment newInstance() {
        ServersCashedOutFragment fragment = new ServersCashedOutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        manuel = ServersCashedOutFragmentArgs.fromBundle(getArguments()).getHeadWait();
        navController = Navigation.findNavController(view);

        recyclerView = view.findViewById(R.id.SCO_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new ServersCashedOutAdapter(manuel.getServers());
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.FSCO_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersCashedOutFragmentDirections.ActionServersCashedOutFragmentToServersFragment action =
                        ServersCashedOutFragmentDirections.actionServersCashedOutFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servers_cashed_out, container, false);
    }
}