package com.fis.queue;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        CustomQueue<SinhVien> lisSinhVien = new CustomQueue<>();
        Queue<SinhVien> lisSV = new LinkedList<SinhVien>();
        SinhVien sinhVien1 = new SinhVien("0001", 18);
        SinhVien sinhVien2 = new SinhVien("0002", 20);
        SinhVien sinhVien3 = new SinhVien("0003", 16);
        SinhVien sinhVien4 = new SinhVien("0004", 12);
        SinhVien sinhVien5 = new SinhVien("0005", 10);
        SinhVien sinhVien6 = new SinhVien("0006", 19);
        SinhVien sinhVien7 = new SinhVien("0007", 22);

        lisSinhVien.enqueue(sinhVien1);
        lisSinhVien.enqueue(sinhVien2);
        lisSinhVien.enqueue(sinhVien3);
        lisSinhVien.dequeue();
        lisSinhVien.enqueue(sinhVien4);
        lisSinhVien.enqueue(sinhVien5);
        lisSinhVien.enqueue(sinhVien6);
        lisSinhVien.enqueue(sinhVien7);
        lisSinhVien.dequeue();
        lisSinhVien.enqueue(sinhVien1);
        lisSV.add(sinhVien1);
        lisSV.add(sinhVien2);

        System.out.println("Queue Front : " + lisSV.remove().toString());
        System.out.println("Queue Rear : " + lisSV.remove().toString());
    }
}
