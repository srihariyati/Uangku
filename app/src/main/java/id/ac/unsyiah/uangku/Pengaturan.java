package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pengaturan extends AppCompatActivity {
    Button home, statistik, akun, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        home = (Button) findViewById(R.id.to_home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHomePem = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHomePem);
            }
        });

        statistik = (Button) findViewById(R.id.to_sta);
        statistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_statistik = new Intent(getApplicationContext(), StatistikPengeluaran.class);
                startActivity(buka_statistik);
            }
        });

        add = (Button) findViewById(R.id.to_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_add = new Intent(getApplicationContext(), AddPengeluaran.class);
                startActivity(buka_add);
            }
        });

        akun = (Button) findViewById(R.id.to_acc);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_acc = new Intent(getApplicationContext(), Akun.class);
                startActivity(buka_acc);
            }
        });
    }
}