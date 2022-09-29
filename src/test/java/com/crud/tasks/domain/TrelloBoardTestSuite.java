package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloBoardTestSuite {
    @Test
    void shouldCreateTrelloBoardWithNoArgsTest() {
        //Given & When
        TrelloBoard trelloBoard = new TrelloBoard();

        //Then
        assertNull(trelloBoard.getId());
        assertNull(trelloBoard.getName());
        assertNull(trelloBoard.getLists());
    }
}