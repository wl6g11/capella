/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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

package org.polarsys.capella.core.semantic.queries.basic.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.fa.SequenceLinkEnd;
import org.polarsys.capella.core.model.helpers.SequenceLinkEndExt;

public class SequenceLinkEndTargetSequenceLinks implements IQuery {

  public SequenceLinkEndTargetSequenceLinks() {
    // do nothing
  }

  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    if (object instanceof SequenceLinkEnd) {
      SequenceLinkEnd sequenceLinkEnd = (SequenceLinkEnd) object;
      return new ArrayList<>(SequenceLinkEndExt.getOutgoingSequenceLinks(sequenceLinkEnd));
    }
    return Collections.emptyList();
  }
}
