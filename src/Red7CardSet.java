/**
 * Red7CardSet class
 *
 * @author Hieu Duong
 * @date 3/26/18
 */

public class Red7CardSet {
    Red7Card[] cardset;
    int frontInd;
    int backInd;

    public Red7CardSet(){

        cardset = new Red7Card[7];
        frontInd = 0;
        backInd = 0;
    }

    public Red7Card[] getCardset(){
        return cardset;
    }

    public void add(Red7Card card) {
        if (isFull()) {
            System.out.println("Card set is full, unable to add.");
        } else {
            cardset[backInd] = card;
            backInd++;
            sortCardSet();
        }
    }

    public void remove(Red7Card cardToRemove){

        int indexOfcardToRemove = -1;
        for(int i = 0; i < backInd; i++){
            Red7Card card = cardset[i];
            if(card!=null){
                if(card.getOverallVal() == cardToRemove.getOverallVal()){
                    System.out.println("Index i: "+i);
                    indexOfcardToRemove = i;
                    --backInd;
                }
            }
        }

        if(backInd ==0){
            cardset[0] = null;
            return;
        }

        cardset[indexOfcardToRemove] = null;
        //System.out.println("Back index after: "+backInd);
        if(indexOfcardToRemove>-1){
            for (int i = indexOfcardToRemove; i < backInd; i++) {
                cardset[i] = cardset[i+1];
                cardset[i+1] = null;
            }
        }
    }

    public Red7Card get(int index){
        return cardset[index];
    }

    public void sortCardSet(){
        Red7Card tempCard;
        for(int i=0; i<cardset.length; i++){
            for(int j=i+1; j<cardset.length; j++){
                if(cardset[i]!=null && cardset[j]!=null) {
                    if (cardset[i].getNumber() < cardset[j].getNumber()) {
                        tempCard = cardset[j];
                        cardset[j] = cardset[i];
                        cardset[i] = tempCard;
                    }
                }
            }
        }
    }

    public int compareRule(Red7CardSet rs, String color){
        int value = 0;

        /**
         * Compare Red rule
         */
        if(color.equals("red")){
            if(cardset[0]!=null&& rs.get(0)!=null){
                Red7Card myCard = cardset[0];
                Red7Card opponentCard = rs.get(0);

                value = myCard.compareTo(opponentCard);
            }
        }
        /**
         * Compare Orange Rule
         */
        else if(color.equals("orange")){
            int myMatchingCardCount = 1;
            for(int i=0; i<cardset.length; i+=myMatchingCardCount) {
                for (int j = i + 1; j < cardset.length; j++) {
                    if(get(i)!=null && get(j)!=null) {
                        if (get(i).getNumber() == get(j).getNumber()) {
                            myMatchingCardCount++;
                        }
                    }
                }
            }
            int opponentMatchingCardCount = 1;
            for(int i=0; i<rs.getSize(); i+=opponentMatchingCardCount) {
                for (int j = i + 1; j < rs.getSize(); j++) {
                    if(rs.get(i)!=null && rs.get(j)!=null) {
                        if (rs.get(i).getNumber() == rs.get(j).getNumber()) {
                            opponentMatchingCardCount++;
                        }
                    }
                }
            }

            value = myMatchingCardCount - opponentMatchingCardCount;
            if(value==0){
                value = get(0).compareTo(rs.get(0));
            }
        }
        /**
         * Compare Yellow rule
         */
        else if(color.equals("yellow")){

            int myMatchingColorValue = getMaxValue(this.cardset, this.getSize());
            int opponentMatchingColorValue = getMaxValue(rs.getCardset(), rs.getSize());

            value = myMatchingColorValue - opponentMatchingColorValue;
        }
        /**
         * Compare Green rule
         */
        else if(color.equals("green")){

            int myEvenCardValue = getEvenCardValue(this.cardset, this.getSize());
            int opponentEvenCardValue = getEvenCardValue(rs.getCardset(), rs.getSize());

            value = myEvenCardValue - opponentEvenCardValue;
        }
        /**
         * Compare Blue rule
         */
        else if(color.equals("blue")){

            int myDifferentColorCardsValue = getDifferentColorCardsValue(this.cardset, this.getSize());
            int opponentDifferentColorCardsValue = getDifferentColorCardsValue(rs.getCardset(), rs.getSize());

            value = myDifferentColorCardsValue - opponentDifferentColorCardsValue;
        }
        /**
         * Compare Indigo rule
         */
        else if(color.equals("indigo")){
            int myStraightCards = getStraightCardsValue(this.cardset, this.getSize());
            int opponentStraightCards = getStraightCardsValue(rs.getCardset(), rs.getSize());

            //If neither player has a straight run, get the highest card from each player and compare the value
            if(myStraightCards == 0 && opponentStraightCards == 0){
                myStraightCards = get(0).getOverallVal();
                opponentStraightCards = rs.get(0).getOverallVal();
            }
            value = myStraightCards - opponentStraightCards;
        }
        /**
         * Compare Violet rule
         */
        else if(color.equals("violet")){
            int[] myBelowFourValue = getBelowFourValue(this.cardset, this.getSize());
            int[] opponentBelowFourValue = getBelowFourValue(rs.getCardset(), rs.getSize());

            value = myBelowFourValue[0] - opponentBelowFourValue[0];
            if(value == 0){
                value = myBelowFourValue[1] - opponentBelowFourValue[1];
            }
        }
        return value;
    }

