package dsa.qs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static HashSet<String> ans = new HashSet<>();

    public static void main(String[] args) {
        int [] A= {-1,5,2,1,3,1};
        int B= 7;
        foursum(A,B);
        for(String val : ans) {
            System.out.println(val);
        }
    }
    /*
    private static void foursum(int[] a, int b) {
     //   HashMap<Integer,Integer> mp = new HashMap<>();
       int n= a.length;
       if(n<3) return;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        int sum=0;
                        sum=a[i]+a[j]+a[k]+a[l];
                        if(sum==b) {
                            String st = a[i] + " " + a[j] + " " + a[k] + " " + a[l];
                            ans.add(st);
                        }
                    }
                }
            }
        }
    }*/

/*
    private static void foursum(int[] a, int b) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n= a.length;
        for(int val :a)
            hm.put(val,hm.getOrDefault(val,0)+1);
        //-1,5,2,1,3,1
        // i j k
       for(int i=0;i<n;i++){
           hm.put(a[i],hm.get(a[i])-1);
           for(int j=i+1;j<n;j++){
               hm.put(a[i],hm.get(a[i])-1);
               for(int k=j+1;k<n;k++){
                   hm.put(a[i],hm.get(a[i])-1);
                   int element = b-a[i]-a[j]-a[k];
                   if(hm.containsKey(element) && hm.get(element)>0){
                       String st = a[i] + " " + a[j] + " " + a[k] + " " + element;
                       ans.add(st);
                   }
                   hm.put(a[k],hm.get(a[k])+1);
               }
               hm.put(a[j],hm.get(a[j])+1);
           }
           hm.put(a[i],hm.get(a[i])+1);
       }
    }
    */
private static void foursum(int[] a, int b) {
        Arrays.sort(a);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = a[i] + a[j] + a[l] + a[r];
                    if (sum == b) {
                        String st = a[i] + " " + a[j] + " " + a[l] + " " + a[r];
                        ans.add(st);
                        l++;
                        r--;
                    } else if (sum < b) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

}

}
