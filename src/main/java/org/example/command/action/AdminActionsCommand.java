package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;


public class AdminActionsCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        if (Optional.ofNullable(request.getParameterValues("condition")).isEmpty()) {
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }
        List<String> loginValues;
        loginValues = List.of(request.getParameterValues("condition"));

        for (int i = 0; i < DataBase.getUsers().size(); i++) {
            if (loginValues.contains(DataBase.getUsers().get(i).getLogin())) {
                DataBase.setReadOnlyModeForUser(DataBase.getUsers().get(i).getLogin(), true);
            } else {
                DataBase.setReadOnlyModeForUser(DataBase.getUsers().get(i).getLogin(), false);
            }

        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
