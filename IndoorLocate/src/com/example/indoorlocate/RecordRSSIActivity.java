package com.example.indoorlocate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecordRSSIActivity extends Activity {
	WifiManager wifiManager;
	WifiReceiver wifiReceiver;
	LinearLayout ll;
	List<ScanResult> scans;
	
	List<SignalReading> signals;
	Location loc;
	
	
	Button stopBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_record_rssi);
	    
	    ll = (LinearLayout)findViewById(R.id.rssi_list);
	    stopBtn = (Button)findViewById(R.id.record_btn);
	    
	    wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
	    wifiReceiver = new WifiReceiver();
	    wifiManager.startScan();

	    signals = new ArrayList<SignalReading>();
	    int locationId = getIntent().getIntExtra(CalibrateActivity.EXTRA_LOCATION_ID, -1);
	    loc = new Location(locationId, -1, -1, null);
	    
	    stopBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				for(int i=0;i<scans.size();i++){
					ScanResult sr = scans.get(i);
					if(sr.SSID != null && sr.BSSID != null){
						SignalReading signal = new SignalReading(null, sr.BSSID, sr.level, sr.SSID, loc);
						signals.add(signal);
					}
				}
				
				Toast.makeText(RecordRSSIActivity.this, "Signal Logged", Toast.LENGTH_LONG).show();
				
				for(long i = 0;i<1000000;i++){
					//do nothing
				}
				
				finish();
				
//				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		        ObjectOutputStream objectOutputStream = null;
//		        try {
//		            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//		            objectOutputStream.writeObject(signals);
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//		       if(objectOutputStream != null) {
//		    	   new HttpPostTask(objectOutputStream.toString()).execute();
//		       }
			}
		});
	 }
	
	@Override
	protected void onPause(){
		unregisterReceiver(wifiReceiver);
	    super.onPause();
	
	}
	
	@Override
	protected void onResume() {
	      registerReceiver(wifiReceiver, new IntentFilter(
	      WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	      super.onResume();
	}
	
	class WifiReceiver extends BroadcastReceiver {
        public void onReceive(Context c, Intent intent) {
            scans = wifiManager.getScanResults();
            for(int i = 0; i < scans.size(); i++){
                ScanResult sr = scans.get(i);
                TextView tv = new TextView(RecordRSSIActivity.this);
                tv.setText("AP: "+sr.BSSID+" SSID: "+sr.SSID+" RSSI: "+sr.level);
                ll.addView(tv);
            }
        }
    }
	
	class HttpPostTask extends AsyncTask<Void, Void, Void> {

		private String data;


		public HttpPostTask(String data){
			this.data = data;
		}
		
		
		@Override
		protected Void doInBackground(Void... params) {
			HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost("http://76.180.42.125/save_readings");

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		        System.out.println("------------------------------+++++++++++++++++");
		        System.out.println(data);
		        nameValuePairs.add(new BasicNameValuePair("data", data));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
		        
		        
		    } catch (ClientProtocolException e) {
		        // TODO Auto-generated catch block
		    	e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		    	e.printStackTrace();
		    	Log.e("IOError", e.getLocalizedMessage());
		    }

		return null;

		}
		
	}
}
