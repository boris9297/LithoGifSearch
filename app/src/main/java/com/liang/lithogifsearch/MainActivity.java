package com.liang.lithogifsearch;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.GridLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ComponentContext c = new ComponentContext(this);
//        final RecyclerBinder binder = new RecyclerBinder.Builder().layoutInfo(
//                new LinearLayoutInfo(c.getAndroidContext(),
//                OrientationHelper.VERTICAL, false))
//                .build(c);

        final RecyclerBinder binder = new RecyclerBinder.Builder()
                .layoutInfo(
                    new GridLayoutInfo(this, 3)
                )
                .build(c);

        final Component component = HomeComponent.create(c)
                .hint("Search Gif")
                .listener(new HomeComponentSpec.OnQueryUpdateListener(){
                    @Override
                    public void onQueryUpdate(String query) {
                        Log.i("MainActivity", "query updated: " + query);
                        Toast.makeText(MainActivity.this, "query updated: " + query, Toast.LENGTH_SHORT).show();
                    }
                })
                .binder(binder)
                .build();

        final LithoView view = LithoView.create(c, component);
        setContentView(view);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 30; i++) {
                    binder.insertItemAt(i, GifItemView.create(c).build());
                }
            }
        },2000);
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


}
