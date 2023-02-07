package ru.udya.services.department.security.auth.jwt;

import io.jmix.oidc.OidcProperties;
import io.jmix.oidc.jwt.JmixJwtAuthenticationConverter;
import io.jmix.oidc.jwt.JmixJwtAuthenticationToken;
import io.jmix.oidc.user.JmixOidcUser;
import io.jmix.oidc.usermapper.OidcUserMapper;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collections;

public class ExtJmixJwtAuthenticationConverter extends JmixJwtAuthenticationConverter {

    public ExtJmixJwtAuthenticationConverter(OidcUserMapper oidcUserMapper, OidcProperties oidcProperties) {
        super(oidcUserMapper,oidcProperties);
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        OidcIdToken oidcIdToken = OidcIdToken.withTokenValue(jwt.getTokenValue())
                .claims(claims -> claims.putAll(jwt.getClaims()))
                .build();

        String usernameClaimToUse = usernameClaimName != null ?
                usernameClaimName :
                oidcProperties.getJwtAuthenticationConverter().getUsernameClaim();

        DefaultOidcUser oidcUser = new DefaultOidcUser(Collections.emptyList(), oidcIdToken, usernameClaimToUse);
        JmixOidcUser jmixOidcUser = oidcUserMapper.toJmixUser(oidcUser);

        // begin extension
        JmixJwtAuthenticationToken token = new ExtJmixJwtAuthenticationToken(jwt,
                jmixOidcUser,
                jmixOidcUser.getAuthorities());

        // end extension

        return token;
    }


}
