package br.com.truedev.ecommerce.security;

import br.com.truedev.ecommerce.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import io.jsonwebtoken.security.Keys;

public class ECTokenUtil {

    public static final long UM_SEGUNDO = 1000;
    public static final long UM_MINUTO = 60 * UM_SEGUNDO;
    public static final long UMA_HORA  = 60 * UM_MINUTO;
    public static final long UM_DIA = 24 * UMA_HORA;
    public static final long UMA_SEMANA = 7 * UM_DIA;

    public static final String EMISSOR = "*Vasconcelos*";
    public static final String TOKEN_KEY = "01234567890123456789012345678901";
    public static final String TOKEN_HEADER = "Bearer ";

    public static ECToken generateToken(Usuario usuario){
        Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());

        String jwt = Jwts.builder().setSubject(usuario.getLogin())
                                    .setIssuer(EMISSOR)
                                    .setExpiration(new Date(System.currentTimeMillis() + UMA_SEMANA))
                                    .signWith(secretKey, SignatureAlgorithm.HS256).compact();

        ECToken token = new ECToken();
        token.setToken(TOKEN_HEADER + jwt);
        return token;
    }

    public static Authentication decodeToken(HttpServletRequest request){
            String token = request.getHeader("Authorization");
            token = token.replace(TOKEN_HEADER, "");

            Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(TOKEN_KEY.getBytes()).build().parseClaimsJws(token);
            String login = jwsClaims.getBody().getSubject();
            String emissor = jwsClaims.getBody().getIssuer();
            Date validade = jwsClaims.getBody().getExpiration();

            if(login.length() > 0 && emissor.equals(EMISSOR)
                    && validade.after(new Date(System.currentTimeMillis())))
                return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());

        return null;
    }
}
