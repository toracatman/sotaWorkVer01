//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;
import	java.awt.Color;
import	java.io.IOException;
import	org.jsoup.Jsoup;
import	org.jsoup.nodes.Document;
import	org.jsoup.nodes.Element;
import	org.jsoup.select.Elements;
import	java.time.*;
import	java.io.BufferedReader;
import	java.io.InputStream;
import	java.io.InputStreamReader;
import	java.net.HttpURLConnection;
import	java.net.URL;
import	javax.script.ScriptEngine;
import	javax.script.ScriptEngineManager;
import	javax.script.ScriptException;

public class mymain
{

	public CPlayWave cplay;
	public String speechRecogResult;
	public RecogResult recogresult;
	public long noDetectDuration;
	public CRobotPose pose;
	public String date_string;
	public String time_string;
	public LocalDateTime localDateTime;
	public int getDateTimeElement;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,672,32,False,10,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CPlayWave cplay*/;																							//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,9,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,8,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,7,break@</BlockInfo>
																														//@<EndOfBlock/>
		noDetectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,6,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,480,32,480,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*LocalDateTime localDateTime*/;																				//@<BlockInfo>jp.vstone.block.variable,544,32,544,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int getDateTimeElement*/;																						//@<BlockInfo>jp.vstone.block.variable,608,32,608,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void faceTracking()																							//@<BlockInfo>jp.vstone.block.func,32,304,1248,304,False,23,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,96,304,1184,304,False,22,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.thread,160,304,416,304,False,21,スレッド@</BlockInfo>
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							
							
