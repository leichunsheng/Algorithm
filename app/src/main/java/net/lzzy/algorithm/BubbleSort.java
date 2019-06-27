package net.lzzy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/20.  冒泡排序
 * Description:平方阶立方阶难度
 */
public class BubbleSort <T extends Comparable<T>> extends BaseSort{
    BubbleSort(Comparable[] items) {
        super(items);
    }

    @Override
    public void sort() {
    long satrt=System.currentTimeMillis();
    for (int i=0;i<items.length-1;i++){
        boolean exchange=false;
        for (int j=items.length-2;j>=i;j--){
            if (bigger(items[j],items[j+1])){
                swap(j,j+1);
                exchange=true;
            }
        }
        if (!exchange){
            break;
        }
    }
    setDuratiob(System.currentTimeMillis()-satrt);

    }

    private void setDuratiob(long l) {
    }
}
