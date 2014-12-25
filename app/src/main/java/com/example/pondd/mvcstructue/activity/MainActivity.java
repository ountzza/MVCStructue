package com.example.pondd.mvcstructue.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pondd.mvcstructue.R;
import com.example.pondd.mvcstructue.fragment.FragmentMain;
import com.example.pondd.mvcstructue.fragment.FragmentSecond;
import com.example.pondd.mvcstructue.fragment.manager.bus.BusEventPill;
import com.example.pondd.mvcstructue.utils.ScreenUtils;
import com.inthecheesefactory.thecheeselibrary.manager.bus.MainBus;
import com.squareup.otto.Subscribe;


public class MainActivity extends ActionBarActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       textView = (TextView) findViewById(R.id.textView);
//        textView.setText("Height:"+ScreenUtils.getInstance().getScreenHeight()+
//                        "Width:"+ScreenUtils.getInstance().getScreenWidth());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, FragmentMain.newInstance(), "FragmentMain")
                    .commit();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        MainBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainBus.getInstance().unregister(this);
    }

    @Subscribe
    public void busEventRecived(BusEventPill event) {
        String text = event.getValue();

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().popBackStackImmediate();
        FragmentMain fragmentMain = (FragmentMain) getSupportFragmentManager().findFragmentByTag("FragmentMain");
        fragmentMain.setName(text);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, FragmentSecond.newInstance(), "FragmentSecond")
                    .addToBackStack(null)
                    .commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
