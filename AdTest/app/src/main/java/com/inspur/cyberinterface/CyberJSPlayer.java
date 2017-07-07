package com.inspur.cyberinterface;

public interface CyberJSPlayer {
	
	public int create(String jsonParam);

	public int destroy(int handle);

	public int start(int handle, String parameter);

	public int stop(int handle);

	public int pause(int handle);

	public int resume(int handle);

	public int forward(int handle, int scale);

	public int backward(int handle, int scale);

	public int seek(int handle, int seconds);

	public int mute(int handle);

	public int unmute(int handle);

	public int enableSubtitle(int handle);

	public int disableSubtitle(int handle);

	public int getSubtitleStatus(int handle);

	public int set(int handle, String parmeter);

	public String get(int handle, String parameter);
	

}
