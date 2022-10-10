package ru.javarush.configs.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.javarush.services.UserDetailsImpl;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpiration}")
    private Long expired;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Date now = new Date();
        Date exp = new Date(now.getTime() + expired);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(jwtSecret))
                .compact();

    }

    public boolean validateJwtToken(String jwt) {
        try {
            Jwts.parser()
                    .setSigningKey(TextCodec.BASE64URL.decode(jwtSecret))
                    .parseClaimsJws(jwt);
            return true;
        } catch (JwtException e) {
            log.error("Exception occurred: {}", e.getLocalizedMessage());
        }
        return false;
    }

    public String getUsernameFromJwtToken(String jwt) {
        return Jwts.parser().setSigningKey(TextCodec.BASE64URL.decode(jwtSecret)).parseClaimsJws(jwt).getBody().getSubject();
    }

}
