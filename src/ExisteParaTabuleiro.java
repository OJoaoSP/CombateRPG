import javax.swing.*;
import java.util.List;

public interface ExisteParaTabuleiro {
    public String getNome();
    public String getId();
    public void Receber_dano_cura(Integer dano_cura);

    public Boolean EstaNaGuilda(List<String> arrL);
    public Boolean EstaNaGuilda(String arrL);

    public Integer getLevel();
}
