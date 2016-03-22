package io.vksn.summons.ejb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		Runnable r = new Runnable() {
			@Override
			public void run() {
				FileWriter writer = null;
				File log = new File(System.getProperty("user.dir")+ "/summons-audit.log");
				try {
					writer = new FileWriter(log);
					writer.write(System.nanoTime() + ":User "+ u +" Entering -> " + entryPoint);
					writer.flush();
				} catch (IOException e) {
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
