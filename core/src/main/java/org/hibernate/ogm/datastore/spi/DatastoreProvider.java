/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * JBoss, Home of Professional Open Source
 * Copyright 2011-2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.ogm.datastore.spi;

import org.hibernate.ogm.dialect.GridDialect;
import org.hibernate.ogm.service.impl.QueryParserService;
import org.hibernate.service.Service;

/**
 * Provides datastore centric configurations and native access.
 * <p>
 * Implementations of this service offer native interfaces to access the underlying datastore. It is also responsible
 * for starting and stopping the connection to the datastore.
 *
 * @author Emmanuel Bernard <emmanuel@hibernate.org>
 * @author Gunnar Morling
 */
public interface DatastoreProvider extends Service {

	Class<? extends GridDialect> getDefaultDialect();

	/**
	 * Returns the type of {@link QueryParserService} to be used for executing queries against the underlying datastore
	 * if no parser service type was explicitly configured by the user via the
	 * {@link org.hibernate.ogm.cfg.OgmConfiguration#OGM_QUERY_PARSER_SERVICE} option.
	 *
	 * @return the default {@link QueryParserService} for the underlying datastore; never {@code null}
	 */
	Class<? extends QueryParserService> getDefaultQueryParserServiceType();
}
