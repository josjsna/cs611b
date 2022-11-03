public class Sort {
    public static void Sort(String[] s) {
        //find the smallest
        // swap with the first
        //sort (recursion）
        Sort(s,0);


    }private static void Sort(String[] s, int start){
        if(start==s.length){
            return;
        }
        int smallestIndex=findsmallest(s,start);
         swap(s,start,smallestIndex);
         Sort(s,start+1);


        }
    public static int findsmallest(String[] s, int start){
        int smallestIndex=start;
        for (int i = start; i < s.length; i++) {
            int cmp=s[i].compareTo(s[smallestIndex]);
            if(cmp <0){
                smallestIndex=i;
            }
        }return smallestIndex;
    }public static void swap(String[] s,int a,int b){
        String temp=s[a];
        s[a]=s[b];
        s[b]=temp;

    }
}
