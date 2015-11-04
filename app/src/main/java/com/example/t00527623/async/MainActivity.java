package com.example.t00527623.async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView progress, answer;
    private static long actualPass = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (TextView) findViewById(R.id.textView1);
        answer = (TextView) findViewById(R.id.textView2);
    }



    private void setProgress(String status){
        progress.setText(status);

    }

    private void setAnswer(int pass){
        answer.setText("The correct password is " + pass);

    }

    //onClick method
    public void guessPassword (View v){
        setProgress("Start Testing...");
        //setAnswer(9999);

        final long RANGE = 100000;
        // final long RATE = 1000;
        long check = 0;
        long count = 0;

        Random rand = new Random();
        while (check != actualPass){
            count++;
            check = Math.abs(rand.nextLong()) % RANGE;
            Log.d("NUM", count + " :: Random Password = " + check);
        }

        setProgress("Done Tried: " + count + " times");
        setAnswer((int)check);
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
