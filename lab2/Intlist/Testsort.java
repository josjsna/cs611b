import org.junit.Test;
import static org.junit.Assert.*;
public class Testsort {




  @Test
    public void Testfindsmallest() {

        String[] input2={"there","are","many","pigs"};
        int output2=2;
                ;
        int actual2=Sort.findsmallest(input2,2);
        assertEquals(actual2,output2);
    }
    @Test
    public  void testswap(){
        String[] input={"i","have","an","egg"};
        int a=0;
        int b=2;
        String[] expected={"an","have","i","egg"};
        Sort.swap(input,a,b);
        assertEquals(expected,input);
    }
    @Test
    public  void testsort(){
        String[] input={"i","have","an","egg"};
        String[] expected={"an","egg","have","i"};
        Sort.Sort(input);
        assertEquals(expected,input);
    }




    }

