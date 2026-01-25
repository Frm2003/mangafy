package com.api.mangafy.adapters.security;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.mangafy.domain.Roles;

public class UserPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;

	private final UUID id;
	private final String email;
	private final String passwd;
	private final Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(UUID id, String email, String passwd, Set<Roles> roles) {
		this.id = id;
		this.email = email;
		this.passwd = passwd;
		this.authorities = roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).toList();
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return passwd;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
