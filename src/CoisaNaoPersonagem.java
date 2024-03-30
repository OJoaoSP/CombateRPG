import javax.crypto.Mac;
import javax.management.DescriptorKey;
import java.util.List;

public class CoisaNaoPersonagem implements ExisteParaTabuleiro {
    private String Nome;
    private String Id;
    private Integer Vida;
    private Boolean EstaQuebrado;

    public CoisaNaoPersonagem(String nome, Integer vida){
        Nome = nome;
        Vida = vida;
        EstaQuebrado = false;
        Id = Nome + this.hashCode();
    }
    @Override
    public String getNome() {return Nome;}

    @Override
    public String getId() {return Id;    }

    public Integer getVida() {return Vida;}

    @Override
    @DescriptorKey("Teste")
    public void Receber_dano_cura(Integer dano) {
        if (EstaQuebrado){
            System.out.println("Já esta quebrado, calma ai");
            return;
        }

        if (dano> 0){
            return;
        }
        Vida += dano;
        if (Vida <= 0 ){
            EstaQuebrado = true;
            Vida = 0;
        }
    }
    @Override
    public String toString() {return this.Nome + "| " + this.Vida + " Esta Quebrado: " + this.EstaQuebrado;}

    @Override
    public Boolean EstaNaGuilda(List<String> arrL) {
        return false;
    }

    @Override
    public Boolean EstaNaGuilda(String arrL) {
        return false;
    }

    @Override
    public Integer getLevel() {
        return 0;
    }
}
