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

import com.example.headwaitapp.R;
import com.example.headwaitapp.appclasses.Headwait;

public class RemitFragment extends Fragment {
    private RemitFragmentArgs args;
    private Headwait manuel;
    private NavController navController;

    public RemitFragment() {
        // Required empty public constructor
    }
    public static RemitFragment newInstance() {
        RemitFragment fragment = new RemitFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        args = RemitFragmentArgs.fromBundle(getArguments());
        manuel = args.getHeadWait();
        navController = Navigation.findNavController(view);

        view.findViewById(R.id.FR_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemitFragmentDirections.ActionRemitFragmentToServersFragment action =
                        RemitFragmentDirections.actionRemitFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remit, container, false);
    }
}