package net.lzzy.algorithm;

import javax.xml.transform.Templates;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort extends BaseSort {

    //------------构造器--------
    InsertSort(Integer[] items) {
        super(items);
        //---------构造器-------
    }

    @Override
    public void sort() {//sort方法

        long start = System.currentTimeMillis();
        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            Integer tmp = (Integer) items[i];
            while (j >= 0 && bigger(items[j], tmp)) {
                items[j + 1] = items[j];
                moveStep++;
                j--;
            }
            items[j + 1] = tmp;
        }
        long duration = System.currentTimeMillis() - start;
    }
}
