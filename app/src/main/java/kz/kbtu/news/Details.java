package kz.kbtu.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Details extends Activity {

    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if(ArrayListFragment.cat==0){
            text=News.Clubs_f[ArrayListFragment.newsA];
        }
        if(ArrayListFragment.cat==1){
            text=News.Restorans_f[ArrayListFragment.newsA];
        }
        if(ArrayListFragment.cat==2){
            text=News.Sushi_f[ArrayListFragment.newsA];
        }
        if(ArrayListFragment.cat==3){
            text=News.Other_f[ArrayListFragment.newsA];
        }
        ((TextView)findViewById(R.id.text)).setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
}
