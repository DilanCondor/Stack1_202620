import java.util.Stack;

public class Pila {
    private Stack<Post> objPila;

    public Pila(){
        objPila=new Stack<>();

    }
    public void push(Post dato){
        objPila.push(dato);
    }

    public  Post pop ()throws Exception{
        if(objPila.isEmpty())
            throw new Exception("Pila sin elementos");
        return objPila.pop();
    }

    public Post peek () throws Exception {
        if (objPila.isEmpty())
            throw new Exception("No hay elementos en la pila");
        return objPila.peek();
    }

    public String showAll (){
        String resultado="";
        for (int i=objPila.size()-1; i>=0 ; i--){
            resultado+=objPila.get(i).toString();
        }
        return resultado.length() !=0?resultado:"No existen elementos";
    }
}
