public class TabuleiroService {
    public static Integer CalculaDistancia(Integer x_p1, Integer y_p1, Integer x_p2, Integer y_p2){
        Integer distancia_tabuleiro = (Math.abs(x_p1 - x_p2) + Math.abs(y_p1 - y_p2)) - 1;
        return distancia_tabuleiro;
    }

    public static Integer CalculaDistancia(Integer[] ponto1, Integer[] ponto2){
        Integer distancia_tabuleiro = (Math.abs(ponto1[0] - ponto2[0]) + Math.abs(ponto1[1] - ponto2[1])) - 1;
        return distancia_tabuleiro;
    }
}
