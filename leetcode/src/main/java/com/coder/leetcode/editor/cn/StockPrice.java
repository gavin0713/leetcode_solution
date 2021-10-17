package com.coder.leetcode.editor.cn;

import java.util.*;

/**
 * Created by kougavin on 10/10/2021.
 */
public class StockPrice {
    TreeMap<Integer, Integer> treeMap;
    TreeMap<Integer, Integer> treeSet;
    public StockPrice() {
        treeMap = new TreeMap<>();
        treeSet = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (treeMap.containsKey(timestamp)) {
            Integer value = treeMap.get(timestamp);
            treeSet.merge(value, -1, Integer::sum);
            if (treeSet.get(value) <= 0) {
                treeSet.remove(value);
            }
        }
        treeMap.put(timestamp, price);
        treeSet.merge(price, 1, Integer::sum);
    }

    public int current() {
        return treeMap.lastEntry().getValue();
    }

    public int maximum() {
        return treeSet.lastKey();
    }

    public int minimum() {
        return treeSet.firstKey();
    }

    private int INT_MAX = 10_000_000;

    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        int sum=0;
        for(int v:nums) sum+=v;
        List<Integer>[] ss1 = new List[n+1];
        List<Integer>[] ss2 = new List[n+1];
        for (int i = 0; i <= n; i++) {
            ss1[i] = new ArrayList<>();
            ss2[i] = new ArrayList<>();
        }
        int T=(1<<n);
        for(int i=0;i<T;i++){
            int s1=0,s2=0;
            int cnt=0;
            for(int j=0;j<n;j++){
                if(((i>>j)&1) > 0){
                    cnt++;
                    s1+=nums[j];
                    s2+=nums[j+n];
                }
            }
            ss1[cnt].add(s1);
            ss2[cnt].add(s2);
        }
        int ans=INT_MAX;
        for(int i=0;i<=n;i++){
            ss1[i].sort(Comparator.comparing(x -> (int)x));
            ss2[n-i].sort(Comparator.comparing(x -> (int)x));
            int p=(int)ss2[n-i].size()-1;
            for(int j=0;j<ss1[i].size();j++){
                while(p>=0&&(ss1[i].get(j)+ss2[n-i].get(p))*2>sum){
                    ans=Math.min(ans,Math.abs((ss1[i].get(j)+ss2[n-i].get(p))*2-sum));
                    p--;
                }
                if(p>=0l) ans=Math.min(ans,Math.abs((ss1[i].get(j)+ss2[n-i].get(p))*2-sum));
            }
        }
        return ans;




    }

    public int compress(char[] chars) {
        int ans = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else {
                ans += count == 1 ? 1 : 2;
                count = 1;
            }
        }
        ans += count == 1? 1:2;
        return ans;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long diff = (long) nums[j] - nums[i];
                maps[j].merge(diff, maps[i].getOrDefault(diff, 0) + 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Long, Integer> map : maps) {
            ans += map.values().stream().mapToInt(x -> x).sum();
        }
        return ans - nums.length * (nums.length-1) /2;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int compress = stockPrice.compress("aabbccc".toCharArray());


        stockPrice.numberOfArithmeticSlices(new int[]{2,2,3,4});
    }


}
