package com.java.exercises.chess;

import java.util.List;
import java.util.Optional;


public class Horse implements Piece {

    private Position currentPosition;
    private String color;

    private Board board;

    public Horse(Position startPosition, String color) {
        this.color = color;
        this.currentPosition = startPosition;
    }


    @Override
    public boolean move(Position newPosition) {
// TODO muovi solo se mossa è legale o posizione non è occupata da tuo pezzo se occupata da pezzo nemico, mangia il pezzo

        if (isMoveLegal(currentPosition, newPosition)) {

            Optional<Piece> piece = board.getPieceInPosition(newPosition);

            if (!piece.isPresent()) {
                currentPosition = newPosition;
                return true;
            } else if (piece.get().getColor().equals(color)) {
                return false;
            } else if (!piece.get().getColor().equals(color)) {
                board.eatPiece(piece.get());
                currentPosition = newPosition;
                return true;
            }

        }
        return false;
    }


    @Override
    public boolean isMoveLegal(Position startPosition, Position endPosition) {

        if (!board.isPositionInsideTheBoard(currentPosition)) {
            return false;
        }

        if (Math.abs(endPosition.getX() - startPosition.getX()) == 2 && Math.abs(endPosition.getY() - startPosition.getY()) == 1) {
            return true;
        }
        if (Math.abs(endPosition.getX() - startPosition.getX()) == 1 && Math.abs(endPosition.getY() - startPosition.getY()) == 2) {
            return true;
        }
        return false;
    }

    @Override
    public Piece getPieceInBoardPosition(Position position, List<Piece> piecesOnTheBoard) {
        return null;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Position getPosition(){
        return currentPosition;
    }



}
