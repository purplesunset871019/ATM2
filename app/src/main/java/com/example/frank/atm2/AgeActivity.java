package com.example.frank.atm2;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {

    int[] numbers = {19,20,21,22,23,24,25};
    private EditText edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        RecyclerView ageRecycler = findViewById(R.id.recycler);
        ageRecycler.setHasFixedSize(true);
        ageRecycler.setLayoutManager(new LinearLayoutManager(this));
        ageRecycler.setAdapter(new AgeAdapter());

        AgeAdapter adapter = new AgeAdapter();
        ageRecycler.setAdapter(adapter);
        edAge = findViewById(R.id.ed_age);
    }

    public void next(View view){
        int age = Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        user.setAge(age);

        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view){
        finish();
    }

    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);

            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, final int position) {
            holder.ageText.setText(numbers[position]+"");
            if(numbers[position] == 19){
                holder.ageText.setTextColor(Color.RED);
            }

            holder.ageText.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Log.d("AgeActivity","onclick"+numbers[position]);
                    edAge.setText(numbers[position]+"");
                }
            });
        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder{
            TextView ageText;
            public AgeHolder(View itemView){
                super (itemView);
                ageText = itemView.findViewById(R.id.tv_age);
            }
        }

    }
}
