package com.zodiac.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.zodiac.entity.Message;

@ServerEndpoint("/gameWebsocket")  
public class GameWebsocket {
	 //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。  
    private static int onlineCount = 0;  
  
   
  
    //与某个客户端的连接会话，需要通过它来给客户端发送数据  
    private Session session;  
  
    /** 
     * 连接建立成功调用的方法 
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据 
     */  
    @OnOpen  
    public void onOpen(Session session){  
        this.session = session;  
      
        addOnlineCount();           //在线数加1  
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());  
    }  
  
    /** 
     * 连接关闭调用的方法 
     */  
    @OnClose  
    public void onClose(){  
     
        subOnlineCount();           //在线数减1  
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());  
    }  
  
    /** 
     * 收到客户端消息后调用的方法 
     * @param message 客户端发送过来的消息 
     * @param session 可选的参数 
     */  
    @OnMessage  
    public void onMessage(String msg, Session session) {  
        System.out.println("来自客户端的消息:" + msg);
        
        Message message=JSON.parseObject(msg,Message.class);
        message.setGameWebsocket(this);
        try {
			this.sendMessage("msg:ready");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }  
  
    /** 
     * 发生错误时调用 
     * @param session 
     * @param error 
     */  
    @OnError  
    public void onError(Session session, Throwable error){  
        System.out.println("发生错误");  
        error.printStackTrace();  
    }  
  
    /** 
     * 发送消息的方法
     * @param message 
     * @throws IOException 
     */  
    public void sendMessage(String message) throws IOException{  
        this.session.getBasicRemote().sendText(message);  
        //this.session.getAsyncRemote().sendText(message);  
    }  
  
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
  
    public static synchronized void addOnlineCount() {  
       onlineCount++;  
    }  
  
    public static synchronized void subOnlineCount() {  
       onlineCount--;  
    }  
}
