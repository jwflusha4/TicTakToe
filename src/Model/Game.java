package Model;

import Strategy.WinningStrategy.WinningStrategy;
import Strategy.bot.BotStrategyLevel;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    int currentPlayerIndex;
    GameStatus gameState;
    Player winner;
    List<WinningStrategy> winningStrategies;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board=new Board(dimension);
        this.moves=new ArrayList<>();
        this.gameState=GameStatus.IN_PROGRESS;
        this.currentPlayerIndex=0;
        this.winningStrategies=winningStrategies;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void addMove(Move move){
        moves.add(move);
    }
    public void updateBoard(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell cell=move.getCell();
        this.board.getBoard().get(row).set(col,cell);
    }
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        List<Player> players;
        List<WinningStrategy> winningStrategies;
        int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build() {

            // TODO: validations here.
            // TODO: Add excepions here.

            return new Game(dimension, players, winningStrategies);

        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GameStatus getGameState() {
        return gameState;
    }

    public void setGameState(GameStatus gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
    public int nextPlayerTurn() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % players.size();
        return this.currentPlayerIndex;
    }
}
