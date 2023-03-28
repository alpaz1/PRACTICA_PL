package ast;

public class Declaration extends Instruction {

    private KindInstruction tipoIns;
    private KindTypes tipoVar;
    private String iden;

    public Declaration(KindInstruction tipoIns){
        this.tipoIns = tipoIns;
        //this.tipoVar = tipoVar;
    }

    public KindInstruction kind() {return tipoIns;}
    public KindTypes kindVar() {return tipoVar;}

    public String toString() {return tipoIns.toString() ;}//+ "(" + tipoVar.toString();}
 }
