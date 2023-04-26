package ast.Accesos;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Declaracion;
import ast.Expresions.Const;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Estructuras.EnumClass;


public class AccesoVar extends Acceso{
    private String direccionInicial;
    private String nombreEnum;

    
    public AccesoVar(String nombreVar){
        this.direccionInicial = nombreVar;
    }

    public String getNombreEnum(){
        return this.nombreEnum;
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(direccionInicial);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento de acceso sin declaracion: " + direccionInicial);
            Programa.okVinculacion = false;
        }
        else
            this.nodoVinculo = nodo;
    }

    public String toString(){
        return direccionInicial;
    }

    @Override
    public void checkType() {
        if(this.nodoVinculo instanceof Declaracion){
            this.tipo = ((Declaracion) nodoVinculo).getTipo();
        }
        else if(this.nodoVinculo instanceof Const){
            this.tipo = ((Const) nodoVinculo).getTipo();

        }
        else {
            boolean ok = false;
            for(ASTNode nodo: Programa.definiciones.getEnumList() ){
              
                    for(Const c: ((EnumClass)nodo).getCampos()){

                        if (c.getValor().equals(direccionInicial)){
                            ok = true;
                            nombreEnum = ((EnumClass)nodo).getName();
                            this.tipo = new BasicTypes(KindTypes.ENUM);
                            break;
                            
                        }
                        
                    }
                   
                    if(ok) break;

                    
                    
            }
            if(!ok){
                System.out.println("Error tipos: acceso a variable  " + direccionInicial);
                Programa.okTipos = false;
            }
        }
    
    }
}
