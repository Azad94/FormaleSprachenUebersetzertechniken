package visitor;

import ast.*;

public class IndependentToStringVisitor {
	public void print(HeteroAST n) {
        switch ( n.getToken().getType()) {
            case 2 : print((AddNode)n); break;
            case 3 : print((MinusNode)n); break;
            case 4 : print((MultiNode)n); break;
            case 5 : print((DivNode)n); break;
            case 8 : print((IntNode)n); break;
            case 12: print((UMinusNode)n); break;
            default :
                // catch unhandled node types
                throw new UnsupportedOperationException("Node "+
                          n.getClass().getName()+ " not handled");
        }
    }

    public void print(AddNode n) {
    	System.out.print("( + ");
        print(n.getLeft());         
        print(n.getRight());        
        System.out.print(") ");
    }

    public void print(MinusNode n) {
    	System.out.print("( - ");
        print(n.getLeft());         
        print(n.getRight());        
        System.out.print(") ");
    }
	
    public void print(MultiNode n) {
        System.out.print("( * ");
        print(n.getLeft());
        print(n.getRight());
        System.out.print(") ");
    }
	
    public void print(DivNode n) {
        System.out.print("( / ");
        print(n.getLeft());
        print(n.getRight());
        System.out.print(") "); 
    }
	
    public void print(IntNode n) {
        System.out.print(" " + n.toString() + " ");
    }

}
