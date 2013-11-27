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

import org.eclipse.rap.demo.controls.ExampleTab;
import org.eclipse.rap.rwt.SingletonUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.eclipsesource.tabris.ui.AbstractPage;
import com.eclipsesource.tabris.ui.PageData;
import com.eclipsesource.tabris.widgets.ScrollingComposite;


public class ExampleTabPage extends AbstractPage {

  private final ExampleTabHolder tabHolder;
  private ExampleTab tab;
  private Composite parent;

  public ExampleTabPage() {
    tabHolder = SingletonUtil.getSessionInstance( ExampleTabHolder.class );
  }

  @Override
  public void createContent( Composite parent, PageData data ) {
    this.parent = parent;
  }

  @Override
  public void activate() {
    if( tab == null ) {
      String currentPageId = getUI().getPageOperator().getCurrentPageId();
      tab = tabHolder.getTab( currentPageId );
      ScrollingComposite container = new ScrollingComposite( parent, SWT.H_SCROLL | SWT.V_SCROLL );
      container.setLayout( new FillLayout() );
      tab.createContents( container );
      container.getParent().layout( true, true );
    }
    parent.layout( true );
  }

}
