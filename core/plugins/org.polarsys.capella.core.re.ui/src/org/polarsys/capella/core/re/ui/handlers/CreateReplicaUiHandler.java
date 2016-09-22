/*******************************************************************************
 * Copyright (c) 2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.re.ui.handlers;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.capella.common.ef.command.ICommand;
import org.polarsys.capella.common.re.ui.handlers.uihead.UIHeadHandler;
import org.polarsys.capella.core.re.commands.CreateReplicaCommand;
import org.polarsys.capella.core.re.handlers.CreateReplicaHandler;
import org.polarsys.capella.core.transition.common.commands.DefaultCommand;

/**
 */
public class CreateReplicaUiHandler extends CreateReplicaHandler {

  /**
   * {@inheritDoc}
   */
  @Override
  protected ICommand createCommand(Collection<Object> selection, IProgressMonitor progressMonitor) {
    DefaultCommand command = new CreateReplicaCommand(selection, progressMonitor);
    command.addParameters(new UIHeadHandler(false));
    return command;
  }

  @Override
  public Object resolveSemanticObject(Object object) {
    Object semantic = super.resolveSemanticObject(object);
    if (semantic != null) {
      if (semantic instanceof DSemanticDecorator) {
        Object adapter = ((DSemanticDecorator) semantic).getTarget();
        if (adapter instanceof EObject) {
          semantic = adapter;
        }
      }
    }
    return semantic;
  }

}
