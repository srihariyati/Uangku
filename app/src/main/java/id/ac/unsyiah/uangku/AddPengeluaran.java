package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPengeluaran extends AppCompatActivity {
    Button back, addpem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pengeluaran);

        back = (Button) findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHome);
            }
        });

        addpem = (Button) findViewById(R.id.add_pem);
        addpem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaAddPem = new Intent(getApplicationContext(), AddPemasukan.class);
                startActivity(bukaAddPem);
            }
        });
    }
}