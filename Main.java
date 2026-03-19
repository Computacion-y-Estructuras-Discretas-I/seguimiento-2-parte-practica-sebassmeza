import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt(), nb = sc.nextInt(), k = sc.nextInt();

        int[] servidorA = new int[na];
        for (int i = 0; i < na; i++) servidorA[i] = sc.nextInt();

        int[] servidorB = new int[nb];
        for (int i = 0; i < nb; i++) servidorB[i] = sc.nextInt();

        int[] baneados = new int[k];
        for (int i = 0; i < k; i++) baneados[i] = sc.nextInt();

        sc.close();

        TreeSet<Integer> activos = jugadoresActivos(servidorA, servidorB, baneados);

        System.out.println(activos.size());
        StringBuilder sb = new StringBuilder();
        for (int id : activos) sb.append(id).append(' ');
        System.out.println(sb.toString().trim());
    }


    public static TreeSet<Integer> jugadoresActivos(int[] servidorA,
                                                    int[] servidorB,
                                                    int[] baneados) {
        TreeSet<Integer> activos = new TreeSet<>();
        HashSet<Integer> banSet = new HashSet<>();
        {


            for (int b : baneados) {
                banSet.add(b);
            }


            for (int a : servidorA) {
                if (!banSet.contains(a)) {
                    activos.add(a);
                }
            }


            for (int b : servidorB) {
                if (!banSet.contains(b)) {
                    activos.add(b);
                }
            }

            return activos;
        }

    }
}