																														//@<OutputChild>
							while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,224,304,352,304,False,12,Endless@</BlockInfo>
							{
							
																																	//@<OutputChild>
								noDetectDuration = GlobalVariable.robocam.getNotDetectDuration();									//@<BlockInfo>jp.vstone.block.facedetect.nodetectduration.get,288,304,288,304,False,11,顔が見えていない場合、その累積時間を変数long noDetectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
							}
																																	//@<EndOfBlock/>
																																		//@</OutputChild>

							
						} catch(Exception e) {
							CRobotUtil.Err("jp.vstone.block.thread","例外が発生しました。");
							e.printStackTrace();
						}
					}
				});
				th.start();
			}
																														//@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,480,304,1120,304,False,20,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,544,256,1056,256,False,19,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)8)
				{
																														//@<OutputChild>
					GlobalVariable.robocam.setEnableFaceSearch(false);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,608,256,608,256,False,18,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
					GlobalVariable.sotawish.stop();																		//@<BlockInfo>jp.vstone.block.talk.say,672,256,672,256,False,17,@</BlockInfo>
					if(cplay != null){
					    cplay.stop();
					}

					{
						String selectLang = "日本語";

						switch(selectLang){
							case "日本語":
								jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
								break;
							case "英語":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
								break;
							case "中国語_簡体字":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
								break;
							case "中国語_繁体字":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
								break;
							case "韓国語":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
								break;
							default:
								break;
						}
					}
					GlobalVariable.sotawish.Say((String)"ようこそ 秋田県庁 第二庁舎 へ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
					while(noDetectDuration<6)																			//@<BlockInfo>jp.vstone.block.while,736,256,864,256,False,16,TRUE@</BlockInfo>
					{


																														//@<OutputChild>
						talk1();																						//@<BlockInfo>jp.vstone.block.callfunc.base,800,256,800,256,False,13,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					ActBye();																							//@<BlockInfo>jp.vstone.block.callfunc.base,928,256,928,256,False,15,@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.robocam.setEnableFaceSearch(true);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,992,256,992,256,False,14,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,224,144,False,26,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,96,144,96,144,False,25,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)"プログラムを実行開始します",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
		faceTracking();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,144,160,144,False,24,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void ActBye()																								//@<BlockInfo>jp.vstone.block.func,32,464,416,464,False,32,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,96,464,96,464,False,31,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,160,464,160,464,False,30,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,224,464,224,464,False,29,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,260,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,288,464,288,464,False,28,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,352,464,352,464,False,27,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void sayTime()																								//@<BlockInfo>jp.vstone.block.func,720,848,1424,848,False,50,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		localDateTime = LocalDateTime.now();																			//@<BlockInfo>jp.vstone.block.time.getlocaldatetime,784,848,784,848,False,49,ローカル時間をロボット内のカレンダーより取得し、変数LocalDateTime lodalDateTimeに代入。取得した情報から日時などを個別に切り出す場合は「日時の切り出しブロック」を使う@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,848,848,848,848,False,48,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getHour();
		}																												//@<EndOfBlock/>
		int hour=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,912,848,912,848,False,47,break@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,976,848,976,848,False,46,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getMinute();
		}																												//@<EndOfBlock/>
		int minute=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,1040,848,1040,848,False,45,break@</BlockInfo>
																														//@<EndOfBlock/>
		String say_words="いま" + hour + "時" + minute + "分です。";															//@<BlockInfo>jp.vstone.block.variable,1104,848,1104,848,False,44,break@</BlockInfo>
																														//@<EndOfBlock/>
		if(hour==9)																										//@<BlockInfo>jp.vstone.block.if,1168,464,1296,464,False,43,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			say_words+=(String)"今日も元気にがんばろう！";																			//@<BlockInfo>jp.vstone.block.calculater,1232,464,1232,464,False,33,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==10)
		{
																														//@<OutputChild>
			say_words+=(String)"お仕事ですか？お疲れ様です";																			//@<BlockInfo>jp.vstone.block.calculater,1232,560,1232,560,False,34,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==11)
		{
																														//@<OutputChild>
			say_words+=(String)"今日のお昼はなに食べようかな";																		//@<BlockInfo>jp.vstone.block.calculater,1232,656,1232,656,False,35,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==12)
		{
																														//@<OutputChild>
			say_words+=(String)"お昼だよ！おなかがすいたなぁ";																		//@<BlockInfo>jp.vstone.block.calculater,1232,752,1232,752,False,36,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==13)
		{
																														//@<OutputChild>
			say_words+=(String)"ボクのお仕事もあと半分！がんばるよ！";																	//@<BlockInfo>jp.vstone.block.calculater,1232,848,1232,848,False,37,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==14 && minute<30)
		{
																														//@<OutputChild>
			say_words+=(String)"仕事中だけど正直眠いよ";																			//@<BlockInfo>jp.vstone.block.calculater,1232,944,1232,944,False,38,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==14 && minute>=30)
		{
																														//@<OutputChild>
			say_words+=(String)"もうすぐおやつの時間だね";																			//@<BlockInfo>jp.vstone.block.calculater,1232,1040,1232,1040,False,39,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==15)
		{
																														//@<OutputChild>
			say_words+=(String)"おやつの時間だよ。何か食べた？";																		//@<BlockInfo>jp.vstone.block.calculater,1232,1136,1232,1136,False,40,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==16)
		{
																														//@<OutputChild>
			say_words+=(String)"もうすぐボクのお仕事も終わり！";																		//@<BlockInfo>jp.vstone.block.calculater,1232,1232,1232,1232,False,41,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1360,848,1360,848,False,42,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)say_words,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public Object get(String json,String code)																			//@<BlockInfo>jp.vstone.block.func,720,1344,848,1344,False,52,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		ScriptEngineManager manager = new ScriptEngineManager();														//@<BlockInfo>jp.vstone.block.freeproc,784,1344,784,1344,False,51,@</BlockInfo>
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		String script = "var obj = " + json + ";";
		try {
			engine.eval(script);
			{
				return engine.eval("obj." + code);
			}
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void sayWeather()																							//@<BlockInfo>jp.vstone.block.func,720,1696,1616,1696,False,74,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,784,1696,784,1696,False,73,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)"ちょっと待ってね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
		String weather="";																								//@<BlockInfo>jp.vstone.block.variable,848,1696,848,1696,False,72,break@</BlockInfo>
																														//@<EndOfBlock/>
		String weather2="";																								//@<BlockInfo>jp.vstone.block.variable,912,1696,912,1696,False,71,break@</BlockInfo>
																														//@<EndOfBlock/>
		String strUrl = "http://weather.livedoor.com/forecast/webservice/json/v1?city=050010";							//@<BlockInfo>jp.vstone.block.freeproc,976,1696,976,1696,False,70,@</BlockInfo>
		HttpURLConnection urlConn = null;
		InputStream in = null;
		BufferedReader reader = null;

		try {
			URL url = new URL(strUrl);

			urlConn = (HttpURLConnection) url.openConnection();

			urlConn.setRequestMethod("GET");

			urlConn.connect();

			int status = urlConn.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {

				in = urlConn.getInputStream();

				reader = new BufferedReader(new InputStreamReader(in));

				StringBuilder output = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					output.append(line);
				}

				Object value = get(output.toString(), "forecasts[0].telop");
				weather = value.toString();

				value = get(output.toString(), "forecasts[1].telop");
				weather2 = value.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (urlConn != null) {
					urlConn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
																														//@<EndOfBlock/>
		String say_words="今日の天気は";																						//@<BlockInfo>jp.vstone.block.variable,1040,1696,1040,1696,False,69,break@</BlockInfo>
																														//@<EndOfBlock/>
		switch((String)weather)																							//@<BlockInfo>jp.vstone.block.switch,1104,1456,1232,1456,False,68,@</BlockInfo>
		{
			case (String)"晴れ":
			{
																														//@<OutputChild>
				say_words+=(String)"晴れ、気分までよくなるね。";																			//@<BlockInfo>jp.vstone.block.calculater,1168,1456,1168,1456,False,53,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"曇り":
			{
																														//@<OutputChild>
				say_words+=(String)"曇り、気分までくもっちゃうね。";																		//@<BlockInfo>jp.vstone.block.calculater,1168,1552,1168,1552,False,54,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雨":
			{
																														//@<OutputChild>
				say_words+=(String)"雨、ソータはロボットだから濡れたら大変だよ。";																//@<BlockInfo>jp.vstone.block.calculater,1168,1648,1168,1648,False,55,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雪":
			{
																														//@<OutputChild>
				say_words+=(String)"雪、寒すぎるよ。";																				//@<BlockInfo>jp.vstone.block.calculater,1168,1744,1168,1744,False,56,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"暴風雪":
			{
																														//@<OutputChild>
				say_words+=(String)"暴風せつ、寒すぎるよ。";																			//@<BlockInfo>jp.vstone.block.calculater,1168,1840,1168,1840,False,57,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				say_words+=(String)weather + "。";																			//@<BlockInfo>jp.vstone.block.calculater,1168,1936,1168,1936,False,58,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
		say_words+=(String)"ちなみに明日は";																					//@<BlockInfo>jp.vstone.block.calculater,1296,1696,1296,1696,False,67,@</BlockInfo>
																														//@<EndOfBlock/>
		switch((String)weather2)																						//@<BlockInfo>jp.vstone.block.switch,1360,1456,1488,1456,False,66,@</BlockInfo>
		{
			case (String)"晴れ":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1424,1456,1424,1456,False,59,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"曇り":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1424,1552,1424,1552,False,60,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雨":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1424,1648,1424,1648,False,61,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雪":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1424,1744,1424,1744,False,62,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"暴風雪":
			{
																														//@<OutputChild>
				say_words+=(String)"暴風せつ";																					//@<BlockInfo>jp.vstone.block.calculater,1424,1840,1424,1840,False,63,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1424,1936,1424,1936,False,64,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1552,1696,1552,1696,False,65,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)say_words,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void talk1()																									//@<BlockInfo>jp.vstone.block.func,32,4032,608,4032,False,151,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);											//@<BlockInfo>jp.vstone.block.talk.speechrecog.regex2,96,576,544,576,False,150,音声認識を行い、結果を条件に正規表現文字列で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
		speechRecogResult = recogresult.CheckBest(new String[]{
		 ".*こんにちは.*" ,  ".*ここはどこ.*" ,  ".*お名前は.*" ,  "(.*バイバイ.*|.*さようなら.*)" ,  ".*おはよう.*" ,  ".*元気.*" ,  ".*今日の天気は.*" ,  ".*ありがとう.*" ,  ".*今日は何日.*" ,  ".*いま何時.*" ,  ".*教育庁.*" ,  ".*高校教育.*" ,  ".*特別支援教育.*" ,  ".*義務教育.*" ,  ".*保健体育.*" ,  ".*幼保.*" ,  ".*公営企業.*" ,  ".*うまいもの.*" ,  ".*スポーツ振興.*" ,  ".*文化振興.*" ,  ".*文化財保護.*" ,  ".*生涯学習.*" ,  ".*福利.*" ,  ".*施設整備.*" ,  ".*情報規格.*" ,  ".*情報化研修.*" ,  ".*総合防災.*" ,  ".*災害対策本部.*" ,  ".*産業労働.*" ,  ".*三ローブ.*" ,  ".*デジタル.*" ,  ".*資源エネルギー産業.*" ,  ".*産業集積.*" ,  ".*産業政策.*" ,  ".*地域産業振興.*" ,  ".*ちさんか.*" ,  ".*食品工業.*" ,  ".*輸送機.*" ,  ".*商業貿易.*" ,  ".*雇用労働.*" ,  ".*活性化センター.*" ,  ".*観光文化スポーツ.*" ,  ".*観光連盟.*" ,  ".*観光振興.*" ,  ".*交通政策.*" ,  ".*観光戦略.*" ,  ".*北秋田市.*観光スポット.*" ,  ".*秋田市.*観光スポット.*" ,  ".*仙北市.*観光スポット.*" ,  ".*横手市.*観光スポット.*" ,  ".*由利本荘市.*観光スポット.*" ,  ".*大館市.*観光スポット.*" ,  ".*男鹿市.*観光スポット.*" ,  ".*湯沢市.*観光スポット.*" ,  ".*鹿角市.*観光スポット.*" ,  ".*八峰町.*観光スポット.*" ,  ".*小坂町.*観光スポット.*" ,  ".*上小阿仁村.*観光スポット.*" ,  ".*藤里町.*観光スポット.*" ,  ".*三種町.*観光スポット.*" ,  ".*五城目町.*観光スポット.*" ,  ".*八郎潟町.*観光スポット.*" ,  ".*井川町.*観光スポット.*" ,  ".*能代市.*観光スポット.*" ,  ".*大潟村.*観光スポット.*" ,  ".*美郷町.*観光スポット.*" ,  ".*羽後町.*観光スポット.*" ,  ".*東成瀬村.*観光スポット.*" ,  ".*潟上市.*観光スポット.*" ,  ".*にかほ市.*観光スポット.*" ,  ".*大仙市.*観光スポット.*" ,  ".*イベント.*" ,  "" , 
		},true);
		if(speechRecogResult == null) speechRecogResult = "";

		if(speechRecogResult.contains((String)".*こんにちは.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,576,160,576,False,75,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"こんにちは",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ここはどこ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,672,160,672,False,76,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ここは秋田県庁 第二庁舎 です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*お名前は.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,768,160,768,False,77,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ソータ です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)"(.*バイバイ.*|.*さようなら.*)"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,864,160,864,False,78,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"さようなら、また来てね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*おはよう.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,960,160,960,False,79,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"おはようございます",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*元気.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1056,160,1056,False,80,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"僕は元気です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*今日の天気は.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayWeather();																								//@<BlockInfo>jp.vstone.block.callfunc.base,160,1152,160,1152,False,81,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ありがとう.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1248,160,1248,False,82,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"どういたしまして",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*今日は何日.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayDate();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,1344,160,1344,False,83,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*いま何時.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayTime();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,1440,160,1440,False,84,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*教育庁.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1536,160,1536,False,85,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁は７階と6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*高校教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1632,160,1632,False,86,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"高校教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*特別支援教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1728,160,1728,False,87,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"特別支援教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*義務教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1824,160,1824,False,88,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"義務教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*保健体育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1920,160,1920,False,89,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"保健体育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*幼保.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2016,160,2016,False,90,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"幼保推進課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*公営企業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2112,160,2112,False,91,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"公営企業課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*うまいもの.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2208,160,2208,False,92,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"秋田うまいもの販売課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*スポーツ振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2304,160,2304,False,93,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"スポーツ振興課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*文化振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2400,160,2400,False,94,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"文化振興課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*文化財保護.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2496,160,2496,False,95,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"文化財 保護室は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*生涯学習.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2592,160,2592,False,96,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"生涯学習課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*福利.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2688,160,2688,False,97,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁福利課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*施設整備.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2784,160,2784,False,98,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁施設整備室は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*情報規格.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2880,160,2880,False,99,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"情報企画課は5階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*情報化研修.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2976,160,2976,False,100,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"情報化研修室は5階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*総合防災.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3072,160,3072,False,101,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"総合防災課は4階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*災害対策本部.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3168,160,3168,False,102,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"災害対策本部室は4階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業労働.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3264,160,3264,False,103,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業労働部は3階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*三ローブ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3360,160,3360,False,104,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業労働部は3階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*デジタル.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3456,160,3456,False,105,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"デジタルイノベーション戦略室は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*資源エネルギー産業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3552,160,3552,False,106,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"資源エネルギー産業課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業集積.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3648,160,3648,False,107,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業集積課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業政策.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3744,160,3744,False,108,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業政策課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*地域産業振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3840,160,3840,False,109,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課は3階ですが，食品工業班は6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ちさんか.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3936,160,3936,False,110,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課は3階ですが，食品工業班は6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*食品工業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4032,160,4032,False,111,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課食品工業班は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*輸送機.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4128,160,4128,False,112,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"輸送機産業振興室は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*商業貿易.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4224,160,4224,False,113,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"商業貿易課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*雇用労働.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4320,160,4320,False,114,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"雇用労働政策課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*活性化センター.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4416,160,4416,False,115,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"あきた企業活性化センターは2階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光文化スポーツ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4512,160,4512,False,116,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光文化スポーツ部は1階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光連盟.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4608,160,4608,False,117,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"秋田県観光連盟は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4704,160,4704,False,118,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光振興課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*交通政策.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4800,160,4800,False,119,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"交通政策課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光戦略.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4896,160,4896,False,120,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光戦略課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*北秋田市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4992,160,4992,False,121,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"きたあきたしわ、すいうんこうえんだよ。きゅうしゅるいのにせんごひゃくほんのあじさいがとてもきれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*秋田市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5088,160,5088,False,122,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"あきたしわ、かわばたどおりだよ。おいしいおみせがたくさんならんでるよ。よるになるとおいしそうなにおいがいっぱいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*仙北市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5184,160,5184,False,123,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"せんぼくしわ、にゅうとうおんせんだよ。からだがしんまであたたまるよ。そーたは、おふろにわはいれないけど。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*横手市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5280,160,5280,False,124,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"よこてしわ、ふるさとむらだよ。アミューズメントパークでだけど、よこてやきそばやいなにわうどんがたべられるよ。そーたもたべてみたいなあ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*由利本荘市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5376,160,5376,False,125,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ゆりほんじょうしわ、みちのえきだよ。にほんかいをうしろに、おみせがたくさんならんでいるよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大館市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5472,160,5472,False,126,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"おおだてしわ、あきたけんかいかんだよ。あきたけんとちいきのれきしをかんじられるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*男鹿市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5568,160,5568,False,127,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"おがしわ、ゴジラいわだよ。ゆうひをはいけいにしゃしんをとるととってもかっこいいんだよ。ちなみにおがしわ、なまはげもゆうめいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*湯沢市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5664,160,5664,False,163,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ゆざわしわ、こやすきょうおおつららがゆうめいだよ。ふゆになるとこやすけいこくに、たかさがさんじゅうメートル、はばもよんじゅうめーとるにもなるつららができるんだよ。とってもはくりょくがあるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*鹿角市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5760,160,5760,False,128,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"かづのしわ、しせきおさりざわこうざんだよ。きちょうなこうぶつがおかれていたり、なかをさんさくできたり、とてもたのしいよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*八峰町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5856,160,5856,False,129,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"はっぽうちょうわ、しらたきだよ。すいりょうがおおいみごとなたきだよ。しゃしんをとると、インスタばえかも。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*小坂町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5952,160,5952,False,130,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"こさかまちは、こさかこうざんじむしょだよ。夜になるとライトアップされて、きれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*上小阿仁村.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6048,160,6048,False,131,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"かみこあにむらは、てんねんあきたすぎのはやしだよ。しぜんのスケールにあっとうされてきのうまでなやんでいたことがなくなっちゃうよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*藤里町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6144,160,6144,False,132,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ふじさとちょうわ、けんこうほようかんだよ。さらかみさんちのふもとにあるてんねんおんせんだよ。トレーニングルームやけいしょくコーナーがあってかぞくでくるといいかもね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*三種町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6240,160,6240,False,133,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"みたねちょうわ、もりたけおんせんきょうだよ。たんぼをつくってたら、とつぜんおゆがわいてきたんだって。そーたのおうちのにわからも、おゆがわかないかなあ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*五城目町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6336,160,6336,False,134,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ごじょうめまちわ、ねこばりいわだよ。つりきちさんぺいのロケちのかわのほとりにあるよ。おおきないわにきょぼくがはえているのには、なかなかあっとうされるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*八郎潟町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6432,160,6432,False,135,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"はちろうがたわ、はちろうがたえきまえのへきがだよ。なかなかじだいをかんじるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*井川町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6528,160,6528,False,136,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"いかわまちわ、にほんこっかえんだよ。とってもおおきなこうえんで、かぞくでたのしめるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*能代市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6624,160,6624,False,137,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"のしろしわ、のしろろけっとじっけんじょうだよ。ねんしょうじっけんはいっぱんのひともみられるから、みにいってきてね。そーたもうちゅうにいってみたいな",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大潟村.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6720,160,6720,False,138,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"おおがたむらわ、おおがたむらソーラースポーツラインだよ。いっしゅうにじゅうごきろめーとるのサーキットで、ソーラーカーたいかいやじどうしゃめーかーのテストにもつかわれているよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*美郷町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6816,160,6816,False,139,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"みさとちょうわ、ろくごうのかまくらだよ。かまくらじたいがあきたけんのめいぶつだけど、それのおまつりだよ。ふゆにわ、いってみてね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*羽後町.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6912,160,6912,False,140,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"うごまちわ、たいへいざんからのちょうぼうがとてもきれだよ。ちょうかいさんがいちぼうできるし、せんぼくしまでみわたせるんだ。いいけしきだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*東成瀬村.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7008,160,7008,False,141,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ひがしなるせむらわ、まるごとしぜんかんだよ。しぜんのもくざいをつかったりしてこうさくをたいけんできたり、そーたとおなじくらいかわいいこけしコレクションがおいてあるんだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*潟上市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7104,160,7104,False,142,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"かたがみしわ、メルシティかたがみだよ。とってもひろいショッピングタウンだから、おかいものをたのしんじゃおう",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*にかほ市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7200,160,7200,False,143,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"にかほしわ、なんきょくこうえんだよ。なんきょくたんけんのいぎょうをこうせいにつたえるきねんかんのまえにひろがるこうえんで、はるにはさくらがうつくしいんだ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大仙市.*観光スポット.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7296,160,7296,False,144,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"だいせんしわ、なんといってもなつのはなびたいかいだよ。ぜんこくトップレベルのはなびがみられるんだ。とってもきれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*イベント.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7392,160,7392,False,148,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ちょっと待ってね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
				String sCity="秋田市";																							//@<BlockInfo>jp.vstone.block.variable,224,7392,224,7392,False,147,break@</BlockInfo>
																															//@<EndOfBlock/>
				Document document;																							//@<BlockInfo>jp.vstone.block.variable,288,7392,288,7392,False,146,break@</BlockInfo>
																															//@<EndOfBlock/>
				try {																										//@<BlockInfo>jp.vstone.block.freeproc,352,7392,352,7392,False,145,@</BlockInfo>
					document = Jsoup.connect("https://www.akitafan.com/archive/events").get();
					Elements events = document.getElementsByClass("tab_panel is_tab_active").first()
							.getElementsByClass("media");
					String[] eventUrl = new String[events.size()];
					int eventNum = 0;
					for (Element event : events) {
						String city = event.child(0).child(0).child(1).child(1).child(1).text();
						if (city.equals("（" + sCity + "）")) {
							eventUrl[eventNum] = event.child(0).attr("href");
							eventNum++;
						}
					}
					Document eventPage = Jsoup.connect(eventUrl[(int) (Math.random() * eventNum)]).get();
					Elements eventString = eventPage.getElementsByClass("l_section");
				
					GlobalVariable.sotawish.stop();
					if(cplay != null){
					    cplay.stop();
					}
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					GlobalVariable.sotawish.Say((String)(eventString.text()),MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
				} catch (IOException e) {
					e.printStackTrace();
				}
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7488,160,7488,False,149,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ごめんなさい 聞き取れませんでした",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void sayDate()																								//@<BlockInfo>jp.vstone.block.func,720,2048,1424,2048,False,162,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,784,2048,784,2048,False,161,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)"ちょっと待ってね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
		localDateTime = LocalDateTime.now();																			//@<BlockInfo>jp.vstone.block.time.getlocaldatetime,848,2048,848,2048,False,160,ローカル時間をロボット内のカレンダーより取得し、変数LocalDateTime lodalDateTimeに代入。取得した情報から日時などを個別に切り出す場合は「日時の切り出しブロック」を使う@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,912,2048,912,2048,False,159,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getMonthValue();
		}																												//@<EndOfBlock/>
		int month=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,976,2048,976,2048,False,158,break@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,1040,2048,1040,2048,False,157,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getDayOfMonth();
		}																												//@<EndOfBlock/>
		int day=getDateTimeElement;																						//@<BlockInfo>jp.vstone.block.variable,1104,2048,1104,2048,False,156,break@</BlockInfo>
																														//@<EndOfBlock/>
		Document document;																								//@<BlockInfo>jp.vstone.block.variable,1168,2048,1168,2048,False,155,break@</BlockInfo>
																														//@<EndOfBlock/>
		String article="";																								//@<BlockInfo>jp.vstone.block.variable,1232,2048,1232,2048,False,154,break@</BlockInfo>
																														//@<EndOfBlock/>
		try {																											//@<BlockInfo>jp.vstone.block.freeproc,1296,2048,1296,2048,False,153,@</BlockInfo>
			document = Jsoup.connect("https://kids.yahoo.co.jp/today/").get();
			Element element = document.getElementById("dateDtl").child(0).child(0);
			article = " " + element.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1360,2048,1360,2048,False,152,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)"今日は" + month + "月" + day + "日" + article + "です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
