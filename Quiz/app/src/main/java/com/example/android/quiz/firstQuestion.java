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

import org.w3c.dom.Text;

public class firstQuestion extends AppCompatActivity {

    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        //Creating an intent to move to the next activity for second question.
        Button nextButton = findViewById(R.id.firstNextButton_id);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(firstQuestion.this, secondQuestion.class);
                startActivity(intent);
            }
        });
    }

    /*
    A method that gets called when submit button for the question is clicked. The conditions below
    give the conditions for the right answer to the question.
     */

    public void submitAnswer(View v) {
        ImageView imageView = findViewById(R.id.firstPagePicture_id);
        TextView textView = findViewById(R.id.scoreOne);

        MyApplication myApp = (MyApplication) getApplication();
        textView.setText(myApp.score + "");


        CheckBox check_box_option_one = findViewById(R.id.checkBoxOne_id);
        CheckBox check_box_option_two = findViewById(R.id.checkBoxTwo_id);
        CheckBox check_box_option_three = findViewById(R.id.checkBoxThree_id);
        CheckBox check_box_option_four = findViewById(R.id.checkBoxFour_id);

        boolean option_one_state = check_box_option_one.isChecked();
        boolean option_two_state = check_box_option_two.isChecked();
        boolean option_three_state = check_box_option_three.isChecked();
        boolean option_four_state = check_box_option_four.isChecked();

        if (option_one_state) {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            imageView.setVisibility(View.VISIBLE);
        } else if (option_two_state && option_three_state && option_four_state) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            imageView.setVisibility(View.VISIBLE);
            myApp.score++;
            textView.setText(myApp.score + "");

        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
