package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatistikPemasukan extends AppCompatActivity {
    Button home, stapeng, pengaturan, akun, add;
    TextView uang, gaji;
    int[] daftar1, daftar2;
    int h_uang = 0, h_gaji = 0;
    protected Cursor cursor1, cursor2;
    DataHelper database;
    StatistikPemasukan spm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik_pemasukan);

        gaji = (TextView) findViewById(R.id.tv_gaji);
        uang = (TextView) findViewById(R.id.tv_uang);

        spm = this;
        database = new DataHelper(this);
        hargaGaji();
        gaji.setText("Rp."+h_gaji);

        hargaUang();
        uang.setText("Rp."+h_uang);

        home = (Button) findViewById(R.id.to_home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHomePem = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHomePem);
            }
        });

        stapeng = (Button) findViewById(R.id.sta_peng);
        stapeng.setOnClickListener(new View.OnClickListener() {
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

        pengaturan = (Button) findViewById(R.id.to_set);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_set = new Intent(getApplicationContext(), Pengaturan.class);
                startActivity(buka_set);
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

    private void hargaGaji() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor1 = db.rawQuery("SELECT * FROM pemasukan WHERE kategori='Gaji Bulanan'", null );
        daftar1= new int [cursor1.getCount()];
        cursor1.moveToFirst();
        for (int i = 0; i < cursor1.getCount(); i++){
            cursor1.moveToPosition(i);
            daftar1[i] = cursor1.getInt(3);
            h_gaji = h_gaji + daftar1[i];
        }
    }

    private void hargaUang() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor2 = db.rawQuery("SELECT * FROM pemasukan WHERE kategori='Uang Saku'", null );
        daftar2 = new int [cursor2.getCount()];
        cursor2.moveToFirst();
        for (int i = 0; i < cursor2.getCount(); i++){
            cursor2.moveToPosition(i);
            daftar2[i] = cursor2.getInt(3);
            h_uang = h_uang + daftar2[i];
        }
    }
}