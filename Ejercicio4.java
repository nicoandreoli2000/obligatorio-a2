import java.util.Arrays;
import java.util.Scanner;

import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        Grafo<Integer> g = convertFromText();
        ejercicio4(g, 1);
    }

    // no dirigido-> tengo que agregar ambos sentidos de la arista
    public static Grafo<Integer> convertFromText() {
        Grafo<Integer> g = new Grafo<Integer>();
        Scanner in = new Scanner(System.in);
        Integer v = Integer.parseInt(in.nextLine());
        g.setExpectedSize(v);
        for (int i = 0; i < v; i++) {
            g.add(i + 1);
        }
        Integer e = Integer.parseInt(in.nextLine());
        for (int i = 0; i < e; i++) {
            String[] l = in.nextLine().split(" ");
            Integer[] linea = new Integer[l.length];
            for (int j = 0; j < l.length; j++) {
                linea[j] = Integer.parseInt(l[j]);
            }
            if (linea.length == 3) {
                Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(linea[1], linea[2]);
                Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(linea[0], linea[2]);
                g.add(linea[0], p1);
                g.add(linea[1], p2);
            } else {
                Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(linea[1], 1);
                Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(linea[0], 1);
                g.add(linea[0], p1);
                g.add(linea[1], p2);
            }
        }
        return g;
    }

    public static void ejercicio4(Grafo<Integer> g, Integer vertice) {

        Boolean[] visitados = new Boolean[g.getSize()];
        Boolean[] pase = new Boolean[g.getSize()];
        Arrays.fill(visitados, false);
        Arrays.fill(pase, false);
        visitados[vertice-1]=true;
        boolean entro2= false;
        boolean termino = false;
        Integer conexos = 1;
        Integer aux = -1;
        for (int h = 0; h < visitados.length&&!termino; h++) {
            if(entro2){
                h=aux;
                entro2=false;
                visitados[h] = true;
            }
            Boolean entro = false;
            for (int i = 0; i < visitados.length&&!entro; i++) {
                Boolean[] copiaV = createCopy(visitados);
                for (int j = 0; j < visitados.length; j++) {
                    if(visitados[j] && !pase[j]){
                        Object[] adys = g.getAdys(j+1);
                        pase[j]=true;
                        if(adys!=null){
                            for (int k = 0; k < adys.length&&adys[k]!=null; k++) {
                                Pair<Integer, Integer> pair = (Pair<Integer, Integer>) adys[k];
                                visitados[pair.fst()-1]=true;
                            }
                        }
                        
                    }
                }
                if(Arrays.equals(visitados, copiaV)){
                    entro = true;                   //lo uso para saber si el array fue modificado,
                }                                   // sirve para ver si empezaria a repetir vertices
            }
            for (int u = 0; u < visitados.length&&!entro2; u++) {
                if(visitados[u]==false){
                    aux=u;
                    conexos++;
                    entro2=true;    //lo uso para ver si entro en este for, si es asi guardo 
                }                   //con que valor entro para usarlo luego
            }
            if(allTrue(visitados)){
                termino = true;
            }
        }
        
        System.out.println(conexos);
    }

    private static boolean allTrue(Boolean[] visitados) {
        boolean b = true;
        for (int i = 0; i < visitados.length; i++) {
            b = b && visitados[i];
        }
        return b;
    }

    //crea una copia del array que no comparte memoria con el original
    private static Boolean[] createCopy(Boolean[] visitados) {
        Boolean[] copy = new Boolean[visitados.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = visitados[i];
        }
        return copy;
    }

   
}
