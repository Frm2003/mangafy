package com.api.mangafy.adapters.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;

	public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getServletPath();

		// 🔹 IGNORAR LOGIN E CADASTRO
		if (path.startsWith("/auth/login")) {
			filterChain.doFilter(request, response);
			return; // não processa JWT
		}

		// 🔹 PROCESSAR JWT PARA ROTAS AUTENTICADAS
		String token = null;
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if ("jwt".equals(cookie.getName())) {
					token = cookie.getValue();
				}
			}
		}

		if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			String email = jwtService.extractUsername(token);
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);

			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);
	}
}
