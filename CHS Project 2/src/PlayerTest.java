public class PlayerTest
{
	public static void main(String [] args)
	{
		RoulettePlayer p = new RoulettePlayer("Herbert", 200.0);
		System.out.println("Player: " + p.toString());
		String name = p.getName();
		double money = p.getMoney();
		System.out.println("Player name: " + name);
		System.out.println("Player money: " + money);
		double change = -50.0;
		while (p.hasMoney())
		{
			p.updateMoney(change);
			System.out.println("Player money is now: " + p.getMoney());
		}
		System.out.println("Player: " + p.toString());
	}
}
