package com.gk.productservice.auditor;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> currentAuditor = Optional.of("Gopal");
		return currentAuditor;
	}
}
