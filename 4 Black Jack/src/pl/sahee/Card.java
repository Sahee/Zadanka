package pl.sahee;

public class Card {
    
    private int[] CardVal;
    private String tag;

    public Card(String tag, int firstVal, int secondVal) {
        this.tag = tag;
        CardVal = new int[2];
        CardVal[0] = firstVal;
        CardVal[1] = secondVal;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public boolean asChecker() {
        if (tag.contains("as")) {
            return true;
        } else {
            return false;
        }
    }

    public int asVal() {
        if (tag.contains("as")) {
            return CardVal[1];
        } else {
            return CardVal[0];
        }
    }

    public void setFirstVal(int val) {
        CardVal[0] = val;
    }

    public int getFirstVal() {
        if (CardVal != null)
            return CardVal[0];
        else
            return 0;
    }

    public int getSecondVal() {
        if (CardVal != null)
            return CardVal[1];
        else
            return 0;
    }
}
