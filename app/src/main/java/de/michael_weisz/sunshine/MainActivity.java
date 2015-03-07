package de.michael_weisz.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

            ArrayList weatherList = new ArrayList();
            weatherList.add("Today - Sunny - 88/63");
            weatherList.add("Tomorrow - Foggy - 70/46");
            weatherList.add("Weds - Cloudy - 72/63");
            weatherList.add("Thurs - Asteroids - 75/65");
            weatherList.add("Fri - Heavy Rain - 65/56");
            weatherList.add("Sat - Rain  - 35/28");
            weatherList.add("Sun - End Times - -100/-163");

            ArrayAdapter<String> weatherDataAdapter = new ArrayAdapter<String>(
                    getActivity(),                      // Context
                    R.layout.list_item_forecast,        // ListView layout xml
                    R.id.list_item_forecast_textview,   // TextView to fill
                    weatherList                         // actual data
            );

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView weatherListView = (ListView) rootView.findViewById(R.id.listview_forecast);
            weatherListView.setAdapter(weatherDataAdapter);

            return rootView;
        }
    }
}
