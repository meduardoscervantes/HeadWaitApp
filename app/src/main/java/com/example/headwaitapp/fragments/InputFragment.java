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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.headwaitapp.R;
import com.example.headwaitapp.appclasses.Headwait;

public class InputFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private EditText serverNameET;
    private EditText remitET;
    private EditText tipPoolET;
    private RadioButton toBar;
    private RadioButton paidOut;
    private RadioButton submittingCash;
    private TextView totalCash;
    private TextView totalTipRetrieval;
    private TextView totalTipPool;
    private Button addButt;
    private Button toHwInfo;
    private InputFragmentArgs args;

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        args = InputFragmentArgs.fromBundle(getArguments());
        if (args.getHeadWait() == null){
            manuel = new Headwait();
        }else{
            manuel = args.getHeadWait();
        }
        toHwInfo = view.findViewById(R.id.HW_info_butt);
        toHwInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputFragmentDirections.ActionInputFragmentToServersFragment action
                        = InputFragmentDirections.actionInputFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }
}