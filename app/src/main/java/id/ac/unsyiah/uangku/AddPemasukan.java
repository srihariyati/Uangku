package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPemasukan extends AppCompatActivity {
    Button back, addpeng, yes, no, buka_pil, p1, p2;
    ImageButton simpan, batal, pu_simpan;
    FrameLayout pu_batal, pilihan;
    DataHelper database;
    String kategori;
    EditText tanggal, namaItem, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pemasukan);

        database = new DataHelper(this);
        tanggal = findViewById(R.id.tanggal);
        //kategori = findViewById(R.id.kategori);
        namaItem = findViewById(R.id.namaItem);
        harga = findViewById(R.id.harga);

        //set invisible semua pop up --> simpan, batal dan pilihan
        pu_simpan = (ImageButton) findViewById(R.id.popupberhasil);
        pu_simpan.setVisibility(View.INVISIBLE);

        pu_batal = (FrameLayout) findViewById(R.id.popupbatal);
        pu_batal.setVisibility(View.INVISIBLE);

        pilihan = (FrameLayout) findViewById(R.id.pilihan_pem);
        pilihan.setVisibility(View.INVISIBLE);

        buka_pil = (Button) findViewById(R.id.buka_pilihan);
        buka_pil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilihan.setVisibility(View.VISIBLE);

                p1 = (Button) findViewById(R.id.pil1);
                p2 = (Button) findViewById(R.id.pil2);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Uang Saku";
                    }
                });

                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Gaji Bulanan";
                    }
                });
            }
        });

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

        simpan = (ImageButton) findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pu_simpan.setVisibility(View.VISIBLE);
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into pemasukan(tanggal, kategori, item, harga) values(' "+
                        tanggal.getText().toString() +"','"+
                        kategori +"','"+
                        namaItem.getText().toString()+ "','"+
                        harga.getText().toString()+"')");
                Toast.makeText(AddPemasukan.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
                HomePemasukan.hpl.RefreshList();
                finish();
            }
        });

        batal = (ImageButton) findViewById(R.id.btn_batal);
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pu_batal.setVisibility(View.VISIBLE);

                yes = (Button) findViewById(R.id.v);
                no = (Button) findViewById(R.id.x);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                        startActivity(bukaHome);
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pu_batal.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });


    }
}