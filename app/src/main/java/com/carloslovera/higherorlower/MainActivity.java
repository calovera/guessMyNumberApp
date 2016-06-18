package com.carloslovera.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNum;
    int userNumber = -1;
    Random randomGenerator = new Random();
    public void checkGuess(View view) {
        EditText guessedNum = (EditText) findViewById(R.id.guessedNumber);
        String userNum = guessedNum.getText().toString();
        userNumber = Integer.parseInt(userNum);

        //System.out.println(userNumber);
        String txt = "";

        if (userNumber != -1) {
            if (userNumber > randomNum) {
                txt = "Too High!";
            } else if (userNumber < randomNum) {
                txt = "Too Low!";
            } else {
                txt = "Correct! You got my number!";
                randomNum = randomGenerator.nextInt(16);
            }

            Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please enter a valid number!", Toast.LENGTH_SHORT).show();
        }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNum = randomGenerator.nextInt(16);
    }
}
