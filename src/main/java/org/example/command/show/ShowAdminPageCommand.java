package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.example.Resources.*;

public class ShowAdminPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = DataBase
                .getUsers()
                .stream()
                .filter(x -> x.getUserType() == UserType.CLIENT)
                .collect(toList());
        request.setAttribute("users", users);
        return new ForwardResult(PAGE_ADMIN);
    }
}
