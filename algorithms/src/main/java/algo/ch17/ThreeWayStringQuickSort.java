package algo.ch17;

import algo.util.SortUtils;

public final class ThreeWayStringQuickSort {
    private final String[] array;

    public ThreeWayStringQuickSort(String[] array) {
        this.array = array;
    }

    public String[] sort() {
        this.sort(0, array.length - 1, 0);
        return array;
    }

    private void sort(int low, int high, int d) {
        if(high <= low) {
            return;
        }

        int partChar = charAt(array[low], d);

        int lt = low, gt = high, i = low + 1;
        while(i <= gt) {
            int iChar = charAt(array[i], d);
            if(iChar < partChar) {
                SortUtils.swap(array, lt++, i++);
            } else if(iChar > partChar) {
                SortUtils.swap(array, i, gt--);
            } else {
                i++;
            }
        }

        sort(low, lt - 1, d);
        if(partChar >= 0) {
            sort(lt, gt, d + 1);
        }
        sort(gt + 1, high, d);
    }

    private int charAt(String str, int d) {
        if(d < str.length()) {
            return str.charAt(d);
        }
        return -1;
    }
}
