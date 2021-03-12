package com.example.headwaitapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.headwaitapp.R;
import com.example.headwaitapp.appclasses.Headwait;

public class ServersFragment extends Fragment {
    private ServersFragmentArgs args;
    private Headwait manuel;
    private NavController navController;

    public ServersFragment() {
        // Required empty public constructor
    }
    public static ServersFragment newInstance() {
        ServersFragment fragment = new ServersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        args = ServersFragmentArgs.fromBundle(getArguments());
        manuel = args.getHeadWait();
        navController = Navigation.findNavController(view);

        view.findViewById(R.id.ServersCashedTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersFragmentDirections.ActionServersFragmentToServersCashedOutFragment action =
                        ServersFragmentDirections.actionServersFragmentToServersCashedOutFragment(manuel);
                navController.navigate(action);
            }
        });
        view.findViewById(R.id.TipRetrievalTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersFragmentDirections.ActionServersFragmentToTipRetrievalFragment action =
                        ServersFragmentDirections.actionServersFragmentToTipRetrievalFragment(manuel);
                navController.navigate(action);
            }
        });
        view.findViewById(R.id.RemitTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersFragmentDirections.ActionServersFragmentToRemitFragment action =
                        ServersFragmentDirections.actionServersFragmentToRemitFragment(manuel);
                navController.navigate(action);
            }
        });
        view.findViewById(R.id.TipPoolTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersFragmentDirections.ActionServersFragmentToTipPoolFragment action =
                        ServersFragmentDirections.actionServersFragmentToTipPoolFragment(manuel);
                navController.navigate(action);
            }
        });
        view.findViewById(R.id.toHW_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServersFragmentDirections.ActionServersFragmentToInputFragment action =
                        ServersFragmentDirections.actionServersFragmentToInputFragment();
                action.setHeadWait(manuel);
                navController.navigate(action);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servers, container, false);
    }
}