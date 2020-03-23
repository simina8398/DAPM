package com.example.lab5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

class Car{
    public String name;
    public int imageResource;
}

class TagCar{
    public TextView name;
    public ImageView image;
}
public class MainActivity extends Activity {

    private ListView listOfCars;
    CarAdapter carAdapter;
    private EditText addNewCar;
    private Button addButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            //TODO 1
        listOfCars = findViewById(R.id.lv_list_cars);
            //TODO 2
        carAdapter = new CarAdapter(this);
            //TODO 3
        listOfCars.setAdapter(carAdapter);
            //TODO 4
        carAdapter.addCar("Audi",R.drawable.car);
        carAdapter.addCar("BMW",R.drawable.car);
        carAdapter.addCar("Mercedes",R.drawable.car);
        carAdapter.addCar("Jaguar",R.drawable.car);

        addNewCar = findViewById(R.id.ed_new_car);
        addButton = findViewById(R.id.b_add_car);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = addNewCar.getText().toString();
                carAdapter.addCar(text, R.drawable.car);
                addNewCar.setText("");
            }
        });

    }
}

