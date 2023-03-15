public class Domino {
    int top;
    int bottom;
    public Domino() {
        top = 0;
        bottom = 0;
    }
    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }
    public String toString (){
        return top+"/"+bottom;
    }
    public void flip(){
        int temp = top;
        top = bottom;
        bottom = temp;
    }
    public void settle(){
        if (top>bottom){
            flip();
        }
    }
    public int compareTo(Domino other){
        settle();
        other.settle();
        if (top < other.getTop())
            return -1;
        if (top > other.getTop())
            return 1;
        else{ // top == otherTop
            if(bottom < other.getBottom())
                return -1;
            if(bottom > other.getBottom())
                return 1;
            else
                return 0;
        }
    }
    public int compareToWeight(Domino other){
        settle();
        other.settle();
        int total = top+bottom;
        int otherTotal = other.getTop()+other.getBottom();
        if (total < otherTotal)
            return -1;
        if (total > otherTotal)
            return 1;
        else{ // total == other total
                return 0;
        }
    }

    public boolean canConnect(Domino other){
        settle();
        other.settle();
        if(top == other.getTop())
            return true;
        if(top == other.getBottom())
            return true;
        if(bottom == other.getTop())
            return true;
        if(bottom == other.getBottom())
            return true;
        return false;
    }
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
