package io.vksn.summons.ejb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.ejb.Singleton;

@Singleton
public class AuditLogger {
	private static Executor pool = Executors.newFixedThreadPool(5);
	private String user;

	public void setUser(String user) {
		this.user = user;
	}

	public void addEntryLog(final String entryPoint) {
		final String u = user;
		//SECURITY_WEAKNESS: weakness_4: use of Java SE concurrency API in Java EE context
		//SECURITY_WEAKNESS: weakness_23: Use of java.io package in EJB
		//SECURITY_WEAKNESS: weakness_24: Use of ClassLoader in EJB
		Runnable r = new Runnable() {
			@Override
			public void run() {
				FileWriter writer = null;
				try {
					URI logFile = this.getClass().getClassLoader().getResource(System.getProperty("user.dir")+ "/summons-audit.log").toURI();
					File log = new File(logFile);
					writer = new FileWriter(log);
					writer.write(System.nanoTime() + ":User "+ u +" Entering -> " + entryPoint);
					writer.flush();
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				finally {
					if(writer != null) {
						try {
							writer.close();
						} catch (IOException e) {}
					}
				}
			}
		};
		pool.execute(r);
	}
}
