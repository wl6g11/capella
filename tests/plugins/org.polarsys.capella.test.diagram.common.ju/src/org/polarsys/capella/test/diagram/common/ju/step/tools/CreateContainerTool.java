/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.diagram.common.ju.step.tools;

import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.ArgumentType;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.DiagramHelper;

public class CreateContainerTool extends AbstractToolStep<DDiagramElementContainer> {

  String containerView;
  String newIdentifier;

  Collection<DDiagramElement> _elements;
  Collection<DDiagramElement> _newElements;

  public CreateContainerTool(DiagramContext context, String toolName, String containerView_p) {
    super(context, toolName);
    containerView = containerView_p;
  }

  public CreateContainerTool(DiagramContext context, String toolName, String newIdentifier_p, String containerView_p) {
    this(context, toolName, containerView_p);
    newIdentifier = newIdentifier_p;
  }

  @Override
  protected void preRunTest() {
    super.preRunTest();
    DSemanticDecorator element = getExecutionContext().getView(containerView);
    _elements = DiagramHelper.getOwnedElements(element);
  }

  @Override
  protected void dispose() {
    super.dispose();
    _elements = null;
    _newElements = null;
  }

  @Override
  protected void postRunTest() {
    super.postRunTest();
    DSemanticDecorator element = getExecutionContext().getView(containerView);
    _newElements = DiagramHelper.getOwnedElements(element);
    _newElements.removeAll(_elements);

    if (_newElements.size() != 1) {
      assertFalse(true);
    }
    if (!(_newElements.iterator().next() instanceof DDiagramElementContainer)) {
      assertFalse(true);
    }

  }

  @Override
  public DDiagramElementContainer getResult() {
    DDiagramElementContainer view = (DDiagramElementContainer) _newElements.iterator().next();
    if (newIdentifier != null) {
      getExecutionContext().putSemanticElement(newIdentifier, view.getTarget());
      getExecutionContext().putView(newIdentifier, view);
    }
    return view;
  }

  @Override
  protected void initToolArguments() {
    DSemanticDecorator element = getExecutionContext().getView(containerView);
    _toolWrapper.setArgumentValue(ArgumentType.CONTAINER, element.getTarget());
    _toolWrapper.setArgumentValue(ArgumentType.CONTAINER_VIEW, element);
  }
}
