public class BowlingGame {
    public static final int TOTAL_ROUND = 10;   // 总局数

    private int[] scores;                       // 记录每局得分的数组
    private int lastOneHit, lastTwoHit;         // 最后两次击球
    private int totalScore;                     // 总成绩
    private boolean firstHit;                   // 是否是每局的第一次击球

    public BowlingGame() {
        scores = new int[TOTAL_ROUND];
        firstHit = true;
    }

    public void calcScore(int[][] numberOfHits) {
        // from round 1 to round 9
        for (int i = 0; i < numberOfHits.length - 1; i++) {
            if (numberOfHits[i][0] == 10) {  // Strike(全中)
                scores[i] += 10;
                if (numberOfHits[i + 1][0] == 10) {
                    scores[i] += 10;
                    if (i < 8) {
                        scores[i] += numberOfHits[i + 2][0];
                    } else {
                        scores[i] += lastOneHit;
                    }
                } else {
                    scores[i] += numberOfHits[i + 1][0] + numberOfHits[i + 1][1];
                }
            } else if (numberOfHits[i][0] + numberOfHits[i][1] == 10) { // Spare(补中)
                scores[i] += 10;
                scores[i] += numberOfHits[i + 1][0];
            } else {
                scores[i] += numberOfHits[i][0] + numberOfHits[i][1];
            }
        }
        // the last round
        if (numberOfHits[9][0] == 10) {
            scores[9] += 10;
            scores[9] += lastOneHit + lastTwoHit;
        } else if (numberOfHits[9][0] + numberOfHits[9][1] == 10) {
            scores[9] += 10;
            scores[9] += lastOneHit;
        } else {
            scores[9] += numberOfHits[9][0] + numberOfHits[9][1];
        }
    }

    /**
     * 设置最后第一球击倒瓶子数
     *
     * @param num 击倒瓶子数
     */
    public void setLastOneHit(int num) {
        this.lastOneHit = num;
    }

    /**
     * 设置最后第二球击倒瓶子数
     *
     * @param num 瓶子数
     */
    public void setLastTwoHit(int num) {
        this.lastTwoHit = num;
    }

    /**
     * 计算总分数
     *
     * @return 总分数
     */
    public int getTotalScore() {
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }
        return totalScore;
    }

    /**
     * 获得指定局数的累积得分
     *
     * @param round 局数
     * @return 从第一局到指定局数的累积得分
     */
    public int getScoreByRound(int round) {
        int sum = 0;
        for (int i = 0; i <= round; i++) {
            sum += scores[i];
        }
        return sum;
    }

    public int bowling(int[][] nums, int one, int two) {
        setLastOneHit(one);
        setLastTwoHit(two);
        calcScore(nums);
        return getTotalScore();
    }
}
