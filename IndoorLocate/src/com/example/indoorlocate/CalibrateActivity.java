package com.example.indoorlocate;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CalibrateActivity extends Activity {

	//final int noOfLocations = 16;
	LocationCoordinates locations[] = new LocationCoordinates[16];
	int actionBarHeight;
	
	public static final String EXTRA_LOCATION_ID = "com.example.indoorlocate.locationid";
	
//	public void initializeLocation(){
//		locations = new Location[16];
//		for(Location l:locations)
//			l = new Location();
//		
//		locations[0].label = "C101";
//		locations[0].X1 = 90;locations[0].Y1 = 470;
//		locations[0].X2 = 153;locations[0].Y2 = 505;
//		
//		locations[1].label = "C100";
//		locations[1].X1 = 159;locations[1].Y1 = 396;
//		locations[1].X2 = 181;locations[1].Y2 = 470;
//		
//		locations[2].label = "S103";
//		locations[2].X1 = 157;locations[2].Y1 = 280;
//		locations[2].X2 = 200;locations[2].Y2 = 361;
//		
//		locations[3].label = "101";
//		locations[3].X1 = 64;locations[3].Y1 = 324;
//		locations[3].X2 = 94;locations[3].Y2 = 382;
//		
//		locations[4].label = "101 NE";
//		locations[4].X1 = 100;locations[4].Y1 = 255;
//		locations[4].X2 = 147;locations[4].Y2 = 330;
//		
//		locations[5].label = "101 SE";
//		locations[5].X1 = 120;locations[5].Y1 = 380;
//		locations[5].X2 = 144;locations[5].Y2 = 441;
//		
//		locations[6].label = "C102";
//		locations[6].X1 = 147;locations[6].Y1 = 178;
//		locations[6].X2 = 195;locations[6].Y2 = 234;
//		
//		locations[7].label = "C100B";
//		locations[7].X1 = 157;locations[7].Y1 = 118;
//		locations[7].X2 = 193;locations[7].Y2 = 160;
//		
//		locations[8].label = "106";
//		locations[8].X1 = 115;locations[8].Y1 = 94;
//		locations[8].X2 = 148;locations[8].Y2 = 138;
//		
//		locations[9].label = "106W";
//		locations[9].X1 = 55;locations[9].Y1 = 82;
//		locations[9].X2 = 94;locations[9].Y2 = 109;
//		
//		locations[10].label = "106S";
//		locations[10].X1 = 57;locations[10].Y1 = 123;
//		locations[10].X2 = 93;locations[10].Y2 = 144;
//		
//		locations[11].label = "106C";
//		locations[11].X1 = 70;locations[11].Y1 = 153;
//		locations[11].X2 = 133;locations[11].Y2 = 174;
//		
//		locations[12].label = "113A N";
//		locations[12].X1 = 196;locations[12].Y1 = 85;
//		locations[12].X2 = 235;locations[12].Y2 = 114;
//		
//		locations[13].label = "113A S";
//		locations[13].X1 = 198;locations[13].Y1 = 121;
//		locations[13].X2 = 238;locations[13].Y2 = 142;
//		
//		locations[14].label = "C115 W";
//		locations[14].X1 = 247;locations[14].Y1 = 160;
//		locations[14].X2 = 339;locations[14].Y2 = 183;
//		
//		locations[15].label = "C115";
//		locations[15].X1 = 354;locations[15].Y1 = 150;
//		locations[15].X2 = 484;locations[15].Y2 = 177;
//	}
	
	
	ImageView map;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibrate);
        
        //Location[] locations = new Location[16];
        for(int j=0;j<16;j++){
        	locations[j] = new LocationCoordinates();
        }
        
