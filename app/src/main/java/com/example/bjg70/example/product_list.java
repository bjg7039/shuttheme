package com.example.bjg70.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class product_list extends AppCompatActivity {
    private ListView listView; // ListView 생성

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.product_list);

        listView = (ListView)findViewById(R.id.product_list);

        dataSetting();
    }

    // 주어진 데이터를 설정하는 함수
    private void dataSetting(){
        productAdapter productAdapter = new productAdapter();

        // 반복을 통해 임시 10번 데이터 저장
        for(int i=0; i<10; i++){
            productAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_camera), "제품이름", "유통기한", "구매날짜");
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name","제품이름");
            intent.putExtra("buy_date", "구매날짜");
            intent.putExtra("sell_by_date", i + "/" + i);
        }


        // 주어진 데이터 Adapter에 연결
        listView.setAdapter(productAdapter);
    }
}
