/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.platform.sirius.ui.services;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

public class PlatformSiriusServiceFactory extends AbstractServiceFactory {

  @Override
  public Object create(Class serviceInterface, IServiceLocator parentLocator, IServiceLocator locator) {
    if (IElementIdentifierService.class.equals(serviceInterface)) {
      return new ElementIdentifierService();
    }

    return null;
  }

}