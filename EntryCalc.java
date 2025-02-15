class EntryCalc {
    public static void main(String[] args) {

        if(args.length != 1 && args.length != 4) {
            System.err.println("invalid number of arguments.");
            System.exit(0);
        }

        if(args[0].equals("args")) {
            System.out.println("1. lot size 2. entry price  3. stoploss percentage  4. take profit percentage");
            System.exit(0);
        }
	
	float lotSize = getArgAsFloat(args[0]);
        float entryPrice = getArgAsFloat(args[1]);
        float stopPercent = getArgAsFloat(args[2])/100;
        float takePercent = getArgAsFloat(args[3])/100;

        float stopDifference = entryPrice * stopPercent;
        float takeDifference = entryPrice * takePercent;

        float stopLoss = entryPrice - stopDifference;
        float takeProfit = entryPrice + takeDifference;
        System.out.println("Buy:");
        System.out.println("Stop loss: " + stopLoss);
        System.out.println("Take profit: " + takeProfit);
        System.out.println();

        stopLoss = entryPrice + stopDifference;
        takeProfit = entryPrice - takeDifference;
        System.out.println("Sell:");
        System.out.println("Stop loss: " + stopLoss);
        System.out.println("take profit: " + takeProfit);
        System.out.println();

        System.out.println("potential loss: $" + stopDifference * lotSize);
        float potentialProfit = takeDifference - stopDifference;
        System.out.println("potential profit: $" + potentialProfit * lotSize);
    }

    public static float getArgAsFloat(String arg) {

        float num = 0;
        try {
            num = Float.parseFloat(arg);
        } catch (NumberFormatException e) {
            System.err.println("invalid argument: " + arg);
            System.exit(0);
        }
        return num;
    }
}
