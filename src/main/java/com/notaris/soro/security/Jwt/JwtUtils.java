package com.notaris.soro.security.Jwt;


import com.notaris.soro.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;


import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${notaris.app.jwtSecret}")
    private String jwtSecret;

    @Value("${notaris.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${notaris.app.jwtCookieName}")
    private String jwtCookie;

    //---------obtenir le JWT depuis les cookies par le nom de cookie
    public String getJwtFromCookies(HttpServletRequest request){
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);

        if(cookie != null){
            return cookie.getValue();
        }else {
            return null;
        }
    }

    //-----------génère un Cookie contenant JWT entre nom d'utilisateur, date, expiration, secret
    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal){
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/notaris").maxAge(24 * 60).httpOnly(true).build();
        return  cookie;

    }

    //---------- retourne un cookie avec null comme valeur(utilisé pour nettoyer les cookies)
    public ResponseCookie getCleanJwtCookie(){
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/notaris").build();
        return  cookie;
    }


    //-------- obtenir le nom d'utilisateur de JWT
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    //-------------Valider le JWT avec un secret
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("JWT Token invalid: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token est expiré: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token n'est pas réconnu: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error(" Le champ  claims de JWT claims est invalide: {}", e.getMessage());
        }

        return false;
    }


    //----------obtenir le nom de l'utilisateur depuis le JWT-------------
    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
}
