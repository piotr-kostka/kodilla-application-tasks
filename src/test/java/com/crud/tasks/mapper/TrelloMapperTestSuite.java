package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    private List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
    private List<TrelloBoard> trelloBoardList = new ArrayList<>();
    private List<TrelloListDto> trelloListDtos = new ArrayList<>();
    private List<TrelloList> trelloLists = new ArrayList<>();
    private TrelloCard trelloCard;
    private TrelloCardDto trelloCardDto;

    @BeforeEach
    void initData() {
        trelloBoardDtoList.add(new TrelloBoardDto("1", "No.1 board", new ArrayList<>()));
        trelloBoardDtoList.add(new TrelloBoardDto("2", "No.2 board", new ArrayList<>()));
        trelloBoardDtoList.add(new TrelloBoardDto("3", "No.3 board", new ArrayList<>()));

        trelloBoardList.add(new TrelloBoard("1", "No.1 board", new ArrayList<>()));
        trelloBoardList.add(new TrelloBoard("2", "No.2 board", new ArrayList<>()));
        trelloBoardList.add(new TrelloBoard("3", "No.3 board", new ArrayList<>()));

        trelloListDtos.add(new TrelloListDto("1", "No.1 list", true));
        trelloListDtos.add(new TrelloListDto("2", "No.2 list", false));
        trelloListDtos.add(new TrelloListDto("3", "No.3 list", true));

        trelloLists.add(new TrelloList("1", "No.1 list", true));
        trelloLists.add(new TrelloList("2", "No.2 list", false));
        trelloLists.add(new TrelloList("3", "No.3 list", true));

        trelloCard = new TrelloCard("Card 1", "Card number one", "TOP", "1");

        trelloCardDto = new TrelloCardDto("Card 1", "Card number one", "TOP", "1");
    }

    @Test
    void mapToBoardsTest() {
        //When
        List<TrelloBoard> expected = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(3, expected.size());
        assertEquals("No.1 board", expected.get(0).getName());
        assertEquals("2", expected.get(1).getId());
        assertTrue(expected.get(2).getLists().isEmpty());
    }

    @Test
    void mapToBoardsDtoTest() {
        //When
        List<TrelloBoardDto> expected = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(3, expected.size());
        assertEquals("No.1 board", expected.get(0).getName());
        assertEquals("2", expected.get(1).getId());
        assertTrue(expected.get(2).getLists().isEmpty());
    }

    @Test
    void mapToListTest() {
        //When
        List<TrelloList> expected = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(3, expected.size());
        assertEquals("No.1 list", expected.get(0).getName());
        assertEquals("2", expected.get(1).getId());
        assertTrue(expected.get(2).isClosed());
    }

    @Test
    void mapToListDtoTest() {
        //When
        List<TrelloListDto> expected = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(3, expected.size());
        assertEquals("No.1 list", expected.get(0).getName());
        assertEquals("2", expected.get(1).getId());
        assertTrue(expected.get(2).isClosed());
    }

    @Test
    void mapToCardDtoTest() {
        //When
        TrelloCardDto expected = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Card 1", expected.getName());
        assertEquals("Card number one", expected.getDescription());
        assertEquals("TOP", expected.getPos());
        assertEquals("1", expected.getListId());
    }

    @Test
    void mapToCardTest() {
        //When
        TrelloCard expected = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Card 1", expected.getName());
        assertEquals("Card number one", expected.getDescription());
        assertEquals("TOP", expected.getPos());
        assertEquals("1", expected.getListId());
    }
}