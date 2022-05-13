package sg.edu.rp.c36.id21028831.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker pickDate;
    TimePicker pickTime;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickDate=findViewById(R.id.datePicker);
        pickTime=findViewById(R.id.timePicker);
        btnDisplayDate=findViewById(R.id.buttonDisplayDate);
        btnDisplayTime=findViewById(R.id.buttonDisplayTime);
        output=findViewById(R.id.output);
        btnReset=findViewById(R.id.btnReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayHour=pickTime.getCurrentHour().toString();
                int displayMinute=pickTime.getCurrentMinute();

                String mintueString;
                if (displayMinute<10){
                    mintueString="0"+ (pickTime.getCurrentMinute().toString());
                }else{
                    mintueString=pickTime.getCurrentMinute().toString();
                }

                output.setText("Time is "+displayHour + ":" + mintueString);

            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int displayDay=pickDate.getDayOfMonth();
                int displayMonth=pickDate.getMonth();
                int displayYear=pickDate.getYear();


                String dayString;
                if (displayDay<10){
                    dayString="0"+(pickDate.getDayOfMonth()+"");
                }else{
                    dayString=pickDate.getDayOfMonth()+"";
                }
//
//                String monthString;
//                if (displayMonth<10){
//                    monthString="0"+(pickDate.getMonth()+"");
//                }else{
//                    monthString=pickDate.getMonth()+"";
//                }
//
//                output.setText(dayString+"/"+monthString+"/"+displayYear);
                
                final Calendar c = Calendar.getInstance();
                String month=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                output.setText(month +" "+ dayString +" "+ displayYear);


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate.updateDate(2020, 0, 1);
            }
        });


    }
}