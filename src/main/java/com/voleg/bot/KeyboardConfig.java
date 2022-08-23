package com.voleg.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardConfig {

    public static ReplyKeyboardMarkup setUpKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(new KeyboardButton("/news"));
        firstRow.add(new KeyboardButton("/team_ranking"));

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(new KeyboardButton("/matches"));
        secondRow.add(new KeyboardButton("/results"));

        keyboardRowList.add(firstRow);
        keyboardRowList.add(secondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }
}
