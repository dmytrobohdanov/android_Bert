package com.dmytro.bert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of PhoneKeeper


        //here should be:
        //Call ambulance button
        //call police button
        //settings button


        //on swipe listener:
        //to left: camera
        //right: emergency activity

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        TextView infoTextView = (TextView) findViewById(R.id.textView);

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.emer_numbers:
                Intent intent = new Intent(this, com.dmytro.bert.emergencyServices.MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.feature_1:
                Intent intent1 = new Intent(this, com.dmytro.bert.emergencyServices.MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.feature_2:
                Intent intent2 = new Intent(this, com.dmytro.bert.emergencyServices.MainActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
