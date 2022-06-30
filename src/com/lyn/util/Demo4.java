import com.lyn.util.AboutList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Demo4 {

    public static void main(String[] args) {


    }

    public int Sort(int[] arr) {
        int result=0;

        if (arr.length<3){
            return result;
        }

        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        arrayList.sort(Comparator.naturalOrder());
        result=arrayList.size()-2;

        return result;
    }
}
