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
import android.widget.Toast;

import com.example.headwaitapp.R;
import com.example.headwaitapp.appclasses.Headwait;
import com.example.headwaitapp.appclasses.Server;

public class InputFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private EditText serverNameET;
    private EditText remitET;
    private EditText tipPoolET;
    private RadioButton toBar;
    private RadioButton paidOut;
    private RadioButton submittingCash;
    private TextView serverNameTV;
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
        serverNameET = view.findViewById(R.id.server_name);
        remitET = view.findViewById(R.id.remit_amount);
        tipPoolET = view.findViewById(R.id.tipPool);
        toBar = view.findViewById(R.id.toBarRB);
        paidOut = view.findViewById(R.id.paidOutRB);
        submittingCash = view.findViewById(R.id.submittingCashRB);
        serverNameTV = view.findViewById(R.id.serverAddedTV);
        totalCash = view.findViewById(R.id.totalCash);
        totalTipRetrieval = view.findViewById(R.id.totalTipRetrieval);
        totalTipPool = view.findViewById(R.id.totalTipPool);

        addButt = view.findViewById(R.id.addButt);
        addButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if(!(serverNameET.getText().toString().isEmpty()) && !(remitET.getText().toString().isEmpty())
                            && !(tipPoolET.getText().toString().isEmpty())){
                        if(toBar.isChecked()){
                            if(Double.valueOf(remitET.getText().toString()) > 0){ //Remit must be negative to go to the bar...
                                Toast.makeText(v.getContext(),"Can not send to the bar",Toast.LENGTH_SHORT).show();
                            }else{
                                Server server = new Server(Double.valueOf(tipPoolET.getText().toString()), serverNameET.getText().toString(), Double.valueOf(remitET.getText().toString()));
                                manuel.addServer(server);
                                manuel.addTipRetrievalServer(server);
                                serverNameTV.setText(server.getName() + " cashed out");
                                totalCash.setText("Cash you should have: " + manuel.getCash());
                                totalTipRetrieval.setText("Tip Retrieval Total should be: " + manuel.getTotalTipRetrieval());
                                totalTipPool.setText("Total tip pool: " + manuel.getTotalTipPool());
                                serverNameET.setText("");
                                remitET.setText("");
                                tipPoolET.setText("");
                            }
                        }
                        if(paidOut.isChecked()) {
                            if (Double.valueOf(remitET.getText().toString()) < 0) {
                                if ((-1 * (Double.valueOf(remitET.getText().toString()))) < manuel.getCash()) {
                                    Server server = new Server(Double.valueOf(tipPoolET.getText().toString()), serverNameET.getText().toString(), Double.valueOf(remitET.getText().toString()));
                                    manuel.addServer(server);
                                    manuel.addCash(Double.valueOf(remitET.getText().toString()));
                                    serverNameTV.setText(server.getName() + " cashed out");
                                    totalCash.setText("Cash you should have: " + manuel.getCash());
                                    totalTipRetrieval.setText("Tip Retrieval Total should be: " + manuel.getTotalTipRetrieval());
                                    totalTipPool.setText("Total tip pool: " + manuel.getTotalTipPool());
                                    serverNameET.setText("");
                                    remitET.setText("");
                                    tipPoolET.setText("");
                                }else {
                                    Toast.makeText(v.getContext(),"Don't have enough $$$ to pay out",Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(v.getContext(),"Can not pay out",Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(submittingCash.isChecked()){
                            if(Double.valueOf(remitET.getText().toString()) < 0 ){
                                Toast.makeText(v.getContext(),"Can not submit $$$",Toast.LENGTH_SHORT).show();
                            }else{
                                Server server = new Server(Double.valueOf(tipPoolET.getText().toString()), serverNameET.getText().toString(), Double.valueOf(remitET.getText().toString()));
                                manuel.addServer(server);
                                manuel.addCash(Double.valueOf(remitET.getText().toString()));
                                serverNameTV.setText(server.getName() + " cashed out");
                                totalCash.setText("Cash you should have: " + manuel.getCash());
                                totalTipRetrieval.setText("Tip Retrieval Total should be: " + manuel.getTotalTipRetrieval());
                                totalTipPool.setText("Total tip pool: " + manuel.getTotalTipPool());
                                serverNameET.setText("");
                                remitET.setText("");
                                tipPoolET.setText("");
                            }
                        }
                    }
                    else{
                        Toast.makeText(v.getContext(),"Input all info first",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

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