package alex;

public class Symbol {
    public int sym;
    public Object value;
    public Symbol(int sym) {
	this.sym = sym;
    }
    public Symbol(int sym, Object value) {
	this.sym = sym;
	this.value = value;
    }
}
