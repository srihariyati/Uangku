package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePengeluaran extends AppCompatActivity {
    Button homepem, statistik, pengaturan, akun, add;
    String[] daftar; //harga;
    int[] daftar1;
    int h_saldo=0;
    ListView listView;
    TextView saldo;
    Menu menu;
    protected Cursor cursor, cursor1;
    DataHelper database;
    public static HomePengeluaran hpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pengeluaran);


        hpr = this;
        database = new DataHelper(this);

        saldo = (TextView) findViewById(R.id.saldopl);
        tampilSaldo();
        saldo.setText("  Rp. "+h_saldo);

        homepem = (Button) findViewById(R.id.home_pem);

        homepem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHomePem = new Intent(HomePengeluaran.this, HomePemasukan.class);
                startActivity(bukaHomePem);
            }
        });

        statistik = (Button) findViewById(R.id.to_sta);
        statistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_statistik = new Intent(HomePengeluaran.this, StatistikPengeluaran.class);
                startActivity(buka_statistik);
            }
        });

//        add = (Button) findViewById(R.id.to_add);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent buka_add = new Intent(getApplicationContext(), AddPengeluaran.class);
//                startActivity(buka_add);
//            }
//        });
        FloatingActionButton add = findViewById(R.id.to_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_add = new Intent(HomePengeluaran.this, AddPengeluaran.class);
                startActivity(buka_add);
            }
        });

        pengaturan = (Button) findViewById(R.id.to_set);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_set = new Intent(HomePengeluaran.this, Pengaturan.class);
                startActivity(buka_set);
            }
        });

        akun = (Button) findViewById(R.id.to_acc);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_acc = new Intent(HomePengeluaran.this, Akun.class);
                startActivity(buka_acc);
            }
        });
        hpr = this;
        database = new DataHelper(this);
        RefreshList();
    }

    private void tampilSaldo() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor1 = db.rawQuery("SELECT * FROM pengeluaran ", null );
        daftar1= new int [cursor1.getCount()];
        cursor1.moveToFirst();
        for (int i = 0; i < cursor1.getCount(); i++){
            cursor1.moveToPosition(i);
            daftar1[i] = cursor1.getInt(3);
            h_saldo = h_saldo + daftar1[i];
        }
    }


    public void RefreshList() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pengeluaran", null );
        daftar = new String [cursor.getCount()];
        //harga = new String [cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(2).toString();
            //harga[i] = cursor.getString(3).toString();
        }
        listView = (ListView) findViewById(R.id.item);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));

        listView.setSelected(true);
    }
}