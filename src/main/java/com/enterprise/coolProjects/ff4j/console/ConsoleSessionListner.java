package com.enterprise.coolProjects.ff4j.console;

/*import com.capitalone.enterprisecustomerservicing.ff4j.BankFeatureToggleConsoleHelper;
import org.ff4j.web.embedded.ConsoleConstants;*/

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session listener is added as we need to destroy  client in the event of session is destroyed
 *
 */
public class ConsoleSessionListner implements HttpSessionListener {
	

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

}
