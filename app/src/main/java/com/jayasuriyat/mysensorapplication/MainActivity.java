package com.jayasuriyat.mysensorapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends ActionBarActivity {
    Integer[] img={R.drawable.accelerometer,R.drawable.light,R.drawable.proximity,R.drawable.magnet,R.drawable.gyroscope};
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView g=(GridView)findViewById(R.id.grid);
        g.setAdapter( new MyAdapter(this,img));

        g.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        i=new Intent(MainActivity.this,sensor.class);
                        i.putExtra("type",position);
                        startActivity(i);
                    }
                }
        );
    }



}
