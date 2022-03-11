
package pe.com.cma.apiaccess.security.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import pe.com.cma.apiaccess.controller.request.LoginRequest;
import pe.com.cma.apiaccess.dao.model.User;
import pe.com.cma.apiaccess.enumeration.AccessCodeEnum;
import pe.com.cma.apiaccess.enumeration.RoleType;
import pe.com.cma.apiaccess.exception.JwtAuthenticationException;
import pe.com.cma.apiaccess.security.dto.*;

import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

        SecurityRequest request = (SecurityRequest) authentication;
        LoginRequest login = request.getRequest();
        String username = login.getEmail();

        AccessResult<User> status = AccessResult.<User>builder()
            .code(AccessCodeEnum.NOT_AUTHENTICATED.getCode())
        .build();

        if (AccessCodeEnum.OK.isCode(status.getCode())) {
            User user = status.getResult();
            UserWrapper userInfo = new UserWrapper(user);
            List<UserRole> roles = userInfo.getRoles();
            return new SecurityToken(username, null, roles, userInfo);
        }
        else
        {
            throw new JwtAuthenticationException("No se identifico correctamente");
        }
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
