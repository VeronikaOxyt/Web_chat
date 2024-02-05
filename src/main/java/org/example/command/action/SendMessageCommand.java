package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String text = request.getParameter("message");
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        Message message = new Message(name, text);

        DataBase.addMessage(message);

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
