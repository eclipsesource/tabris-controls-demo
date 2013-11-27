/*******************************************************************************
 * Copyright (c) 2008, 2012 Innoopract Informationssysteme GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Innoopract Informationssysteme GmbH - initial API and implementation
 *    EclipseSource - ongoing development
 ******************************************************************************/
package org.eclipse.rap.demo.controls;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


class DateTimeTab extends ExampleTab {

  private static final String PROP_CONTEXT_MENU = "contextMenu";
  private static final String PROP_SELECTION_LISTENER = "selectionListener";
  DateTime dateTime1;
  Group group1, group2;

  DateTimeTab() {
    super( "DateTime" );
    setDefaultStyle( SWT.BORDER | SWT.DATE | SWT.MEDIUM );
  }

  @Override
  protected void createStyleControls( Composite parent ) {
    group1 = new Group( styleComp, SWT.SHADOW_IN );
    group1.setText( "Type" );
    group1.setLayout( new RowLayout( SWT.VERTICAL ) );
    createStyleButton( group1, "DATE", SWT.DATE, SWT.RADIO, true );
    createStyleButton( group1, "TIME", SWT.TIME, SWT.RADIO, false );
    createStyleButton( group1, "CALENDAR", SWT.CALENDAR, SWT.RADIO, false );
    group2 = new Group( styleComp, SWT.SHADOW_IN );
    group2.setText( "Details" );
    group2.setLayout( new RowLayout( SWT.VERTICAL ) );
    createStyleButton( group2, "SHORT", SWT.SHORT, SWT.RADIO, false );
    createStyleButton( group2, "MEDIUM", SWT.MEDIUM, SWT.RADIO, true );
    createStyleButton( group2, "LONG", SWT.LONG, SWT.RADIO, false );
    createStyleButton( "DROP_DOWN", SWT.DROP_DOWN, false );
    createStyleButton( "BORDER", SWT.BORDER, true );
    createVisibilityButton();
    createEnablementButton();
    createFontChooser();
    createFgColorButton();
    createBgColorButton();
    createPropertyCheckbox( "Add Context Menu", PROP_CONTEXT_MENU );
    createPropertyCheckbox( "Add Selection Listener", PROP_SELECTION_LISTENER );
  }

  @Override
  protected void createExampleControls( Composite parent ) {
    parent.setLayout( new RowLayout( SWT.VERTICAL ) );
    int style = getStyle() | getStyle( group1 ) | getStyle( group2 );
    /* Create the example widgets */
    dateTime1 = new DateTime( parent, style );
    if( hasCreateProperty( PROP_CONTEXT_MENU ) ) {
      Menu dateTimeMenu = new Menu( dateTime1 );
      MenuItem dateTimeMenuItem = new MenuItem( dateTimeMenu, SWT.PUSH );
      dateTimeMenuItem.addSelectionListener( new SelectionAdapter() {

        @Override
        public void widgetSelected( final SelectionEvent event ) {
          String message = "You requested a context menu for the DateTime";
          MessageDialog.openInformation( dateTime1.getShell(),
                                         "Information",
                                         message );
        }
      } );
      dateTimeMenuItem.setText( "DateTime context menu item" );
      dateTime1.setMenu( dateTimeMenu );
    }
    if( hasCreateProperty( PROP_SELECTION_LISTENER ) ) {
      dateTime1.addSelectionListener( new SelectionListener() {

        public void widgetSelected( final SelectionEvent event ) {
          String message = "DateTime WidgetSelected! Selected date: "
            + dateTime1.getDay()
            + "/" + ( dateTime1.getMonth() + 1 )
            + "/" + dateTime1.getYear()
            + " " + dateTime1.getHours()
            + ":" + dateTime1.getMinutes()
            + ":" + dateTime1.getSeconds();
          log( message );
        }

        public void widgetDefaultSelected( final SelectionEvent event ) {
          String message = "DateTime WidgetDefaultSelected!";
          log( message );
        }
      } );
    }
    registerControl( dateTime1 );
  }

  protected Button createStyleButton( Composite parent,
                                      String name,
                                      int style,
                                      int buttonStyle,
                                      boolean checked )
  {
    Button button = new Button( parent, buttonStyle );
    button.setText( name );
    button.addSelectionListener( new SelectionAdapter() {

      @Override
      public void widgetSelected( final SelectionEvent event ) {
        createNew();
      }
    } );
    button.setData( "style", new Integer( style ) );
    button.setSelection( checked );
    return button;
  }

  protected int getStyle( Composite comp ) {
    int result = SWT.NONE;
    if( checkControl( comp ) ) {
      Control[] ctrls = comp.getChildren();
      if( ctrls.length != 0 ) {
        for( int i = 0; i < ctrls.length; i++ ) {
          if( ctrls[ i ] instanceof Button ) {
            Button button = ( Button )ctrls[ i ];
            if( button.getSelection() ) {
              Object data = button.getData( "style" );
              if( data != null && data instanceof Integer ) {
                int style = ( ( Integer )data ).intValue();
                result |= style;
              }
            }
          }
        }
      }
    }
    return result;
  }
}
