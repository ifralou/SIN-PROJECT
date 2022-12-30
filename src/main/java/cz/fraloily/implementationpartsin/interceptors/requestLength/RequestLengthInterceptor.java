package cz.fraloily.implementationpartsin.interceptors.requestLength;

import cz.fraloily.implementationpartsin.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Component
public class RequestLengthInterceptor implements HandlerInterceptor {

    private final String time = "startTimeTimeStamp";
    private final Logger log = LoggerFactory.getLogger(RequestLengthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(time, Timer.getCurrentTime());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(handler instanceof HandlerMethod m) {
            var start = (Timestamp) request.getAttribute(time);
            log.info("\u001B[32m" + m.getShortLogMessage() + "\u001B[0m" + ": request duration is " + Timer.millisecondsFromNow(start) + " ms.");
        }
    }
}
