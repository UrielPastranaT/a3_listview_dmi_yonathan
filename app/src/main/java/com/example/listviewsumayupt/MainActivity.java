package com.example.listviewsumayupt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText tfN1;
    private EditText tfN2;
    private ListView lvResultado;
    private ArrayList<String> arrayResultados;
    private ArrayAdapter adapter;

    private Button btnCalcular;
    private Button btnLimpiar;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tfN1 = (EditText)findViewById(R.id.tfN1);
        tfN2 = (EditText)findViewById(R.id.tfN2);

        lvResultado = (ListView)findViewById(R.id.lvResultado);
        arrayResultados = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayResultados);
        lvResultado.setAdapter(adapter);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);

        tfN1.setOnClickListener(this);
        tfN2.setOnClickListener(this);

        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        lvResultado = (ListView)findViewById(R.id.lvResultado);
        lvResultado.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "Has seleccionado: "+ arrayResultados.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tfN1:
                tfN2.requestFocus();
                break;
            case R.id.tfN2:
                btnCalcular.requestFocus();
                break;
            case R.id.btnCalcular:
                int n1 = Integer.parseInt(tfN1.getText().toString());
                int n2 = Integer.parseInt(tfN2.getText().toString());
                int suma = n1 + n2;

                arrayResultados.add(n1 + " + " + n2 + " = " + String.valueOf(suma));
                adapter.notifyDataSetChanged();

                btnLimpiar.requestFocus();
                break;
            case R.id.btnLimpiar:
                tfN1.setText("");
                tfN2.setText("");
                tfN1.requestFocus();
                break;
        }
    }
}