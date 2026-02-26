package med.voll.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario) throws JWTCreationException {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        return JWT.create()
                .withIssuer("API Voll.med.api")
                .withSubject(usuario.getLogin())
                .withExpiresAt(this.expireDate())
                .sign(algorithm);
    }

    public String getSubject(String tokenJWT) throws JWTVerificationException {
        var algoritmo = Algorithm.HMAC256(this.secret);
        return JWT.require(algoritmo)
                .withIssuer("API Voll.med")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }


    private Instant expireDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}