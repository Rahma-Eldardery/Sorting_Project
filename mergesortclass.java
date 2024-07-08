package sort;

import java.util.ArrayList;
/**
 *
 * @author mena_
 */
class MergeSort implements sortable{
    @Override
    public void sort(ArrayList<Integer> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
            ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
            sort(left);
            sort(right);
            merge(list, left, right);
        }
    }


    private void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) > right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

   /* public static void main(String[] args) {
        MergeSort m = new MergeSort();
        ArrayList<Integer>list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(1);
        m.sort(list);
        System.out.println(list);
    }*/
}