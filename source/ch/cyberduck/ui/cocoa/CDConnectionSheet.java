package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2002 David Kocher. All rights reserved.
 *  http://icu.unizh.ch/~dkocher/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.Host;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.core.Session;
import com.apple.cocoa.application.*;
import com.apple.cocoa.foundation.*;
import org.apache.log4j.Logger;
import java.util.Iterator;
import ch.cyberduck.core.History;

/**
* @version $Id$
 */
public class CDConnectionSheet {
    private static Logger log = Logger.getLogger(CDConnectionSheet.class);

    private static final String FTP_STRING = "FTP (File Transfer)";
    private static final String SFTP_STRING = "SFTP (SSH Secure File Transfer)";
    
        // ----------------------------------------------------------
    // Outlets
    // ----------------------------------------------------------

    private NSWindow sheet;
    public void setSheet(NSWindow sheet) {
	this.sheet = sheet;
    }

    private NSPopUpButton protocolPopup;
    public void setProtocolPopup(NSPopUpButton protocolPopup) {
	this.protocolPopup = protocolPopup;
    }

    private NSPopUpButton hostPopup;
    public void setHostField(NSPopUpButton hostPopup) {
	this.hostPopup = hostPopup;
    }
    
//    private NSTextField pathField;
//    public void setPathField(NSTextField pathField) {
//	this.pathField = pathField;
//    }

    private NSTextField portField;
    public void setPortField(NSTextField portField) {
	this.portField = portField;
    }

    private NSTextField usernameField;
    public void setUsernameField(NSTextField usernameField) {
	this.usernameField = usernameField;
    }

    private NSTextField passField;
    public void setPassField(NSTextField passField) {
	this.passField = passField;
    }

    private NSTextField urlLabel;
    public void setUrlLabel(NSTextField urlLabel) {
	this.urlLabel = urlLabel;
    }

    public NSWindow window() {
	return this.sheet;
    }

    
    private CDBrowserController browser;
    // ----------------------------------------------------------
    // Constructors
    // ----------------------------------------------------------

    public CDConnectionSheet(CDBrowserController browser) {
	this.browser = browser;
	log.debug("CDConnectionSheet");
        if (false == NSApplication.loadNibNamed("Connection", this)) {
            log.fatal("Couldn't load Connection.nib");
            return;
        }
	this.init();
    }
            
    private void init() {
	log.debug("init");
	// Notify the textInputDidChange() method if the user types.
	NSNotificationCenter.defaultCenter().addObserver(
						    this,
						    new NSSelector("textInputDidChange", new Class[]{NSNotification.class}),
						    NSControl.ControlTextDidChangeNotification,
						    hostPopup);
//	NSNotificationCenter.defaultCenter().addObserver(
//						    this,
//						    new NSSelector("textInputDidChange", new Class[]{NSNotification.class}),
//						    NSControl.ControlTextDidChangeNotification,
//						    pathField);
	NSNotificationCenter.defaultCenter().addObserver(
						    this,
						    new NSSelector("textInputDidChange", new Class[]{NSNotification.class}),
						    NSControl.ControlTextDidChangeNotification,
						    portField);
	NSNotificationCenter.defaultCenter().addObserver(
						    this,
						    new NSSelector("textInputDidChange", new Class[]{NSNotification.class}),
						    NSControl.ControlTextDidChangeNotification,
						    usernameField);
        this.usernameField.setStringValue(Preferences.instance().getProperty("connection.login.name"));

	//initalizaing protcol popup
//	this.protocolPopup.removeAllItems();
//	this.protocolPopup.addItemsWithTitles(new NSArray(new String[]{FTP_STRING, SFTP_STRING}));
//	this.protocolPopup.itemWithTitle(FTP_STRING).setTag(Session.FTP_PORT);
//	this.protocolPopup.itemWithTitle(FTP_STRING).setKeyEquivalent("F");
//	this.protocolPopup.itemWithTitle(FTP_STRING).setKeyEquivalentModifierMask(NSEvent.CommandKeyMask);
//	this.protocolPopup.itemWithTitle(SFTP_STRING).setTag(Session.SSH_PORT);
//	this.protocolPopup.itemWithTitle(SFTP_STRING).setKeyEquivalent("S");
//	this.protocolPopup.itemWithTitle(SFTP_STRING).setKeyEquivalentModifierMask(NSEvent.CommandKeyMask);
	this.protocolPopup.setTitle(Preferences.instance().getProperty("connection.protocol.default").equals("ftp") ? FTP_STRING : SFTP_STRING);

	//initializing host popup
	Iterator i = History.instance().iterator();
	while(i.hasNext()) {
	    Host h = (Host)i.next();
	    hostPopup.addItem(h.getName());
	}
	
	this.portField.setIntValue(protocolPopup.selectedItem().tag());
//	this.pathField.setStringValue("~");
    }

