package br.com.sandclan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaJokeMain {
    private List<String> jokes = new ArrayList<String>();
    private Random randomGenerator = new Random();
    public JavaJokeMain(){

        jokes.add("Knock, knock!\n Who s there?\n Opportunity!\n That is impossible. Opportunity doesnt come knocking twice!");
        jokes.add("Knock knock.\n Who s there?\n An extraterrestrial.\nExtraterrestrial who?\n What – how many extra-terrestrials do you know?");
        jokes.add("Knock knock.\n Who s there?\n Beats.\n Beats who?\n Beats me.");
        jokes.add("Knock knock.\n Who s there?\n The interrupting cow.\n Interrupting cow wh- Moooooo!");
        jokes.add("Knock knock.\n Who s there?\n The door.");
        jokes.add("Knock knock.\n Who s there?\n Double.\n Double who?\n W!");
        jokes.add("Knock, knock.\n Who s there?\n No-one.\n No-one who?\n (Remain silent)");
        jokes.add("Knock knock.\n Who s there?\n Yoda lady.\n Yoda lady who?\n Good job yodeling!");
        jokes.add("Why did the chicken cross the road?\n To hunt somebody down.\n Knock knock.\n Who s there?\n The chicken.");
        jokes.add("Knock knock.\n Who s there?\n Deja.\n Deja who?\n Knock knock.");
        jokes.add("Knock, Knock.\n Who s there?\n Leaf!\n Leaf who?\n Leaf the house, you re not the owner anymore!");
    }



    public String getJoke() {
        int index = randomGenerator.nextInt(jokes.size());
        return jokes.get(index);
    }
}
