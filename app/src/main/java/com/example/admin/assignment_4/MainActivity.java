package com.example.admin.assignment_4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button generate, cancel;
    EditText number;

    EditText txt, txtTemp, txtHum, txtAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = (Button) findViewById(R.id.btnGenerate);
        cancel = (Button) findViewById(R.id.btn);

        number = (EditText) findViewById(R.id.txtNumber);

        txt = (EditText)findViewById(R.id.txtOut);
        txtTemp = (EditText)findViewById(R.id.txtTemp);
        txtHum = (EditText)findViewById(R.id.txtHumidity);
        txtAct = (EditText)findViewById(R.id.txtActivity);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TestAsync(). execute(number.getText().toString());

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTemp.setText("");
                txtHum.setText("");
                txtAct.setText("");
                txt.setText("");

            }
        });
    }

    class TestAsync extends AsyncTask<String, Integer, String>
    {
        String TAG = getClass().getSimpleName();
        String res = "";
        int temp, humidity,activity;
        protected void onPreExecute (){
        }

        protected String doInBackground(String...params) {

            int n = Integer.parseInt(params[0]);


            for(int i=1; i<=n; i++){
                temp = (int)(Math.random()*100);
                humidity = (int)(Math.random()*100);
                activity = (int)(Math.random()*100);

                res = res+"\n\n Output - "+i+" Temperature : "+temp+" F Humidity : "+humidity+"%Activity: "+activity;
                // publishProgress(i);
            }
            return res;
        }

        protected void onProgressUpdate(Integer...a){
        }

        protected void onPostExecute(String result) {

            txt.setText("\n");
            txtTemp.setText(""+temp+" F");
            txtHum.setText(""+humidity+"%");
            txtAct.setText(""+activity);
            txt.append(result);
        }
    }
}


