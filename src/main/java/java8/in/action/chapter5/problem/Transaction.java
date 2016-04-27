package java8.in.action.chapter5.problem;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class Transaction {

    private Trader trader;
    private int tradeYear;
    private int tradeAmount;

    public Transaction(Trader trader, int tradeYear, int tradeAmount) {
        this.trader = trader;
        this.tradeYear = tradeYear;
        this.tradeAmount = tradeAmount;
    }

    public int getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(int tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getTradeYear() {
        return tradeYear;
    }

    public void setTradeYear(int tradeYear) {
        this.tradeYear = tradeYear;
    }
}
