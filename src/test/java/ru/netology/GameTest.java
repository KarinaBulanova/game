package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {

    @Test
    public void testFirstPlayerWins() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 750);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertEquals(1, game.round("Nastya", "Vasya"));
    }

    @Test
    public void testSecondPlayerWins() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 450);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertEquals(2, game.round("Nastya", "Vasya"));
    }

    @Test
    public void testDrawInTheGame() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 500);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertEquals(0, game.round("Nastya", "Vasya"));
    }

    @Test
    public void testFirstPlayerNotExist() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 450);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Galya", "Vasya")
        );
    }

    @Test
    public void testSecondPlayerNotExist() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 450);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Nastya", "Galya")
        );
    }

    @Test
    public void testBothPlayersNotExist() {
        Player Vasya = new Player(1, "Vasya", 500);
        Player Nastya = new Player(2, "Nastya", 450);
        Game game = new Game();

        game.register(Vasya);
        game.register(Nastya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Valya", "Galya")
        );
    }

}
