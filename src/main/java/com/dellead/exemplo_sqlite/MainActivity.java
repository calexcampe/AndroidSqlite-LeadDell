package com.dellead.exemplo_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtesporte,edttime,edtequipe,edtjogadores;
    Button btnenvia, btncancela;
    Sqlite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlite = new Sqlite(this);

        edtesporte = findViewById(R.id.edtesporte);
        edttime = findViewById(R.id.edttime);
        edtequipe = findViewById(R.id.edtequipe);
        edtjogadores = findViewById(R.id.edtequipe);

        btnenvia = findViewById(R.id.btnenvia);
        btncancela = findViewById(R.id.btncancelar);

        btncancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtesporte.setText("");
                edttime.setText("");
                edtequipe.setText("");
                edtjogadores.setText("");
            }
        });

        btnenvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    sqlite.InserirInformacoes(edtesporte.getText().toString(), edttime.getText().toString(),
                            edtequipe.getText().toString(), edtjogadores.getText().toString());
                }catch (Exception e){

                    System.err.println("AsyncTask erro: " + e.getMessage());
                }
            }
        });
    }
}
