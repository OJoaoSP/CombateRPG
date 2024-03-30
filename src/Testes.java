import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Testes{
    @Test
    public void TesteErrarAtaqueCurto(){
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("p2", TipoAtaqueEnum.LongoAlcance);
        var esperado = "Fora do alcance";

        var tb = new Tabuleiro(5, 5);
        tb.AdicionaAoTabuleiro(p1,5 -1,5 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);

        var Feito = p1.Machuchar(p2, 4,tb);
        assertEquals(Feito,esperado);

    }
    @Test
    public void TesteDano(){
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("p2", TipoAtaqueEnum.LongoAlcance);
        var esperado = 996;

        var tb = new Tabuleiro(5, 5);
        tb.AdicionaAoTabuleiro(p1,5 -1,5 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);

        p2.Machuchar(p1, 4,tb);
        assertEquals(p1.getVida(),esperado, 0);

    }
    @Test
    public void TesteLevelMaior() {
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("p2", TipoAtaqueEnum.LongoAlcance);
        var tb = new Tabuleiro(2, 2);
        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);

        var dano = 3;
        p1.setLevel(100);
        p1.Machuchar(p2, dano, tb);
        var esperado = 1000 - (dano * 2);

        assertEquals(p2.getVida(),esperado, 0);

    }

    @Test
    public void TesteLevelMenor() {
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("p2", TipoAtaqueEnum.LongoAlcance);
        var tb = new Tabuleiro(2, 2);
        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);

        var dano = 10;
        p2.setLevel(100);
        p1.Machuchar(p2, dano, tb);
        var esperado = 1000 - (dano / 2);

        assertEquals(p2.getVida(),esperado, 0);

    }
    @Test
    public void TesteRegraNaoBaterAliado(){
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var p2 = new Personagem("Dartagnan", TipoAtaqueEnum.LongoAlcance);
        var tb = new Tabuleiro(5, 5);
        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);
        tb.AdicionaAoTabuleiro(p2,0,0);

        p2.EntrarNaGuilda("Ghannor");
        p2.EntrarNaGuilda("Mosqueteiros");

        p1.EntrarNaGuilda(p2.getGuilda());
        var d = p1.Machuchar(p2, 4, tb);

        var esperado = 1000;
        assertEquals(p2.getVida(),esperado, 0);

    }
    @Test
    public void TesteAtacarNP(){
        var p1 = new Personagem("p1", TipoAtaqueEnum.CorpoaCorpo);
        var tb = new Tabuleiro(5, 5);
        var vida = 2000;
        var dano = 200;

        tb.AdicionaAoTabuleiro(p1,2 -1,2 -1);
        var ob = new CoisaNaoPersonagem("Arvore", vida);
        tb.AdicionaAoTabuleiro(ob,0,0);
        p1.Machuchar(ob, dano, tb);

        var esperado = vida - dano;
        assertEquals(ob.getVida(),esperado, 0);


    }





}

