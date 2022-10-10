package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class project_details extends AppCompatActivity {

    String[] State={"Andhra Pradesh", "Arunachal Pradesh", "Assam","Bihar","Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
            "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand",
            "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};

    EditText title_pr_details,short_desc,City,country_name;
    Button start_date_btn,end_date_btn,save;
    TextView start_date_txt,end_date_txt;
    AutoCompleteTextView ac;
    ArrayAdapter<String> adapterItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        getSupportActionBar().setTitle("Add Project");

        ac= findViewById(R.id.ac);
        ArrayAdapter adapterItems = new ArrayAdapter(project_details.this, android.R.layout.simple_list_item_1,State);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,State);

        ac.setAdapter(adapterItems);

        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x = parent.getItemAtPosition(position).toString();
                Toast.makeText(project_details.this, "Item: "+x, Toast.LENGTH_SHORT).show();
            }
        });

//        start_date_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int yr1 = cal.get(Calendar.YEAR);
//                int mt1 = cal.get(Calendar.MONTH);
//                int dy1 = cal.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog dp1 = new DatePickerDialog(project_details.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                        start_date_txt.setText(dayOfMonth+"/"+(month+1)+"/"+year);
//                    }
//                },yr1,mt1,dy1);
//                dp1.show();
//            }
//        });
//
//        end_date_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int yr2 = cal.get(Calendar.YEAR);
//                int mt2 = cal.get(Calendar.MONTH);
//                int dy2 = cal.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog dp2 = new DatePickerDialog(project_details.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                        end_date_txt.setText(dayOfMonth+"/"+(month+1)+"/"+year);
//                    }
//                },yr2,mt2,dy2);
//                dp2.show();
//            }
//        });
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String projectname=title_pr_details.getText().toString();
//                String desc = short_desc.getText().toString();
//                String startdatestring= start_date_txt.getText().toString();
//                String Endstring= end_date_txt.getText().toString();
//
//            }
//        });

    }
}