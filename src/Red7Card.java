/**
 * Red7Card class
 *
 * @author Hieu Duong
 * @date 3/24/18
 */

public class Red7Card implements R7Comparable {
    private int number;
    private String color;

    public Red7Card(String clr, int num) {
        this.number = num;
        this.color = clr;
    }

    public int getNumber(){
        return number;
    }
    public int getColorInd(){
        return R7Comparable.getColorId(color);
    }

    public String getColor() {
        return color;
    }

    public int getOverallVal(){
        return getColorInd()+getNumber()*7;
    }

    @Override
    public int compareTo(R7Comparable o) {
        return getOverallVal()-o.getOverallVal();
    }

    @Override
    public String toString() {
        return number+""+color;
    }
}
