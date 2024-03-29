public class Personagem implements ExisteParaTabuleiro{

    private final String Id;
    private Integer Vida;

    public String getNome() {
        return Nome;
    }
    private String Nome;
    private Integer Level;
    private Boolean EstaVivo ;
    private Integer Alcance;


    public static Integer VidaMaxima = 1000;

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Personagem(String nome, TipoAtaqueEnum tipAt){
        this.Nome = nome;
        this.Vida = 1000;
        this.Level = 1;
        this.EstaVivo= true;
        this.Alcance = tipAt.alcance;
        this.Id = Nome + Alcance.toString() + Level.toString();
    }
    public void Machuchar (Personagem Atingido, Integer dano, Tabuleiro tb){
        if(this == Atingido){
            System.out.println("Aqui é proibido isso");
            return;
        }
        if ( TabuleiroService.CalculaDistancia(
                tb.ProcuraId(this), tb.ProcuraId(Atingido)) * tb.TamanhoPadraoCelula > this.Alcance){
            System.out.println("Fora do alcance");
            return;
        }

        var a = Atingido.getLevel() - this.Level;
        if ( a >= 5){
            dano = dano /2;
        } else if (a <= -5) {
            dano = dano * 2;

        }

        Atingido.Receber_dano_cura(-dano);
    }
    public void Receber_dano_cura(Integer dano_cura){
        if(!this.EstaVivo){
            return;
        }

        Integer resultado = this.Vida + dano_cura;
        if(resultado <= 0){
            this.EstaVivo = false;
            this.Vida = 0;
        } else if (resultado > Personagem.VidaMaxima) {
            this.Vida = Personagem.VidaMaxima;
        }
        else {
            this.Vida = resultado;
        }
    }
    public void Curar(Personagem Atingido, Integer cura){
        Atingido.Receber_dano_cura(cura);
    }

    @Override
    public String toString() {
        return this.Nome +"| " +this.Vida + " Level: "+this.Level + " Esta vivo: " + this.EstaVivo ;
    }

    public Integer getAlcance() {
        return Alcance;
    }

    @Override
    public String getId() {
        return Id;
    }
}
