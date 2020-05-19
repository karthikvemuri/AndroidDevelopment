package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class thirdQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreThree);

        scoreTextView.setText(myApp.score + "");

        //Create an intent to move to the next activity for next question.
        Button thirdNextButton = findViewById(R.id.thirdNextButton_id);
        thirdNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdIntent = new Intent(thirdQuestion.this, fourthQuestion.class);
                startActivity(thirdIntent);
            }
        });
    }

    /*
   A method that gets called when submit button for the question is clicked. The conditions below
   give the conditions for the right answer to the question.
    */
    public void thirdSubmitAnswer(View v) {
        ImageView thirdImageView = findViewById(R.id.thirdPagePicture_id);
        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreThree);

        RadioButton third_radioButton_One = findViewById(R.id.third_RadioButtonOne_id);
        RadioButton third_radioButton_Two = findViewById(R.id.third_RadioButtonTwo_id);
        RadioButton third_radioButton_Three = findViewById(R.id.third_RadioButtonThree_id);
        RadioButton third_radioButton_Four = findViewById(R.id.third_RadioButtonFour_id);

        boolean third_option_one_state = third_radioButton_One.isChecked();
        boolean third_option_two_state = third_radioButton_Two.isChecked();
        boolean third_option_three_state = third_radioButton_Three.isChecked();
        boolean third_option_four_state = third_radioButton_Four.isChecked();

        if (third_option_four_state && !third_option_one_state && !third_option_two_state && !third_option_three_state) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            thirdImageView.setVisibility(View.VISIBLE);
            myApp.score++;
            scoreTextView.setText(myApp.score + "");
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            thirdImageView.setVisibility(View.VISIBLE);
        }

    }
}


