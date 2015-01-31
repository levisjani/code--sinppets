public class PithagoraTriple {

	public static void main(String[] args) {
		
		int a,b,c;
		System.out.println("a\tb\tc");
		
		for(a=1; a<=100; a++)
			for(b=1; b<=100; b++)
				for(c=1; c<=100; c++)
					if ((a*a)+(b*b)==(c*c)) {
						System.out.printf("a=%d\tb=%d\tc=%d\n",a,b,c);
					}
	}

}
