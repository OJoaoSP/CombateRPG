import java.util.ArrayList;
import java.util.List;

public class Personagem implements ExisteParaTabuleiro {

    private final String Id;
    private Integer Vida;
    private List<String> Guilda = new ArrayList<>();
    private String Nome;
    private Integer Level;
    private Boolean EstaVivo;
    private Integer Alcance;
    public static Integer VidaMaxima = 1000;

    public List<String> getGuilda(){return Guilda;}
    public Integer getVida() {return Vida;}
    public String getNome() {
        return Nome;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Personagem(String nome, TipoAtaqueEnum tipAt) {
        this.Nome = nome;
        this.Vida = 1000;
        this.Level = 1;
        this.EstaVivo = true;
        this.Alcance = tipAt.alcance;
        this.Id = Nome + Alcance.toString() + Level.toString();
    }

    public String Machuchar(ExisteParaTabuleiro Atingido, Integer dano, Tabuleiro tb) {
        if (this == Atingido) {
            System.out.println("Aqui é proibido isso");
            return "Aqui é proibido isso";
        }
        if (TabuleiroService.CalculaDistancia(
                tb.ProcuraId(this), tb.ProcuraId(Atingido)) * tb.TamanhoPadraoCelula > this.Alcance) {
            System.out.println("Fora do alcance");
            return "Fora do alcance";
        }

        if (Atingido.EstaNaGuilda(this.Guilda)) {return "Não pode atacar amiguinho";}

        var diferenca_level = Atingido.getLevel() - this.Level;
        if (diferenca_level >= 5) {
            dano = dano / 2;
        } else if (diferenca_level <= -5) {
            dano = dano * 2;

        }

        Atingido.Receber_dano_cura(-dano);
        return "Machucado";
    }

    public void Receber_dano_cura(Integer dano_cura) {
        if (!this.EstaVivo) {
            return;
        }

        Integer resultado = this.Vida + dano_cura;
        if (resultado <= 0) {
            this.EstaVivo = false;
            this.Vida = 0;
        } else if (resultado > Personagem.VidaMaxima) {
            this.Vida = Personagem.VidaMaxima;
        } else {
            this.Vida = resultado;
        }
    }

    public void Curar(Personagem Atingido, Integer cura) {
        Atingido.Receber_dano_cura(cura);
    }

    @Override
    public String toString() {return this.Nome + "| " + this.Vida + " Level: " + this.Level + " Esta vivo: " + this.EstaVivo;}

    public Integer getAlcance() {
        return Alcance;
    }

    @Override
    public String getId() {
        return Id;
    }

    public void EntrarNaGuilda(String NomeDaGuilda) {
        this.Guilda.add(NomeDaGuilda);
    }
    public void EntrarNaGuilda(List<String> ListaNomeDaGuilda) {
        this.Guilda.addAll(ListaNomeDaGuilda);
    }

    public void SairDaGuilda(String NomeDaGuilda) {
        this.Guilda.remove(NomeDaGuilda);
    }
    public void SairDaGuilda(List<String> ListaNomeDaGuilda) {
        this.Guilda.removeAll(ListaNomeDaGuilda);
    }

    public Boolean EstaNaGuilda(String NomeDaGuilda) {
        return Guilda.contains(NomeDaGuilda);
    }

    public Boolean EstaNaGuilda(List<String> ArrNomeDaGuilda) {
        var saida = false;
        for (String ss : ArrNomeDaGuilda) {
            saida = Guilda.contains(ss);
        }
        return saida;
    }
}