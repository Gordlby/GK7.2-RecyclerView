package com.example.gk72_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Timestamp;
import java.util.Date;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent in = getIntent();
        String pname = in.getStringExtra("Intern-Data-Name");
        String pid = in.getStringExtra("Intern-Data-Id");
        String pprice = in.getStringExtra("Intern-Data-Price");
        TextView tv1 = findViewById(R.id.productName);
        TextView tv2 = findViewById(R.id.productId);
        TextView tv3 = findViewById(R.id.productPrice);

        tv1.setText(pname);
        tv2.setText(pid);
        tv3.setText(pprice);


    }
}

/*
public void onClick(View v) {
    Intent in = new Intent(getApplicationContext(), LinkExplicitActivity.class);
    in.putExtra("Intern-Data-Name", p.getName);
    in.putExtra("Intern-Data-Id", p.getId);
    in.putExtra("Intern-Data-Price", p.getPreis);
    startActivity(in);
}
*/