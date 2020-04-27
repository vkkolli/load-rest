package com.cei.load.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The Class JpaAuditingConfiguration.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {

	/**
	 * Creates the auditing listener.
	 *
	 * @return the auditing entity listener
	 */
	@Bean
	public AuditingEntityListener createAuditingListener() {
		return new AuditingEntityListener();
	}
	
	/**
	 * Auditor aware.
	 *
	 * @return the auditor aware
	 */
	@Bean
	public AuditorAware<Long> auditorAware(){
		return new AuditorAwareImpl();
	}
	
	/**
	 * The Class AuditorAwareImpl.
	 */
	public static class AuditorAwareImpl implements AuditorAware<Long> {

		/**
		 * Gets the current auditor.
		 *
		 * @return the current auditor
		 */
		@Override
		public Optional<Long> getCurrentAuditor() {
			return Optional.of(1L);
		}
		
	}
}
