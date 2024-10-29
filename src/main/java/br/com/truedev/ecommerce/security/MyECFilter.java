package br.com.truedev.ecommerce.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class MyECFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Encaminhado a requisição
        //Essa arquietetura permite o filtro de autenticação de usuário

        if(request.getHeader("Authorization") != null) {
            Authentication auth = ECTokenUtil.decodeToken(request);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}
