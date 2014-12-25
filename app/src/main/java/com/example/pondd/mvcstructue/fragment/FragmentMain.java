package com.example.pondd.mvcstructue.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pondd.mvcstructue.R;
import com.example.pondd.mvcstructue.fragment.manager.bus.BusEventPill;
import com.inthecheesefactory.thecheeselibrary.manager.bus.MainBus;
import com.squareup.otto.Subscribe;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentMain extends Fragment {
    TextView textView;
    public FragmentMain() {
        super();
    }

    public static FragmentMain newInstance() {
        FragmentMain fragment = new FragmentMain();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        setRetainInstance(true);
        textView = (TextView) rootView.findViewById(R.id.textView);
    }

    public void setName(String text){
        textView.setText(text);
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
