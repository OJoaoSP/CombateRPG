public class Main {
    public static void main(String[] args) {
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("p2", TipoAtaqueEnum.LongoAlcance);

        var tb = new Tabuleiro(10, 10);
        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);
        System.out.println(tb);

        p1.Machuchar(p2, 4,tb);

        var b = TabuleiroService.CalculaDistancia(tb.ProcuraId(p1), tb.ProcuraId(p2)) * tb.TamanhoPadraoCelula;
        System.out.println(b);
        //TesteLevel(p1,p2);
    }

    public static void TesteLevel(Personagem p1, Personagem p2){
        System.out.println(p1);
        System.out.println(p2);
        var tb = new Tabuleiro(2, 2);

        p1.Machuchar(p2, 3, tb);
        System.out.println(p2);
        p1.Curar(p2, 2056);

        System.out.println(p2);
        System.out.println("Level maior");
        p1.setLevel(100);
        p1.Machuchar(p2, 3, tb);
        System.out.println(p2);
        System.out.println("Level menor");
        p2.setLevel(15000);
        p1.Machuchar(p2, 3, tb);
        System.out.println(p2);

    }

}