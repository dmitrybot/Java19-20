import java.util.*;

public class Main {
    static Map<Integer, String> letters = new HashMap<>();
    static int[] mas = new int[] {0, 0, 0, 0, 0, 0, 1};
    static int[] masLimits = new int[] {12, 10, 10, 10, 12, 12, 200};
    public static String genNumber(){
        int j = 0;
        while (j < 7 && mas[j] == masLimits[j]) {
            mas[j] = 0;
            j++;
        }
        if (j == 7) return null;
        String ret = letters.get(mas[0]) + mas[1] + mas[2] + mas[3] + letters.get(mas[4]) + letters.get(mas[5]);
        if (mas[5] < 10) ret += "0" + mas[5];
        else ret += mas[5];
        mas[j]++;
        return ret;
    }

    public static void main(String[] args) {
        letters.put(0, "А");
        letters.put(1, "В");
        letters.put(2, "Е");
        letters.put(3, "К");
        letters.put(4, "М");
        letters.put(5, "Н");
        letters.put(6, "О");
        letters.put(7, "Р");
        letters.put(8, "С");
        letters.put(9, "Т");
        letters.put(10, "У");
        letters.put(11, "Х");
        for (int i = 0; i < 1; i++){
            System.out.println(genNumber());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 100000; i++){
            int k = (int)((Math.random() * ((200000 - 0) + 1)) + 0);
            arrayList.add(k);
            treeSet.add(k);
            hashSet.add(k);
        }
        System.out.println(arrayList);

        Scanner in = new Scanner(System.in);
        boolean t;
        long beginTime, elapsedTime;
        int k1 = in.nextInt(), tt;
        beginTime = System.nanoTime();
        t = arrayList.contains(k1);
        elapsedTime = System.nanoTime() - beginTime;
        if (t) System.out.println("Поиск перебором: номер найден, поиск занял " + elapsedTime + "нс");
        else System.out.println("Поиск перебором: номер не найден, поиск занял " + elapsedTime +"нс");
        Collections.sort(arrayList);
        beginTime = System.nanoTime();
        tt = Collections.binarySearch(arrayList, k1);
        elapsedTime = System.nanoTime() - beginTime;
        if (tt >=0) System.out.println("Поиск binarySearch: номер найден, поиск занял " + elapsedTime + "нс");
        else System.out.println("Поиск binarySearch: номер не найден, поиск занял " + elapsedTime +"нс");
        beginTime = System.nanoTime();
        t = treeSet.contains(k1);
        elapsedTime = System.nanoTime() - beginTime;
        if (t) System.out.println("Поиск treeSet: номер найден, поиск занял " + elapsedTime + "нс");
        else System.out.println("Поиск treeSet: номер не найден, поиск занял " + elapsedTime +"нс");
        beginTime = System.nanoTime();
        t = hashSet.contains(k1);
        elapsedTime = System.nanoTime() - beginTime;
        if (t) System.out.println("Поиск hashSet: номер найден, поиск занял " + elapsedTime + "нс");
        else System.out.println("Поиск hashSet: номер не найден, поиск занял " + elapsedTime +"нс");

    }
}
