package com.example.myshoppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonAddCloths;
    Button buttonChange;
    Spinner spinnerKInds;

    DatabaseReference databaseCloths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseCloths = FirebaseDatabase.getInstance().getReference("cloths");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAddCloths = (Button) findViewById(R.id.buttonAddCloths);
        buttonChange = (Button) findViewById(R.id.buttonChange);
        spinnerKInds = (Spinner) findViewById(R.id.spinnerKinds);

        buttonAddCloths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCloths();
            }
        });

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Content.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

    }
    private void addCloths(){
        String clothsName =  editTextName.getText().toString().trim();
        String kinds = spinnerKInds.getSelectedItem().toString();

        if(!TextUtils.isEmpty(clothsName)){
            String id = databaseCloths.push().getKey();
            Cloths cloths = new Cloths(id, clothsName, kinds);
            databaseCloths.child(id).setValue(cloths);
            Toast.makeText(this,"옷이 등록되었습니다",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "명칭을 입력하고 엔터를 눌러라", Toast.LENGTH_LONG).show();
        }
    }

}