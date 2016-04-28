package common.vo;

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

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Transaction that = (Transaction) o;

		if (tradeYear != that.tradeYear)
			return false;
		if (tradeAmount != that.tradeAmount)
			return false;
		return trader != null ? trader.equals(that.trader) : that.trader == null;

	}

	@Override public int hashCode() {
		int result = trader != null ? trader.hashCode() : 0;
		result = 31 * result + tradeYear;
		result = 31 * result + tradeAmount;
		return result;
	}

	@Override public String toString() {
		return "Transaction{" +
				"trader=" + trader +
				", tradeYear=" + tradeYear +
				", tradeAmount=" + tradeAmount +
				'}';
	}
}
