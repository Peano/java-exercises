package com.java.exercises.chess;

import java.util.List;
import java.util.Optional;

public class Board {

    private Integer length;
    private Integer width;

    private List<Piece> pieces;

    public Board(Integer length, Integer width, List<Piece> pieces) {
        this.length = length;
        this.width = width;
        this.pieces = pieces;
    }


    // TODO optimization con puntatori a pezzi attivi e no...

    Optional<Piece> getPieceInPosition(Position position) {
        for (Piece piece : pieces) {
            if (piece.getPosition().equals(position))
            return Optional.of(piece);
        }
        return Optional.empty();
    }

    boolean isPositionInsideTheBoard(Position endPosition) {
        return (endPosition.getX() <= width && endPosition.getY() <= length);
    }

    void eatPiece(Piece pieceToEat) {
        Optional<Piece> toRemove = Optional.empty();
        for (Piece piece : pieces) {
            if (piece.getPosition().equals(pieceToEat.getPosition())) {
                toRemove = Optional.of(piece);
                break;
            }
        }
        toRemove.ifPresent(p -> pieces.remove(p));
    }


}
