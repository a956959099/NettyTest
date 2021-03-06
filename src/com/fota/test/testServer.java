package com.fota.test;

import com.fota.sdk.server.connect.service.Client;
import com.fota.sdk.server.connect.service.CommunicationManager;
import com.fota.sdk.server.connect.service.Repeater;
import com.fota.sdk.server.connect.service.ResponseListener;
import com.fota.sdk.server.connect.service.Service;

public class testServer implements ResponseListener {

	public testServer() {
		Service s=new Service(2324);
		CommunicationManager comm=new CommunicationManager(s, this);
		comm.DEBUG=true;
	}

	@Override
	public void OnMessage(Repeater r, Client c) {
		System.out.println(c.getMessage().toString());
	}

	@Override
	public void OnBreak(String key) {
		System.err.println();
	}
	public static void main(String[] args) {
		new testServer();
	}
}
