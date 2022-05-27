package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StatistikPengeluaran extends AppCompatActivity {
    Button home, stapem, pengaturan, akun, add;
    TextView makanan, minuman, internet;
    int[] daftar1, daftar2, daftar3;
    int h_makanan = 0, h_minuman = 0, h_internet = 0;
    protected Cursor cursor1, cursor2, cursor3;
    DataHelper database;
    StatistikPengeluaran spr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik_pengeluaran);

        makanan = (TextView) findViewById(R.id.tv_makanan);
        minuman = (TextView) findViewById(R.id.tv_minuman);
        internet = (TextView) findViewById(R.id.tv_internet);

        spr = this;
        database = new DataHelper(this);
        hargaMakanan();
        makanan.setText("Rp."+h_makanan);

        hargaMinuman();
        minuman.setText("Rp."+h_minuman);

        hargaInternet();
        internet.setText("Rp."+h_internet);


        home = (Button) findViewById(R.id.to_home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHomePem = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHomePem);
            }
        });

        stapem = (Button) findViewById(R.id.sta_pem);
        stapem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_statistik = new Intent(getApplicationContext(), StatistikPemasukan.class);
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

    private void hargaMakanan() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor1 = db.rawQuery("SELECT * FROM pengeluaran WHERE kategori='Makanan'", null );
        daftar1= new int [cursor1.getCount()];
        cursor1.moveToFirst();
        for (int i = 0; i < cursor1.getCount(); i++){
            cursor1.moveToPosition(i);
            daftar1[i] = cursor1.getInt(3);
            h_makanan = h_makanan + daftar1[i];
        }
    }

    private void hargaMinuman() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor2 = db.rawQuery("SELECT * FROM pengeluaran WHERE kategori='Minuman'", null );
        daftar2 = new int [cursor2.getCount()];
        cursor2.moveToFirst();
        for (int i = 0; i < cursor2.getCount(); i++){
            cursor2.moveToPosition(i);
            daftar2[i] = cursor2.getInt(3);
            h_minuman = h_minuman + daftar2[i];
        }
    }

    private void hargaInternet() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor3 = db.rawQuery("SELECT * FROM pengeluaran WHERE kategori='Internet'", null );
        daftar3 = new int [cursor3.getCount()];
        cursor3.moveToFirst();
        for (int i = 0; i < cursor3.getCount(); i++){
            cursor3.moveToPosition(i);
            daftar3[i] = cursor3.getInt(3);
            h_minuman = h_minuman + daftar3[i];
        }
    }


}