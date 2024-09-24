import java.util.ArrayList;
import java.util.List;

interface ScoreObserver {
    void update(String match, int runs, int wickets);
}

class Player implements ScoreObserver {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void update(String match, int runs, int wickets) {
        System.out.println(name + " sees the score: " + match + " - Runs: " + runs + ", Wickets: " + wickets);
    }
}

class Scoreboard {
    private String match;
    private int runs;
    private int wickets;
    private List<ScoreObserver> observers = new ArrayList<>();

    public Scoreboard(String match) {
        this.match = match;
    }

    public void addObserver(ScoreObserver observer) {
        observers.add(observer);
    }

    public void setScore(int runs, int wickets) {
        this.runs = runs;
        this.wickets = wickets;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (ScoreObserver observer : observers) {
            observer.update(match, runs, wickets);
        }
    }
}

public class Cricketscore {
    public static void main(String[] args) {
        Scoreboard matchScore = new Scoreboard("Cricket Match: Team A vs Team B");

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        matchScore.addObserver(player1);
        matchScore.addObserver(player2);

        matchScore.setScore(120, 2);
        matchScore.setScore(150, 4);
    }
}

