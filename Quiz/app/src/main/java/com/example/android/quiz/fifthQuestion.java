package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class fifthQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);

        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreFive);

        scoreTextView.setText(myApp.score + "");

        //Create an intent to move to the last activity.
        Button fifthNextButton = findViewById(R.id.fifthNextButton_id);
        fifthNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fifthIntent = new Intent(fifthQuestion.this, byeActivity.class);
                startActivity(fifthIntent);
            }
        });
    }

    /*
   A method that gets called when submit button for the question is clicked. The conditions below
   give the conditions for the right answer to the question.
    */
    public void fifthSubmitAnswer(View v) {
        ImageView fifthImageView = findViewById(R.id.fifthPagePicture_id);

        EditText editText = findViewById(R.id.fifthAnswer_id);

        String fifthAnswer = editText.getText().toString();

        MyApplication myApp = (MyApplication) getApplication();
        TextView scoreTextView = findViewById(R.id.scoreFive);

        if (fifthAnswer.equalsIgnoreCase("Wall")) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            fifthImageView.setVisibility(View.VISIBLE);
            myApp.score++;
            scoreTextView.setText(myApp.score + "");
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
            fifthImageView.setVisibility(View.VISIBLE);
        }
    }
}
