package com.kh.spring09.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.cert")
public class CertProperties {
	private int expireMinutes; //custom.cert.expire-minutes
}
