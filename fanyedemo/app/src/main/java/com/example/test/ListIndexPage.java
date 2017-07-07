package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.test.SensorManagerHelper.OnShakeListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListIndexPage extends Activity implements OnClickListener {

	private ListView list;
	Button btnLeft, btnRight;
	MoreAdapter ma;

	ArrayList<Map<String, Object>> attentionList;
	int VIEW_COUNT = 1;
	int index = 0;
	String[] info = { "sdfsf ","�������ڶ�ҳ","����������ҳ","�ٺ٣�����ҳ","��д��ҳ���������Լ��İ�"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		list = (ListView) this.findViewById(R.id.list);

		/* �洢��ʾ������ */
		attentionList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= 5; i++) {
			Map<String, Object> moreAttentionMap = new HashMap<String, Object>();
			moreAttentionMap.put("m_Attention", info[i-1]);
			attentionList.add(moreAttentionMap);
		}
		ma = new MoreAdapter(this, attentionList);
		list.setAdapter(ma);

		btnLeft = (Button) this.findViewById(R.id.btnLeft);
		btnRight = (Button) this.findViewById(R.id.btnRight);
		btnLeft.setOnClickListener(this);
		btnRight.setOnClickListener(this);
		// ���2��Button�Ƿ��ǿ��õ�
		checkButton();
		SensorManagerHelper sensorHelper = new SensorManagerHelper(this);
		sensorHelper.setOnShakeListener(new OnShakeListener() {

			@Override
			public void onShake() {
				// TODO Auto-generated method stub
				if (attentionList.size() - index * VIEW_COUNT <= VIEW_COUNT) {
					return;
				}else{
					rightView();
				}
			}
		});
	}

	private void checkButton() {
		// ����ֵС�ڵ���0����ʾ������ǰ��ҳ�ˣ��Ѿ����˵�һҳ�ˡ�
		// ����ǰ��ҳ�İ�ť��Ϊ�����á�
		if (index <= 0) {
			btnLeft.setEnabled(false);
		}
		/**
		 * ֵ�ĳ��ȼ�ȥǰ��ҳ�ĳ��ȣ�ʣ�µľ�����һҳ�ĳ��ȣ� �����һҳ�ĳ��ȱ�View_CountС�� ��ʾ��������һҳ�ˣ�������û���ˡ�
		 */
		// �����ҳ�İ�ť��Ϊ�����á�
		else if (attentionList.size() - index * VIEW_COUNT <= VIEW_COUNT) {
			btnRight.setEnabled(false);
		}
		// ����2����ť����Ϊ���õġ�
		else {
			btnLeft.setEnabled(true);
			btnRight.setEnabled(true);
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLeft:
			leftView();
			break;
		case R.id.btnRight:
			rightView();
			break;
		}

	}

	private void rightView() {
		index++;
		// ˢ��ListView�������ֵ��
		ma.notifyDataSetChanged();
		checkButton();
	}

	private void leftView() {
		index--;
		// ˢ��ListView�������ֵ��
		ma.notifyDataSetChanged();
		// ���Button�Ƿ���á�
		checkButton();
	}

	// ListView��Adapter������ǹؼ��ĵ��¿��Է�ҳ�ĸ���ԭ��
	public class MoreAdapter extends BaseAdapter {

		private Context context;
		private ArrayList<Map<String, Object>> attentionList;

		public MoreAdapter(ListIndexPage listIndexPage,
				ArrayList<Map<String, Object>> attentionList) {
			context = listIndexPage;
			this.attentionList = attentionList;
		}

		// ����ÿһҳ�ĳ��ȣ�Ĭ�ϵ���View_Count��ֵ��
		public int getCount() {

			// ori��ʾ��ĿǰΪֹ��ǰ��ҳ���ܹ��ĸ�����
			int ori = VIEW_COUNT * index;
			// ֵ���ܸ���-ǰ��ҳ�ĸ���������һҳҪ��ʾ�ĸ����������Ĭ�ϵ�ֵС��˵���������һҳ��ֻ����ʾ��ô��Ϳ�����
			if (attentionList.size() - ori < VIEW_COUNT) {
				return attentionList.size() - ori;
			}
			// �����Ĭ�ϵ�ֵ��Ҫ��˵��һҳ��ʾ���꣬��Ҫ�û�һҳ��ʾ����һҳ��Ĭ�ϵ�ֵ��ʾ���Ϳ����ˡ�
			else {
				return VIEW_COUNT;
			}

		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			TextView textView;
			if (convertView == null) {
				/** ʹ��listview.xmlΪÿһ��item��Layoutȡ��Id */
				LayoutInflater mInflater = LayoutInflater.from(context);
				convertView = mInflater.inflate(R.layout.listview, null);
				textView = new TextView(context);
				/** ʵ��������Ŀؼ� */
				textView = (TextView) convertView
						.findViewById(R.id.moreAttention);
				convertView.setTag(textView);
			} else {
				textView = (TextView) convertView.getTag();
			}
			textView.setText((String) attentionList.get(
					position + index * VIEW_COUNT).get("m_Attention"));
			return convertView;
		}

	}
}
