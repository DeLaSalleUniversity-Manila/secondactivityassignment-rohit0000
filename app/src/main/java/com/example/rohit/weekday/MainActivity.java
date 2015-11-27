package com.example.rohit.weekday;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int day;
    private int month;
    private int year;
    private int century;

    private int weekday_num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    public void getInputValues() {
        EditText et_day = (EditText) findViewById(R.id.textday);
        EditText et_month = (EditText) findViewById(R.id.textmonth);
        EditText et_year = (EditText) findViewById(R.id.textyear);


        day = Integer.parseInt(et_day.getText().toString());
        month = Integer.parseInt(et_month.getText().toString());
        String s = et_year.getText().toString();
        century = Integer.parseInt(s.substring(0, 2));
        year = Integer.parseInt(s.substring(2));


    }

    private void dateChecker(){

        if(month == 1 || month == 2){
            month += 12;
            if(year > 0)
                year --;
            else if(year == 0){
                century--;
                year = 99;
            }
        }
    }

    private void computeDay() {
        // TODO: Give the formula here:

        weekday_num = (day + (int) (26 * (month + 1) / 10.0) + year + (int) (year / 4.0) + (int) (century / 4.0) + 5 * century) % 7;
    }

    public void clickCompute(View view) {
        getInputValues();
        dateChecker();
        computeDay();
        identifyDay();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void identifyDay() {
        String day_text;
        switch (weekday_num) {
            case 0: {
                day_text = "It's Saturday!";
                break;
            }
            case 1: {
                day_text = "It's Sunday!";
                break;
            }
            case 2: {
                day_text = "It's Monday!";
                break;
            }
            case 3: {
                day_text = "It's Tuesday!";
                break;
            }
            case 4: {
                day_text = "It's Wednesday!";
                break;
            }
            case 5: {
                day_text = "It's Thursday!";
                break;
            }
            case 6: {
                day_text = "It's Friday!";
                break;
            }
            default:
                day_text = "Invalid day!";
        }



        /*//FOR OUTPUT TEXT VIEW
        TextView output = (TextView) findViewById(R.id.output);
        output.setText(day_text);
        //END OUTPUT TEXT*/


        //FOR NEW SCREEN OUTPUT
        Intent i = new Intent(this, Activity2.class);

        /// Put attachment data along with the intent
        i.putExtra("message", day_text);

        startActivity(i);

        //END SCREEN OUTPUT*/
    }
}
