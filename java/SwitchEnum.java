//Space Box with Enum
import java.util.Scanner;
/*
class SpaceBox
{
	enum SpaceBoxGravity{ VENUS = 0.78, MARS = 0.39, JUPITER = 2.65, SATURN = 1.17, URANUS = 1.05, NEPTUNE = 1.23}

	SpaceBoxGravity gravity;
}
*/
public class EnumGravity
{
	public static void main(String args[])
	{
		//SpaceBox probe = new SpaceBox();
		Scanner keyboard = new Scanner(System.in);
		double venus = 0.78;
		double mars = 0.39;
		double jupiter = 2.65;
		double saturn = 1.17;
		double uranus = 1.05;
		double neptune = 1.23;
		

		System.out.print("Please enter your current earth weight: ");
		double weight = keyboard.nextFloat();

		System.out.print("\n");

		System.out.println("I have information about:\n1.Venus  2.Mars  3.Jupiter\n4.Saturn  5.Uranus  6.Neptune\n");
		System.out.print("Which planet are you choosing? ");
		int planet = keyboard.nextInt();

		switch(planet)
		{
			case 1:
			System.out.println("Your weight will be: "+(weight*venus));
			break;

			case 2:
			System.out.println("Your weight will be: "+(weight*mars));
			break;

			case 3:
			System.out.println("Your weight will be: "+(weight*jupiter));
			break;

			case 4:
			System.out.println("Your weight will be: "+(weight*saturn));
			break;

			case 5:
			System.out.println("Your weight will be: "+(weight*uranus));
			break;

			case 6:
			System.out.println("Your weight will be: "+(weight*neptune));
			break;

			default:
			System.out.print("Error, no value provided!!");
		}

		//probe.gravity = SpaceBox.SpaceBoxGravity.MARS;
		//System.out.println("Your weight will be: "+(weight*mars));
	}
}
