package guice.sank.rest.app.server;

public interface TestServer {
	String getServerUrl();
	void start() throws Exception;
	void stop() throws Exception;
	boolean isStarted();
	boolean isFailed();
}