    private int[] getBelowFourValue(Red7Card[] cardSet, int cardsetSize) {
        int[] value = new int[2];

        int totalCardBelowFour = 0;
        int totalBelowFourValue = 0;
        for (int i = 0; i < cardsetSize; i++) {
            if (cardSet[i] != null) {
                if (cardSet[i].getNumber() < 4) {
                    totalCardBelowFour+=1;
                    totalBelowFourValue+=cardSet[i].getOverallVal();
                }
            }
        }
        value[0] = totalCardBelowFour;
        value[1] = totalBelowFourValue;

        return  value;
    }

    private int getStraightCardsValue(Red7Card[] cardSet, int cardsetSize) {
        int firstCardValue = 0;
        int totalValue =0;
        int cardCount =1;
        //Must have more than 1 card in the set to form a straight run
        if(cardsetSize < 2){
            totalValue = 0;
        }
        else {
            for (int i = 0; i < cardsetSize; i += cardCount) {
                if (i == cardsetSize - 1) {
                    break;
                }
                firstCardValue = cardSet[i].getNumber();
                totalValue = cardSet[i].getNumber();

                for (int j = i + 1; j < cardsetSize; j++) {
                    if (cardSet[j] != null) {
                        if (cardSet[j].getNumber() + (j - i) == firstCardValue) {
                            totalValue += cardSet[j].getNumber();
                            cardCount += 1;
                        }
                    }
                }
            }
        }
        //Must have more than 1 card to form a straight run
        if(cardCount == 1){
            totalValue = 0;
        }
        return totalValue;
    }

    private int getDifferentColorCardsValue(Red7Card[] cardSet, int cardsetSize) {
        int[] array = new int[7];
        int differentColorCardsValue = 0;
        for (int i = 0; i < 7; i++) {
            int colorIndex = i + 1;
            int matchingValue = 0;
            for (int j = 0; j < cardsetSize; j++) {
                if (cardSet[j].getColorInd() == colorIndex) {
                    matchingValue = cardSet[j].getOverallVal();
                    break;
                }
            }
            array[i] = matchingValue;
        }

        for (int i = 0; i < array.length; i++) {
            differentColorCardsValue += array[i];
        }
        return differentColorCardsValue;
    }

    private int getEvenCardValue(Red7Card[] cardset, int cardsetSize) {
        int evenCardValue = 0;
        for(int i=0; i<cardsetSize; i++) {
            if((cardset[i].getNumber()%2)==0){
                evenCardValue +=cardset[i].getOverallVal();
            }
        }
        return evenCardValue;
    }

    private int getMaxValue(Red7Card[] cardSet, int cardsetSize) {
        int maxValue = 0;
        int[] array = new int[7];
        for (int i = 0; i < 7; i++) {
            int colorIndex = i + 1;
            int matchingValue = 0;
            for (int j = 0; j < cardsetSize; j++) {
                if(cardSet[j]!=null) {
                    if (cardSet[j].getColorInd() == colorIndex) {
                        matchingValue += cardSet[j].getOverallVal();
                    }
                }
            }
            array[i] = matchingValue;
        }
        maxValue = array[0];
        for(int i=0; i<7; i++){
            if(maxValue<array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public int getSize(){
        return backInd;
    }

    public boolean isFull(){
        return backInd==cardset.length;
    }

    public boolean isEmpty(){
        return backInd == 0;
    }

    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < cardset.length; i++) {

            if (cardset[i] != null) {
                Red7Card card = cardset[i];
                result +=  card.toString()+",";
            }
        }

        //Remove the last comma to make the String looks nice
        if(result.lastIndexOf(",")>-1){
            result = result.substring(0, result.lastIndexOf(","));
        }

        return result;
    }
}
