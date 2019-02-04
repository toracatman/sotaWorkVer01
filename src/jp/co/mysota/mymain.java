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
	public LocalDateTime localDateTime;
	public int getDateTimeElement;
	public int faceDetectResultAge;
	public void sayDate()																								//@<BlockInfo>jp.vstone.block.func,464,2160,1168,2160,False,11,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,528,2160,528,2160,False,10,@</BlockInfo>
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
		localDateTime = LocalDateTime.now();																			//@<BlockInfo>jp.vstone.block.time.getlocaldatetime,592,2160,592,2160,False,9,ローカル時間をロボット内のカレンダーより取得し、変数LocalDateTime lodalDateTimeに代入。取得した情報から日時などを個別に切り出す場合は「日時の切り出しブロック」を使う@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,656,2160,656,2160,False,8,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getMonthValue();
		}																												//@<EndOfBlock/>
		int month=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,720,2160,720,2160,False,7,break@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,784,2160,784,2160,False,6,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getDayOfMonth();
		}																												//@<EndOfBlock/>
		int day=getDateTimeElement;																						//@<BlockInfo>jp.vstone.block.variable,848,2160,848,2160,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		Document document;																								//@<BlockInfo>jp.vstone.block.variable,912,2160,912,2160,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		String article="";																								//@<BlockInfo>jp.vstone.block.variable,976,2160,976,2160,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		try {																											//@<BlockInfo>jp.vstone.block.freeproc,1040,2160,1040,2160,False,2,@</BlockInfo>
			document = Jsoup.connect("https://kids.yahoo.co.jp/today/").get();
			Element element = document.getElementById("dateDtl").child(0).child(0);
			article = " " + element.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1104,2160,1104,2160,False,1,@</BlockInfo>
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

	//@<Separate/>
	public void fastStart()																								//@<BlockInfo>jp.vstone.block.func,336,144,592,144,False,14,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,400,144,528,144,False,13,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			talk1();																									//@<BlockInfo>jp.vstone.block.callfunc.base,464,144,464,144,False,12,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void sayEvent(String ni,String de)																			//@<BlockInfo>jp.vstone.block.func,464,2800,1872,2800,False,45,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		speechRecogResult=(String)speechRecogResult.replaceAll("新川", "に井川");											//@<BlockInfo>jp.vstone.block.calculater,528,2800,528,2800,False,44,@</BlockInfo>
																														//@<EndOfBlock/>
		int niindex=speechRecogResult.indexOf(ni);																		//@<BlockInfo>jp.vstone.block.variable,592,2800,592,2800,False,43,break@</BlockInfo>
																														//@<EndOfBlock/>
		int deindex=speechRecogResult.indexOf(de, niindex + 1);															//@<BlockInfo>jp.vstone.block.variable,656,2800,656,2800,False,42,break@</BlockInfo>
																														//@<EndOfBlock/>
		String substr="";																								//@<BlockInfo>jp.vstone.block.variable,720,2800,720,2800,False,41,break@</BlockInfo>
																														//@<EndOfBlock/>
		int sMonth=0;																									//@<BlockInfo>jp.vstone.block.variable,784,2800,784,2800,False,40,break@</BlockInfo>
																														//@<EndOfBlock/>
		try {																											//@<BlockInfo>jp.vstone.block.freeproc,848,2800,848,2800,False,39,@</BlockInfo>
			substr = speechRecogResult.substring(0, niindex);
		} catch (StringIndexOutOfBoundsException e) {
			sMonth = 0;
		}
																														//@<EndOfBlock/>
		switch((String)substr)																							//@<BlockInfo>jp.vstone.block.switch,912,2272,1040,2272,False,38,@</BlockInfo>
		{
			case (String)"一月":
			{
																														//@<OutputChild>
				sMonth=(int)1;																								//@<BlockInfo>jp.vstone.block.calculater,976,2272,976,2272,False,15,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"二月":
			{
																														//@<OutputChild>
				sMonth=(int)2;																								//@<BlockInfo>jp.vstone.block.calculater,976,2368,976,2368,False,16,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"三月":
			{
																														//@<OutputChild>
				sMonth=(int)3;																								//@<BlockInfo>jp.vstone.block.calculater,976,2464,976,2464,False,17,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"四月":
			{
																														//@<OutputChild>
				sMonth=(int)4;																								//@<BlockInfo>jp.vstone.block.calculater,976,2560,976,2560,False,18,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"五月":
			{
																														//@<OutputChild>
				sMonth=(int)5;																								//@<BlockInfo>jp.vstone.block.calculater,976,2656,976,2656,False,19,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"六月":
			{
																														//@<OutputChild>
				sMonth=(int)6;																								//@<BlockInfo>jp.vstone.block.calculater,976,2752,976,2752,False,20,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"七月":
			{
																														//@<OutputChild>
				sMonth=(int)7;																								//@<BlockInfo>jp.vstone.block.calculater,976,2848,976,2848,False,21,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"八月":
			{
																														//@<OutputChild>
				sMonth=(int)8;																								//@<BlockInfo>jp.vstone.block.calculater,976,2944,976,2944,False,22,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"九月":
			{
																														//@<OutputChild>
				sMonth=(int)9;																								//@<BlockInfo>jp.vstone.block.calculater,976,3040,976,3040,False,23,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"十月":
			{
																														//@<OutputChild>
				sMonth=(int)10;																								//@<BlockInfo>jp.vstone.block.calculater,976,3136,976,3136,False,24,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"十一月":
			{
																														//@<OutputChild>
				sMonth=(int)11;																								//@<BlockInfo>jp.vstone.block.calculater,976,3232,976,3232,False,25,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"十二月":
			{
																														//@<OutputChild>
				sMonth=(int)12;																								//@<BlockInfo>jp.vstone.block.calculater,976,3328,976,3328,False,26,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
		if(sMonth!=0)																									//@<BlockInfo>jp.vstone.block.if,1104,2752,1808,2752,False,37,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,1168,2752,1168,2752,False,35,@</BlockInfo>
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
			String sCity=speechRecogResult.substring(niindex + 1, deindex);												//@<BlockInfo>jp.vstone.block.variable,1232,2752,1232,2752,False,34,break@</BlockInfo>
																														//@<EndOfBlock/>
			Document document;																							//@<BlockInfo>jp.vstone.block.variable,1296,2752,1296,2752,False,33,break@</BlockInfo>
																														//@<EndOfBlock/>
			int eventNum=0;																								//@<BlockInfo>jp.vstone.block.variable,1360,2752,1360,2752,False,32,break@</BlockInfo>
																														//@<EndOfBlock/>
			String say_words="";																						//@<BlockInfo>jp.vstone.block.variable,1424,2752,1424,2752,False,31,break@</BlockInfo>
																														//@<EndOfBlock/>
			try {																										//@<BlockInfo>jp.vstone.block.freeproc,1488,2752,1488,2752,False,197,@</BlockInfo>
				document = Jsoup.connect("https://www.akitafan.com/archive/events").get();
				Elements events = document.getElementsByClass("tab_panel is_tab_active").first()
						.getElementsByClass("media");
				String[] eventUrl = new String[events.size()];
				boolean match;
				for (Element event : events) {
					match = false;
					String[] date = event.child(0).child(0).child(1).child(1).child(0).text().split("[年月]");
					int month = Integer.parseInt(date[1]);
					if (date.length == 3) {
						if (sMonth == month)
							match = true;
					} else {
						int month2 = Integer.parseInt(date[3]);
						if (month <= month2) {
							if (sMonth >= month && sMonth <= month2)
								match = true;
						} else {
							if (sMonth >= month || sMonth <= month2)
								match = true;
						}
					}
					String city = event.child(0).child(0).child(1).child(1).child(1).text();
					if (match && city.equals("（" + sCity + "）")) {
						eventUrl[eventNum] = event.child(0).attr("href");
						eventNum++;
					}
				}
				if (eventNum > 0) {
					Document eventPage = Jsoup.connect(eventUrl[(int) (Math.random() * eventNum)]).get();
					String eventTitle = eventPage.getElementsByClass("l_section").first().child(0).text();

					say_words = eventTitle;
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
																														//@<EndOfBlock/>
			if(eventNum>0)																								//@<BlockInfo>jp.vstone.block.if,1552,2704,1744,2704,False,30,コメント@</BlockInfo>
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																			//@<BlockInfo>jp.vstone.block.talk.say,1616,2704,1616,2704,False,28,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)(eventNum + "件見つかりました。"),MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
				GlobalVariable.sotawish.stop();																			//@<BlockInfo>jp.vstone.block.talk.say,1680,2704,1680,2704,False,27,@</BlockInfo>
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
			}
			else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																			//@<BlockInfo>jp.vstone.block.talk.say,1616,2800,1616,2800,False,29,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"1件も見つかりませんでした。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,1168,2848,1168,2848,False,36,@</BlockInfo>
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
	public void ActBye()																								//@<BlockInfo>jp.vstone.block.func,32,464,416,464,False,51,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,96,464,96,464,False,50,コメント@</BlockInfo>
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
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,160,464,160,464,False,49,コメント@</BlockInfo>
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
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,224,464,224,464,False,48,コメント@</BlockInfo>
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
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,288,464,288,464,False,47,コメント@</BlockInfo>
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
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,352,464,352,464,False,46,コメント@</BlockInfo>
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
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,144,224,144,False,54,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,96,144,96,144,False,53,@</BlockInfo>
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
		faceTracking();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,144,160,144,False,52,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void faceTracking()																							//@<BlockInfo>jp.vstone.block.func,32,304,1248,304,False,67,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,96,304,1184,304,False,66,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.thread,160,304,416,304,False,65,スレッド@</BlockInfo>
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							
							
																														//@<OutputChild>
							while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,224,304,352,304,False,56,Endless@</BlockInfo>
							{
							
																																	//@<OutputChild>
								noDetectDuration = GlobalVariable.robocam.getNotDetectDuration();									//@<BlockInfo>jp.vstone.block.facedetect.nodetectduration.get,288,304,288,304,False,55,顔が見えていない場合、その累積時間を変数long noDetectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
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
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,480,304,1120,304,False,64,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,544,256,1056,256,False,63,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)8)
				{
																														//@<OutputChild>
					GlobalVariable.robocam.setEnableFaceSearch(false);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,608,256,608,256,False,62,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
					GlobalVariable.sotawish.stop();																		//@<BlockInfo>jp.vstone.block.talk.say,672,256,672,256,False,61,@</BlockInfo>
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
					while(noDetectDuration<6)																			//@<BlockInfo>jp.vstone.block.while,736,256,864,256,False,60,TRUE@</BlockInfo>
					{


																														//@<OutputChild>
						talk1();																						//@<BlockInfo>jp.vstone.block.callfunc.base,800,256,800,256,False,57,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					ActBye();																							//@<BlockInfo>jp.vstone.block.callfunc.base,928,256,928,256,False,59,@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.robocam.setEnableFaceSearch(true);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,992,256,992,256,False,58,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
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
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,608,32,False,76,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CPlayWave cplay*/;																							//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,75,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,74,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,73,break@</BlockInfo>
																														//@<EndOfBlock/>
		noDetectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,72,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,71,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*LocalDateTime localDateTime*/;																				//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,70,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int getDateTimeElement*/;																						//@<BlockInfo>jp.vstone.block.variable,480,32,480,32,False,69,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int faceDetectResultAge*/;																					//@<BlockInfo>jp.vstone.block.variable,544,32,544,32,False,68,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public Object get(String json,String code)																			//@<BlockInfo>jp.vstone.block.func,464,1456,592,1456,False,78,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		ScriptEngineManager manager = new ScriptEngineManager();														//@<BlockInfo>jp.vstone.block.freeproc,528,1456,528,1456,False,77,@</BlockInfo>
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
	public void sayWeather()																							//@<BlockInfo>jp.vstone.block.func,464,1808,1360,1808,False,100,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,528,1808,528,1808,False,99,@</BlockInfo>
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
		String weather="";																								//@<BlockInfo>jp.vstone.block.variable,592,1808,592,1808,False,98,break@</BlockInfo>
																														//@<EndOfBlock/>
		String weather2="";																								//@<BlockInfo>jp.vstone.block.variable,656,1808,656,1808,False,97,break@</BlockInfo>
																														//@<EndOfBlock/>
		String strUrl = "http://weather.livedoor.com/forecast/webservice/json/v1?city=050010";							//@<BlockInfo>jp.vstone.block.freeproc,720,1808,720,1808,False,96,@</BlockInfo>
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
		String say_words="今日の天気は";																						//@<BlockInfo>jp.vstone.block.variable,784,1808,784,1808,False,95,break@</BlockInfo>
																														//@<EndOfBlock/>
		switch((String)weather)																							//@<BlockInfo>jp.vstone.block.switch,848,1568,976,1568,False,94,@</BlockInfo>
		{
			case (String)"晴れ":
			{
																														//@<OutputChild>
				say_words+=(String)"晴れ、気分までよくなるね。";																			//@<BlockInfo>jp.vstone.block.calculater,912,1568,912,1568,False,79,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"曇り":
			{
																														//@<OutputChild>
				say_words+=(String)"曇り、気分までくもっちゃうね。";																		//@<BlockInfo>jp.vstone.block.calculater,912,1664,912,1664,False,80,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雨":
			{
																														//@<OutputChild>
				say_words+=(String)"雨、ボクはロボットだから濡れたら大変だよ。";																	//@<BlockInfo>jp.vstone.block.calculater,912,1760,912,1760,False,81,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雪":
			{
																														//@<OutputChild>
				say_words+=(String)"雪、寒すぎるよ。";																				//@<BlockInfo>jp.vstone.block.calculater,912,1856,912,1856,False,82,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"暴風雪":
			{
																														//@<OutputChild>
				say_words+=(String)"暴風せつ、寒すぎるよ。";																			//@<BlockInfo>jp.vstone.block.calculater,912,1952,912,1952,False,83,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				say_words+=(String)weather + "。";																			//@<BlockInfo>jp.vstone.block.calculater,912,2048,912,2048,False,84,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
		say_words+=(String)"ちなみに明日は";																					//@<BlockInfo>jp.vstone.block.calculater,1040,1808,1040,1808,False,93,@</BlockInfo>
																														//@<EndOfBlock/>
		switch((String)weather2)																						//@<BlockInfo>jp.vstone.block.switch,1104,1568,1232,1568,False,92,@</BlockInfo>
		{
			case (String)"晴れ":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1168,1568,1168,1568,False,85,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"曇り":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1168,1664,1168,1664,False,86,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雨":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1168,1760,1168,1760,False,87,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"雪":
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1168,1856,1168,1856,False,88,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"暴風雪":
			{
																														//@<OutputChild>
				say_words+=(String)"暴風せつ";																					//@<BlockInfo>jp.vstone.block.calculater,1168,1952,1168,1952,False,89,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				say_words+=(String)weather2;																				//@<BlockInfo>jp.vstone.block.calculater,1168,2048,1168,2048,False,90,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1296,1808,1296,1808,False,91,@</BlockInfo>
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
	public void talk1()																									//@<BlockInfo>jp.vstone.block.func,32,4128,352,4128,False,178,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);											//@<BlockInfo>jp.vstone.block.talk.speechrecog.regex2,96,576,288,576,False,177,音声認識を行い、結果を条件に正規表現文字列で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
		speechRecogResult = recogresult.CheckBest(new String[]{
		 ".*こんにちは.*" ,  ".*ここはどこ.*" ,  ".*お名前は.*" ,  ".*(バイバイ|さようなら).*" ,  ".*おはよう.*" ,  ".*元気.*" ,  ".*今日の天気は.*" ,  ".*ありがとう.*" ,  ".*今日は何日.*" ,  ".*いま何時.*" ,  ".*教育庁.*" ,  ".*高校教育.*" ,  ".*特別支援教育.*" ,  ".*義務教育.*" ,  ".*保健体育.*" ,  ".*幼保.*" ,  ".*公営企業.*" ,  ".*うまいもの.*" ,  ".*スポーツ振興.*" ,  ".*文化振興.*" ,  ".*文化財保護.*" ,  ".*生涯学習.*" ,  ".*福利.*" ,  ".*施設整備.*" ,  ".*情報規格.*" ,  ".*情報化研修.*" ,  ".*総合防災.*" ,  ".*災害対策本部.*" ,  ".*産業労働.*" ,  ".*三ローブ.*" ,  ".*デジタル.*" ,  ".*資源エネルギー産業.*" ,  ".*産業集積.*" ,  ".*産業政策.*" ,  ".*地域産業振興.*" ,  ".*ちさんか.*" ,  ".*食品工業.*" ,  ".*輸送機.*" ,  ".*商業貿易.*" ,  ".*雇用労働.*" ,  ".*活性化センター.*" ,  ".*観光文化スポーツ.*" ,  ".*観光連盟.*" ,  ".*観光振興.*" ,  ".*交通政策.*" ,  ".*観光戦略.*" ,  ".*北秋田市.*観光.*" ,  ".*秋田市.*観光.*" ,  ".*仙北市.*観光.*" ,  ".*横手市.*観光.*" ,  ".*由利本荘市.*観光.*" ,  ".*大館市.*観光.*" ,  ".*男鹿市.*観光.*" ,  ".*湯沢市.*観光.*" ,  ".*鹿角市.*観光.*" ,  ".*八峰町.*観光.*" ,  ".*小坂町.*観光.*" ,  ".*上小阿仁村.*観光.*" ,  ".*藤里町.*観光.*" ,  ".*三種町.*観光.*" ,  ".*五城目町.*観光.*" ,  ".*八郎潟町.*観光.*" ,  ".*井川町.*観光.*" ,  ".*能代市.*観光.*" ,  ".*大潟村.*観光.*" ,  ".*美郷町.*観光.*" ,  ".*羽後町.*観光.*" ,  ".*東成瀬村.*観光.*" ,  ".*潟上市.*観光.*" ,  ".*にかほ市.*観光.*" ,  ".*大仙市.*観光.*" ,  ".+に.+で.*イベント.*" ,  ".+の.+のイベント.*" ,  ".*いくつに見える.*" ,  "" , 
		},true);
		if(speechRecogResult == null) speechRecogResult = "";

		if(speechRecogResult.contains((String)".*こんにちは.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,576,160,576,False,101,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,672,160,672,False,102,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,768,160,768,False,103,@</BlockInfo>
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
		else if(speechRecogResult.contains((String)".*(バイバイ|さようなら).*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,864,160,864,False,104,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,960,160,960,False,105,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1056,160,1056,False,106,@</BlockInfo>
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
				sayWeather();																								//@<BlockInfo>jp.vstone.block.callfunc.base,160,1152,160,1152,False,107,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ありがとう.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1248,160,1248,False,108,@</BlockInfo>
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
				sayDate();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,1344,160,1344,False,109,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*いま何時.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayTime();																									//@<BlockInfo>jp.vstone.block.callfunc.base,160,1440,160,1440,False,110,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*教育庁.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1536,160,1536,False,111,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1632,160,1632,False,112,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1728,160,1728,False,113,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1824,160,1824,False,114,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,1920,160,1920,False,115,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2016,160,2016,False,116,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2112,160,2112,False,117,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2208,160,2208,False,118,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2304,160,2304,False,119,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2400,160,2400,False,120,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2496,160,2496,False,121,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2592,160,2592,False,122,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2688,160,2688,False,123,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2784,160,2784,False,124,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2880,160,2880,False,125,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,2976,160,2976,False,126,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3072,160,3072,False,127,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3168,160,3168,False,128,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3264,160,3264,False,129,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3360,160,3360,False,130,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3456,160,3456,False,131,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3552,160,3552,False,132,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3648,160,3648,False,133,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3744,160,3744,False,134,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3840,160,3840,False,135,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,3936,160,3936,False,136,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4032,160,4032,False,137,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4128,160,4128,False,138,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4224,160,4224,False,139,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4320,160,4320,False,140,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4416,160,4416,False,141,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4512,160,4512,False,142,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4608,160,4608,False,143,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4704,160,4704,False,144,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4800,160,4800,False,145,@</BlockInfo>
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
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4896,160,4896,False,146,@</BlockInfo>
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
		else if(speechRecogResult.contains((String)".*北秋田市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,4992,160,4992,False,147,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"北秋田市は、すいうん公園だよ。9種類の、2500本の紫陽花がとてもきれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*秋田市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5088,160,5088,False,148,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"秋田市は、川反通りだよ。おいしいお店がたくさんならんでるよ。夜になると、おいしそうな匂いがいっぱいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*仙北市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5184,160,5184,False,149,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"仙北市は、乳頭温泉だよ。体が芯まであたたまるよ。ボクは、お風呂には入れないけど。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*横手市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5280,160,5280,False,150,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"横手市は、ふるさと村だよ。アミューズメントパークだけど、横手やきそばや稲庭うどんがたべられるよ。ボクも食べてみたいなあ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*由利本荘市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5376,160,5376,False,151,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"由利本荘市は、法体の滝だよ。日本の滝百選にも選ばれているんだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大館市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5472,160,5472,False,152,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"大館市は、秋田犬会館だよ。秋田犬と地域の歴史を感じられるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*男鹿市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5568,160,5568,False,153,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"男鹿市は、ゴジラいわだよ。夕日を背景に写真を撮ると、とってもかっこいいんだよ。ちなみに男鹿市は、なまはげも有名だよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*湯沢市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5664,160,5664,False,154,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"湯沢市は、小安峡おおつららが有名だよ。冬になると小安渓谷に、高さが３０メートル、幅も４０メートルにもなるつららができるんだよ。とっても迫力があるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*鹿角市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5760,160,5760,False,155,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"鹿角市は、史跡尾去沢鉱山だよ。貴重な鉱物がおかれていたり、中を散策できたり、とても楽しいよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*八峰町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5856,160,5856,False,156,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"八峰町は、しらたきだよ。水量が多い見事な滝だよ。写真をとると、インスタばえかも。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*小坂町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,5952,160,5952,False,157,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"こさか町は、小坂鉱山事務所だよ。夜になるとライトアップされて、きれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*上小阿仁村.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6048,160,6048,False,158,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"上小阿仁村は、秋田杉のコブ杉だよ。自然のスケールに圧倒されて、きのうまで悩んでいたことなんてなくなっちゃうよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*藤里町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6144,160,6144,False,159,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"藤里町は、健康保養館だよ。白神山地のふもとにある天然温泉だよ。トレーニングルームや軽食コーナーがあって家族で行くといいかもね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*三種町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6240,160,6240,False,160,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"三種町は、森岳温泉郷だよ。田んぼをつくっていたら、とつぜんお湯が湧いてきたんだって。ボクのおうちの庭からも、お湯が湧かないかなあ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*五城目町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6336,160,6336,False,161,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"五城目町は、ネコバリいわだよ。釣りキチ三平のロケ地の川のほとりにあるよ。大きな岩に巨木が生えているのにはなかなか圧倒されるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*八郎潟町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6432,160,6432,False,162,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"八郎潟は、八郎潟駅前の壁画だよ。なかなか時代を感じるよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*井川町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6528,160,6528,False,163,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"いかわ町は、日本国花苑だよ。とっても広い公園で、家族で行くといいかもね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*能代市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6624,160,6624,False,164,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"能代市は、能代ロケット実験場だよ。燃焼実験は一般の人も見れるから、見に行ってきてね。ボクも宇宙に行ってみたいな。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大潟村.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6720,160,6720,False,165,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"大潟村は、大潟村ソーラースポーツラインだよ。一周20キロメートルのサーキットで、ソーラーカー大会や自動車メーカーのテストにも使われているよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*美郷町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6816,160,6816,False,166,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"美郷町は、六郷のかまくらだよ。かまくら自体が秋田の名物だけど、それのお祭りだよ。冬には、いってみてね。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*羽後町.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,6912,160,6912,False,167,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"羽後町は、たいへいざんからの眺望がきれいだよ。鳥海山が一望できるし、仙北まで見渡せるんだ。いい景色だよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*東成瀬村.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7008,160,7008,False,168,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"東成瀬村は、まるごと自然かんだよ。自然の木材を使って工作を体験できたり、ボクと同じくらいかわいいこけしコレクションがおいてあるんだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*潟上市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7104,160,7104,False,169,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"潟上市は、メルシティ潟上だよ。とっても広いショッピングタウンだから、お買い物を楽しんじゃおう。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*にかほ市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7200,160,7200,False,170,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"にかほ市は、南極公園だよ。南極探検の偉業を後世に伝える記念館の前に広がる公園で、春には桜が美しいんだ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*大仙市.*観光.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7296,160,7296,False,171,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"大仙市は、なんといっても全国花火競技大会だよ。全国トップレベルの花火がみられるんだ。とってもきれいだよ。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".+に.+で.*イベント.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayEvent((String)"に",(String)"で");																			//@<BlockInfo>jp.vstone.block.callfunc.base,160,7392,160,7392,False,172,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".+の.+のイベント.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				sayEvent((String)"の",(String)"の");																			//@<BlockInfo>jp.vstone.block.callfunc.base,160,7488,160,7488,False,173,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*いくつに見える.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();										//@<BlockInfo>jp.vstone.block.facedetect.age.get2,160,7584,160,7584,False,175,現在認識している顔の年齢がfaceDetectResultAgeに格納される。顔が認識されない場合、faceDetectResultAgeに-1が代入される。@</BlockInfo>
				faceDetectResultAge = GlobalVariable.faceresult.getAge();													//@<EndOfBlock/>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,224,7584,224,7584,False,174,@</BlockInfo>
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
				GlobalVariable.sotawish.Say((String)"あなたは" + faceDetectResultAge + "歳ですね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,160,7680,160,7680,False,176,@</BlockInfo>
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
	public void sayTime()																								//@<BlockInfo>jp.vstone.block.func,464,960,1168,960,False,196,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		localDateTime = LocalDateTime.now();																			//@<BlockInfo>jp.vstone.block.time.getlocaldatetime,528,960,528,960,False,195,ローカル時間をロボット内のカレンダーより取得し、変数LocalDateTime lodalDateTimeに代入。取得した情報から日時などを個別に切り出す場合は「日時の切り出しブロック」を使う@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,592,960,592,960,False,194,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getHour();
		}																												//@<EndOfBlock/>
		int hour=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,656,960,656,960,False,193,break@</BlockInfo>
																														//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.time.getdatetimeelement,720,960,720,960,False,192,dateTimeに記録された日時情報から、年・月・日・時・分・秒のうち一つをtypeで指定し、変数int getDateTimeElementに代入する@</BlockInfo>
			LocalDateTime d = (LocalDateTime)localDateTime;
			getDateTimeElement = d.getMinute();
		}																												//@<EndOfBlock/>
		int minute=getDateTimeElement;																					//@<BlockInfo>jp.vstone.block.variable,784,960,784,960,False,191,break@</BlockInfo>
																														//@<EndOfBlock/>
		String say_words="いま" + hour + "時" + minute + "分です。";															//@<BlockInfo>jp.vstone.block.variable,848,960,848,960,False,190,break@</BlockInfo>
																														//@<EndOfBlock/>
		if(hour==9)																										//@<BlockInfo>jp.vstone.block.if,912,576,1040,576,False,189,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			say_words+=(String)"今日も元気にがんばろう！";																			//@<BlockInfo>jp.vstone.block.calculater,976,576,976,576,False,179,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==10)
		{
																														//@<OutputChild>
			say_words+=(String)"お仕事ですか？お疲れ様です";																			//@<BlockInfo>jp.vstone.block.calculater,976,672,976,672,False,180,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==11)
		{
																														//@<OutputChild>
			say_words+=(String)"今日のお昼はなに食べようかな";																		//@<BlockInfo>jp.vstone.block.calculater,976,768,976,768,False,181,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==12)
		{
																														//@<OutputChild>
			say_words+=(String)"お昼だよ！おなかがすいたなぁ";																		//@<BlockInfo>jp.vstone.block.calculater,976,864,976,864,False,182,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==13)
		{
																														//@<OutputChild>
			say_words+=(String)"ボクの仕事もあと半分！がんばるよ！";																		//@<BlockInfo>jp.vstone.block.calculater,976,960,976,960,False,183,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==14 && minute<30)
		{
																														//@<OutputChild>
			say_words+=(String)"２時だから，お空にも虹が出るかな？";																		//@<BlockInfo>jp.vstone.block.calculater,976,1056,976,1056,False,184,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==14 && minute>=30)
		{
																														//@<OutputChild>
			say_words+=(String)"もうすぐおやつの時間だね";																			//@<BlockInfo>jp.vstone.block.calculater,976,1152,976,1152,False,185,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==15)
		{
																														//@<OutputChild>
			say_words+=(String)"おやつの時間だよ。何か食べた？";																		//@<BlockInfo>jp.vstone.block.calculater,976,1248,976,1248,False,186,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else if(hour==16)
		{
																														//@<OutputChild>
			say_words+=(String)"今日の仕事，ラストスパートです";																		//@<BlockInfo>jp.vstone.block.calculater,976,1344,976,1344,False,187,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,1104,960,1104,960,False,188,@</BlockInfo>
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

}
