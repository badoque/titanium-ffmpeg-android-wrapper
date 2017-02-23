package com.badoque.ffmpeg.android;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollObject;
import org.appcelerator.kroll.KrollDict;

import com.github.hiteshsondhi88.libffmpeg.*;

import java.util.HashMap;


@Kroll.module(name="FfmpegAndroidWrapper", id="com.badoque.ffmpeg.android")
public class FfmpegAndroidWrapperModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "FfmpegAndroidWrapperModule";
	private static final boolean DBG = TiConfig.LOGD;

	private KrollFunction successCallback;
	private KrollFunction errorCallback;

	public FfmpegAndroidWrapperModule()
	{
		super();
		
		TiApplication appContext = TiApplication.getInstance();
		FFmpeg ffmpeg = FFmpeg.getInstance(appContext);
		try {
		  ffmpeg.loadBinary(new LoadBinaryResponseHandler() {
		
		    @Override
		    public void onStart() {}
		
		    @Override
		    public void onFailure() {}
		
		    @Override
		    public void onSuccess() {}
		
		    @Override
		    public void onFinish() {}
		  });
		} catch (Exception e) {
		  // Handle if FFmpeg is not supported by device
		}
	}
	
	// Methods
	@Kroll.method
	public void execute(KrollDict options)
	{	
		String cmd = (String) options.get("cmd");
		successCallback = (KrollFunction) options.get("successCallback");
		errorCallback = (KrollFunction) options.get("errorCallback");
		
		TiApplication appContext = TiApplication.getInstance();
		FFmpeg ffmpeg = FFmpeg.getInstance(appContext);
		try {
		    String[] command = cmd.split(" ");
		    
		  	ffmpeg.execute(command, new ExecuteBinaryResponseHandler() {
		
		    @Override
		    public void onStart() {}
		
		    @Override
		    public void onProgress(String message) {}

		    @Override
		    public void onFailure(String message) {
		    	Log.e(LCAT, message);
					HashMap<String, String> args = new HashMap<String, String>();
		    	args.put("error", message);
					errorCallback.call(getKrollObject(), args);
		   	}
				
		    @Override
		    public void onSuccess(String message) {				
					HashMap<String, String> args = new HashMap<String, String>();
					args.put("sucess", message);
					successCallback.call(getKrollObject(), args);
		    }
				
		    @Override
		    public void onFinish() {}
		  });
		} catch (Exception e) {
			HashMap<String, String> args = new HashMap<String, String>();
		  args.put("error", "Cannot run ffmpeg");
			errorCallback.call(getKrollObject(), args);
		}
	}

}

