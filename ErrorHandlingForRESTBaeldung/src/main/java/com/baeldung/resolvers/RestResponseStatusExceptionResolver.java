package com.baeldung.resolvers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.ACCEPT;

@Slf4j
@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
        try {
            if (e instanceof IllegalArgumentException) {
                return handleIllegalArgument((IllegalArgumentException) e, response, obj);
            }
        } catch (Exception handlerException) {
            log.warn("Handling of {} resulted in exception", e.getClass().getName());
        }
        return null;
    }

    private ModelAndView handleIllegalArgument(IllegalArgumentException e, HttpServletResponse response, Object obj) throws IOException {
        response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED);
        String accept = response.getHeader(ACCEPT);

        return new ModelAndView();
    }

}