    public void finalize() throws Throwable {
	super.finalize();
	log.debug("finalize");
        NSNotificationCenter.defaultCenter().removeObserver(this);
    }

    public void protocolSelectionChanged(Object sender) {
	log.debug("protocolSelectionChanged");
	NSMenuItem selectedItem = protocolPopup.selectedItem();
	if(selectedItem.tag() == Session.SSH_PORT)
	    portField.setIntValue(Session.SSH_PORT);
	if(selectedItem.tag() == Session.FTP_PORT)
	    portField.setIntValue(Session.FTP_PORT);
	this.textInputDidChange(null);
    }

    public void textInputDidChange(NSNotification sender) {
	NSMenuItem selectedItem = protocolPopup.selectedItem();
	String protocol = null;
	if(selectedItem.tag() == Session.SSH_PORT)
	    protocol = Session.SFTP+"://";
	else if(selectedItem.tag() == Session.FTP_PORT)
	    protocol = Session.FTP+"://";
	urlLabel.setStringValue(protocol+usernameField.stringValue()+"@"+hostPopup.stringValue()+":"+portField.stringValue());
    }

    public void closeSheet(NSButton sender) {
	log.debug("closeSheet");
	// Ends a document modal session by specifying the sheet window, sheet. Also passes along a returnCode to the delegate.
	NSApplication.sharedApplication().endSheet(this.window(), sender.tag());
    }
    
    public void connectionSheetDidEnd(NSWindow sheet, int returncode, NSWindow main) {
	log.debug("connectionSheetDidEnd");
	sheet.orderOut(null);
	switch(returncode) {
	    case(NSAlertPanel.DefaultReturn):
		int tag = protocolPopup.selectedItem().tag();
		Host host = null;
		switch(tag) {
		    case(Session.SSH_PORT):
			try {
			    host = new Host(Session.SFTP, hostPopup.stringValue(), Integer.parseInt(portField.stringValue()), new CDLoginController(browser.window(), usernameField.stringValue(), passField.stringValue()));
			    host.setHostKeyVerification(new CDHostKeyController(browser.window()));
			}
			    catch(com.sshtools.j2ssh.transport.InvalidHostFileException e) {
		//This exception is thrown whenever an exception occurs open or reading from the host file.
				NSAlertPanel.beginCriticalAlertSheet(
				 "Error", //title
				 "OK",// defaultbutton
				 null,//alternative button
				 null,//other button
				 browser.window(), //docWindow
				 null, //modalDelegate
				 null, //didEndSelector
				 null, // dismiss selector
				 null, // context
				 "Could not open or read the host file: "+e.getMessage() // message
				 );
			    }
			    break;
		    case(Session.FTP_PORT):
			host = new Host(Session.FTP, hostPopup.stringValue(), Integer.parseInt(portField.stringValue()), new CDLoginController(browser.window(), usernameField.stringValue(), passField.stringValue()));
			break;
		    default:
			throw new IllegalArgumentException("No protocol selected.");
		}

		    browser.mount(host);
		    
	case(NSAlertPanel.AlternateReturn):
		//
	}
    }
}
