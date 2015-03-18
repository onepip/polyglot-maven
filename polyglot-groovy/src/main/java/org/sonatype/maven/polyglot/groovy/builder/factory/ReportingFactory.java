/**
 * Copyright (c) 2012 to original author or authors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.sonatype.maven.polyglot.groovy.builder.factory;

import groovy.util.FactoryBuilderSupport;
import org.apache.maven.model.Reporting;

import java.util.Map;

/**
 * Builds {@link org.apache.maven.model.Reporting} nodes.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 *
 * @since 0.7
 */
public class ReportingFactory extends NamedFactory {
  public ReportingFactory() {
    super("reporting");
  }

  public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attrs) throws InstantiationException, IllegalAccessException {
    builder.getContext().put(Reporting.class.getName(), true);
    return new Reporting();
  }

  @Override
  public void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    builder.getContext().remove(Reporting.class.getName());
  }
}