package org.example.filter;

import org.example.data.User;
import org.example.data.UserType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Optional<Object> user = Optional.ofNullable(httpServletRequest.getSession().getAttribute("user"));

        if (user.isPresent() && ((User) user.get()).getUserType().equals(UserType.CLIENT)
                && ("admin_actions".equals(request.getParameter("command")))) {
                httpServletRequest.getRequestDispatcher(COMMAND_SHOW_CHAT_PAGE).forward(request, response);
                return;
            }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
