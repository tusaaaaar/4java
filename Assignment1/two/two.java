abstract class Bird
{
	void giveEggs()
	{
		System.out.println("lays Eggs");
	}

}

abstract class Flyingones extends Bird
{
	abstract void fly();
}

abstract class NonFlyingones extends Bird
{
	abstract void walk();
}

class Eagle extends Flyingones
{
	void fly()
	{
		System.out.println("Eagle can Fly");
	}

}

class Penguin extends NonFlyingones 
{
	void walk()
	{
		System.out.println("Penguine walk on ground");
	}
}


public class two 
{
	public static void main(String[] args)
	{
		Eagle eagle=new Eagle();
		eagle.giveEggs();
		eagle.fly();
		
		Penguin penguin = new Penguin();
		penguin.giveEggs();
		penguin.walk();
	}
}

