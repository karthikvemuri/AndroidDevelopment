package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class fourthQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);

        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreFour);

        scoreTextView.setText(myApp.score + "");


        //Create an intent to move to the next activity for next question.
        Button fourthNextButton = findViewById(R.id.fourthNextButton_id);
        fourthNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fourthIntent = new Intent(fourthQuestion.this, fifthQuestion.class);
                startActivity(fourthIntent);
            }
        });
    }

     /*
    A method that gets called when submit button for the question is clicked. The conditions below
    give the conditions for the right answer to the question.
     */

    public void fourthSubmitAnswer(View v) {
        ImageView fourthImageView = findViewById(R.id.fourthPagePicture_id);
        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreFour);

        CheckBox fourth_check_box_option_one = findViewById(R.id.fourth_CheckBoxOne_id);
        CheckBox fourth_check_box_option_two = findViewById(R.id.fourth_CheckBoxTwo_id);
        CheckBox fourth_check_box_option_three = findViewById(R.id.fourth_CheckBoxThree_id);
        CheckBox fourth_check_box_option_four = findViewById(R.id.fourth_CheckBoxFour_id);

        boolean fourth_option_one_state = fourth_check_box_option_one.isChecked();
        boolean fourth_option_two_state = fourth_check_box_option_two.isChecked();
        boolean fourth_option_three_state = fourth_check_box_option_three.isChecked();
        boolean fourth_option_four_state = fourth_check_box_option_four.isChecked();

        if (fourth_option_three_state && fourth_option_one_state && !fourth_option_two_state && !fourth_option_four_state) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            fourthImageView.setVisibility(View.VISIBLE);
            myApp.score++;
            scoreTextView.setText(myApp.score + "");
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            fourthImageView.setVisibility(View.VISIBLE);
        }
    }
}
