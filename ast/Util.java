package ast;

import java.util.List;

public class Util {
    public static String prettify(List lst){
        return lst.toString().substring(1, lst.toString().length() - 1);
    } 
}
