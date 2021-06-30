package com.order.leet;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xiaojw
 * @describe LruList
 * @date 2021/1/28 14:54
 */
public class LruLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private static final long serialVersionUID = 5593948922514032683L;
    private int capacity;
    public LruLinkedHashMap(int n) {
        super(n,0.75f,true);
        capacity = n;
    }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size()>capacity;
        }

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);

        System.out.println("请输入总共内存页面数： ");
        int n = cin.nextInt();
        Map<Integer, Integer> map=new LruLinkedHashMap<Integer, Integer>(n);

        System.out.println("请输入按顺序输入要访问内存的总共页面数： ");
        int y = cin.nextInt();

        System.out.println("请输入按顺序输入访问内存的页面序列： ");
        for(int i=1;i<=y;i++)
        {
            int x = cin.nextInt();
            map.put(x,  x);
        }
        System.out.println("此时内存中包含的页面数是有:");
        //用for-each语句，遍历此时内存中的页面并输出
        for(java.util.Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

}
