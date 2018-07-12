package com.java.exercises.chess;

import java.util.List;

public interface Piece {

    boolean move(Position newPosition);

    boolean isMoveLegal(Position startPosition, Position endPosition);

    Piece getPieceInBoardPosition(Position position, List<Piece> piecesOnTheBoard);

    String getColor();

    Position getPosition();

}
