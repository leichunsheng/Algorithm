package net.lzzy.algorithm;

import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
//封装的BaseSort
//Description:类型参数T需要加约束，约束T实现Comparable<T>接口
public abstract class BaseSort<T extends Comparable<? super T>> {

    T[] items;
    private long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;

    BaseSort(T[] items) {
        this.items = items;
        compareCount = 0;
        swapCount = 0;
        moveStep = 0;
    }

    boolean bigger(T a, T b) {
        compareCount++;
        return a.compareTo(b) > 0;
    }

    void swap(int i, int j) {

    }

    public String getResult() {
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display;
    }

    public void sortWithTime() {
        long start = System.currentTimeMillis();
        sort();
        duration = System.currentTimeMillis() - start;
    }

    public abstract void sort();

    public long getDuration() {
        return duration;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getMoveStep() {
        return moveStep;
    }
}
