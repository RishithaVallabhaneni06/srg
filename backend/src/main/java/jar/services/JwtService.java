package jar.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jar.model.User;

@Service
public class JwtService {

    private static final String JWT_SECRET_KEY =
            "vikramramvikramramvikramram123456789";

    private static final long JWT_TOKEN_VALIDITY =  60 * 1000;

    private Key generateSecretKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());
    }

    public String generateJwtToken(User user) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_TOKEN_VALIDITY);

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("name", user.getName());
        claims.put("email", user.getEmail());

        return Jwts.builder()
                .claims(claims)
                .subject(user.getEmail())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(generateSecretKey())
                .compact();
    }
}