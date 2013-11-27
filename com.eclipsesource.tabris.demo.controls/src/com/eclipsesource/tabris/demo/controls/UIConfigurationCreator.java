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

import com.eclipsesource.tabris.ui.PageConfiguration;
import com.eclipsesource.tabris.ui.UIConfiguration;


public class UIConfigurationCreator {

  public static UIConfiguration create() {
    UIConfiguration configuration = new UIConfiguration();
    ExampleTab[] tabs = ControlsDemo.createExampleTabs();
    for( ExampleTab tab : tabs ) {
      PageConfiguration pageConfiguration = new PageConfiguration( tab.getId(), ExampleTabPage.class );
      pageConfiguration.setTitle( tab.getName() );
      pageConfiguration.setTopLevel( true );
      configuration.addPageConfiguration( pageConfiguration );
    }
    return configuration;
  }


  private UIConfigurationCreator() {
    // prevent instantiation
  }

}
