package com.UserOfTheDayBot;

//import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        //ApiContextInitializer.init();
	try {
	TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
	telegramBotsApi.registerBot(new Bot());	
        } catch (TelegramApiException e){
		e.printStackTrace();
	}
    }

}
