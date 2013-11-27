/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.tabris.demo.controls;

import org.eclipse.rap.demo.controls.ControlsDemo;
import org.eclipse.rap.demo.controls.ExampleTab;


public class ExampleTabHolder {

  private final ExampleTab[] tabs;

  public ExampleTabHolder() {
    tabs = ControlsDemo.createExampleTabs();
  }

  public ExampleTab getTab( String id ) {
    for( ExampleTab tab : tabs ) {
      if( tab.getId().equals( id ) ) {
        return tab;
      }
    }
    return null;
  }
}
