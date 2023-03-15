import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class DominoPile {
    ArrayList <Domino> pile;

    public DominoPile() {
        pile = new ArrayList<>();
    }
    public void newStack6(){
        pile.add(new Domino(0,0)); // so that it is not null, and I can use pile.size()-1 below
        for(int i =0; i<=6; i++){
            for (int j=1; j<=6; j++){
                if(!(contains(i,j))){
                    pile.add(new Domino(i, j));
                }
            }
        }
    }
    public boolean contains(int i, int j){ // check if pile already contains the domino being added to
        for(Domino domino:pile){
            if (((domino.getTop() == j)&&(domino.getBottom()==i))||((domino.getTop()==i)&&(domino.getBottom()==j))){
                return true;
            }
        }
        return false;
    }
    public void shuffle(){
        int random_int1;
        int random_int2;
        for (int i =0; i<999; i++){
            random_int1 = (int)Math.floor(Math.random() * (pile.size() ));
            random_int2 = (int)Math.floor(Math.random() * (pile.size() ));
            if(random_int1 != random_int2){
                Domino temp = pile.get(random_int1);
                pile.set(random_int1,pile.get(random_int2));
                pile.set(random_int2,temp);
            }
        }
    }
    public ArrayList<Domino> getPile() {
        return pile;
    }
}
