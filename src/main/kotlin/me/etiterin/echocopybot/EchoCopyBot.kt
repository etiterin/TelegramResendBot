package me.etiterin.echocopybot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


private const val PROPERTY_BOT_API_KEY = "BOT_API_KEY"
private const val BOT_USERNAME = "EchoCopyBot"

class EchoCopyBot(private val propertiesReader: PropertiesReader) : TelegramLongPollingBot() {

    override fun getBotUsername(): String = BOT_USERNAME

    override fun getBotToken(): String = propertiesReader.getProperty(PROPERTY_BOT_API_KEY).orEmpty()

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val message = update.message

            val sendDocumentRequest = SendDocument()

            sendDocumentRequest.chatId = message.chatId.toString()
            sendDocumentRequest.document = InputFile(message.document.fileId)
            sendDocumentRequest.caption = message.caption

            try {
                execute(sendDocumentRequest)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }
}