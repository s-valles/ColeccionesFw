public class Card {

    private final String palo;
    private final String color;
    private String valor;


    Card(String palo,String color){
        this.palo = palo;
        this.color = color;
    }

    public void valorCarta(Integer valor) {
        if(valor <= 10){ if(valor == 1) this.valor = "A";
            this.valor = valor.toString();
        }else if(valor==11){
            this.valor = "J";
        }else if (valor==12){
            this.valor = "Q";
        }else {
            this.valor = "K";
        }
    }

    @Override public String toString() {
        return  palo+ " " + color + " " + valor;
    }
}
