package com.example.pondd.mvcstructue.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pondd.mvcstructue.R;
import com.inthecheesefactory.thecheeselibrary.manager.bus.MainBus;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentSecond extends Fragment {
    private final View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    EditText editText;
    private Button fragButton;

    public FragmentSecond() {
        super();
    }

    public static FragmentSecond newInstance() {
        FragmentSecond fragment = new FragmentSecond();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        setRetainInstance(true);

        editText = (EditText) rootView.findViewById(R.id.editText);
        fragButton = (Button) rootView.findViewById(R.id.fragButton);
        fragButton.setOnClickListener(buttonClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
