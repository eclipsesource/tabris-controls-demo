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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.Application.OperationMode;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;

import com.eclipsesource.tabris.TabrisClientInstaller;
import com.eclipsesource.tabris.ui.TabrisUIEntrypointFactory;


public class AppConfiguration implements ApplicationConfiguration {

  @Override
  public void configure( Application application ) {
    TabrisClientInstaller.install( application );
    Map<String, String> properties = new HashMap<String, String>();
    properties.put( WebClient.PAGE_TITLE, "RWT Controls Demo" );
    application.setOperationMode( OperationMode.SWT_COMPATIBILITY );
    application.addEntryPoint( "/controls", new TabrisUIEntrypointFactory( UIConfigurationCreator.create() ), null );
  }
}
