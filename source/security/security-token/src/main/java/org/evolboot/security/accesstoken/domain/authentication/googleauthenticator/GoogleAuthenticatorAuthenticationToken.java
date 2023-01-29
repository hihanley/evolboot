package org.evolboot.security.accesstoken.domain.authentication.googleauthenticator;

import org.evolboot.security.accesstoken.domain.authentication.AuthenticationToken;
import org.evolboot.security.accesstoken.domain.authentication.AuthenticationTokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author evol
 */
@Getter
@AllArgsConstructor
public class GoogleAuthenticatorAuthenticationToken implements AuthenticationToken {

    private String username;

    private String encodePassword;

    private String googleAuthenticatorCode;

    @Override
    public AuthenticationTokenType getAuthenticationTokenType() {
        return AuthenticationTokenType.GOOGLE_AUTHENTICATOR;
    }
}
