package monserGame;

public class ConsoleWriter {
	
	private StringBuilder printer;
	
	public ConsoleWriter(){
		printer = new StringBuilder();
	}
	
	public void Write(){
		System.out.println(this.printer.toString());
	}

	public void setPrinter(StringBuilder printer) {
		this.printer.append(printer);
	}
	
}
