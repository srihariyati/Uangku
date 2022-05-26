package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class AddPemasukan extends AppCompatActivity {
    Button back, addpeng, yes, no, buka_pil;
    ImageButton simpan, batal, pu_simpan;
    FrameLayout pu_batal, pilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pemasukan);

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
                pu_simpan.setVisibility(View.VISIBLE);

                pu_simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                        startActivity(bukaHome);
                    }
                });
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