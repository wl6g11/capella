/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.data.information.properties.fields;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import org.polarsys.capella.core.data.information.CollectionKind;
import org.polarsys.capella.core.data.information.properties.Messages;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticKindGroup;

/**
 */
public class CollectionKindGroup extends AbstractSemanticKindGroup {
  private Button _collectionBtnArray;
  private Button _collectionBtnSequence;

  /**
   * Constructor.
   * @param parent
   * @param widgetFactory
   */
  public CollectionKindGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
    super(parent, widgetFactory, Messages.getString("CollectionKind.Label"), 2); //$NON-NLS-1$

    _collectionBtnArray = createButton(CollectionKind.ARRAY);
    _collectionBtnSequence = createButton(CollectionKind.SEQUENCE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Button> getSemanticFields() {
    List<Button> fields = new ArrayList<Button>();

    fields.add(_collectionBtnArray);
    fields.add(_collectionBtnSequence);
    
    return fields;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Button getDefaultSemanticField() {
    return _collectionBtnArray;
  }
}
