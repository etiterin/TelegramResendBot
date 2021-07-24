package me.etiterin.echocopybot

import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


fun main() {
    val pr = PropertiesReader()

    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)

    telegramBotsApi.registerBot(EchoCopyBot(pr))
}