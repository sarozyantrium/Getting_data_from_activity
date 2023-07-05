package com.example.formwithnormaltoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_name,edt_number,edt_password;
    Button btn_submit;
    RadioGroup rb_group;
    RadioButton rb_male,rb_female;
    CheckBox cb_android,cb_java,cb_python;
    Spinner sp_cities;
    TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_number=(EditText) findViewById(R.id.edt_number);
        edt_password=(EditText) findViewById(R.id.edt_password);


        rb_female=(RadioButton) findViewById(R.id.rb_female);
        rb_male=(RadioButton) findViewById(R.id.rb_male);

        cb_android=(CheckBox) findViewById(R.id.cb_android);
        cb_java=(CheckBox) findViewById(R.id.cb_Java);
        cb_python=(CheckBox) findViewById(R.id.cb_Python);

        sp_cities=(Spinner) findViewById(R.id.sp_cities);

        btn_submit=(Button) findViewById(R.id.btn_submit);


    }

    public void getAllValues(View view)
    {

        ////////////------get VALUE FORM EDITTEXT--------------////////////////////
        String name=edt_name.getText().toString();
        String passcode=edt_password.getText().toString();
        String number=edt_number.getText().toString();

        ///////////////---------getValue from RadioButton--------------//////////

        String gender=" ";

        if(rb_male.isChecked())
        {
            gender=rb_male.getText().toString();
        }

        if(rb_female.isChecked())
        {
            gender=rb_female.getText().toString();
        }

        //---------getting value from checkBox----------///////////

        String interest=" ";

        if(cb_android.isChecked())
        {
            interest+=cb_android.getText().toString();

        }

        if(cb_java.isChecked())
        {
            interest+=cb_java.getText().toString();

        }

        if(cb_python.isChecked())
        {
            interest+=cb_python.getText().toString();

        }

        //////////------------getting value from Spineer ----------//////////////

        String city=sp_cities.getSelectedItem().toString();

        String res=name+passcode+number+gender+interest+city;

    //Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        /////process of inflating the layout from the another activirty.xml
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_design));

        Toast t=new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER,0,0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(layout);
        t.show();

        //////setting the result(res) in the textview
        txt_view=(TextView)layout.findViewById(R.id.txt_view);
        txt_view.setText(res);
    }
}