package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        Optional<User> user = DataBase
                .getUsers()
                .stream()
                .filter(x -> x.getLogin().equals(login))
                .findFirst();

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            user.get().setOnline(true);
            request.getSession().setAttribute("loginInput", login);
            request.getSession().setAttribute("user", user.get());
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }

        request.setAttribute("errorLoginMessage", "Неверные данные входа");

        return new ForwardResult(COMMAND_SHOW_LOGIN_PAGE);
    }
}
