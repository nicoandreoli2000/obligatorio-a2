import java.util.Scanner;
import tads.OpenHashMap;

public class Ejercicio11 {

    static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Coord other = (Coord) o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return x + y * y;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s2 = s.split(" ");
        int m = Integer.parseInt(s2[0]);
        int n = Integer.parseInt(s2[1]);
        int k = in.nextInt();
        String a = in.nextLine();
        int[][] lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = in.nextLine();
            String[] row2 = row.split(" ");
            for (int j = 0; j < row2.length; j++) {
                lab[i][j] = Integer.parseInt(row2[j]);
            }
        }

        int p = in.nextInt();
        String a2 = in.nextLine();


        for (int i = 0; i < p; i++) {
            String coord = in.nextLine();
            String[] coords = coord.split(" ");
            int x1 = Integer.parseInt(coords[0]);
            int y1 = Integer.parseInt(coords[1]);
            Coord org = new Coord(x1 - 1, y1 - 1);
            int x2 = Integer.parseInt(coords[2]);
            int y2 = Integer.parseInt(coords[3]);
            Coord dest = new Coord(x2 - 1, y2 - 1);

            int res = lab(org, dest, lab);

            System.out.println(res);
        }
    }

    private static int lab(Coord org, Coord dest, int[][] lab) {
        int solOpt = Integer.MAX_VALUE;
        int solC = 0; // sol candidata
        solC = agregoCosto(solC, org, lab);
        OpenHashMap<Coord, Coord> setSolC = new OpenHashMap<Coord, Coord>(lab.length * lab[0].length);
        setSolC.insert(org, org);
        int res = labBT(org, dest, lab, solC, setSolC, solOpt);
        return res;
    }

    private static int labBT(Coord org, Coord dest, int[][] lab, int solC, OpenHashMap<Coord, Coord> setSolC,
            int solOpt) {
        if (puedoPodar(solC, solOpt))
            return solOpt;
        if (llegueAlDestido(org, dest)) {
            if (esMejor(solC, solOpt))
                return solC;
            else
                return solOpt;
        }

        int[][] movs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < movs.length; i++) {
            Coord nuevoOri = nuevoOrigen(org, movs[i]);
            if (esPosicionValida(nuevoOri, lab)) {
                if (noVisitado(nuevoOri, setSolC)) {
                    agregamos(nuevoOri, setSolC);
                    solC = agregoCosto(solC, nuevoOri, lab);
                    solOpt = labBT(nuevoOri, dest, lab, solC, setSolC, solOpt);
                    quitamos(nuevoOri, setSolC);
                    solC = quitarCosto(solC, nuevoOri, lab);
                }
            }
        }
        return solOpt;
    }

    private static int quitarCosto(int solC, Ejercicio11.Coord nuevoOri, int[][] lab) {
        solC -= lab[nuevoOri.y][nuevoOri.x];
        return solC;
    }

    private static void quitamos(Coord nuevoOri, OpenHashMap<Coord, Coord> setSolC) {
        setSolC.delete(nuevoOri);
    }

    private static void agregamos(Coord nuevoOri, OpenHashMap<Coord, Coord> setSolC) {
        setSolC.insert(nuevoOri, nuevoOri);
    }

    private static boolean noVisitado(Coord nuevoOri, OpenHashMap<Coord, Coord> setSolC) {
        return !setSolC.contains(nuevoOri);
    }

    private static boolean esPosicionValida(Coord nuevoOri, int[][] lab) {
        return nuevoOri.x >= 0 && nuevoOri.x < lab[0].length &&
                nuevoOri.y >= 0 && nuevoOri.y < lab.length && lab[nuevoOri.y][nuevoOri.x]!=0;
    }

    private static Coord nuevoOrigen(Coord org, int[] is) {
        return new Coord(org.x + is[0], org.y + is[1]);
    }

    private static boolean esMejor(int solC, int solOpt) {
        return solC < solOpt;
    }

    private static boolean llegueAlDestido(Coord org, Coord dest) {
        return org.x == dest.x && org.y == dest.y;
    }

    private static boolean puedoPodar(int solC, int solOpt) {
        return solC > solOpt;
    }

    private static int agregoCosto(int solC, Coord org, int[][] lab) {
        solC += lab[org.y][org.x];
        return solC;
    }

}
