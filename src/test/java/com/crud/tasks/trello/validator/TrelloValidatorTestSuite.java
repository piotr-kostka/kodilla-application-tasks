package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloValidatorTestSuite {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoardsTest() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "board 1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "board 2", new ArrayList<>()));

        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
        assertEquals("board 2", result.get(1).getName());
        assertTrue(result.get(0).getLists().isEmpty());
    }

    @Test
    void emptyListTest() {
        //Given
        TrelloBoard testTrelloBoard = new TrelloBoard("1", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(testTrelloBoard);

        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void validateCardTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card", "description", "position", "1");

        //When & Then
        trelloValidator.validateCard(trelloCard);
    }
}