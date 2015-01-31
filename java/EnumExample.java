public class EnumExample {
 
	public enum Company {
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
		private int value;
 
		private Company(int value) {
			this.value = value;
		}
	}
 
	public static void main(String[] args) {
		for (Company cName : Company.values()) {
			System.out.println("Company Value: " + cName.value + " - Comapny Name: " + cName);
		}
	}
}
