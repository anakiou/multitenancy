package com.anakiou.mt.util;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 8168907057647334460L;
	private static final String DEFAULT_TENANT_ID = "tenant_1";

	@Autowired
	private DataSource dataSource1;

	@Autowired
	private DataSource dataSource2;

	@Autowired
	private DataSource dataSource3;

	private Map<String, DataSource> map;

	@PostConstruct
	public void load() {
		map = new HashMap<>();
		map.put("tenant_1", dataSource1);
		map.put("tenant_2", dataSource2);
		map.put("tenant_3", dataSource3);
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return map.get(DEFAULT_TENANT_ID);
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		return map.get(tenantIdentifier);
	}
}
