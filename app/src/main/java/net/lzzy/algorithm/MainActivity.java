package net.lzzy.algorithm;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    Spinner spinner;
    private LinearLayout container;
    Spinner spSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        spinner=findViewById(R.id.activity_spin);
        initSpinner();
        initViews();
        initSearch();
    }

    private void initSearch(){
         spSearch=findViewById(R.id.activity_spin2);
        spSearch.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,SearchFactory.getSearchNames()));
//        container=findViewById(R.id.activity_Search);
    }


    private void initSpinner() {
        Spinner spinner = findViewById(R.id.activity_spin);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SortFactory.getSortNames()));
    }

    private void initViews() {
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
                BaseSort<Integer> sort = SortFactory.getInstance(spinner.getSelectedItemPosition(), items);
                BaseSort<Integer> sortNotNull = Objects.requireNonNull(sort);
                sortNotNull.sortWithTime();
                String result = sort.getResult();
                String str = "运行时长："+sort.getDuration()
                        +"\n比较次数：" +sort.getCompareCount()+
                        "\n交换次数"+sort.getSwapCount()+"移动次数"+sort.getMoveStep();

                tvResult.setText(result);
                Toast.makeText(this, "总时长：" + sort.getDuration(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    private void resetSearch(){
        container.removeAllViews();
        generateItems();
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

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
