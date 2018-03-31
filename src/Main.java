import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Main class
 *
 * @author Hieu Duong
 * @date 3/26/18
 */

public class Main {
    public static void main(String[] args){

        /*
        Red7Card r1 = new Red7Card("Yellow", 7);
        Red7Card r2 = new Red7Card("Orange", 3);

        System.out.println("Compare r1 and r2: "+r1.compareTo(r2));

        Red7CardSet r7h = new Red7CardSet();
        r7h.add(new Red7Card("Yellow",7));

        Red7CardSet r7h2 = new Red7CardSet();
        r7h2.add(new Red7Card("Orange",3));
        r7h2.add(new Red7Card("Violet",5));


        Red7CardSet r7h3 = new Red7CardSet();
        r7h3.add(new Red7Card("Indigo",6));
        r7h3.add(new Red7Card("Indigo",2));


        Red7CardSet r7h4 = new Red7CardSet();
        r7h4.add(new Red7Card("Yellow",6));
        r7h4.add(new Red7Card("Yellow",4));

        Red7CardSet r7h5 = new Red7CardSet();
        r7h5.add(new Red7Card("Green",6));
        r7h5.add(new Red7Card("Green",5));

        System.out.println("Hand 1: " +r7h);
        System.out.println("Hand 2: " +r7h2);

*/
        Red7CardSet r7h6 = new Red7CardSet();
        r7h6.add(new Red7Card("Green",6));
        r7h6.add(new Red7Card("Green",5));
        r7h6.add(new Red7Card("Green",2));
        r7h6.add(new Red7Card("Green",1));
        r7h6.add(new Red7Card("Green",4));
        r7h6.add(new Red7Card("Green",7));

        System.out.println(r7h6);


        r7h6.remove(new Red7Card("Green",7));
        r7h6.remove(new Red7Card("Green",5));
        r7h6.remove(new Red7Card("Green",2));
        r7h6.remove(new Red7Card("Green",1));
        r7h6.remove(new Red7Card("Green",4));
        r7h6.remove(new Red7Card("Green",6));

        r7h6.add(new Red7Card("Green",1));
        r7h6.add(new Red7Card("Green",4));
        r7h6.add(new Red7Card("Green",7));
        r7h6.remove(new Red7Card("Green",4));
        System.out.println(r7h6);

/*
        boolean rc1 = r7h.compareRule(r7h2,"red") > 0;
        boolean rc2 = r7h2.compareRule(r7h,"red") < 0;
        System.out.println("Red - Should be true: " + rc1);
        System.out.println("Red - Should be true: " + rc2);


        boolean oc1 = r7h.compareRule(r7h2,"orange") > 0;
        boolean oc2 = r7h2.compareRule(r7h,"orange") < 0;
        boolean oc3 = r7h2.compareRule(r7h3,"orange") < 0;
        System.out.println("Orange - Should be true: " + oc1);
        System.out.println("Orange - Should be true: " + oc2);
        System.out.println("Orange - Should be true: " + oc3);

        boolean yc1 = r7h.compareRule(r7h2,"yellow") > 0;
        boolean yc2 = r7h2.compareRule(r7h,"yellow") < 0;
        boolean yc3 = r7h2.compareRule(r7h3,"yellow") < 0;
        System.out.println("Yellow - Should be true: " + yc1);
        System.out.println("Yellow - Should be true: " + yc2);
        System.out.println("Yellow - Should be true: " + yc3);


        boolean gc1 = r7h.compareRule(r7h3,"green") < 0;
        boolean gc2 = r7h3.compareRule(r7h,"green") > 0;
        boolean gc3 = r7h2.compareRule(r7h,"green") == 0;
        boolean gc4 = r7h4.compareRule(r7h3,"green") > 0;
        System.out.println("Green - Should be true: " + gc1);
        System.out.println("Green - Should be true: " + gc2);
        System.out.println("Green - Should be true: " + gc3);
        System.out.println("Green - Should be true: " + gc4);

        boolean bc1 = r7h.compareRule(r7h3,"blue") > 0;
        boolean bc2 = r7h3.compareRule(r7h,"blue") < 0;
        boolean bc3 = r7h2.compareRule(r7h,"blue") > 0;
        System.out.println("Blue - Should be true: " + bc1);
        System.out.println("Blue - Should be true: " + bc2);
        System.out.println("Blue - Should be true: " + bc3);

        boolean ic1 = r7h.compareRule(r7h2,"indigo") > 0;
        boolean ic2 = r7h2.compareRule(r7h,"indigo") < 0;
        boolean ic3 = r7h5.compareRule(r7h,"indigo") > 0;
        System.out.println("Indigo - Should be true: " + ic1);
        System.out.println("Indigo - Should be true: " + ic2);
        System.out.println("Indigo - Should be true: " + ic3);

        boolean vc1 = r7h.compareRule(r7h4,"violet") == 0;
        boolean vc2 = r7h2.compareRule(r7h3,"violet") > 0;
        boolean vc3 = r7h3.compareRule(r7h2,"violet") < 0;
        boolean vc4 = r7h.compareRule(r7h2,"violet") < 0;
        System.out.println("Violet - Should be true: " + vc1);
        System.out.println("Violet - Should be true: " + vc2);
        System.out.println("Violet - Should be true: " + vc3);
        System.out.println("Violet - Should be true: " + vc4);


        /*
        int totalCardBelowFour = 0;
        int totalBelowFourValue = 0;
        for (int i = 0; i < r7h2.getSize(); i++) {
            if (r7h2.get(i) != null) {
                if (r7h2.get(i).getNumber() < 4) {
                    totalCardBelowFour+=1;
                    totalBelowFourValue+=r7h2.get(i).getOverallVal();
                }
            }
        }

        System.out.println("Total card below 4: "+totalCardBelowFour +", total value: "+totalBelowFourValue);
        /*
        int firstCardValue = 0;
        int totalValue =0;
        int cardCount =1;

        for(int i=0; i<r7h5.getSize(); i+=cardCount) {

            if(i==r7h5.getSize()-1){
                break;
            }
            firstCardValue = r7h5.get(i).getNumber();
            totalValue = r7h5.get(i).getNumber();

            for (int j = i + 1; j < r7h5.getSize(); j++) {
                if (r7h5.get(j) != null) {
                    if (r7h5.get(j).getNumber() + (j - i) == firstCardValue) {
                        totalValue += r7h5.get(j).getNumber();
                        cardCount += 1;
                    }
                }
            }

        }

        System.out.println("Total value: "+totalValue);
        System.out.println("Total card count: "+cardCount);

/*
        int[] array1 = new int[7];
        for (int i = 0; i < 7; i++) {
            int colorIndex = i + 1;
            int matchingValue = 0;
            for (int j = 0; j < r7h.getSize(); j++) {
                if (r7h.get(j).getColorInd() == colorIndex) {
                    System.out.println("Color index: "+r7h.get(j).getColorInd() );
                    matchingValue = r7h.get(j).getOverallVal();
                    break;
                }
            }
            array1[i] = matchingValue;
        }

        int differentColorCount = 0;
        for (int i = 0; i < array1.length; i++) {
            differentColorCount += array1[i];
        }
        System.out.println("Matching Color Count: " + differentColorCount);

        String value = "";
        for(int i=0; i<array1.length; i++){
            value +=array1[i]+" ";
        }
        System.out.println(value);

        /*
        int evenCardValue = 0;
        for(int i=0; i<r7h3.getSize(); i++) {
           if((r7h3.get(i).getNumber()%2)==0){
               evenCardValue +=r7h3.get(i).getOverallVal();
           }
        }

        System.out.println("Even card value: "+evenCardValue);


        /*
        int[] array = {1,2,7,2,2};

        int count = 1;
        for(int i=0; i<array.length; i+=count) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
        }
/*
        System.out.println("Something");



            int[] array1 = new int[7];
            for (int i = 0; i < 7; i++) {
                int colorIndex = i + 1;
                int matchingValue = 0;
                for (int j = 0; j < r7h3.getSize(); j++) {
                    if (r7h3.get(j).getColorInd() == colorIndex) {
                        matchingValue += r7h3.get(j).getOverallVal();
                        System.out.println("Matching value: " + matchingValue);
                    }
                }
                array1[i] = matchingValue;
            }

            String value1 = "";
            for (int i = 0; i < array1.length; i++) {
                value1 += array1[i] + " ";
            }
            System.out.println("New array: " + value1);
        int maxvalue = array1[0];
        for(int i=0; i<7; i++){
            if(maxvalue<array1[i]){
                maxvalue = array1[i];
            }
        }

        System.out.println("Max value "+maxvalue);
/*
        int opponentMatchingCardCount = 1;
        int value = 0;
        for(int i=0; i<r7h3.getSize(); i+=opponentMatchingCardCount) {
            for (int j = i + 1; j < r7h3.getSize(); j++) {
                if(r7h3.get(i)!=null && r7h3.get(j)!=null) {
                    if (r7h3.get(i).getColorInd() == r7h3.get(j).getColorInd()) {
                        opponentMatchingCardCount++;
                        value+=r7h3.get(i).getNumber()+r7h3.get(j).getNumber();
                    }
                }
            }
        }

        System.out.println("Opponent card match count: " + opponentMatchingCardCount);
        System.out.println("value: "+value);
*/

/*
        int temp;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }


        String value = "";
        for(int i=0; i<array.length; i++){
            value +=array[i]+" ";
        }
        System.out.println(value);

        */
    }
}
