package br.com.empiricus.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthorization extends BasicAuthenticationFilter {

	public JWTAuthorization(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	// prefixo do token que será recebido no HttpServletRequest
	private static final String token_prefix = "Bearer ";
	
	// segredo: substituir para uma string codificada
	private static final String secret = "SEGREDO";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if(token == null || !token.startsWith(token_prefix)) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken auth = getAuthentication(token);

        // define o usuário como autenticado no contexto da aplicação
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {

        if(token == null) {
            return null;
        }

        // decodifica o token para recuperar o username
        String username = JWT.require(Algorithm.HMAC512(secret.getBytes()))
                .build()
                .verify(token.replace(token_prefix, ""))
                .getSubject();

        if(username == null) {
            return null;
        }
		
		// substituir por 
        return new UsernamePasswordAuthenticationToken(
                username, null, Collections.emptyList()
        );
    }
}