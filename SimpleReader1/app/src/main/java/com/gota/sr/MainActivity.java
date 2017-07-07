package com.gota.sr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	ReadView readView;
	BufferedReader reader;
	CharBuffer buffer = CharBuffer.allocate(8000);
	int position;
	Button btPre;
	private int currentPageNum;
	private int lastPageNum;
	private String tag = MainActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btPre = (Button) findViewById(R.id.main_bt_prev);
		readView = (ReadView) findViewById(R.id.read_view);
		
		loadBook();
		loadPage(0);
		btPre.requestFocus();
	}

	/**
	 * 将电子书都一部分到缓冲区
	 */
	private void loadBook() {
		AssetManager assets = getAssets();
		try {
			InputStream in = assets.open("documents/The Golden Compass.txt");
			Charset charset = CharsetDetector.detect(in);
			reader = new BufferedReader(new InputStreamReader(in, charset));
			reader.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从指定位置开始载入一页
	 */
	private void loadPage(int position) {
		buffer.position(position);
		readView.setText(buffer);
	}
	
	/**
	 * 上一页按钮
	 */
	public void previewPageBtn(View view) {
		currentPageNum = readView.getCharNum();
		position -= currentPageNum;
		if(position < 0){
			position = 0;
		}
		Log.i(tag,"MainActivity.previewPageBtn currentPageNum: "+currentPageNum+
				", position: "+position);
		loadPage(position);
	}
	
	/**
	 * 下一页按钮
	 */
	public void nextPageBtn(View view) {
		currentPageNum = readView.getCharNum();
		position += currentPageNum;
		Log.i(tag,"MainActivity.nextPageBtn currentPageNum: "+currentPageNum+
		", position: "+position);
		loadPage(position);
//		readView.resize();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
