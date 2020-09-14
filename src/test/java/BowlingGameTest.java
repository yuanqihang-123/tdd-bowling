import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    void total_score_is_zero(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        int scores = bowlingGame.bowling(nums, 0, 0);
        assertEquals(0, scores);
    }

    @Test
    void the_game_had_one_spare_in_the_middle(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{1,2},{1,2},{1,2},{1,2},{1,9},{1,2},{1,2},{1,2},{1,2},{1,2}};
        int scores = bowlingGame.bowling(nums, 0, 0);
        assertEquals(38, scores);
    }

    @Test
    void the_game_had_one_strike_in_the_middle(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{1,2},{1,2},{1,2},{1,2},{10,0},{1,2},{1,2},{1,2},{1,2},{1,2}};
        int scores = bowlingGame.bowling(nums, 0, 0);
        assertEquals(40, scores);
    }

    @Test
    void the_game_had_one_spare_at_the_end(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,9}};
        int scores = bowlingGame.bowling(nums, 1, 0);
        assertEquals(38, scores);
    }

    @Test
    void the_game_had_one_strike_at_the_end(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{10,0}};
        int scores = bowlingGame.bowling(nums, 1, 2);
        assertEquals(40, scores);
    }

    @Test
    void every_round_is_ten(){
        BowlingGame bowlingGame = new BowlingGame();
        int nums[][] = {{10,10},{10,10},{10,10},{10,10},{10,10},{10,10},{10,10},{10,10},{10,10},{10,10}};
        int scores = bowlingGame.bowling(nums, 10, 10);
        assertEquals(300, scores);
    }

}
