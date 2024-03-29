public enum TipoAtaqueEnum {
    CorpoaCorpo(2),
    LongoAlcance(20);
    public Integer alcance;

    TipoAtaqueEnum(Integer i) {
        this.alcance = i;
    }
}
