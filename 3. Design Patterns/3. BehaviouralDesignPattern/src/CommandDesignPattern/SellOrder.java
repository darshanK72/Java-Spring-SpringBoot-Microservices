package CommandDesignPattern;

public class SellOrder implements Order{
	
	private Stock stock;
	
	public SellOrder(Stock stock)
	{
		this.stock = stock;
	}

	@Override
	public void execute() {
		this.stock.sellStock();
	}

}
