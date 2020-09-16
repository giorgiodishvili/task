package ge.george;

import ge.george.murtaza.Action;
import ge.george.murtaza.EnteranceAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.nextUp;

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
//        Scanner scanner = new Scanner(System.in);
//        char[] f = scanner.next().toCharArray();
//        char[] s = scanner.next().toCharArray();
//        boolean addition = false;
//        char[] mas = {'0'};
//        char[] longest = f.length > s.length ? f : s;
//        char[] shortest = f.length <= s.length ? f : s;
//        int diff = longest.length - shortest.length;
//
//        for (int i = shortest.length-1 ; i >= 0; i--) {
//           addition = add(longest,shortest,i+diff,i,addition);
//        }
//        while (addition && diff-->0){
//            addition = add(longest,mas,diff,0,addition);
//        }
//      String result = new String(longest);
//        if(addition){
//            result='1'+result;
//        }
//
//         System.out.println(result);
//    }
//
//    public static boolean add(char[] l, char[] s,int li,int si,boolean add){
//        int a = l[li] - '0';
//        int b = s[si] - '0';
//        int c = a+b;
//        if (add) {
//            c++;
//        }
//        l[li]=(char)((c%10)+'0');
//        return c>=10;
//    }
public class Main {

    public static void main(String[] args) {
        List<Action> list = new ArrayList<>();
        list.add(new Action(100, EnteranceAction.CHECK_IN));
        list.add(new Action(101, EnteranceAction.CHECK_IN));
        list.add(new Action(102, EnteranceAction.CHECK_OUT));
        list.add(new Action(103, EnteranceAction.CHECK_IN));
        list.add(new Action(100, EnteranceAction.CHECK_OUT));
        list.add(new Action(101, EnteranceAction.CHECK_IN));
        list.add(new Action(103, EnteranceAction.CHECK_OUT));
        list.add(new Action(104, EnteranceAction.CHECK_IN));
        System.out.println(list.toString());
        List<Action> list1 = bugDetection(list);
        list1.forEach((n) -> System.out.println(n));


    }

    public static String intrestingNum(long number) {
        long sum = 0L;
        long mult = 1L;
        String s = Long.toString(number);
        for (int i = 0; i < s.length(); i++) {

            sum += s.charAt(i) - '0';
            mult = mult * (s.charAt(i) - '0');
        }
        if (mult < sum) {
            return "TRUE";
        } else {
            return "FALSE";
        }
    }

    public static List<Action> bugDetection(List<Action> listOfMurtazy) {
        List<Action> list = new ArrayList<>();
        Map<Integer, Integer> fix = new HashMap<>();
        if (listOfMurtazy.isEmpty()) {
            return null;
        }
        fix.put(listOfMurtazy.get(0).getRoomNum(), listOfMurtazy.get(0).getAction() == EnteranceAction.CHECK_IN ? 1 : -1);
        for (int i = 1; i < listOfMurtazy.size(); i++) {
            int roomNum = listOfMurtazy.get(i).getRoomNum();
            Integer integer = fix.get(roomNum);
            if (integer == null) integer = 0;
            if (listOfMurtazy.get(i).getAction() == EnteranceAction.CHECK_IN) {
                fix.put(roomNum, integer + 1);
            } else {
                fix.put(roomNum, integer - 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : fix.entrySet()) {
            boolean b = false;
            if (entry.getValue() != 0) {
                b = entry.getValue() > 0;
            } else {
                continue;
            }
            EnteranceAction action = b ? EnteranceAction.CHECK_OUT : EnteranceAction.CHECK_IN;
            list.add(new Action(entry.getKey(), action));
        }
        return list;
    }


}

