package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("MyHandlerExceptionResolver @@");
        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalAccessException resolver to 400");
                // IllegalArgumentException 는 나는 400으로 할거다 하고 변경 (Error처리 방법 중 하나)
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());

                return new ModelAndView();
            }
        } catch(IOException e) {
            log.error("resolver ex",e);
        }
        return null;
    }
}
