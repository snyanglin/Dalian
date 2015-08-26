/*!
 * 系统timer
 * znjg - v1.0.0 (2014-05-20 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 系统timer
 * @author gb
 */

var PublicTimer = {
		xxtxTimer : null
};

var ProtectedTimer = {
		ssxxTimer : null,
		sstjTimer : null,
		ssdjTimer : null
};

var PrivateTimer = {
		zhdd: {
			jqztTimer : null
		},
		fxyp : {
			dsyjTimer : null,
			zhfxTimer :null
		},
		jtts : {
			sslkTimer : null,
			lkbjTimer :null,
			zoomSslkTimer:null,
			zoomSslkCxTimer:null,
			zoomLkycTimer:null
		}
};

var SysTimer = {
		clearTimer : function(timer) {
			clearInterval(timer);
			timer = null;
		},
		
		clearAllTimer : function() {
			this.clearPrivateTimer();
			this.clearProtectedTimer();
		},
		
		clearPrivateTimer : function() {
			for(var k in PrivateTimer){
				var json = PrivateTimer[k];
				for(var key in json) {
					this.clearTimer(json[key]);
				}
			}
		},
		
		clearProtectedTimer : function() {
			for(var k in ProtectedTimer) {
				this.clearTimer(ProtectedTimer[k]);
			}
		}
};