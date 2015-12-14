jws.MosPlugIn = {
				NS: jws.NS_BASE + ".plugins.mosplugin",
				processToken: function( aToken ) {
					if( aToken.ns == jws.MosPlugIn.NS ) {
						if( aToken.reqType = "requestServerTime" ){
							eval(aToken.callback+"("+aToken.message+")");
						}
					}
				},
				requestServerTime:function( aOptions ){
				},
				mospluginSubscribe: function(text, aAccessKey, aOptions) {
					var lRes = this.checkConnected();
					if (0 == lRes.code) {
						this.sendToken({
							ns: jws.MosPlugIn.NS,
							type: jws.MosPlugIn.SUBSCRIBE,
							channel: text,
							accessKey: aAccessKey
						}, aOptions);
					}
					return lRes;
				},
				changeBusinConnect: function(connectCode, aOptions) {
					var lRes = this.checkConnected();
					if (0 == lRes.code) {
						this.sendToken({
							ns: jws.MosPlugIn.NS,
							type: "requestServerTime",
							connectCode: connectCode
						}, aOptions);
					}
					return lRes;
				}
}
jws.oop.addPlugIn( jws.jWebSocketTokenClient, jws.MosPlugIn );

var lURL = "";

var lWSC = null;

var loginObject = null;

function initPage() {
	if( jws.browserSupportsWebSockets() ) {
		lWSC = new jws.jWebSocketJSONClient();
	}
}

/**
 * @author message -- ��Ϣ��Ϣ
 * @author key -- ָ��Key
 * */
function shendToServer(message,key){  //���������������
	if(lWSC){
		lWSC.mospluginSubscribe(message,key);
	}
}



/**
 * @author yandabin 
 * 向服务器发起改变当连接KEY值
 **/
function changeBusinConnect(connectCode){
	lWSC.changeBusinConnect(connectCode);
}


/**
 * @author yandabin 
 * �������Ӻ��½���÷���
 **/
function mosSocketLogin(){
	if( lWSC.isConnected() ) {
		lWSC.login(loginObject,null,null);
	}
}


/**
 * @author yandabin 
 * �������Ӻ��½���÷���
 **/
function initConnect(loginInfo){
	loginObject = loginInfo;
	initPage();
	connect();
}


function connect() {
	/*
		//lURL = jws.getDefaultServerURL();
		lURL = encodeURI("ws://" + MOS_SOCKET_IP + ":" + MOS_SOCKET_SERVER_PROT + "/jWebSocket/jWebSocket");
		lWSC.open( lURL, {
		OnOpen: function( aEvent ) {
			mosSocketLogin();
		},
		OnMessage: function( aEvent, aToken ) {
			
		},
		OnClose: function( aEvent ) {
			
		}
	});
	*/
}

