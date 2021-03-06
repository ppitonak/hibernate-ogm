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
package org.hibernate.ogm.test.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Rule;
import org.junit.Test;

import org.hibernate.ogm.test.utils.PackagingRule;
import org.hibernate.ogm.test.utils.TestHelper;

/**
 * @author Emmanuel Bernard <emmanuel@hibernate.org>
 * @author Sanne Grinovero <sanne@hibernate.org>
 */
public class JPAStandaloneORMAndOGMTest {

	@Rule
	public PackagingRule ogmPackaging = new PackagingRule( "persistencexml/jpajtastandalone-ormogm.xml", Poem.class );

	@Test
	//Test for OGM-416 (avoid StackOverFlow when both an OGM and ORM PU are used
	public void testJTAStandaloneNoOgm() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpajtastandalone", TestHelper.getEnvironmentProperties() );
		emf.close();
		emf = Persistence.createEntityManagerFactory( "jpajtastandalone-noogm" );
		emf.close();
	}

}
