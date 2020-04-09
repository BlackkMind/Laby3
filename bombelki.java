package zad4;

import java.util.Arrays;

public class bombelki implements Sortable {
    private double k = 0;

    @Override
    public int[] sort(int[] tab) {
        int[] jb = Arrays.copyOf(tab, tab.length);
//kopiuję do posortowania aby nie zmieniać oryginału 
        for(int q = 0; q < jb.length; q++) {
            for(int j = 0; j < jb.length - q - 1; j++) {
                k++;
                if(jb[j] > jb[j+1]) {
                    int bi = jb[j];
                    jb[j] =  jb[j+1];
                    jb[j+1] = bi;
                }
            }
        }
        return jb;
    }

    @Override
    public double step_counting() {
        return k;
    }
}
