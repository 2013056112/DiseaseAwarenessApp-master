package com.real.francisamiel.diseaseawarenessapp;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymptomsSearch extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    Firebase myFirebase;
    private ArrayAdapter<String> myArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_search);
        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://diseaseawarenessapp.firebaseio.com/");
        ListView list = findViewById(R.id.theList);
        EditText filter = findViewById(R.id.theFilter);
        myArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myArrayList);
        list.setAdapter(myArrayAdapter);

        myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String myChildValues = dataSnapshot.getValue(String.class);
                myArrayList.add(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (SymptomsSearch.this).myArrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent myIntent = new Intent(view.getContext(),Asthma.class);
                    startActivityForResult(myIntent,0);
                }
                if (position==1){
                    Intent myIntent = new Intent(view.getContext(),BreastCancer.class);
                    startActivityForResult(myIntent,1);
                }
                if (position==2){
                    Intent myIntent = new Intent(view.getContext(),Bronchitis.class);
                    startActivityForResult(myIntent,2);
                }
                if (position==3){
                    Intent myIntent = new Intent(view.getContext(),ChronicKidneyDisease.class);
                    startActivityForResult(myIntent,3);
                }
                if (position==4){
                    Intent myIntent = new Intent(view.getContext(),CoronaryHeartDisease.class);
                    startActivityForResult(myIntent,4);
                }
                if (position==5){
                    Intent myIntent = new Intent(view.getContext(),Diabetes.class);
                    startActivityForResult(myIntent,5);
                }
                if (position==6){
                    Intent myIntent = new Intent(view.getContext(),Emphysema.class);
                    startActivityForResult(myIntent,6);
                }
                if (position==7){
                    Intent myIntent = new Intent(view.getContext(),Hypertension.class);
                    startActivityForResult(myIntent,7);
                }
                if (position==8){
                    Intent myIntent = new Intent(view.getContext(),Influenza.class);
                    startActivityForResult(myIntent,8);
                }
                if (position==9){
                    Intent myIntent = new Intent(view.getContext(),LiverCancer.class);
                    startActivityForResult(myIntent,9);
                }
                if (position==10){
                    Intent myIntent = new Intent(view.getContext(),Malaria.class);
                    startActivityForResult(myIntent,10);
                }
                if (position==11){
                    Intent myIntent = new Intent(view.getContext(),Pneumonia.class);
                    startActivityForResult(myIntent,11);
                }
                if (position==12){
                    Intent myIntent = new Intent(view.getContext(),ProstateCancer.class);
                    startActivityForResult(myIntent,12);
                }
                if (position==13){
                    Intent myIntent = new Intent(view.getContext(),Stroke.class);
                    startActivityForResult(myIntent,13);
                }
                if (position==14){
                    Intent myIntent = new Intent(view.getContext(),Tubercolosis.class);
                    startActivityForResult(myIntent,14);
                }
            }
        });

    }



}
