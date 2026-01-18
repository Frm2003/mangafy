package com.api.mangafy.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ReaderProfile {
	private boolean subscriber;
	private LocalDate subscriptionEnd;

	public boolean isSubscriptionActive() {
		return subscriber && subscriptionEnd.isAfter(LocalDate.now());
	}
}
