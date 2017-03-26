public class Main {

    public static void main(String[] args)
    {
	    Input input=new Input("input.txt");
	    String text=input.readText();
	    MultiPrime enc=new MultiPrime();
	    enc.doEncryption();

    }
}
