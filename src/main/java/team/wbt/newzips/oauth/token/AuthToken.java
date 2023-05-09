package team.wbt.newzips.oauth.token;


import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;

@Slf4j
@Getter
@RequiredArgsConstructor
public class AuthToken {
    private static final String AUTHORITIES_KEY = "role";
    private final String token;
    private final Key key;

    AuthToken(String id, Date expiry, Key key) {
        this.key = key;
        this.token = createToken(id, expiry);
    }

    AuthToken(String id, Date expiry, Key key, String role) {
        this.key = key;
        this.token = createToken(id, expiry, role);
    }

    private String createToken(String id, Date expiry) {
        return Jwts.builder()
                .setSubject(id)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(expiry)
                .compact();
    }

    private String createToken(String id, Date expiry, String role) {
        return Jwts.builder()
                .setSubject(id)
                .claim(AUTHORITIES_KEY, role)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(expiry)
                .compact();
    }

    public boolean validate() {
        return this.getTokenClaims() != null;
    }

    public Claims getTokenClaims() {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SecurityException e) {
            log.info("Invalid JWT signature.");
        } catch (MalformedJwtException e){
            log.info("Invalid JWT Token.");
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token.");
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token.");
        } catch (IllegalArgumentException e){
            log.info("JWT token compact of handler are invalid.");
        }
        return null;
    }

    public Claims getExpiredTokenClaims() {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token.");
            return e.getClaims();
        }
        return null;
    }
}
