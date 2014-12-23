package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    enum Theme {
        DAY, NIGHT
    }

    // Initialize the current theme to Day.
    private static Theme selectedTheme = Theme.DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        // Set the theme
        if (selectedTheme.equals(Theme.DAY)) {
            setTheme(R.style.Theme_Day);
        } else {
            setTheme(R.style.Theme_Night);
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button switch_theme = (Button) rootView.findViewById(R.id.switch_theme_button);
            switch_theme.setOnClickListener((MainActivity) getActivity());

            return rootView;
        }
    }

    @Override
    public void onClick(View v) {

        // Update the theme
        if (selectedTheme.equals(Theme.DAY)) {
            selectedTheme = Theme.NIGHT;
        } else {
            selectedTheme = Theme.DAY;
        }

        // Restart the Activity using the same intent
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }

}
