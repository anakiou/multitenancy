package com.anakiou.mt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Autowired
	private MultitenancyProperties multitenancyProperties;

	@Bean(name = { "dataSource", "dataSource1" })
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource1")
	public DataSource dataSource1() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource1().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource1().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource1().getUsername())
				.password(this.multitenancyProperties.getDatasource1().getPassword())
				.url(this.multitenancyProperties.getDatasource1().getUrl());
		return factory.build();
	}

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource2")
	public DataSource dataSource2() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource2().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource2().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource2().getUsername())
				.password(this.multitenancyProperties.getDatasource2().getPassword())
				.url(this.multitenancyProperties.getDatasource2().getUrl());
		return factory.build();
	}

	@Bean(name = "dataSource3")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource3")
	public DataSource dataSource3() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.multitenancyProperties.getDatasource3().getClassLoader())
				.driverClassName(this.multitenancyProperties.getDatasource3().getDriverClassName())
				.username(this.multitenancyProperties.getDatasource3().getUsername())
				.password(this.multitenancyProperties.getDatasource3().getPassword())
				.url(this.multitenancyProperties.getDatasource3().getUrl());
		return factory.build();
	}
}
