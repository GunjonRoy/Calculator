package com.gunjon.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculate=findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator();
            }
        });
    }
    private void calculator(){
        EditText first =findViewById(R.id.first);
        EditText second=findViewById(R.id.second);

        RadioButton add=findViewById(R.id.addd);
        RadioButton sub=findViewById(R.id.sub);
        RadioButton mul=findViewById(R.id.mul);
        RadioButton div=findViewById(R.id.div);

        TextView t =findViewById(R.id.solution);
        try {
            float n1=Integer.parseInt(first.getText().toString());
            float n2=Integer.parseInt(second.getText().toString());

            float result=0;

            if(add.isChecked()){
                result=n1+n2;
            }
            else if(sub.isChecked()){
                result=n1-n2;
            }
            else if(mul.isChecked()){
                result=n1*n2;
            }
            else {
                if(n2==0){
                    Toast.makeText(this,"Second Number can't be Zero...Try Again",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if(div.isChecked()){
                        result=n1/n2;
                    }
                }
            }
            t.setText("The Result is : "+result);
        }catch (Exception e){

            Toast.makeText(this,"Enter Number",Toast.LENGTH_SHORT).show();

        }

    }

}
