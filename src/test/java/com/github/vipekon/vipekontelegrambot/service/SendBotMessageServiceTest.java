package  com.github.vipekon.vipekontelegrambot.service;

import com.github.vipekon.vipekontelegrambot.bot.VipekonTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendMessageService")

public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private VipekonTelegramBot vipekonBot;

    @BeforeEach
    public void init() {
        vipekonBot = Mockito.mock(VipekonTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(vipekonBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(vipekonBot).execute(sendMessage);
    }
}
