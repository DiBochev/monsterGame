package monserGame;

public class Writer {
	
	private StringBuilder printer;
	
	Writer(){
		printer = new StringBuilder();
	}
	
	public void ConseleWrter(){
		System.out.println(this.printer.toString());
	}

	public StringBuilder getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer.append(printer);
	}
	
	
}
