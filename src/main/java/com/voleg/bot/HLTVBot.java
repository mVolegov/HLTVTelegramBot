package com.voleg.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

public class HLTVBot extends TelegramLongPollingBot {

    private final BotResponseBuilder responseBuilder;

    public HLTVBot(BotResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            handleMessage(message);
        }
    }

    private void handleMessage(Message message) {
        try {
            buildResponse(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void buildResponse(Message message) throws TelegramApiException {
        try {
            String response = responseBuilder.makeResponse(getCommand(message));

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId().toString());
//            sendMessage.setReplyToMessageId(message.getMessageId());  // будет высвечиваться как ответ на сообщение
            sendMessage.setText(response);
            sendMessage.setReplyMarkup(KeyboardConfig.setUpKeyboard());

            execute(sendMessage);
        } catch (IllegalArgumentException e) {
            execute(new SendMessage(message.getChatId().toString(), "Я вас не понимаю"));
        }
    }

    private String getCommand(Message message) throws IllegalArgumentException {
        if (!(message.hasEntities() && message.hasText())) {
            throw new IllegalArgumentException();
        }

        Optional<MessageEntity> commandEntity =
                message
                        .getEntities()
                        .stream()
                        .filter(messageEntity -> "bot_command".equals(messageEntity.getType()))
                        .findFirst();

        if (commandEntity.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
    }

    @Override
    public String getBotUsername() {
        return "HLTVTelegramBot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }
}
