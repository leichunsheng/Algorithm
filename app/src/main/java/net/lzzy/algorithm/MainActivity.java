package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                directSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {


        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (items[j].compareTo(items[i]) < 0) {
                continue;
            }
            Integer tmp = items[i];
            while (j >= 0 && items[j].compareTo(tmp) > 0) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = tmp;
        }
    }
//        for(int i=0;i<items.length-1;i++){
//            int minPos=i;
//            for (int j=i+1;j<items.length;j++){
//                if (items[minPos].compareTo(items[j])>0){
//                    minPos=j;
//                }
//            }
//        }
//        for (int j=0;j<=items.length-1;j++){
//            for (int i=0;i<items.length-1;i++){
//                if (items[j]<items[i]){
//                    int temp=items[i] ;
//                    items[i]=items[j];
//                    items[j]=temp;
//                }
//            }
//        }


    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
