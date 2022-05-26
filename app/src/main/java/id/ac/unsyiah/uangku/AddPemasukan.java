package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPemasukan extends AppCompatActivity {
    Button back, addpeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pemasukan);

        back = (Button) findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHome);
            }
        });

        addpeng = (Button) findViewById(R.id.add_peng);
        addpeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaAddPeng = new Intent(getApplicationContext(), AddPengeluaran.class);
                startActivity(bukaAddPeng);
            }
        });
    }
}