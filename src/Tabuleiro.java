import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tabuleiro {
    public Tabuleiro(Integer altura, Integer largura) {
        Largura = largura;
        Altura = altura;
        Mapa = new ArrayList<ArrayList<ExisteParaTabuleiro>>();

        for (Integer y = 0; y < Altura; y ++) {
            Mapa.add(y, new ArrayList<ExisteParaTabuleiro>(Arrays.asList(new ExisteParaTabuleiro[Largura]) ) );

        }
    }

    private Integer Altura;
    private Integer Largura;
    public static Integer TamanhoPadraoCelula = 2;

    public List<ArrayList<ExisteParaTabuleiro>> Mapa;

    public void AdicionaAoTabuleiro(ExisteParaTabuleiro b, Integer x, Integer y){
        try{
            Mapa.get(y).set(x,b);
        } catch (IndexOutOfBoundsException n){
            System.out.println("Fora do tabuleiro");
        }

    }
    public Integer[] ProcuraId(ExisteParaTabuleiro pp){
        var saida = new Integer[2];
        Integer index_y = null;
        Integer index_x = null;

        var b = Mapa.stream()
                    .map(arr -> arr.stream()
                                    .filter(v -> v != null)
                                    .filter(v -> v.getId() == pp.getId()).toList()
                        )
                    .toList();

        for (List arr: b){ if (!arr.isEmpty()) { index_y = b.indexOf(arr);}}
        if (index_y != null){
            index_x = Mapa.get(index_y).indexOf(pp);


        }
        saida[0] = index_x;
        saida[1] = index_y;
        if (saida[0] == null | saida[1] == null){
            return null;
        }
        return saida;


    }

    @Override
    public String toString() {
        var saida = new String();
        for (ArrayList<ExisteParaTabuleiro> arl: Mapa) {
            for (ExisteParaTabuleiro s: arl){
                if (s == null){ saida += "___ "; continue;}
                saida += s.getNome() + " ";
            }
            saida += "\n";
        }
        
        return saida;
    }
}
