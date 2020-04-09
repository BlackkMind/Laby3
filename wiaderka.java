package zad4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class wiaderka implements Sortable {
    private double k= 0;

    private void sortBucket(List<Integer> wiadraa) {

        for(int q = 0; q < wiadraa.size(); q++) {
            for(int w = 0; w< wiadraa.size() - q - 1; w++) {
                k++;
                if(wiadraa.get(w) > wiadraa.get(w+1)) {
                    int il = wiadraa.get(w);
                    wiadraa.set(w, wiadraa.get(w+1));
                    wiadraa.set(w+1, il);
                }
            }
        }
    }

    @Override
    public int[] sort(int[] tab) {
        int ilwiad = 5; // jakas liczba kubełków im więcej tym mniej potównań 
        int[] jb = Arrays.copyOf(tab, tab.length);
        int max = jb[0];

        for(int q = 0; q < jb.length; q++) { 
            if(max < jb[q]) {
                max = jb[q];
            }// szukanie max wartości w tablicy 
        }
        int podzi = max/ilwiad + 1;

        List<Integer>[] wiaderka = new List[ilwiad];

        for(int q = 0; q < ilwiad; q++){
            wiaderka[q] = new LinkedList<>();
        }

        for(int num : jb){
            wiaderka[num / podzi].add(num);
        }

        for(List<Integer> wiadro : wiaderka){
            sortBucket(wiadro);
        }
        int q = 0;
        for(List<Integer> wiadro : wiaderka){
            for(int t : wiadro){
                jb[q++] = t;
            }
        }
/* jako że nie wiemy jakie liczby będą a będziemy musieli je poukładać w kubełkach 
to bierzemy maksymalną liczbę z tablicy i dzielimy ją przez iloszcz kubelków +1 aby móc wyliczyć indeks do którego kubełka ma trafić dana liczba */
        return jb;
    }

    @Override
    public double step_counting() {
        return k;
    }
}
