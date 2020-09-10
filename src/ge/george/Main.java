package ge.george;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[scanner.nextInt() + 1];
//        int elementCount = scanner.nextInt();
//        Set<Integer> st = new HashSet<>();
//        for (int i = 0; i < elementCount; i++) {
//            int a = scanner.nextInt();
//            if (!st.add(a)) {
//                arr[a]++;
//            }
//            if (st.size() == arr.length - 1) {
//                st = new HashSet<>();
//                for (int j = 1; j < arr.length; j++) {
//                    if (arr[j] != 0) {
//                        st.add(j);
//                        arr[j]--;
//                    }
//                }
//                System.out.print('1');
//            } else {
//                System.out.print('0');
//            }
//        }
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        char[] f = scanner.next().toCharArray();
        char[] s = scanner.next().toCharArray();
        boolean addition = false;
        char[] mas = {'0'};
        char[] longest = f.length > s.length ? f : s;
        char[] shortest = f.length <= s.length ? f : s;
        int diff = longest.length - shortest.length;

        for (int i = shortest.length-1 ; i >= 0; i--) {
           addition = add(longest,shortest,i+diff,i,addition);
        }
        while (addition && diff-->0){
            addition = add(longest,mas,diff,0,addition);
        }
      String result = new String(longest);
        if(addition){
            result='1'+result;
        }

         System.out.println(result);
    }

    public static boolean add(char[] l, char[] s,int li,int si,boolean add){
        int a = l[li] - '0';
        int b = s[si] - '0';
        int c = a+b;
        if (add) {
            c++;
        }
        l[li]=(char)((c%10)+'0');
        return c>=10;
    }


}
