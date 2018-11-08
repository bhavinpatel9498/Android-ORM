package m.com.orm_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn;
    private Button viewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = findViewById(R.id.button);

        viewBtn = findViewById(R.id.button2);

        viewButtonMethods(viewBtn);
        saveButtonMethods(saveBtn);
    }


    private void viewButtonMethods(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                    Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);
                    startActivity(intent);

            }
        });
    }


    private void saveButtonMethods(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                EditText ele1 =(EditText) findViewById(R.id.editText2);
                String sName = ele1.getText().toString();

                EditText ele2 =(EditText) findViewById(R.id.editText3);
                String sEmail = ele2.getText().toString();

                EditText ele3 =(EditText) findViewById(R.id.editText4);
                String sStudentId = ele3.getText().toString();

                ActiveAndroid.beginTransaction();
                try {

                    StudentBO stuObj = new StudentBO();

                    stuObj.name = sName;
                    stuObj.email = sEmail;
                    stuObj.aNumber = sStudentId;

                    stuObj.save();
                    ActiveAndroid.setTransactionSuccessful();

                    Toast.makeText(getApplicationContext(), "Details Saved in SQL Lite DB.", Toast.LENGTH_SHORT).show();

                }
                finally {
                    ActiveAndroid.endTransaction();
                }

            }
        });
    }
}
