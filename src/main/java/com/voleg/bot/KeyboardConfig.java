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
        firstRow.add(new KeyboardButton(CommandEnum.GET_NEWS_FOR_TODAY.getButtonName()));
        firstRow.add(new KeyboardButton(CommandEnum.GET_TEAMS_RANKING.getButtonName()));

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(new KeyboardButton(CommandEnum.GET_MATCHES_FOR_TODAY.getButtonName()));
        secondRow.add(new KeyboardButton(CommandEnum.GET_RESULTS_FOR_TODAY.getButtonName()));

        keyboardRowList.add(firstRow);
        keyboardRowList.add(secondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }
}
