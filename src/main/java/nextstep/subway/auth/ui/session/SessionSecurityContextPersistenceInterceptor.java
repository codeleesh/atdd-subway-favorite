package nextstep.subway.auth.ui.session;

import nextstep.subway.auth.infrastructure.SecurityContext;
import nextstep.subway.auth.infrastructure.SecurityContextHolder;
import nextstep.subway.auth.ui.SecurityContextPersistenceInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static nextstep.subway.auth.infrastructure.SecurityContextHolder.SPRING_SECURITY_CONTEXT_KEY;

public class SessionSecurityContextPersistenceInterceptor extends SecurityContextPersistenceInterceptor {
    @Override
    protected boolean proceedAfter(HttpServletRequest request, HttpServletResponse response, Object handler) {
        SecurityContext securityContext = (SecurityContext) request.getSession().getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        if (securityContext != null) {
            SecurityContextHolder.setContext(securityContext);
        }
        return true;
    }
}