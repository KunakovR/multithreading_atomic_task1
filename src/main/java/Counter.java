public class Counter {

    private static int countForThree = 0;
    private static int countForFour = 0;
    private static int countForFive = 0;

    public void setCount(int count) {
        switch (count) {
            case 3: ++countForThree;
                break;
            case 4: ++countForFour;
                break;
            case 5: ++countForFive;
                break;
        }
    }

    public int getCount(int count) {
        if (count == 3) {
            return countForThree;
        }
        if (count == 4) {
            return countForFour;
        }
        if (count == 5) {
            return countForFive;
        }
        return 0;
    }
}
