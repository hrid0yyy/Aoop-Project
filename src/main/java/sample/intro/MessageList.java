package sample.intro;

import java.util.List;

public class MessageList {



    private List<Message> messages;

    public MessageList(List<Message> messages) {
        this.messages = messages;
    }

    private String result;

    public String getResult() {
        return result;
    }
}
