public class Main {
    public static void main(String[] args) {
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var tb = new Tabuleiro(5, 5);
        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);

        var ob = new CoisaNaoPersonagem("Arvore", 2000);
        tb.AdicionaAoTabuleiro(ob,0,0);
        p1.EntrarNaGuilda("Ghannor");
        p1.EntrarNaGuilda("Mosqueteiros");
        p1.setLevel(100);
        System.out.println(ob);
        p1.Machuchar(ob, 2100, tb);
        System.out.println(ob);
        p1.Machuchar(ob, 2100, tb);

    }

}