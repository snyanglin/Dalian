package com.founder.service.socketMessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import net.sf.json.JSONObject;

import com.founder.framework.config.SystemConfig;

public class SocketClient {
	
	private Socket socket = null;
	private BufferedReader bufferedReader = null;
	private PrintWriter printWriter = null;
	private String IP = null;
	private int PROT = 0;
	
	public void ShendMessage(Map sendMap){
		try{
			//System.out.println(System.getProperty("sun.jnu.encoding"));
			IP = SystemConfig.getString("websocket.ip");
			PROT = Integer.parseInt(SystemConfig.getString("websocket.prot"));
			socket = new Socket(IP,PROT);
			String sendType = (String)sendMap.get("sendType");
			String sendCode = (String)sendMap.get("sendCode");
			JSONObject  messageJson = (JSONObject) sendMap.get("sendMsg");
			String sendMsg = messageJson.toString();
			String callback = (String)sendMap.get("callback");
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
			printWriter.println(sendType);
			printWriter.flush();
			printWriter.println(sendCode);
			printWriter.flush();
			printWriter.println(sendMsg);
			printWriter.flush();
			printWriter.println(callback);
			printWriter.flush();
			printWriter.println("END");
			printWriter.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				bufferedReader.close();
				printWriter.close();
				socket.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
