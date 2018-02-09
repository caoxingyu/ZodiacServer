package com.zodiac.entity;

import com.zodiac.websocket.GameWebsocket;

public class Message {

	private String msgType;     //消息类型
	private String userId;  //发送者id
	private String toUserId;  //接收者id
	private Integer startType;  // 先手还是后手  1:先手 2:后手
	private GameWebsocket gameWebsocket;  //发送消息的websocket
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public Integer getStartType() {
		return startType;
	}
	public void setStartType(Integer startType) {
		this.startType = startType;
	}
	public GameWebsocket getGameWebsocket() {
		return gameWebsocket;
	}
	public void setGameWebsocket(GameWebsocket gameWebsocket) {
		this.gameWebsocket = gameWebsocket;
	}
	
	
	
	
	

}