//        locations[0].label = "C101";
//		locations[0].X1 = 46;locations[0].Y1 = 322;
//		locations[0].X2 = 82;locations[0].Y2 = 352;
//		
//		locations[1].label = "C100";
//		locations[1].X1 = 83;locations[1].Y1 = 267;
//		locations[1].X2 = 98;locations[1].Y2 = 320;
//		
//		locations[2].label = "S103";
//		locations[2].X1 = 79;locations[2].Y1 = 203;
//		locations[2].X2 = 101;locations[2].Y2 = 252;
//		
//		locations[3].label = "101";
//		locations[3].X1 = 27;locations[3].Y1 = 224;
//		locations[3].X2 = 53;locations[3].Y2 = 262;
//		
//		locations[4].label = "101 NE";
//		locations[4].X1 = 51;locations[4].Y1 = 186;
//		locations[4].X2 = 71;locations[4].Y2 = 234;
//		
//		locations[5].label = "101 SE";
//		locations[5].X1 = 57;locations[5].Y1 = 277;
//		locations[5].X2 = 72;locations[5].Y2 = 296;
//		
//		locations[6].label = "C102";
//		locations[6].X1 = 73;locations[6].Y1 = 133;
//		locations[6].X2 = 104;locations[6].Y2 = 181;
//		
//		locations[7].label = "C100B";
//		locations[7].X1 = 83;locations[7].Y1 = 84;
//		locations[7].X2 = 97;locations[7].Y2 = 108;
//		
//		locations[8].label = "106";
//		locations[8].X1 = 53;locations[8].Y1 = 63;
//		locations[8].X2 = 74;locations[8].Y2 = 78;
//		
//		locations[9].label = "106W";
//		locations[9].X1 = 26;locations[9].Y1 = 54;
//		locations[9].X2 = 51;locations[9].Y2 = 74;
//		
//		locations[10].label = "106S";
//		locations[10].X1 = 30;locations[10].Y1 = 83;
//		locations[10].X2 = 55;locations[10].Y2 = 95;
//		
//		locations[11].label = "106C";
//		locations[11].X1 = 34;locations[11].Y1 = 107;
//		locations[11].X2 = 74;locations[11].Y2 = 123;
//		
//		locations[12].label = "113A N";
//		locations[12].X1 = 103;locations[12].Y1 = 58;
//		locations[12].X2 = 124;locations[12].Y2 = 80;
//		
//		locations[13].label = "113A S";
//		locations[13].X1 = 103;locations[13].Y1 = 85;
//		locations[13].X2 = 126;locations[13].Y2 = 101;
//		
//		locations[14].label = "C115 W";
//		locations[14].X1 = 137;locations[14].Y1 = 108;
//		locations[14].X2 = 197;locations[14].Y2 = 120;
//		
//		locations[15].label = "C115";
//		locations[15].X1 = 210;locations[15].Y1 = 109;
//		locations[15].X2 = 271;locations[15].Y2 = 119;
		
		locations[0].label = "C101";
		locations[0].X1 = 79;locations[0].Y1 = 555;
		locations[0].X2 = 121;locations[0].Y2 = 607;
		
		locations[1].label = "C100";
		locations[1].X1 = 129;locations[1].Y1 = 450;
		locations[1].X2 = 158;locations[1].Y2 = 554;
		
		locations[2].label = "S103";
		locations[2].X1 = 123;locations[2].Y1 = 357;
		locations[2].X2 = 153;locations[2].Y2 = 422;
		
		locations[3].label = "101";
		locations[3].X1 = 37;locations[3].Y1 = 397;
		locations[3].X2 = 85;locations[3].Y2 = 461;
		
		locations[4].label = "101 NE";
		locations[4].X1 = 78;locations[4].Y1 = 331;
		locations[4].X2 = 105;locations[4].Y2 = 382;
		
		locations[5].label = "101 SE";
		locations[5].X1 = 77;locations[5].Y1 = 487;
		locations[5].X2 = 107;locations[5].Y2 = 535;
		
		locations[6].label = "C102";
		locations[6].X1 = 106;locations[6].Y1 = 222;
		locations[6].X2 = 165;locations[6].Y2 = 305;
		
		locations[7].label = "C100B";
		locations[7].X1 = 131;locations[7].Y1 = 136;
		locations[7].X2 = 152;locations[7].Y2 = 164;
		
		locations[8].label = "106";
		locations[8].X1 = 82;locations[8].Y1 = 106;
		locations[8].X2 = 113;locations[8].Y2 = 148;
		
		locations[9].label = "106W";
		locations[9].X1 = 45;locations[9].Y1 = 90;
		locations[9].X2 = 75;locations[9].Y2 = 130;
		
		locations[10].label = "106S";
		locations[10].X1 = 49;locations[10].Y1 = 142;
		locations[10].X2 = 97;locations[10].Y2 = 168;
		
		locations[11].label = "106C";
		locations[11].X1 = 68;locations[11].Y1 = 182;
		locations[11].X2 = 110;locations[11].Y2 = 206;
		
		locations[12].label = "113A N";
		locations[12].X1 = 162;locations[12].Y1 = 91;
		locations[12].X2 = 193;locations[12].Y2 = 133;
		
		locations[13].label = "113A S";
		locations[13].X1 = 165;locations[13].Y1 = 138;
		locations[13].X2 = 188;locations[13].Y2 = 171;
		
		locations[14].label = "C115 W";
		locations[14].X1 = 202;locations[14].Y1 = 177;
		locations[14].X2 = 302;locations[14].Y2 = 203;
		
		locations[15].label = "C115";
		locations[15].X1 = 334;locations[15].Y1 = 182;
		locations[15].X2 = 407;locations[15].Y2 = 204;
		
		
		
		actionBarHeight = 56;
        
        map = (ImageView)findViewById(R.id.map);
        
//        map.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				int[] values = new int[2]; 
//	            arg0.getLocationOnScreen(values);
//	            
//	            int X = values[0];
//				int Y = values[1];
//				
//				Toast.makeText(CalibrateActivity.this,X+" "+Y,Toast.LENGTH_LONG).show();
//				
//				int region = -1;
//				
//				for(int i=0;i<16;i++){
//					if(locations[i].X1<=X && locations[i].Y1<=Y 
//							&& locations[i].X2>=X && locations[i].Y2>=Y){
//						region = i;
//						break;
//					}
//				}
//				
//				if(region != -1){
//					Toast.makeText(CalibrateActivity.this, getResources().getIdentifier("loc"+region, "string", getPackageName()), Toast.LENGTH_LONG).show();
//				}
//			}
//		});
        
        
        map.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					int X = (int)event.getX();
					int Y = (int)event.getY();
					
					//Toast.makeText(CalibrateActivity.this,X+" "+Y,Toast.LENGTH_SHORT).show();
					
					int region = -1;
					
					for(int i=0;i<16;i++){
						if(locations[i].X1<=X && locations[i].Y1<=Y 
								&& locations[i].X2>=X && locations[i].Y2>=Y){
							region = i;
							break;
						}
					}
					
					if(region != -1){
						String msg = "Collecting RSSI at "+locations[region].label;
						Toast.makeText(CalibrateActivity.this, msg, Toast.LENGTH_SHORT).show();
						
						Intent i = new Intent(CalibrateActivity.this,RecordRSSIActivity.class);
						i.putExtra(CalibrateActivity.EXTRA_LOCATION_ID, region);
						startActivity(i);
						
					}
				}
				return true;
			}
		});
        
    }
}
