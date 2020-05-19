package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class secondQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreTwo);

        scoreTextView.setText(myApp.score + "");

        //Create an intent to move to the next activity for next question.
        Button secondNextButton = findViewById(R.id.secondNextButton_id);
        secondNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(secondQuestion.this, thirdQuestion.class);
                startActivity(secondIntent);
            }
        });
    }

    /*
   A method that gets called when submit button for the question is clicked. The conditions below
   give the conditions for the right answer to the question.
    */
    public void secondSubmitAnswer(View v) {
        ImageView secondImageView = findViewById(R.id.secondPagePicture_id);
        TextView textViewTwo = findViewById(R.id.scoreTwo);

        MyApplication myApp = (MyApplication) getApplication();

        RadioButton second_RadioButton_option_one = findViewById(R.id.second_RadioButtonOne_id);
        RadioButton second_RadioButton_option_two = findViewById(R.id.second_RadioButtonTwo_id);
        RadioButton second_RadioButton_option_three = findViewById(R.id.second_RadioButtonThree_id);
        RadioButton second_RadioButton_option_four = findViewById(R.id.second_RadioButtonFour_id);

        boolean second_option_one_state = second_RadioButton_option_one.isChecked();
        boolean second_option_two_state = second_RadioButton_option_two.isChecked();
        boolean second_option_three_state = second_RadioButton_option_three.isChecked();
        boolean second_option_four_state = second_RadioButton_option_four.isChecked();

        if (second_option_three_state && !second_option_one_state && !second_option_two_state && !second_option_four_state) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            secondImageView.setVisibility(View.VISIBLE);
            myApp.score++;
            textViewTwo.setText(myApp.score + "");
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            secondImageView.setVisibility(View.VISIBLE);
        }
    }
}
