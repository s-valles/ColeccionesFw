import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    public ArrayList<Card> poker = new ArrayList<>();
    private final HashMap<String,String> suit = new HashMap<>();

    Deck(){
        dck();
    }
    public void randomHead (){
        Collections.shuffle(poker);
    }
    public void shuffle(){
        Collections.shuffle(poker);
        System.out.println("\nSe mezcló el Deck");
    }
    public void dck(){
        suit.put("\nTrebol ♣","Negro");
        suit.put("\nPica ♠","Negro");
        suit.put("\nDiamante ♦","Rojo");
        suit.put("\nCorazon ♥","Rojo");

        for (Map.Entry<String,String> palo:suit.entrySet()){
            int count=1;
            Card carta;
            while (count <=13){
                carta = new Card(palo.getKey(), palo.getValue());
                carta.valorCarta(count);
                poker.add(carta);
                count ++;
            }
        }
    }

    public void head() throws Exception{
        if (poker.isEmpty())
            throw new Exception("\nLas cartas se han agotado");
        int remove=1;
        var card = poker.get(poker.size()-remove);
        poker.remove(card);
        System.out.println(card.toString());
        System.out.printf("\n Quedan %s%n",poker.size());
    }

    public void pick() throws Exception {
        if(poker.isEmpty() || poker.size() <=1)
            throw new Exception("\nLas cartas se han agotado");
        var pickCard = Randomizer();
        poker.remove(pickCard);
        System.out.println(pickCard.toString());
        System.out.printf("\n Quedan %s%n",poker.size());
    }

    public void CardDeck(ArrayList<Card> cards){
        for (var card: cards) System.out.println(card.toString());
    }

    private Card Randomizer(){
        var card_random = (int)Math.floor(Math.random()*(1-poker.size()+1)+poker.size());
        return poker.get(card_random);
    }
    public void hand() throws Exception{
        if(poker.isEmpty() || poker.size() <5)
            throw new Exception("\nLas cartas se han agotado, intenta nuevamente.");
        if(poker.size() <= 5){  for (var card:poker){

            poker.remove(card);
        }
        }else { var cards = new ArrayList<Card>();
            Card card;
            int con=1;
            while (con<=5){ card = Randomizer();
                poker.remove(card);
                cards.add(card);
                con++;
            }
            CardDeck(cards);
            System.out.printf("\n Quedan %s%n",poker.size());
        }
    }
}
